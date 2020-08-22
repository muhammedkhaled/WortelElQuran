package com.example.ertaqiwratel.home.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.ertaqiwratel.databinding.DialogInfoBinding;
import com.example.ertaqiwratel.utils.Prevalent;

public class InfoDialog extends DialogFragment {

    private DialogInfoBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = DialogInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setViews();
    }

    private void setViews() {
        if (Prevalent.CURRENT_ONLINE_USER.getUserType().equals("معلم")) {
            binding.dialogInfoClassLl.setVisibility(View.VISIBLE);
            binding.dialogInfoPhoneLl.setVisibility(View.VISIBLE);
            binding.dialogInfoShiekhLl.setVisibility(View.VISIBLE);
            binding.myChikhInfoTvIgaza.setVisibility(View.GONE);
            binding.dialogInfoStudentTimeLl.setVisibility(View.VISIBLE);
            binding.dialogInoTitle.setText("مواعيد الحضور");
        } else {
            binding.dialogInfoClassLl.setVisibility(View.GONE);
            binding.dialogInfoPhoneLl.setVisibility(View.GONE);
            binding.dialogInfoShiekhLl.setVisibility(View.GONE);
            binding.dialogInfoStudentTimeLl.setVisibility(View.GONE);
        }

    }

}