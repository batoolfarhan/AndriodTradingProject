package com.example.batool_f.tradingapp.user;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.batool_f.tradingapp.R;
import com.example.batool_f.tradingapp.trade_items.ItemsViewerActivity;
import com.example.batool_f.tradingapp.util.NetworkUtil;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class LoginFragment extends Fragment {

    private EditText etEmail;
    private EditText etPassword;
    private boolean isLoggedIn = false;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        initViews();
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    private void initViews() {
        etEmail = getView().findViewById(R.id.et_login_email);
        etPassword = getView().findViewById(R.id.et_login_password);
        Button btnLogin = getView().findViewById(R.id.btn_login);
//        btnLogin.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                new LoginTask().execute();
//            }
//        });
        Button btnRegister = getView().findViewById(R.id.btn_login_register);
        //btnRegister.setOnClickListener(v -> startActivity(new Intent(getActivity(), RegistrationActivity.class)));
    }

    private class LoginTask extends AsyncTask<Void, Void, String> {
        private String url = "http://www.abualzait.site/mobapps/exchangeApp/user/login.php?";
        private String Parameters;

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            try {
                Parameters = "email=" + URLEncoder.encode(etEmail.getText().toString(), "UTF-8") +
                        "&password=" + URLEncoder.encode(etPassword.getText().toString(), "UTF-8");
                url = url + Parameters;
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }

        @Override
        protected String doInBackground(Void... arg0) {
            Log.i("Networks", "Request Url  = " + url);
            String jsonStr = "";
            try {
                jsonStr = NetworkUtil.makeServiceCall(url);
            } catch (Exception e) {
                e.printStackTrace();
            }
            Log.i("Networks", jsonStr);

            if (jsonStr != null) {
                return jsonStr;
            }
            return null;
        }

        @Override
        protected void onPostExecute(String result) {
            if (!result.equalsIgnoreCase("0")) {
                Toast.makeText(getActivity(), "Logged in !!!!", Toast.LENGTH_LONG).show();
                Intent i = new Intent(getActivity(), ItemsViewerActivity.class);
                startActivity(i);
            } else
                Toast.makeText(getActivity(), "Wrong username or Password!!!", Toast
                        .LENGTH_LONG).show();
        }

    }
}
