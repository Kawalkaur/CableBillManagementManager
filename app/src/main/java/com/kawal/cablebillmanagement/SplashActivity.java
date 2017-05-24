package com.kawal.cablebillmanagement;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {
SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        preferences = getSharedPreferences(Util.PREFS_NAME,MODE_PRIVATE);
        boolean isReg = preferences.contains(Util.KEY_EMAIL);
        if (isReg){
            handler.sendEmptyMessageDelayed(101,3000);
        }
        handler.sendEmptyMessageDelayed(102, 3000);
}
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 102) {
                Intent intent = new Intent(SplashActivity.this, ManagerLogin.class);
                startActivity(intent);
                finish();
            }else if (msg.what==101){
                Intent intent = new Intent(SplashActivity.this, ManagerLogin.class);
                startActivity(intent);
                finish();
            }
        }
    };
}