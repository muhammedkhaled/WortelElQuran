package com.example.ertaqiwratel.presentation.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.example.ertaqiwratel.R;
import com.google.android.material.tabs.TabLayout;

import java.util.Locale;

public class LandingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing);
    }

    public void hideStarterFragment() {
        FrameLayout starterView = findViewById(R.id.fragment_view);
        ConstraintLayout introView = findViewById(R.id.intro_view);
        starterView.setVisibility(View.GONE);
        introView.setVisibility(View.VISIBLE);

        // make default direction RTL
        Configuration config = LandingActivity.this.getResources().getConfiguration();
        config.setLayoutDirection(new Locale("ar"));

        ViewPager viewPager = findViewById(R.id.pagerIntroSlider);
        TabLayout tabLayout = findViewById(R.id.tabs);
        final TextView leaveLandingPage = findViewById(R.id.tv_next);

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
        Intent intent = new Intent(LandingActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}