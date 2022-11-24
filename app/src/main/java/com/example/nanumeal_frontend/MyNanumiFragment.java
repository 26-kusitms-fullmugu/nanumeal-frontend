package com.example.nanumeal_frontend;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class MyNanumiFragment extends Fragment {


    class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.nanumi_my_certify_tv:
                    Intent intent = new Intent(getActivity(), RegisterNanumiCertifyActivity.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                    startActivity(intent);

            }

        }
    }

    public MyNanumiFragment() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_my_nanumi, container, false);
        TextView certifyTv = (TextView) rootView.findViewById(R.id.nanumi_my_certify_tv);
        clickListener clickListener = new clickListener();
        certifyTv.setOnClickListener(clickListener);


        return rootView;
    }
}