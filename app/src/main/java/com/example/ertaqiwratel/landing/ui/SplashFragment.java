package com.example.ertaqiwratel.landing.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentSplashBinding;
import com.example.ertaqiwratel.registration.ui.LoginActivity;

public class SplashFragment extends Fragment {
    private FragmentSplashBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        final boolean isFirstTime = true;
        // wait 1 seconds to show text with app name
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                setAnimations();
            }

        },750);

        // wait 3 seconds to do this
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isFirstTime){
                    // show on boarding Screens
                    ((LandingActivity) requireActivity()).hideStarterFragment();
                }else {
                    // go to mainActivity
                    startActivity(new Intent((LandingActivity)getActivity(), LoginActivity.class));
                    getActivity().finish();
                }
            }
        },2000);
    }


    private void setAnimations() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fad_in_splash);
        binding.splashAppName.setVisibility(View.VISIBLE);
        binding.splashAppName.setAnimation(animation);

    }
}