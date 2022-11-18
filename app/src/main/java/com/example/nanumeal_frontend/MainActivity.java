package com.example.nanumeal_frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.Window;
import android.view.WindowManager;
import android.content.Intent;
import android.graphics.drawable.ColorDrawable;
import android.view.Menu;
import android.widget.LinearLayout;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.tabs.TabLayout;


public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavi;
    private LinearLayout mainLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        settingListener();


    }

    private void init() {
        mainLayout = findViewById(R.id.main_layout);
        bottomNavi = findViewById(R.id.bottom_navi);

    }

    private void settingListener() {
        bottomNavi.setOnNavigationItemSelectedListener(new TabSelectedListener());

    }

    class TabSelectedListener implements BottomNavigationView.OnNavigationItemSelectedListener{
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()) {
                case R.id.item1:
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout,new DonationFragment())
                            .commit();
                    return true;
                }
                case R.id.item2:
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout,new HomeFragment())
                            .commit();
                    return true;
                }
                case R.id.item3:
                {
                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.main_layout,new MyNanumiFragment())
                            .commit();
                    return true;
                }
            }
            return false;
        }
    }


}




