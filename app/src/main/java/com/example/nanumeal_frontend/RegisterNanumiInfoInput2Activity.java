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
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class RegisterNanumiInfoInput2Activity extends AppCompatActivity {
    private ArrayList<String> Input1Value;
    String userId, userPwd, userEmail, userName, userNickName, userAge;

    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.nanumer_info_Input2_ex_tv:
                    Intent view1 = new Intent(RegisterNanumiInfoInput2Activity.this, RegisterNanumiInfoInput1Activity.class);
                    startActivity(view1);
                    finish();
                    break;

                case R.id.nanumer_info_Input2_signIn_btn:
                    Intent view2 = new Intent(RegisterNanumiInfoInput2Activity.this, MainActivity.class);
                    startActivity(view2);
                    finish();
                    break;
            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nanumi_info_input2);

        Intent intent = getIntent();
        Input1Value = (ArrayList<String>) intent.getSerializableExtra("Input1Value");
        userId = Input1Value.get(0);
        userPwd = Input1Value.get(1);
        userEmail = Input1Value.get(2);
        Log.d("userId", userId);
        Log.d("userPwd", userPwd);
        Log.d("userEmail", userEmail);


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        selectListener onClickListener = new selectListener();

        TextView exTv = (TextView) findViewById(R.id.nanumer_info_Input2_ex_tv);
        exTv.setOnClickListener(onClickListener);

        Button signInBtn = (Button) findViewById(R.id.nanumer_info_Input2_signIn_btn);
        signInBtn.setOnClickListener(onClickListener);

    }
}