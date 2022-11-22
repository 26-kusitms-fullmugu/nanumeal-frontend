package com.example.nanumeal_frontend;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ScrollView;


public class MyNanumerFragment extends Fragment {

    class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.my_nanumer_arrow:
                    Intent intent = new Intent(getActivity(), MyNanumerHistoryActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);

            }

        }
    }


    public MyNanumerFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_nanumer, container, false);

        clickListener onClickListener = new clickListener();
        ImageView arrow_btn = (ImageView) rootView.findViewById(R.id.my_nanumer_arrow);
        arrow_btn.setOnClickListener(onClickListener);



        return rootView;

    }
}