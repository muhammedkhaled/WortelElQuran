package com.example.ertaqiwratel.presentation.activities.loginDestinations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentForgotPasswordBinding;

public class ForgotPasswordFragment extends Fragment {

    private FragmentForgotPasswordBinding passwordBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        passwordBinding = FragmentForgotPasswordBinding.inflate(inflater, container, false);
        return passwordBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        passwordBinding.forgotPassCpp.registerCarrierNumberEditText(passwordBinding.forgotPassEtPhone);

        passwordBinding.forgotPassEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (passwordBinding.forgotPassCpp.isValidFullNumber()){
                    passwordBinding.forgotPassBtn.setEnabled(true);
                }else {
                    passwordBinding.forgotPassBtn.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        passwordBinding.forgotPassBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // todo send number with action args to verificationCodeFragment
                Navigation.findNavController(v).navigate(R.id.verificationCodeFragment);
            }
        });

    }
}