package com.example.ertaqiwratel.presentation.activities.destinations.navUi.profile;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;


public class ProfileFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragmnet_profile, container, false);
        root.findViewById(R.id.change_profile_image_btn).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addNewDayFragment));
        return root;
    }
}