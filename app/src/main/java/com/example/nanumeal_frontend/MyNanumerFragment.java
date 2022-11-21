package com.example.nanumeal_frontend;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;


public class MyNanumerFragment extends Fragment {
    public ScrollView scrollView1;

    public static void setWholeScroll(ScrollView scrollView)
    {
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
        ViewGroup viewGroup = (ViewGroup) inflater.inflate(R.layout.fragment_my_nanumer, container, false);

        return inflater.inflate(R.layout.fragment_my_nanumer, container, false);

    }
}