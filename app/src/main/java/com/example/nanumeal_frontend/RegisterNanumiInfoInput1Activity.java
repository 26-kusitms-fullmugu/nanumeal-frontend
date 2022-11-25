package com.example.nanumeal_frontend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;


import java.net.ResponseCache;
import java.util.ArrayList;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;
import org.w3c.dom.Text;


public class RegisterNanumiInfoInput1Activity extends AppCompatActivity {
    private boolean validate = false;
    private boolean pwCheck = false;
    private AlertDialog dialog;
    int Use = 0;
    String userValue;
    String userId;
    String userEmail;
    String userPwd;
    String[] items = {"naver.com", "daum.net", "nate.com", "gmail.com"};

    public void emailCertifyClass() {
        final View emailCertifyLayout = (View) findViewById(R.id.nanumer_info_Input_email_certify_layout);
        emailCertifyLayout.setVisibility(View.VISIBLE);
        final Button emailBtn = (Button) findViewById(R.id.nanumer_info_input_email_btn);
        emailBtn.setVisibility(View.GONE);

        Toast.makeText(getApplicationContext(), "이메일 인증이 완료되었습니다.", Toast.LENGTH_SHORT);

    }

    public void idCertifyClass() {
        final Button idCheckBtn = (Button) findViewById(R.id.nanumer_info_input_id_certify_btn);
        final EditText idEt = (EditText) findViewById(R.id.nanumer_info_input_id_et);

        String userIdEx = idEt.getText().toString();


        userId = userIdEx; //나중에 서버 생기면 지울거
        if (idEt.getText().toString().equals("")) { //빈칸이면
            Toast.makeText(this, "아이디를 입력해주세요", Toast.LENGTH_SHORT).show();

        } else { // 빈칸이 아니면
            if(validate) { //있는 아이디가 x
                userId = userIdEx;
                Use = 1;
            }

        }

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonResponse = new JSONObject(response);
                    boolean success = jsonResponse.getBoolean("success");

                    if(success) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiInfoInput1Activity.this);
                        dialog = builder.setMessage("사용할 수 있는 아이디입니다.").setPositiveButton("확인", null).create();
                        dialog.show();
                        idEt.setEnabled(false); //아이디값 고정
                        validate = true; // 검증완료
                        idCheckBtn.setBackgroundColor(Color.parseColor("#ffffff"));
                    } else {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiInfoInput1Activity.this);
                        dialog = builder.setMessage("이미 존재하는 아이디입니다.").setPositiveButton("확인", null).create();
                        dialog.show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        };

        ValidateRequest validateRequest = new ValidateRequest(userId, responseListener);
        RequestQueue queue = Volley.newRequestQueue(RegisterNanumiInfoInput1Activity.this);
        queue.add(validateRequest);

    }

    public void pwCertifyClass() {
        final EditText pwCheckEt = (EditText) findViewById(R.id.nanumer_info_input_pw_et2);
        final EditText pwEt = (EditText) findViewById(R.id.nanumer_info_input_pw_et1);

        if(pwEt.getText().toString().equals(pwCheckEt.getText().toString())) {
            pwCheck = true;
            userPwd = pwEt.getText().toString();
            Log.d("pwCheck", String.valueOf(pwCheck));
        } else {
            pwCheck = false;
            Log.d("pwCheck", String.valueOf(pwCheck));
            Toast.makeText(this, "비밀번호가 다릅니다", Toast.LENGTH_SHORT).show();
        }



    }

    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            final EditText emailEt = (EditText) findViewById(R.id.nanumer_info_input_email1);
            switch (v.getId()) {
                case R.id.infoInput_nanumer_ex_tv:
                    Intent view1 = new Intent(RegisterNanumiInfoInput1Activity.this, RegisterNanumiCertifyActivity.class);
                    startActivity(view1);
                    finish();
                    break;

                case R.id.infoInput_nanumer_next_tv:
                    final EditText idEt = (EditText) findViewById(R.id.nanumer_info_input_id_et);
                    final EditText pwEt = (EditText) findViewById(R.id.nanumer_info_input_pw_et1);
                    final EditText pw2Et = (EditText) findViewById(R.id.nanumer_info_input_pw_et2);
                    pwCertifyClass();

                    if(idEt.getText().toString().length() ==0 | pwEt.getText().toString().length() == 0 | pw2Et.getText().toString().length() == 0 | emailEt.getText().toString().length() ==0)
                    {
                        Toast.makeText(getApplicationContext(),"빈칸이 있어서는 안됩니다.",Toast.LENGTH_SHORT).show();
                    }
                    else if(pwCheck == false) {
                        Toast.makeText(getApplicationContext(),"입력하신 비밀번호와\n 비밀번호 확인이 다릅니다.",Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        ArrayList<String> Input1Value = new ArrayList<>();
                        Input1Value.add(userId);
                        Log.d("userId", userId);
                        Input1Value.add(userPwd);
                        Log.d("userPwd", userPwd);
                        Input1Value.add(userEmail); //순서대로 id - pwd - email
                        Log.d("userEmail", userEmail);
                        Input1Value.add(userValue); ////순서대로 id - pwd - email - userValue
                        Log.d("userValue", userValue);
                        Intent view2 = new Intent(RegisterNanumiInfoInput1Activity.this, RegisterNanumiInfoInput2Activity.class);
                        view2.putExtra("Input1Value", Input1Value); //ArrayList Intent 넘기기
                        startActivity(view2);
                        finish();
                        break;
                    }

                case R.id.nanumer_info_input_id_certify_btn:
                    final Button idCheckBtn = (Button) findViewById(R.id.nanumer_info_input_id_certify_btn);
                    final TextView certifyText = (TextView) findViewById(R.id.nanumer_info_input_id_certify_tv);
                    idCertifyClass();
                    idCheckBtn.setText("확인완료");
                    certifyText.setVisibility(View.VISIBLE);
                    break;

                case R.id.nanumer_info_input_email_btn:
                    if(emailEt.getText().toString().equals("")) {
                        AlertDialog.Builder builder = new AlertDialog.Builder(RegisterNanumiInfoInput1Activity.this);
                        dialog = builder.setMessage("이메일을 입력해주세요.").setPositiveButton("확인", null).create();
                        dialog.show();
                    } else {
                        Log.d("UserEmail", userEmail); //입력한 et 값이 있을때
                        final Button emailCertifyBtn = (Button) findViewById(R.id.nanumer_info_input_email_btn);
                        emailCertifyBtn.setText("이메일 인증번호 받기");
                        emailCertifyClass();
                    }
                    break;

                case R.id.nanumer_info_input_email_certify_btn:
                    final View emailCertifyLayout = (View) findViewById(R.id.nanumer_info_Input_email_certify_layout);
                    final TextView emailCertifyTv = (TextView) findViewById(R.id.nanumer_info_input_email_certify_tv);
                    emailCertifyLayout.setVisibility(View.GONE);
                    emailCertifyTv.setVisibility(View.VISIBLE);


            }

        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nanumi_info_input1);

        Intent intent = getIntent();
        userValue = intent.getStringExtra("userValue");
        Log.d("userValue", userValue);


        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        selectListener onClickListener = new selectListener();

        TextView exTv = (TextView) findViewById(R.id.infoInput_nanumer_ex_tv);
        exTv.setOnClickListener(onClickListener);

        TextView nextTv = (TextView) findViewById(R.id.infoInput_nanumer_next_tv);
        nextTv.setOnClickListener(onClickListener);

        Button idCertifyBtn = (Button) findViewById(R.id.nanumer_info_input_id_certify_btn);
        idCertifyBtn.setOnClickListener(onClickListener);

        Button emailCertifyBtn = (Button) findViewById(R.id.nanumer_info_input_email_btn);
        emailCertifyBtn.setOnClickListener(onClickListener);

        Spinner spinner = (Spinner) findViewById(R.id.nanumer_info_input_spinner); //스피너 adapter
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item, items);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        Button emailLayoutBtn = (Button) findViewById(R.id.nanumer_info_input_email_certify_btn);
        EditText emailEt = (EditText) findViewById(R.id.nanumer_info_input_email1);
        emailLayoutBtn.setOnClickListener(onClickListener);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(emailEt.getText().toString().equals("")) {
                    userEmail = ""; //입력한 et값이 없을 때

                } else {
                    userEmail = emailEt.getText().toString() + "@" + items[position];
                    Log.d("UserEmail", userEmail); //입력한 et 값이 있을때
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

    }
}