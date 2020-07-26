package com.example.ertaqiwratel.presentation.activities.landingDestinations;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.presentation.activities.adapter.OnBoardingSliderPageAdapter;
import com.example.ertaqiwratel.presentation.activities.loginDestinations.LoginActivity;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);

        // set local to ar to change app direction to rtl and language to ar
        Locale locale = new Locale("ar");
        Locale.setDefault(locale);
        Configuration config =
                getBaseContext().getResources().getConfiguration();
        config.setLocale(locale);
        createConfigurationContext(config);
    }


    public void hideStarterFragment() {
        FrameLayout starterView = findViewById(R.id.fragment_view);
        ConstraintLayout introView = findViewById(R.id.intro_view);
        starterView.setVisibility(View.GONE);
        introView.setVisibility(View.VISIBLE);

        ViewPager viewPager = findViewById(R.id.pagerIntroSlider);
        TabLayout tabLayout = findViewById(R.id.tabs);
        final Button leaveLandingPage = findViewById(R.id.btn_next);

        final OnBoardingSliderPageAdapter adapter = new OnBoardingSliderPageAdapter(getSupportFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);

        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    leaveLandingPage.setVisibility(View.VISIBLE);
                } else {
                    leaveLandingPage.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

        leaveLandingPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                leaveLandingPage();
            }
        });
    }


    private void leaveLandingPage() {
        Intent intent = new Intent(LandingActivity.this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}