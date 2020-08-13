package com.example.ertaqiwratel.home.ui;

import android.os.Bundle;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.DialogProfileBottomSheetBinding;
import com.example.ertaqiwratel.utils.Prevalent;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.android.material.snackbar.BaseTransientBottomBar;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputLayout;


public class ProfileBottomSheetDialog extends BottomSheetDialogFragment {
    private DialogProfileBottomSheetBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = DialogProfileBottomSheetBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        binding.profileBSBtnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        assert getArguments() != null;
        String reason = ProfileBottomSheetDialogArgs.fromBundle(getArguments()).getReason();
        setViews(reason);
    }

    private void setViews(String reason) {
        TextInputLayout firstTil = binding.profileBSFirstTil;
        TextInputLayout secondTil = binding.profileBSSecondTil;
        EditText secondEt = binding.profileBSSecondEt;

        if (reason.equals(Prevalent.EMAIL)){
            secondTil.setHint("البريد الاكترونى الجديد");
            secondEt.setInputType(InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS);

            binding.profileBSBtnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // change email at database
                    dismiss();

                }
            });
        }
        else if (reason.equals(Prevalent.PHONE_NUMBER)){
            binding.changePhoneLl.setVisibility(View.VISIBLE);
            secondTil.setVisibility(View.GONE);
            binding.changeCpp.registerCarrierNumberEditText(binding.changePhoneEt);
            binding.profileBSBtnSave.setText("تأكيد");
            binding.profileBSBtnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    verifyPhoneNumber(v);
                }
            });
        }
        else if (reason.equals(Prevalent.PASSWORD)){
            firstTil.setHint("كلمه المرور القديمه");
            secondTil.setHint("كلمه المرور الجديده");
            secondEt.setInputType(InputType.TYPE_NUMBER_VARIATION_PASSWORD);
            secondTil.setPasswordVisibilityToggleEnabled(true);

            binding.profileBSBtnSave.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // save new pass at database
                    dismiss();
                }
            });
        }

    }

    private void verifyPhoneNumber(View v) {
        if (binding.changeCpp.isValidFullNumber() && binding.changePhoneEt.getText().toString().trim().length() >= 7 ){
            ProfileBottomSheetDialogDirections.ActionProfileBottomSheetFragmentToVerificationCodeFragment2 action =
                    ProfileBottomSheetDialogDirections.actionProfileBottomSheetFragmentToVerificationCodeFragment2();
            action.setReason(Prevalent.CHANGE_PHONE_NUMBER);
            Navigation.findNavController(requireActivity(),R.id.nav_host_fragment).navigate(action);
        }else {
            Snackbar.make(v,"الرجاء ادخال رقم صحيح", BaseTransientBottomBar.LENGTH_LONG).show();
        }
    }
}