package com.example.ertaqiwratel.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ertaqiwratel.R;

public class SplashFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final boolean isFirstTime = true;

        final TextView splashAppName = view.findViewById(R.id.splash_app_name);

        // wait 1 seconds to show text with app name
        // todo add some animation
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                splashAppName.setVisibility(View.VISIBLE);
            }
        },1000);

        // wait 3 seconds to do this
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstTime){
                    // show on boarding Screens
                    ((LandingActivity) getActivity()).hideStarterFragment();
                }else {
                    // go to mainActivity
                    new Intent((LandingActivity)getActivity(),MainActivity.class);
                    getActivity().finish();
                }
            }
        },3000);
    }
}