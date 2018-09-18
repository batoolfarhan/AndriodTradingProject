package com.example.batool_f.tradingapp.welcome;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.batool_f.tradingapp.R;
import com.example.batool_f.tradingapp.trade_items.ItemsViewerActivity;

public class WelcomeActivity extends FragmentActivity {

    View view = View.inflate(this, R.layout.fragment_welcome, null);

    private static final int PAGES_NUM = 2;
    private ViewPager viewPager;
    private PagerAdapter pagerAdapter;

    SharedPreferences sharedPreferences;
    private int noOfVisits;
    private static final String VISITS_NO = "noOfVisits";
    private static final int FIRST_VISIT = 0;


    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        viewPager= (ViewPager)findViewById(R.id.pager);
        pagerAdapter = new ScreenSliderAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        //view.

        sharedPreferences = getPreferences(MODE_PRIVATE);
        noOfVisits = getVisitsNo(sharedPreferences);

        intent = new Intent(this, ItemsViewerActivity.class);
        if(noOfVisits > FIRST_VISIT){
            startActivity(intent);
        }

        sharedPreferences.edit().putInt(VISITS_NO,++noOfVisits).apply();
    }

    private class ScreenSliderAdapter extends FragmentStatePagerAdapter {
        public ScreenSliderAdapter(FragmentManager fm) {
            super(fm);
        }
        @Override
        public int getCount() {
            return PAGES_NUM;
        }

        @Override
        public Fragment getItem(int i) {
            if(i == 0){
                return new WelcomeFragment();
            }
            if(i == 1){
                return  new FeaturesFragment();
            }
            return new WelcomeFragment();
        }
    }

    public int getVisitsNo(SharedPreferences sharedPreferences){
        return sharedPreferences.getInt(VISITS_NO,0);
    }
}

