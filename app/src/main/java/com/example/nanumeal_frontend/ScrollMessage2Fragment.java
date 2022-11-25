package com.example.nanumeal_frontend;

import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class ScrollMessage2Fragment extends Fragment {

    public ScrollMessage2Fragment() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_scroll_message2, container, false);
        HorizontalScrollView horizonsv = rootView.findViewById(R.id.scroll_message2_hv);
        ImageView status1 = (ImageView) rootView.findViewById(R.id.scroll_message_status1);
        ImageView status2 = (ImageView) rootView.findViewById(R.id.scroll_message_status2);
        ImageView status3 = (ImageView) rootView.findViewById(R.id.scroll_message_status3);
        ImageView status4 = (ImageView) rootView.findViewById(R.id.scroll_message_status4);
        ImageView status5 = (ImageView) rootView.findViewById(R.id.scroll_message_status5);

        ImageView icon1 = (ImageView) rootView.findViewById(R.id.scroll_message_icon1);
        ImageView icon2 = (ImageView) rootView.findViewById(R.id.scroll_message_icon2);
        ImageView icon3 = (ImageView) rootView.findViewById(R.id.scroll_message_icon3);
        ImageView icon4 = (ImageView) rootView.findViewById(R.id.scroll_message_icon4);
        ImageView icon5 = (ImageView) rootView.findViewById(R.id.scroll_message_icon5);

        TextView etlength = (TextView) rootView.findViewById(R.id.scroll_message2_length);
        EditText messageEt = (EditText) rootView.findViewById(R.id.scroll_message2_et);


        class clickListener implements View.OnClickListener {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    // status bar event
                    case R.id.scroll_message_status1:
                        horizonsv.smoothScrollTo(0, horizonsv.getScrollY());
                        status1.setImageResource(R.drawable.elipse_red_status_bar_message_scroll);
                        status2.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status3.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status4.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status5.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        break;

                    case R.id.scroll_message_status2:
                        icon2.setImageResource(R.drawable.icon_warmup_big);
                        horizonsv.smoothScrollTo(510, horizonsv.getScrollY());
                        status2.setImageResource(R.drawable.elipse_red_status_bar_message_scroll);
                        status3.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status4.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status5.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status1.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        break;

                    case R.id.scroll_message_status3:
                        icon3.setImageResource(R.drawable.icon_warmup_big);
                        horizonsv.smoothScrollTo(976-26, horizonsv.getScrollY());
                        status3.setImageResource(R.drawable.elipse_red_status_bar_message_scroll);
                        status4.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status5.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status1.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status2.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        break;


                    case R.id.scroll_message_status4:
                        icon4.setImageResource(R.drawable.icon_thankyou_big);
                        horizonsv.smoothScrollTo(1360, horizonsv.getScrollY());
                        status4.setImageResource(R.drawable.elipse_red_status_bar_message_scroll);
                        status5.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status1.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status2.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status3.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        break;


                    case R.id.scroll_message_status5:
                        icon5.setImageResource(R.drawable.icon_fighting_big);
                        horizonsv.smoothScrollTo(2000, horizonsv.getScrollY());
                        status5.setImageResource(R.drawable.elipse_red_status_bar_message_scroll);
                        status1.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status2.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status3.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        status4.setImageResource(R.drawable.elipse_gray_status_bar_message_scroll);
                        break;
                    case R.id.scroll_message2_et:
                        etlength.setText(messageEt.getText().length());
                        break;
                    case R.id.scroll_message_icon3:
                        icon3.setImageResource(R.drawable.icon_warmup_big);
                        break;

                }

            }
        }

        clickListener clickListener = new clickListener();
        status1.setOnClickListener(clickListener);
        status2.setOnClickListener(clickListener);
        status3.setOnClickListener(clickListener);
        status4.setOnClickListener(clickListener);
        status5.setOnClickListener(clickListener);

        icon3.setOnClickListener(clickListener);

        return rootView;
    }
}