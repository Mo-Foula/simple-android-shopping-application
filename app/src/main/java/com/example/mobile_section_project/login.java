package com.example.mobile_section_project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.tabs.TabLayout;

public class login extends AppCompatActivity {
TabLayout tabLayout;
ViewPager viewPager;
FloatingActionButton fb,google,apple;
float v=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        //shared perferences
        final EditText email=(EditText) findViewById(R.id.lemail);
        final EditText pwd=(EditText) findViewById(R.id.lpassword);
        Button login=(Button)findViewById(R.id.logintab);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newemail = email.getText().toString();
                String newpwd = pwd.getText().toString();
                SharedPreferences sp = getSharedPreferences("MYPREFS", MODE_PRIVATE);
                String details = sp.getString(newemail + newpwd + "data", "Email or password incorrect");
                SharedPreferences.Editor editor=sp.edit();
                editor.putString("display",details);
                editor.commit();
                Intent intent =new Intent(login.this,Home.class);
                startActivity(intent);
            }
        });

        //        animation
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