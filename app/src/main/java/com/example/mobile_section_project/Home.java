package com.example.mobile_section_project;

import android.content.SharedPreferences;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        SharedPreferences sp=getSharedPreferences("MYPREFS",MODE_PRIVATE);
        String display=sp.getString("display","");
        TextView name=(TextView)findViewById(R.id.textViewname);
        name.setText(display);

    }
}