package com.example.mobile_section_project;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

public class signuptab  extends Fragment {
    EditText email,password,name;
    Button login;
    float v=0;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view=(ViewGroup)inflater.inflate(R.layout.signup_tab_fragment,container,false);
        email=view.findViewById(R.id.lemail);
        password=view.findViewById(R.id.lpassword);
        name=view.findViewById(R.id.name);
        login=view.findViewById(R.id.signuptab);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("A","first");
                SharedPreferences sp=getActivity().getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
                String newname=name.getText().toString();
                String newemail=email.getText().toString();
                String newpwd=password.getText().toString();
                SharedPreferences.Editor editor=sp.edit();
                editor.putString(newemail+newpwd+"data",newname);
//                editor.putString("email",newemail);
//                editor.putString("pwd",newpwd);
//                editor.putString("name",newname);
                editor.commit();
                Toast.makeText(getContext(),"Account created successfuly ♥ ",Toast.LENGTH_LONG).show();

            }
        });

        email.setTranslationY(800);
        password.setTranslationY(800);
        login.setTranslationY(800);
        name.setTranslationY(800);

        email.setAlpha(v);
        password.setAlpha(v);
        login.setAlpha(v);
        name.setAlpha(v);

        name.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();
        return view;

    }
}
