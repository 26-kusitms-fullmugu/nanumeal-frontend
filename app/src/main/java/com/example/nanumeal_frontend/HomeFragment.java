package com.example.nanumeal_frontend;

import android.Manifest;
import android.content.Intent;
import android.location.Geocoder;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import com.naver.maps.geometry.LatLng;
import com.naver.maps.map.CameraPosition;
import com.naver.maps.map.MapView;
import com.naver.maps.map.NaverMap;
import com.naver.maps.map.OnMapReadyCallback;
import com.naver.maps.map.overlay.InfoWindow;
import com.naver.maps.map.overlay.Marker;
import com.naver.maps.map.overlay.Overlay;
import com.naver.maps.map.overlay.OverlayImage;
import com.naver.maps.map.util.FusedLocationSource;
import com.naver.maps.map.OnMapReadyCallback;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link HomeFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class HomeFragment extends Fragment implements OnMapReadyCallback {

    Marker marker;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    public HomeRecyclerAdapter mRecyclerAdapter;

    public ArrayList<HomeItem> mHomeItem;

    private static final int PERMISSION_REQUEST_CODE = 100;
    private static final String[] PERMISSIONS = {
            Manifest.permission.ACCESS_FINE_LOCATION,
            Manifest.permission.ACCESS_COARSE_LOCATION
    };

    private Marker marker1 = new Marker();
    private Marker marker2 = new Marker();
    private Marker marker3 = new Marker();

    private FusedLocationSource mLocationSource;
    private NaverMap naverMap;
    private MapView mapView;
    private Geocoder geocoder;
    String token;
    String latitude;
    String longitude;

    // 마커 정보 저장시킬 변수들 선언
    private Vector<LatLng> markersPosition;
    private Vector<Marker> activeMarkers;
    private List<String> storeName;

    // 마커 클릭시 정보창
    private InfoWindow infoWindow;
    String infoName;

    // 선택한 마커의 위치가 가시거리(카메라가 보고있는 위치 반경 5km 내)에 있는지 확인
    public final static double REFERANCE_LAT = 1 / 109.958489129649955;
    public final static double REFERANCE_LNG = 1 / 88.74;
    public final static double REFERANCE_LAT_X5 = 5 / 109.958489129649955;
    public final static double REFERANCE_LNG_X5 = 5 / 88.74;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public HomeFragment() {
        // Required empty public constructor

    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HomeFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static HomeFragment newInstance(String param1, String param2) {
        HomeFragment fragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


         Intent mainIntent = getActivity().getIntent();
         token = mainIntent.getExtras().getString("access_token");

        /*
        // 사용자가 설정한 주소 가져오기 (지도 처음 위치 지정하기 위해)
        Call<UserResponse> user = RetrofitClient.getAPIService().getUserInfo(token);
        user.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                if(response.isSuccessful()) {
                    Log.d("연결이 성공적 : ", response.body().toString());
                    UserResponse data = response.body();
                    latitude = data.getUserLatitude();
                    longitude = data.getUserLongitude();
                } else {
                    Log.e("연결이 비정상적 : ", "error code : " + response.code());
                }
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.e("연결실패", t.getMessage());
            }
        });
        */
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_home, container, false);

        Button btnMark1 = (Button) rootView.findViewById(R.id.btnmark1);
        Button btnMark2 = (Button) rootView.findViewById(R.id.btnmark2);
        Button btnMark3 = (Button) rootView.findViewById(R.id.btnmark3);
        ImageView marker = (ImageView) rootView.findViewById(R.id.marker);

        // 지도 객체 생성
        mapView = (MapView) rootView.findViewById(R.id.mapView);
        mapView.onCreate(savedInstanceState);

        marker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MapStoreDetailActivity.class);
                startActivity(intent);
            }
        });

        btnMark1.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker1, 33.2712, 126.5354, R.drawable.marker, 0);

                marker1.setOnClickListener(new Overlay.OnClickListener() {
                    @Override
                    public boolean onClick(@NonNull Overlay overlay)
                    {
                        Intent intent = new Intent(getActivity(), MapStoreDetailActivity.class);
                        startActivity(intent);
                        return false;
                    }
                });
            }
        });

        btnMark2.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker2, 33.49957, 126.531076, R.drawable.marker, 10);
            }
        });

        btnMark3.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                setMarker(marker3, 33.49957, 126.531128, R.drawable.marker, 0);
            }
        });
