package com.su.odb.serialporttest;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android_serialport_api.SerialManager;


public class MainActivity extends AppCompatActivity {
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager= (ViewPager) findViewById(R.id.viewPager);
        Fragment[] fragment=new Fragment[5];
        fragment[0]=new CarInfoFragment();
        fragment[1]=new ODBDataFragment();
        fragment[2]=new HealthFragment();
        fragment[3]=new DeviceControlFragment();
        fragment[4]=new BurglarFrgment();
        MyPagerAdapter adapter=new MyPagerAdapter(getSupportFragmentManager(),fragment);
        viewPager.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        SerialManager.getInstance().start();
        super.onResume();
    }

    @Override
    protected void onPause() {
        SerialManager.getInstance().stop();
        super.onPause();
    }
}
