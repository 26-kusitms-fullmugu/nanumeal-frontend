package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class RegisterSelectActivity extends AppCompatActivity {
    int KakaoCertify = 0;


    class selectListener implements View.OnClickListener { //나누미&나누머 색상 변경 리스너
        TextView nextTv = (TextView) findViewById(R.id.register_select_next_tv);
        Button nanumi_icon = (Button) findViewById(R.id.register_select_nanumi_icon);
        Button nanumer_icon = (Button) findViewById(R.id.register_select_nanumer_icon);
        private String userValue = ""; //서버에 넘길값
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.register_select_nanumi_icon:
                    nanumer_icon.setSelected(false);
                    nanumer_icon.setBackgroundResource(R.drawable.icon_nanumer_blur);
                    nanumi_icon.setSelected(!nanumi_icon.isSelected());
                    nanumi_icon.setBackgroundResource(R.drawable.icon_nanumi_select_checked);
                    nextTv.setVisibility(View.VISIBLE); //다음 버튼 클릭 가능
                    if(KakaoCertify == 1) {
                        userValue = "nanumi_certify";
                    }else {
                        userValue = "nanumi";
                    }
                    Log.d("userValue", userValue);
                    break;

                case R.id.register_select_nanumer_icon:
                    nanumi_icon.setSelected(false);
                    nanumi_icon.setBackgroundResource(R.drawable.icon_nanumi_blur);
                    nanumer_icon.setSelected(!nanumer_icon.isSelected());
                    nanumer_icon.setBackgroundResource(R.drawable.icon_nanumer_black);
                    nextTv.setVisibility(View.VISIBLE); //다음 버튼 클릭 가능
                    userValue = "nanumer";
                    Log.d("userValue", userValue);
                    break;

                case R.id.register_select_next_tv:
                    if(KakaoCertify == 1) {
                            Intent intent = new Intent(RegisterSelectActivity.this, SignUpFinishActivity.class);
                            intent.putExtra("userValue", userValue);
                            startActivity(intent);
                            finish();
                    }
                    else {
                        if(userValue.equals("nanumi")) { //나누미 버튼을 눌렀을 경우
                            Intent intent = new Intent(RegisterSelectActivity.this, RegisterNanumiCertifyActivity.class);
                            intent.putExtra("userValue", userValue);
                            startActivity(intent);
                        }
                        else if (userValue.equals("nanumer")) {
                            Intent intent = new Intent(RegisterSelectActivity.this, RegisterNanumiInfoInput1Activity.class);
                            intent.putExtra("userValue", userValue);
                            startActivity(intent);
                        }
                    }
                    break;
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_select);

        Intent intent = getIntent();
        KakaoCertify = intent.getIntExtra("KAKAO_CERTIFY", 0);
        Log.d("KakaoCertify", String.valueOf(KakaoCertify));


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        selectListener onClickListener = new selectListener();

        Button nanumi_icon = (Button) findViewById(R.id.register_select_nanumi_icon);
        nanumi_icon.setOnClickListener(onClickListener); //나누미-클릭리스터
        Button nanumer_icon = (Button) findViewById(R.id.register_select_nanumer_icon);
        nanumer_icon.setOnClickListener(onClickListener); //나누머-클릭리스너

        TextView nextTv = (TextView) findViewById(R.id.register_select_next_tv);
        nextTv.setOnClickListener(onClickListener); //다음 버튼-클릭리스너

        if(KakaoCertify == 1) { //카카오 회원가입시 선택시 바로 회원가입
            nextTv.setText("회원가입 완료");
            nextTv.setTextColor(Color.parseColor("#DA3915"));
        }

    }
}