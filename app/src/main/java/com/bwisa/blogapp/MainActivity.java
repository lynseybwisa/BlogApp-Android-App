package com.bwisa.blogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //1.1 this code will pause app for 1.5sec and then anything in run will run
       Handler handler = new Handler();
       handler.postDelayed(new Runnable() {
           @Override
           public void run() {
               isFirstTime();

           }
       }, 1500);

    }

    private void isFirstTime() {
        //1.2 for checking if the app is running for the first time
        //we need to save the value to shared preferences
        SharedPreferences preferences = getApplication().getSharedPreferences("onBoard", Context.MODE_PRIVATE);
        Boolean isFirstTime = preferences.getBoolean("isFirstTime", true);
        //1.2.1 default value true
        if (isFirstTime){
            //1.2.2 if its true then its first time and we'll change it false
            SharedPreferences.Editor editor = preferences.edit();
            editor.putBoolean("isFirstTime",false);
            editor.apply();

            //1.2.3 start Onboard activity
            startActivity(new Intent(MainActivity.this,OnBoardActivity.class));
            finish();
        }
        else {
            //1.2.4 start Auth activity
            startActivity(new Intent(MainActivity.this,AuthActivity.class));
            finish();
        }
    }
}