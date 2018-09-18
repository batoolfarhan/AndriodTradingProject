package com.example.batool_f.tradingapp.trade_items;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.batool_f.tradingapp.R;
import com.example.batool_f.tradingapp.user.UserActivity;

public class ItemsViewerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items_viewer);

         final Button loginButton = findViewById(R.id.loginButton);
         final Intent intent = new Intent(this,UserActivity.class);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }
}