;
        mapView.onResume();
        mapView.getMapAsync(this);

        // getMapAsync를 호출하여 비동기로 onMapReady 콜백 메서드 호출
        // onMapReady에서 NaverMap 객체를 받음
        // mapView.getMapAsync((OnMapReadyCallback) this);


        // 지도 사용권한을 받아 옴
        //mLocationSource =
                //new FusedLocationSource(this, PERMISSION_REQUEST_CODE);


        // 가게 리스트
        RecyclerView mRecyclerView = rootView.findViewById(R.id.recycler);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));

        /* initiate adapter */
        mRecyclerAdapter = new HomeRecyclerAdapter();

        /* initiate recyclerview */
        mRecyclerView.setAdapter(mRecyclerAdapter);

        mHomeItem = new ArrayList<>();
        mHomeItem.add(new HomeItem("최강금돈까스", "영업중", "|", "0.4", "km", "이용가능", "사용가능금액", "8,000", "원", R.drawable.store_profile_image, 1, "가게보기", R.drawable.bottom_line));
        mHomeItem.add(new HomeItem("소문난아구찜", "영업중", "|", "0.8", "km", "이용가능", "사용가능금액", "8,000", "원", R.drawable.store_profile_image1, 1, "가게보기", R.drawable.bottom_line));
        mHomeItem.add(new HomeItem("라쿠엔", "영업중", "|", "1.5", "km", "이용가능", "사용가능금액", "12,000", "원", R.drawable.store_profile_image2, 1, "가게보기", R.drawable.bottom_line));
        mHomeItem.add(new HomeItem("장군족발보쌈", "영업중", "|", "1.5", "km", "이용가능", "사용가능금액", "11,000", "원", R.drawable.store_profile_image3, 1, "가게보기", R.drawable.bottom_line));
        mHomeItem.add(new HomeItem("소문난집", "영업중", "|", "1.8", "km", "이용가능", "사용가능금액", "4,000", "원", R.drawable.store_profile_image4, 1, "가게보기", R.drawable.bottom_line));
        mHomeItem.add(new HomeItem("종로찌개마을", "영업중", "|", "1.6", "km", "이용가능", "사용가능금액", "5,000", "원", R.drawable.store_profile_image5, 1, "가게보기", R.drawable.bottom_line));
        mRecyclerAdapter.setHomeList(getContext(), mHomeItem);

        /* adapt data */
        /* Call<FlowerShopListResponse> flowerShopListCall = RetrofitClient.getAPIService().getHotFlowerShop(token); */

        /* flowerShopListCall.enqueue(new Callback<FlowerShopListResponse>() {
            @Override
            public void onResponse(Call<FlowerShopListResponse> call, Response<FlowerShopListResponse> response) {
                FlowerShopListResponse resource = response.body();
                List<FlowerShopResponse> dataList = resource.getData();
                mHomeItems1 = new ArrayList<>();
                if (dataList != null && dataList.size() != 0) {
                    for (FlowerShopResponse data : dataList) {
                        String [] address = data.getFlowerShopAddress().split(" ");
                        mHomeItems1.add(new HomeItem(data.getFlowerShopImage(),
                                data.getFlowerShopName(), address[1] + " " + address[2]));

                    }
                    mRecyclerAdapter.setHomeList(getContext(), mHomeItems1);
                }
            }

            @Override
            public void onFailure(Call<FlowerShopListResponse> call, Throwable t) {
                Log.e("연결실패", t.getMessage());
            }
        });

        Call<PortfolioListResponse> portfolioListCall = RetrofitClient.getAPIService().getHotPortfolio(token); */

        return rootView;
    }

    private void setMarker(Marker marker,  double lat, double lng, int resourceID, int zIndex)
    {
        //원근감 표시
        marker.setIconPerspectiveEnabled(true);
        //아이콘 지정
        marker.setIcon(OverlayImage.fromResource(resourceID));
        //마커의 투명도
        marker.setAlpha(0.8f);
        //마커 위치
        marker.setPosition(new LatLng(lat, lng));
        //마커 우선순위
        marker.setZIndex(zIndex);
        //마커 표시
        marker.setMap(naverMap);
    }

    @Override
    public void onSaveInstanceState(Bundle outState)
    {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }

    @Override
    public void onLowMemory()
    {
        super.onLowMemory();
        mapView.onLowMemory();
    }

    @Override
    public void onMapReady(@NonNull NaverMap naverMap) {

    }
}