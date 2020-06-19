package com.example.ertaqiwratel.presentation.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ertaqiwratel.R;

public class MyChiehkFrament extends Fragment {
    private AppBarConfiguration mAppBarConfiguration;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_chiehk_frament, container, false);
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        TextView myChiekhNameTv = view.findViewById(R.id.mychiekh_name);

        myChiekhNameTv.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.myChiekhInfo,
                null));

        Toolbar toolbar = view.findViewById(R.id.my_chiekh_toolbar);
//        ((AppCompatActivity)requireActivity()).setSupportActionBar(toolbar);



//        final NavController navController = NavHostFragment.findNavController(this);
//        NavigationUI.setupWithNavController(toolbar, navController);

    }
}