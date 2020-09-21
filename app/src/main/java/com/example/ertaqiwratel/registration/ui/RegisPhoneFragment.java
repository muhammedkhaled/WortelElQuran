package com.example.ertaqiwratel.registration.ui;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentRegisPhoneBinding;
import com.example.ertaqiwratel.home.pojo.User;
import com.example.ertaqiwratel.utils.Prevalent;
import com.google.android.material.snackbar.Snackbar;


public class RegisPhoneFragment extends Fragment {
    private static final String TAG = "RegisPhoneFragment";
    private FragmentRegisPhoneBinding binding;
    private String userType;
    private NavController mNavController;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisPhoneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(requireActivity(),R.id.login_host_fragment);
        binding.regCpp.registerCarrierNumberEditText(binding.regsEtPhone);
        binding.tvRegLogin
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment));

        binding.regsEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.regCpp.isValidFullNumber() && binding.regsEtPhone.getText().toString().trim().length() != 0) {
                    binding.regBtnLogin.setEnabled(true);
                } else {
                    binding.regBtnLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
                if (!binding.regCpp.isValidFullNumber() && binding.regsEtPhone.getText().toString().trim().length() >= 12) {
                    binding.regBtnLogin.setEnabled(false);
                    binding.regsEtPhone.setError("الرقم غير صحيح");
                }
            }
        });

        binding.regsUtypeRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = (RadioButton) group.findViewById(checkedId);
                userType = rb.getText().toString();
            }
        });

        binding.regBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                if (validateData()) {
                    Prevalent.CURRENT_ONLINE_USER = new User();
                    Prevalent.CURRENT_ONLINE_USER.setPhone(binding.regCpp.getFullNumberWithPlus());
                    Prevalent.CURRENT_ONLINE_USER.setUserType(userType);
                    RegisPhoneFragmentDirections.ActionRegisPhoneFragmentToVerificationCodeFragment action =
                            RegisPhoneFragmentDirections
                                    .actionRegisPhoneFragmentToVerificationCodeFragment(binding.regCpp.getFullNumberWithPlus());
                    mNavController.navigate(action);
                    binding.regBtnLogin.setEnabled(false);
                }
            }
        });
    }

    private boolean validateData() {
        if (userType == null) {
            Snackbar.make(requireView(), "الرجاء تحديد نوعيه المستخدم", Snackbar.LENGTH_LONG).show();
            binding.regsUtypeRg.requestFocus();
            return false;
        } else {
            return true;
        }
    }
}