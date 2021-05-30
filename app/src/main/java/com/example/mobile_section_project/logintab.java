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
import androidx.fragment.app.Fragment;

public class logintab extends Fragment {
    EditText email,password;
    Button login;
    float v=0;
    public ViewGroup view2;
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup view=(ViewGroup)inflater.inflate(R.layout.login_tab_fragment,container,false);
view2=view;
       email=view.findViewById(R.id.lemail);
        password=view.findViewById(R.id.lpassword);
        login=view.findViewById(R.id.logintab);
        
login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        String newemail = email.getText().toString();
                String newpwd = password.getText().toString();
                SharedPreferences sp =getActivity().getSharedPreferences("MYPREFS", Context.MODE_PRIVATE);
                String details = sp.getString(newemail + newpwd + "data", "Email or password incorrect");
               if(details.compareTo("Email or password incorrect")==0){
                   Toast.makeText(getContext(),"Please Try Again!!!",Toast.LENGTH_LONG).show();
               }
               else {
                   SharedPreferences.Editor editor=sp.edit();
                   editor.putString("display",details);
                   editor.commit();

                   Intent intent =new Intent(getContext(),Home.class);
                   startActivity(intent);
               }

    }
});
        email.setTranslationY(800);
        password.setTranslationY(800);
        login.setTranslationY(800);

        email.setAlpha(v);
        password.setAlpha(v);
        login.setAlpha(v);


        email.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(300).start();
        password.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(500).start();
        login.animate().translationY(0).alpha(1).setDuration(1000).setStartDelay(700).start();

        return view;
    }
}
