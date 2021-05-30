package com.example.mobile_section_project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.airbnb.lottie.LottieAnimationView;

public class IntroductionActivity extends AppCompatActivity {
ImageView logo,name,splash ;
LottieAnimationView lav;
private static final int num=3;
private ViewPager viewPager;
private adaptor pgadaptor;
Animation anim;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_introduction);
        logo=findViewById(R.id.logo);
        name=findViewById(R.id.appname);
        splash=findViewById(R.id.img);
        lav=findViewById(R.id.lottie);
        splash.animate().translationY(-2200).setDuration(1000).setStartDelay(4000);
        logo.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        name.animate().translationY(2000).setDuration(1000).setStartDelay(4000);
        lav.animate().translationY(2000).setDuration(1000).setStartDelay(4000);

        viewPager=findViewById(R.id.pager);
        pgadaptor=new adaptor(getSupportFragmentManager());
        viewPager.setAdapter(pgadaptor);

        anim= AnimationUtils.loadAnimation(this,R.anim.o_b_anim);
        viewPager.startAnimation(anim);
    }
    private class adaptor extends FragmentStatePagerAdapter{

        public adaptor(@NonNull FragmentManager fm) {
            super(fm);
        }

        @NonNull
        @Override
        public Fragment getItem(int position) {
            switch (position){
                case 0:
                    onboardingfragment tab=new onboardingfragment();
                    return tab;
                case 1:
                    onboardingfragment2 tab2=new onboardingfragment2();
                    return tab2;
                case 2:
                    onboardingfragment1 tab1=new onboardingfragment1();
                    return tab1;
            }
            return null;
        }

        @Override
        public int getCount() {
            return num;
        }
    }
}