package com.example.ertaqiwratel.registration.ui;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.utils.Prevalent;
import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentRegisInfoBinding;
import com.google.android.material.snackbar.Snackbar;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;


public class RegisInfoFragment extends Fragment {
    private FragmentRegisInfoBinding binding;
    private final Calendar mCalendar = Calendar.getInstance();
    private NavController mNavController;
    private String mMobile, mFullName, mEmail, mPass, mConPass, mGender, mCountry, mGovernorate, mBirthDate;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentRegisInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mNavController = Navigation.findNavController(requireActivity(),R.id.login_host_fragment);

        sSpinnerEntities();
        addTextWatcher();
        getInputsData();

        mMobile = RegisInfoFragmentArgs.fromBundle(getArguments()).getMobile();

        binding.registerInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUserData()) {
                    String userType = Prevalent.CURRENT_ONLINE_USER.getUserType();
                    if (userType.equals("معلم")){
                        completeShiekhInfo();
                    }else {
                        completeStudentInfo();
                    }
                }

            }
        });

        binding.regsBirthDateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCalendar.set(Calendar.YEAR, 1990);
                mCalendar.set(Calendar.MONTH, 1);
                mCalendar.set(Calendar.DAY_OF_MONTH, 1);
                new DatePickerDialog(requireContext(), R.style.DatePickerTheme, mDate, mCalendar
                        .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                        mCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    private void completeStudentInfo() {
        RegisInfoFragmentDirections.ActionRegisInfoFragmentToCompleteInfoFragmentSt action =
                RegisInfoFragmentDirections.actionRegisInfoFragmentToCompleteInfoFragmentSt(
                        mMobile, mFullName, mEmail, mPass, mConPass, mCountry, mGovernorate, mGender, mBirthDate);
        mNavController.navigate(action);
    }

    private void completeShiekhInfo() {
        RegisInfoFragmentDirections.ActionRegisInfoFragmentToCompleteInfoShFragment action =
                RegisInfoFragmentDirections.actionRegisInfoFragmentToCompleteInfoShFragment(
                       mMobile, mFullName, mEmail, mPass, mConPass, mCountry, mGovernorate, mGender, mBirthDate);
        mNavController.navigate(action);
    }

    private boolean validateUserData() {
        getInputsData();

        if (mFullName.length() <= 6) {
            binding.regsInfoFullNameEt.setError("الرجاء ادخال الاسم بالكامل");
            binding.regsInfoFullNameEt.requestFocus();
            return false;
        }
        else if (android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()) {
            binding.regsInfoEmailEt.setError("برجاء ادخال البريد الاكترونى");
            binding.regsInfoEmailEt.requestFocus();
            return false;
        }
        else if (mPass.length() <= 6) {
            binding.regsInfoPassEt.setError("برجاء ادخال كلمه سر اكثر من 6 حروف او ارقام", null);
            binding.regsInfoPassEt.requestFocus();
            return false;
        } else if (!mConPass.equals(mPass)) {
            binding.regsInfoConPassEt.setError("كلمه السر غير مطابقه", null);
            binding.regsInfoConPassEt.requestFocus();
            return false;
        } else if (mGender.isEmpty()) {
            binding.regsInfoGenderAcTv.setError("برجاء تحديد النوع", null);
            binding.regsInfoGenderAcTv.requestFocus();
            return false;
        } else if (mCountry.isEmpty()) {
            binding.regsCountryAcTv.setError("برجاء اختيار المحافظه", null);
            binding.regsCountryAcTv.requestFocus();
            return false;
        } else if (mCountry.equals("مصر") && mGovernorate.isEmpty()) {
            binding.regsInfoGovernorateAcTv.setError("برجاء اختيار المحافظه", null);
            binding.regsInfoGovernorateAcTv.requestFocus();
            return false;
        } else if (mBirthDate.isEmpty()) {
            Snackbar.make(requireView(), "برجاء ادخال تاريخ الميلاد", Snackbar.LENGTH_LONG).show();
            binding.regsBirthDateBtn.requestFocus();
            return false;
        } else {
            return true;
        }
    }

    DatePickerDialog.OnDateSetListener mDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, monthOfYear);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
            SimpleDateFormat sDFormat = new SimpleDateFormat("dd MM, yyyy", Locale.getDefault());
            binding.regsBirthDateBtn.setText(sDFormat.format(mCalendar.getTime()));
        }
    };

    private void getInputsData() {
        mFullName = binding.regsInfoFullNameEt.getText().toString().trim();
        mEmail = binding.regsInfoFullNameEt.getText().toString().trim();
        mPass = binding.regsInfoPassEt.getText().toString().trim();
        mConPass = binding.regsInfoConPassEt.getText().toString().trim();
        mGender = (binding.regsInfoGenderAcTv.getText().toString().equals("ذكر")) ? "m":"f";
        mCountry = binding.regsCountryAcTv.getEditableText().toString();
        mGovernorate = binding.regsInfoGovernorateAcTv.getEditableText().toString();
        mBirthDate = binding.regsBirthDateBtn.getText().toString();
    }

    private void addTextWatcher() {
        binding.regsInfoFullNameEt.addTextChangedListener(mWatcher);
        binding.regsInfoEmailEt.addTextChangedListener(mWatcher);
        binding.regsInfoPassEt.addTextChangedListener(mWatcher);
        binding.regsInfoConPassEt.addTextChangedListener(mWatcher);
    }

    private final TextWatcher mWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            mFullName = binding.regsInfoFullNameEt.getText().toString().trim();
            mEmail = binding.regsInfoFullNameEt.getText().toString().trim();
            mPass = binding.regsInfoPassEt.getText().toString().trim();
            mConPass = binding.regsInfoConPassEt.getText().toString().trim();

            if (mFullName.length() != 0 && mPass.length() != 0 && mConPass.length() != 0 && mEmail.length() != 0) {
                binding.registerInfoBtn.setEnabled(true);
            } else {
                binding.registerInfoBtn.setEnabled(false);
            }
        }
    };


    private void sSpinnerEntities() {
        binding.regsInfoGenderAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.sex
                , R.layout.list_item_auto_complete_tv));
        binding.regsInfoGovernorateAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.governorate
                , R.layout.list_item_auto_complete_tv));

        binding.regsCountryAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.countries
                , R.layout.list_item_auto_complete_tv));
        binding.regsCountryAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String stateType = parent.getItemAtPosition(position).toString();
                if (stateType.equals("مصر")) {
                    binding.regsInfoGovernorateTil.setVisibility(View.VISIBLE);
                } else {
                    binding.regsInfoGovernorateTil.setVisibility(View.GONE);
                }
            }
        });

    }

}