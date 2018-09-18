package com.example.batool_f.tradingapp.user;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.batool_f.tradingapp.R;
import com.example.batool_f.tradingapp.trade_items.ItemsViewerActivity;
import com.example.batool_f.tradingapp.util.NetworkUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UserActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().add(R.id.fragmentParentViewGroup, new LoginFragment()).commit();
        }
    }



}
