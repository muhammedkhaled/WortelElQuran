package com.example.ertaqiwratel.presentation.activities;

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
import android.widget.Toast;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentRegisPhoneBinding;


public class RegisPhoneFragment extends Fragment {
    private FragmentRegisPhoneBinding regisPhoneBinding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        regisPhoneBinding = FragmentRegisPhoneBinding.inflate(inflater, container, false);
        return regisPhoneBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        regisPhoneBinding.regCpp.registerCarrierNumberEditText(regisPhoneBinding.regsEtPhone);
        regisPhoneBinding.tvRegLogin
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment));

        regisPhoneBinding.regsEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (regisPhoneBinding.regCpp.isValidFullNumber()){
                    regisPhoneBinding.regBtnLogin.setEnabled(true);
                }else {
                    regisPhoneBinding.regBtnLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        regisPhoneBinding.regBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), regisPhoneBinding.regCpp.getFullNumberWithPlus(), Toast.LENGTH_SHORT).show();

                // todo send number with action args to verificationCodeFragment
                Navigation.findNavController(v).navigate(R.id.verificationCodeFragment);
            }
        });

    }
}