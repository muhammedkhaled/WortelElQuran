package com.example.ertaqiwratel.presentation.activities.loginDestinations;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentCompleteInfoShBinding;
import com.example.ertaqiwratel.presentation.activities.homeDesitnations.MainActivity;

import java.util.ArrayList;

public class CompleteInfoShFragment extends Fragment {
    private FragmentCompleteInfoShBinding binding;
    private String mUserState, mSuitableDays;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCompleteInfoShBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sSpinnerEntities();
        binding.registerInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent intent = new Intent(requireActivity(), MainActivity.class);
                    startActivity(intent);
                    requireActivity().finish();
            }
        });
    }

    private void inputsDataString() {
        mUserState = binding.regsInfoShStateAcTv.getEditableText().toString().trim();
    }

    private void sSpinnerEntities() {
        binding.regsInfoShStateAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.new_user_state
                , R.layout.list_item_auto_complete_tv));

    }

}