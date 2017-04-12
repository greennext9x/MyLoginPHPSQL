package com.hoangcuong.myloginphpsql.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.hoangcuong.myloginphpsql.R;
import com.hoangcuong.myloginphpsql.helper.SessionManager;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.name)
    TextView txtName;
    @BindView(R.id.email)
    TextView txtEmail;
    @BindView(R.id.btnLogout)
    Button btnLogout;
    private SessionManager sessionManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        sessionManager = new SessionManager(getApplicationContext());
        if(!sessionManager.isLoggedIn()){
            logoutUer();
        }
        String name = sessionManager.getName();
        String email = sessionManager.getEmail();

        txtName.setText(name);
        txtEmail.setText(email);

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                logoutUer();
            }
        });
    }
    private void logoutUer(){
        sessionManager.setLogin(false);
        sessionManager.clear();
        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
