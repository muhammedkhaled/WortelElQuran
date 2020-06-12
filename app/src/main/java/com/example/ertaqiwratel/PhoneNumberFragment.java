package com.example.ertaqiwratel;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.text.Editable;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class PhoneNumberFragment extends Fragment {
    Button nextButton;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.phone_number_fragment, container, false);

        final TextInputLayout PhoneNumberInput=view.findViewById(R.id.edt_phone_textinput);
        final TextInputEditText PhoneNumberEditText=view.findViewById(R.id.edt_phone_number);
        nextButton =view.findViewById(R.id.btn_login);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // this for checked the phone number is valid or not
                if(isPhoneNumberValid(PhoneNumberEditText.getText())){
                    PhoneNumberInput.setError(getString(R.string.loginError));
                }else {
                    PhoneNumberInput.setError(null); // clear the Error
                    ((NavigationHost)getActivity()).navigateTo(new VrificationCodeFragment(),false);



                }
            }
        });

        PhoneNumberEditText.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                return false;
            }
        });

                return view;
    }

    private boolean isPhoneNumberValid(@Nullable Editable text){
        return text != null && text.length() >=11;
    }


}