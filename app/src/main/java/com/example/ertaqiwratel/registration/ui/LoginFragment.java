package com.example.ertaqiwratel.registration.ui;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentLoginBinding;
import com.example.ertaqiwratel.home.pojo.User;
import com.example.ertaqiwratel.home.ui.MainActivity;
import com.example.ertaqiwratel.utils.Prevalent;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.loginCpp.registerCarrierNumberEditText(binding.loginEtPhone);

        binding.tvLoginRegisterNow
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_regisPhoneFragment);
                    }
                });

        binding.loginEtPhone.addTextChangedListener(mWatcher);
        binding.loginEtPass.addTextChangedListener(mWatcher);

        binding.regBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Prevalent.CURRENT_ONLINE_USER = new User();
                Prevalent.CURRENT_ONLINE_USER.setUserType("معلم");
                Intent intent = new Intent(requireActivity(), MainActivity.class);
                startActivity(intent);
                requireActivity().finish();
                Toast.makeText(getActivity(), binding.loginCpp.getFullNumberWithPlus(), Toast.LENGTH_SHORT).show();
            }
        });

        binding.loginTvForgotPassword
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(v).navigate(R.id.action_loginFragment_to_forgotPasswordFragment);
                    }
                });

    }

    TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            if (binding.loginCpp.isValidFullNumber() && binding.loginEtPass.getText().toString().trim().length() != 0) {
                binding.regBtnLogin.setEnabled(true);
            } else {
                binding.regBtnLogin.setEnabled(false);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {
            if (!binding.loginCpp.isValidFullNumber() && binding.loginEtPhone.getText().toString().trim().length() >= 12) {
                binding.loginEtPhone.setError("الرقم غير صحيح");
                binding.regBtnLogin.setEnabled(false);
            }
        }
    };
}