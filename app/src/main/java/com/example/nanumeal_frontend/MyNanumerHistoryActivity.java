package com.example.nanumeal_frontend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MyNanumerHistoryActivity extends AppCompatActivity {

    class sumOfPrice {
    }

    class selectListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.my_nanumer_history_message:
                    Intent intent = new Intent(MyNanumerHistoryActivity.this, MyNanumerMessageActivity.class);
                    startActivity(intent);
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_nanumer_history);

        selectListener onClickListener = new selectListener();
        TextView messageTv = (TextView) findViewById(R.id.my_nanumer_history_message);
        messageTv.setOnClickListener(onClickListener);

        RoundImageView roundImageView1 = findViewById(R.id.my_nanumer_history_store_iv2);
        roundImageView1.setRectRadius(30f);

        RoundImageView roundImageView2 = findViewById(R.id.my_nanumer_history_store_iv3);
        roundImageView2.setRectRadius(30f);

        RoundImageView roundImageView3 = findViewById(R.id.my_nanumer_history_store_iv4);
        roundImageView3.setRectRadius(30f);


    }
}