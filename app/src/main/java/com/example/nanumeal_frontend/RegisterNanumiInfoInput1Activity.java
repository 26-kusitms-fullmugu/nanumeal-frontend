package com.example.nanumeal_frontend;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class RegisterNanumiInfoInput1Activity extends AppCompatActivity {
    private boolean validate = false;
    private AlertDialog dialog;
    int Use = 0;

    public void idCertifyClass(View v) {
        final EditText idEt = (EditText) findViewById(R.id.nanumer_info_input_id_et);
        final Button certifyBtn = (Button) findViewById(R.id.nanumer_info_input_id_certify_btn);


    }

    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.infoInput_nanumer_ex_tv:
                    Intent view1 = new Intent(RegisterNanumiInfoInput1Activity.this, RegisterNanumiCertifyActivity.class);
                    startActivity(view1);
                    finish();
                    break;

                case R.id.infoInput_nanumer_next_tv:
                    Intent view2 = new Intent(RegisterNanumiInfoInput1Activity.this, RegisterNanumiInfoInput2Activity.class);
                    startActivity(view2);
                    finish();
                    break;

//                    if(idEt.getText().toString().length() ==0 | pwEt.getText().toString().length() ==0 | pwEt1.getText().toString().length() ==0 | emailEt.getText().toString().length() ==0)
//                    {
//                        Toast.makeText(getApplicationContext(),"빈칸이 있어서는 안됩니다",Toast.LENGTH_SHORT).show();
//                    }
//                    else
//                    {
//
//
//                    }

                case R.id.nanumer_info_input_id_certify_btn:



            }

        }
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_nanumi_info_input1);

        Window window = getWindow();
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(Color.parseColor("#ffffff"));

        selectListener onClickListener = new selectListener();

        TextView exTv = (TextView) findViewById(R.id.infoInput_nanumer_ex_tv);
        exTv.setOnClickListener(onClickListener);

        TextView nextTv = (TextView) findViewById(R.id.infoInput_nanumer_next_tv);
        nextTv.setOnClickListener(onClickListener);



    }
}