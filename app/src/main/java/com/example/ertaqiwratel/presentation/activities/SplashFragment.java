package com.example.ertaqiwratel.presentation.activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentSplashBinding;

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


    private void setAnimations() {
        Animation animation = AnimationUtils.loadAnimation(getActivity(), R.anim.fad_in);
        binding.splashAppName.setVisibility(View.VISIBLE);
        binding.splashAppName.setAnimation(animation);

    }
}