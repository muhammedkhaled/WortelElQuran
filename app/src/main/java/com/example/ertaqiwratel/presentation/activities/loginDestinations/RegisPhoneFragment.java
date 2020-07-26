package com.example.ertaqiwratel.presentation.activities.loginDestinations;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentRegisPhoneBinding;
import com.example.ertaqiwratel.presentation.activities.Prevalent;


public class RegisPhoneFragment extends Fragment {
    private FragmentRegisPhoneBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisPhoneBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.regCpp.registerCarrierNumberEditText(binding.regsEtPhone);
        binding.tvRegLogin
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.loginFragment));

        binding.regsEtPhone.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (binding.regCpp.isValidFullNumber()) {
                    binding.regBtnLogin.setEnabled(true);
                } else {
                    binding.regBtnLogin.setEnabled(false);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        binding.regBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Prevalent.CURRENT_ONLINE_USER.setPhone(binding.regCpp.getFullNumber());
                RadioButton btn = (RadioButton) binding.regsUtypeRg
                        .getChildAt(binding.regsUtypeRg.getCheckedRadioButtonId());
                if (btn != null){
                    Prevalent.CURRENT_ONLINE_USER.setUserType(btn.getText().toString());
                }
                // todo send number with action args to verificationCodeFragment
                Navigation.findNavController(v).navigate(R.id.action_regisPhoneFragment_to_verificationCodeFragment);
            }
        });


    }
}