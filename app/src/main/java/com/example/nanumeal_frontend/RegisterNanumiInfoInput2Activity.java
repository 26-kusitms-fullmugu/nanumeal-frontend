package com.example.nanumeal_frontend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

import java.net.ResponseCache;
import java.util.ArrayList;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;


public class RegisterNanumiInfoInput2Activity extends AppCompatActivity {
    private boolean validate = false;
    private ArrayList<String> Input1Value;
    private AlertDialog dialog;
    String userId, userPwd, userEmail, userName, userNickName, userAge;
    String userValue;

    public void setUserName() {
        final EditText nameEt = (EditText) findViewById(R.id.nanumer_info_input2_name_et);
        userName = nameEt.getText().toString();
        Log.d("userName", userName);

    }

    public void setUserAge() {
        final EditText ageEt = (EditText) findViewById(R.id.nanumer_info_Input2_age_et);
        userAge = ageEt.getText().toString();
        Log.d("userAge", userAge);

    }

    public void setUserNickName() {
        final EditText nickNameEt = (EditText) findViewById(R.id.nanumer_info_input2_nick_et);
        String userNameEx = nickNameEt.getText().toString();
        if(userNameEx.equals("")) { //공백일 경우
            Toast.makeText(this, "별명을 입력해주세요", Toast.LENGTH_SHORT).show();
        }
        else { //공백이 아닐경우
            if(validate) {
                userName = userNameEx;
                Log.d("userName", userNameEx);
            }
        }

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiInfoInput2Activity.this);
                        dialog = builder.setMessage("사용할 수 있는 별명입니다.").setPositiveButton("확인", null).create();
                        dialog.show();
                        nickNameEt.setEnabled(false); //아이디값 고정
                        validate = true; // 검증완료
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiInfoInput2Activity.this);
                        dialog = builder.setMessage("이미 존재하는 별명입니다.").setPositiveButton("확인", null).create();
                        dialog.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ValidateRequest2 validateRequest = new ValidateRequest2(userNickName, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterNanumiInfoInput2Activity.this);
        queue.add(validateRequest);

    }



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
                    Intent view2 = new Intent(RegisterNanumiInfoInput2Activity.this, SignUpFinishActivity.class);
                    view2.putExtra("userValue", userValue);
                    startActivity(view2);
                    finish();
                    break;

                case R.id.nanumer_info_input_nick_certify_btn:
                    final Button nicknameBtn = (Button) findViewById(R.id.nanumer_info_input_nick_certify_btn);
                    final TextView nicknameTv = (TextView) findViewById(R.id.nanumer_info_Input2_nickname_tv);
                    final TextView nicknameCertify = (TextView) findViewById(R.id.nanumer_info_Input2_nickname_certify);
                    nicknameTv.setVisibility(View.GONE);
                    nicknameCertify.setVisibility(View.VISIBLE);
                    nicknameBtn.setText("확인완료");
                    nicknameBtn.setBackgroundResource(R.drawable.btn_red_login);
                    setUserNickName();

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
        userValue = Input1Value.get(3);
        Log.d("userId", userId);
        Log.d("userPwd", userPwd);
        Log.d("userEmail", userEmail);
        Log.d("userValue", userValue); //Intent 받기

        setUserName();
        setUserAge();

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        selectListener onClickListener = new selectListener();

        TextView exTv = (TextView) findViewById(R.id.nanumer_info_Input2_ex_tv);
        exTv.setOnClickListener(onClickListener);

        Button signInBtn = (Button) findViewById(R.id.nanumer_info_Input2_signIn_btn);
        signInBtn.setOnClickListener(onClickListener);

        Button nickNameBtn = (Button) findViewById(R.id.nanumer_info_input_nick_certify_btn);
        nickNameBtn.setOnClickListener(onClickListener);

    }
}