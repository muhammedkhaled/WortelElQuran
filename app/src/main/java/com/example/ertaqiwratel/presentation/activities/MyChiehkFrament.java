package com.example.ertaqiwratel.presentation.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.AppBarConfiguration;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toolbar;

import com.example.ertaqiwratel.R;

public class MyChiehkFrament extends Fragment {

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
//        myChiekhNameTv.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Navigation.findNavController(view).navigate(R.id.myChiekhInfo);
//
//            }
//        });

    }
}