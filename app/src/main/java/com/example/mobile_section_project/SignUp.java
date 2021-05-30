package com.example.mobile_section_project;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    TabLayout tabLayout;
    ViewPager viewPager;
    FloatingActionButton fb,google,apple;
    float v=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
//        shared pref
//        final EditText name=(EditText) findViewById(R.id.name);
//        final EditText email=(EditText) findViewById(R.id.lemail);
//        final EditText pwd=(EditText) findViewById(R.id.lpassword);
//        Button signup=(Button)findViewById(R.id.signuptab);

//        Animation of screen
        tabLayout=findViewById(R.id.layout);
        viewPager=findViewById(R.id.viewer);
        fb=findViewById(R.id.facebook);
        google=findViewById(R.id.google);
        apple=findViewById(R.id.apple);

        tabLayout.addTab(tabLayout.newTab().setText("Login"));
        tabLayout.addTab(tabLayout.newTab().setText("SignUp"));
        tabLayout.setTabGravity(tabLayout.GRAVITY_FILL);

        final loginadaptor adaptor=new loginadaptor(getSupportFragmentManager(),this,tabLayout.getTabCount());
        viewPager.setAdapter(adaptor);
        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        fb.setTranslationY(300);
        google.setTranslationY(300);
        apple.setTranslationY(300);

        fb.setAlpha(v);
        google.setAlpha(v);
        apple.setAlpha(v);
        tabLayout.setAlpha(v);

        fb.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(400).start();
        google.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(600).start();
        apple.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();
        tabLayout.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(800).start();

    }
}