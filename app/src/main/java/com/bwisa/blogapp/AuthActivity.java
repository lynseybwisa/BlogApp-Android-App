package com.bwisa.blogapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.bwisa.blogapp.Fragments.SignInFragment;

public class AuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auth);

        //5.1 make sign in fragment as initial screen of AuthActivity
        getSupportFragmentManager().beginTransaction().replace(R.id.frameAuthContainer,new SignInFragment()).commit();
    }
}