package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MessageScrollActivity extends AppCompatActivity {
    String userValue;

    class clickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.message_scroll_btn1:
                    Intent intent = new Intent(MessageScrollActivity.this, MainActivity.class);
                    userValue = "nanumi_certify";
                    intent.putExtra("userValue", userValue);
                    startActivity(intent);
                    finish();
                    break;

            }

        }
    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_message_scroll);


        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment scroll1 = new ScrollMessage1Fragment();
        Fragment scroll2 = new ScrollMessage2Fragment();
        fragmentManager.beginTransaction().replace(R.id.message_scroll_fragment, scroll1).commit();

        Button btn3 = (Button) findViewById(R.id.message_scroll_btn3);

        clickListener clickListener = new clickListener();
        Button btn1 = (Button) findViewById(R.id.message_scroll_btn1);
        btn1.setOnClickListener(clickListener);

        Button btn2 = (Button) findViewById(R.id.message_scroll_btn2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn2.setVisibility(View.GONE);
                btn3.setVisibility(View.VISIBLE);
                fragmentManager.beginTransaction().replace(R.id.message_scroll_fragment, scroll2).commit();

            }
        });

        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MessageScrollActivity.this, "감사 메시지를 전송하였습니다", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MessageScrollActivity.this, MainActivity.class);
                userValue = "nanumi_certify";
                intent.putExtra("userValue", userValue);
                startActivity(intent);
                finish();
            }
        });

    }
}