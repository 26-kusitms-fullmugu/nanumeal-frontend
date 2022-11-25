package com.example.nanumeal_frontend;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

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
    String userValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        userValue = intent.getStringExtra("userValue");
        Log.d("userValue", userValue);

        init();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        Fragment initFragment = new HomeFragment();
        fragmentManager.beginTransaction().replace(R.id.main_layout, initFragment).commit();

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
                    if(userValue.equals("nanumer")) { //userType == nanumer
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout,new MyNanumerFragment())
                                .commit();
                        return true;
                    }
                    else if(userValue.equals("nanumi")) { //userType == nanumi
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout,new MyNanumiFragment())
                                .commit();
                        return true;
                    }
                    else if(userValue.equals("nanumi_certify")) { //userType == nanumi
                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.main_layout,new MyNanumiCertifyFragment())
                                .commit();
                        return true;
                    }
                }
            }
            return false;
        }
    }


}




