package com.example.nanumeal_frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TabHost;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DonationFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DonationFragment extends Fragment {

    public DonationRecyclerAdapter mRecyclerAdapter;
    public DonationRecyclerAdapter2 mRecyclerAdapter2;
    public DonationRecyclerAdapter3 mRecyclerAdapter3;

    public ArrayList<DonationItem> mDonationItem;
    public ArrayList<DonationItem2> mDonationItem2;
    public ArrayList<DonationItem3> mDonationItem3;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DonationFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment DonationFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static DonationFragment newInstance(String param1, String param2) {
        DonationFragment fragment = new DonationFragment();
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
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = (ViewGroup) inflater.inflate(R.layout.fragment_donation, container, false);

        // 가게 리스트
        RecyclerView mRecyclerView = rootView.findViewById(R.id.recycler);
        RecyclerView mRecyclerView2 = rootView.findViewById(R.id.recycler2);
        RecyclerView mRecyclerView3 = rootView.findViewById(R.id.recycler3);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));

        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView2.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));

        mRecyclerView3.setLayoutManager(new LinearLayoutManager(getActivity()));
        mRecyclerView3.setLayoutManager(new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL,false));

        /* initiate adapter */
        mRecyclerAdapter = new DonationRecyclerAdapter();
        mRecyclerAdapter2 = new DonationRecyclerAdapter2();
        mRecyclerAdapter3 = new DonationRecyclerAdapter3();

        /* initiate recyclerview */
        mRecyclerView.setAdapter(mRecyclerAdapter);
        mRecyclerView2.setAdapter(mRecyclerAdapter2);
        mRecyclerView3.setAdapter(mRecyclerAdapter3);

        mDonationItem = new ArrayList<>();
        mDonationItem.add(new DonationItem("최강금돈까스", "영업중", "|", "0.4", "km", "모금액", "230,000", "원", R.drawable.store_profile_image, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem.add(new DonationItem("소문난아구찜", "영업중", "|", "0.8", "km", "모금액", "80,000", "원", R.drawable.store_profile_image1, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem.add(new DonationItem("라쿠엔", "영업중", "|", "1.5", "km", "모금액", "320,000", "원", R.drawable.store_profile_image2, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem.add(new DonationItem("장군족발보쌈", "영업중", "|", "1.5", "km", "모금액", "110,000", "원", R.drawable.store_profile_image3, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem.add(new DonationItem("종로찌개마을", "영업중", "|", "1.6", "km", "모금액", "50,000", "원", R.drawable.store_profile_image5, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem.add(new DonationItem("소문난집", "영업중", "|", "1.8", "km", "모금액", "40,000", "원", R.drawable.store_profile_image4, 1, "가게보기", R.drawable.bottom_line));mRecyclerAdapter.setDonationList(getContext(), mDonationItem);

        mDonationItem2 = new ArrayList<>();
        mDonationItem2.add(new DonationItem2("라쿠엔", "영업중", "|", "1.5", "km", "모금액", "320,000", "원", R.drawable.store_profile_image2, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem2.add(new DonationItem2("최강금돈까스", "영업중", "|", "0.4", "km", "모금액", "230,000", "원", R.drawable.store_profile_image, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem2.add(new DonationItem2("장군족발보쌈", "영업중", "|", "1.5", "km", "모금액", "110,000", "원", R.drawable.store_profile_image3, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem2.add(new DonationItem2("소문난아구찜", "영업중", "|", "0.8", "km", "모금액", "80,000", "원", R.drawable.store_profile_image1, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem2.add(new DonationItem2("종로찌개마을", "영업중", "|", "1.6", "km", "모금액", "50,000", "원", R.drawable.store_profile_image5, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem2.add(new DonationItem2("소문난집", "영업중", "|", "1.8", "km", "모금액", "40,000", "원", R.drawable.store_profile_image4, 1, "가게보기", R.drawable.bottom_line));mRecyclerAdapter.setDonationList(getContext(), mDonationItem);
        mRecyclerAdapter2.setDonationList(getContext(), mDonationItem2);

        mDonationItem3 = new ArrayList<>();
        mDonationItem3.add(new DonationItem3("소문난집", "영업중", "|", "1.8", "km", "모금액", "40,000", "원", R.drawable.store_profile_image4, 1, "가게보기", R.drawable.bottom_line));mRecyclerAdapter.setDonationList(getContext(), mDonationItem);
        mDonationItem3.add(new DonationItem3("종로찌개마을", "영업중", "|", "1.6", "km", "모금액", "50,000", "원", R.drawable.store_profile_image5, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem3.add(new DonationItem3("소문난아구찜", "영업중", "|", "0.8", "km", "모금액", "80,000", "원", R.drawable.store_profile_image1, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem3.add(new DonationItem3("장군족발보쌈", "영업중", "|", "1.5", "km", "모금액", "110,000", "원", R.drawable.store_profile_image3, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem2.add(new DonationItem2("최강금돈까스", "영업중", "|", "0.4", "km", "모금액", "230,000", "원", R.drawable.store_profile_image, 1, "가게보기", R.drawable.bottom_line));
        mDonationItem3.add(new DonationItem3("라쿠엔", "영업중", "|", "1.5", "km", "모금액", "320,000", "원", R.drawable.store_profile_image2, 1, "가게보기", R.drawable.bottom_line));
        mRecyclerAdapter3.setDonationList(getContext(), mDonationItem3);


        TabHost tabHost1 = rootView.findViewById(R.id.tabHost1) ;
        tabHost1.setup() ;

        // 첫 번째 Tab. (탭 표시 텍스트:"TAB 1"), (페이지 뷰:"content1")
        TabHost.TabSpec ts1 = tabHost1.newTabSpec("Tab Spec 1") ;
        ts1.setContent(R.id.content1) ;
        ts1.setIndicator("거리순") ;
        tabHost1.addTab(ts1)  ;

        // 두 번째 Tab. (탭 표시 텍스트:"TAB 2"), (페이지 뷰:"content2")
        TabHost.TabSpec ts2 = tabHost1.newTabSpec("Tab Spec 2") ;
        ts2.setContent(R.id.content2) ;
        ts2.setIndicator("후원순") ;
        tabHost1.addTab(ts2) ;

        // 세 번째 Tab. (탭 표시 텍스트:"TAB 3"), (페이지 뷰:"content3")
        TabHost.TabSpec ts3 = tabHost1.newTabSpec("Tab Spec 3") ;
        ts3.setContent(R.id.content3) ;
        ts3.setIndicator("나눔이 필요해요") ;
        tabHost1.addTab(ts3) ;

        return rootView;
    }
}