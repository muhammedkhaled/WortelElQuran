package com.example.ertaqiwratel.registration.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentVerificationCodeBinding;
import com.example.ertaqiwratel.utils.Prevalent;


public class VerificationCodeFragment extends Fragment {
    private static final String TAG = "VerificationCodeFragmen";
    private FragmentVerificationCodeBinding binding;
    private NavController mNavController;
    private String mobile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentVerificationCodeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(requireActivity(),R.id.login_host_fragment);
        mobile = VerificationCodeFragmentArgs.fromBundle(getArguments()).getMobile();

        binding.otpViewCode.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                if (s.toString().length() == 4){
                    binding.verifyBtn.setEnabled(true);
                }else {
                    binding.verifyBtn.setEnabled(false);
                }
            }
        });

        String reason = VerificationCodeFragmentArgs.fromBundle(getArguments()).getReason();
        if (reason != null && reason.equals(Prevalent.CHANGE_PHONE_NUMBER)){
            binding.verifyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(requireContext(), LoginActivity.class);
                    requireActivity().startActivity(intent);
                    requireActivity().finish();
                }
            });
        }else {
            binding.verifyBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // todo more than one click crush app make sure onew click per network call or per minte
                    VerificationCodeFragmentDirections.ActionVerificationCodeFragmentToRegisInfoFragment action =
                            VerificationCodeFragmentDirections.actionVerificationCodeFragmentToRegisInfoFragment(mobile);
                    mNavController.navigate(action);

                }
            });
        }

    }
}