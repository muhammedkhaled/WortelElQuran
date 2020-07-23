package com.example.ertaqiwratel.presentation.activities;

import android.content.Intent;
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
import com.example.ertaqiwratel.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding loginBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginBinding = FragmentLoginBinding.inflate(inflater, container, false);
        return loginBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        loginBinding.loginCpp.registerCarrierNumberEditText(loginBinding.loginEtPhone);

        loginBinding.tvLoginRegisterNow
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_regisPhoneFragment);
                    }
                });



        loginBinding.loginEtPhone.addTextChangedListener(mWatcher);
        loginBinding.loginEtPass.addTextChangedListener(mWatcher);

        loginBinding.regBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                requireActivity().finish();

                Toast.makeText(getActivity(), loginBinding.loginCpp.getFullNumberWithPlus(), Toast.LENGTH_SHORT).show();
            }
        });

        loginBinding.loginTvForgotPassword
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_loginFragment_to_forgotPasswordFragment));

    }

    TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (loginBinding.loginCpp.isValidFullNumber() && loginBinding.loginEtPass.getText().toString().trim().length() !=0){
                loginBinding.regBtnLogin.setEnabled(true);
            }else {
                loginBinding.regBtnLogin.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}