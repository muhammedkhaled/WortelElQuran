package com.example.ertaqiwratel.presentation.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentRegisInfoBinding;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;


public class RegisInfoFragment extends Fragment {
    private static final String TAG = "RegisInfoFragment";
    private FragmentRegisInfoBinding regisInfoBinding;
    private final Calendar mCalendar = Calendar.getInstance();

    private String mFullName, mEmail, mPass, mConPass, mBirthDate, mGender, mCountry, mGovernorate,
            mUserState, mSuitableDay, mSuitableTime, mShiekhName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        regisInfoBinding = FragmentRegisInfoBinding.inflate(inflater, container, false);
        return regisInfoBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sSpinnerEntities();
        addTextWatcher();
        inputsDataString();
        regisInfoBinding.regsBirthDateEt.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    mCalendar.set(Calendar.YEAR, 1990);
                    mCalendar.set(Calendar.MONTH, 1);
                    mCalendar.set(Calendar.DAY_OF_MONTH, 1);
                    new DatePickerDialog(requireContext(), R.style.DatePickerTheme, mDate, mCalendar
                            .get(Calendar.YEAR), mCalendar.get(Calendar.MONTH),
                            mCalendar.get(Calendar.DAY_OF_MONTH)).show();
                }
                return true;
            }
        });

        regisInfoBinding.registerInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUserData()){
                    Toast.makeText(requireContext(), "done", Toast.LENGTH_SHORT).show();
                }
                // todo navigate to next destination
            }
        });
    }

    private boolean validateUserData() {
        inputsDataString();

        if (mFullName.isEmpty() || mFullName.length() <= 6) {
            regisInfoBinding.regsInfoFullNameEt.setError("الرجاء ادخال الاسم بالكامل");
            regisInfoBinding.regsInfoFullNameEt.requestFocus();
            return false;
        } else if (mEmail.isEmpty() || android.util.Patterns.EMAIL_ADDRESS.matcher(mEmail).matches()){
            regisInfoBinding.regsInfoEmailEt.setError("برجاء ادخال البريد الاكترونى");
            regisInfoBinding.regsInfoEmailEt.requestFocus();
            return false;
        }else if (mPass.isEmpty() || mPass.length() <= 6){
            regisInfoBinding.regsInfoPassEt.setError("برجاء ادخال كلمه سر اكثر من 6 حروف او ارقام", null);
            regisInfoBinding.regsInfoPassEt.requestFocus();
            return false;
        }else if (mConPass.isEmpty() || !mConPass.equals(mPass)){
            regisInfoBinding.regsInfoConPassEt.setError("كلمه السر غير مطابقه", null);
            regisInfoBinding.regsInfoConPassEt.requestFocus();
            return false;
        }else if (mBirthDate.isEmpty()){
            regisInfoBinding.regsBirthDateEt.setError("برجاء ادخال تاريخ الميلاد", null);
            regisInfoBinding.regsBirthDateEt.requestFocus();
            return false;
        }else if (mGender.isEmpty()){
            regisInfoBinding.regsInfoGenderAcTv.setError("برجاء تحديد النوع", null);
            regisInfoBinding.regsInfoGenderAcTv.requestFocus();
            return false;
        }else if (mCountry.isEmpty()){
            regisInfoBinding.regsCountryAcTv.setError("برجاء اختيار المحافظه", null);
            regisInfoBinding.regsCountryAcTv.requestFocus();
            return false;
        }else if (mCountry.equals("مصر") && mGovernorate.isEmpty()){
            regisInfoBinding.regsInfoGovernorateAcTv.setError("برجاء اختيار المحافظه", null);
            regisInfoBinding.regsInfoGovernorateAcTv.requestFocus();
            return false;
        }else if (mSuitableDay.isEmpty()){
            regisInfoBinding.regsInfoDayAcTv.setError("برجاء اختيار اليوم المناسب للجلسه اسبوعيا", null);
            regisInfoBinding.regsInfoDayAcTv.requestFocus();
            return false;
        }else if (mSuitableTime.isEmpty()){
            regisInfoBinding.regsInfoTimeAcTv.setError("برجاء اختيار التوقيت المناسب للجلسه اسبوعيا", null);
            regisInfoBinding.regsInfoTimeAcTv.requestFocus();
            return false;
        }else {
            return true;
        }
    }

    private void inputsDataString() {
        mFullName = regisInfoBinding.regsInfoFullNameEt.getText().toString().trim();
        mEmail = regisInfoBinding.regsInfoFullNameEt.getText().toString().trim();
        mPass = regisInfoBinding.regsInfoPassEt.getText().toString().trim();
        mConPass = regisInfoBinding.regsInfoConPassEt.getText().toString().trim();
        mBirthDate = regisInfoBinding.regsBirthDateEt.getText().toString().trim();
        mGender = regisInfoBinding.regsInfoGenderAcTv.getText().toString().trim();
        mCountry = regisInfoBinding.regsCountryAcTv.getEditableText().toString().trim();
        mGovernorate = regisInfoBinding.regsInfoGovernorateAcTv.getEditableText().toString().trim();
        mUserState = regisInfoBinding.regsInfoStStateAcTv.getEditableText().toString().trim();
        mSuitableDay = regisInfoBinding.regsInfoDayAcTv.getEditableText().toString().trim();
        mSuitableTime = regisInfoBinding.regsInfoTimeAcTv.getEditableText().toString().trim();
        mShiekhName = regisInfoBinding.regsInfoShiekhAcTv.getEditableText().toString().trim();
    }

    private void addTextWatcher() {
        regisInfoBinding.regsInfoFullNameEt.addTextChangedListener(mWatcher);
        regisInfoBinding.regsInfoEmailEt.addTextChangedListener(mWatcher);
        regisInfoBinding.regsInfoPassEt.addTextChangedListener(mWatcher);
        regisInfoBinding.regsInfoConPassEt.addTextChangedListener(mWatcher);
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
            mFullName = regisInfoBinding.regsInfoFullNameEt.getText().toString().trim();
            mEmail = regisInfoBinding.regsInfoFullNameEt.getText().toString().trim();
            mPass = regisInfoBinding.regsInfoPassEt.getText().toString().trim();
            mConPass = regisInfoBinding.regsInfoConPassEt.getText().toString().trim();

            if (mFullName.length() != 0 && mPass.length() !=0 && mConPass.length() != 0 && mEmail.length() != 0) {
                regisInfoBinding.registerInfoBtn.setEnabled(true);
            } else {
                regisInfoBinding.registerInfoBtn.setEnabled(false);
            }
        }
    };


    DatePickerDialog.OnDateSetListener mDate = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            mCalendar.set(Calendar.YEAR, year);
            mCalendar.set(Calendar.MONTH, monthOfYear);
            mCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat sDFormat = new SimpleDateFormat("dd MM, yyyy", Locale.getDefault());
            regisInfoBinding.regsBirthDateEt.setText(sDFormat.format(mCalendar.getTime()));
        }
    };

    private void sSpinnerEntities() {

        regisInfoBinding.regsInfoGenderAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.sex
                , R.layout.list_item_auto_complete_tv));

        regisInfoBinding.regsInfoGovernorateAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.governorate
                , R.layout.list_item_auto_complete_tv));

        regisInfoBinding.regsCountryAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.countries
                , R.layout.list_item_auto_complete_tv));
        regisInfoBinding.regsCountryAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String stateType = parent.getItemAtPosition(position).toString();
                if (stateType.equals("مصر")) {
                    regisInfoBinding.regsInfoGovernorateTil.setVisibility(View.VISIBLE);
                } else {
                    regisInfoBinding.regsInfoGovernorateTil.setVisibility(View.GONE);
                }
            }
        });

        regisInfoBinding.regsInfoStStateAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.new_user_state
                , R.layout.list_item_auto_complete_tv));
        regisInfoBinding.regsInfoStStateAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String stateType = parent.getItemAtPosition(position).toString();

                switch (stateType) {
                    case "جديد":
                        regisInfoBinding.regsInfoQuranAmountTil.setVisibility(View.VISIBLE);
                        regisInfoBinding.regsInfoClassTil.setVisibility(View.GONE);
                        return;
                    case "مشترك":
                        regisInfoBinding.regsInfoQuranAmountTil.setVisibility(View.GONE);
                        regisInfoBinding.regsInfoClassTil.setVisibility(View.VISIBLE);
                        return;
                    default:
                        regisInfoBinding.regsInfoQuranAmountTil.setVisibility(View.GONE);
                        regisInfoBinding.regsInfoClassTil.setVisibility(View.GONE);
                }
            }
        });

        regisInfoBinding.regsInfoClassAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.classes
                , R.layout.list_item_auto_complete_tv));

        regisInfoBinding.regsInfoDayAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.days
                , R.layout.list_item_auto_complete_tv));

        regisInfoBinding.regsInfoTimeAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.time
                , R.layout.list_item_auto_complete_tv));

        ArrayList<String> shiekhName = new ArrayList<String>() {{
            add("لا أعرف احد");
            add("الشيخ ياسر");
            add("الشيخ محمد عبد الغنى");
            add("الشيخ عماد");
            add("الشيخ محمد عبد المنعم");
        }};
        regisInfoBinding.regsInfoShiekhAcTv.setAdapter(new ArrayAdapter<String>
                (requireContext(), R.layout.list_item_auto_complete_tv,
                        shiekhName));
    }

}