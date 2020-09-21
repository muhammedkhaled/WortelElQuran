package com.example.ertaqiwratel.registration.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.checkPoint.CheckPointActivity;
import com.example.ertaqiwratel.databinding.FragmentCompleteInfoStBinding;

import java.util.ArrayList;

public class CompleteInfoFragmentSt extends Fragment {
    private static final String TAG = "CompleteInfoFragmentSt";
    private FragmentCompleteInfoStBinding binding;
    private String mUserState, mPreviousPreservation;
    private int mSuitableDay, mSuitableTime, mSelectedShiekh, mCurrentClass;
    private String mMobile, mFullName, mEmail, mPass, mConPass, mGender, mCountry, mGovernorate, mBirthDate;
    private ArrayList<String> daysArray = new ArrayList<>();
    private ArrayList<String> shiekhNamesArray = new ArrayList<>();
    private ArrayList<String> timesArray = new ArrayList<>();
    private ArrayList<String> classesArray = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentCompleteInfoStBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        sSpinnerEntities();

        mMobile = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getMobile();
        mFullName = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getName();
        mEmail = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getEmail();
        mPass = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getPass();
        mConPass = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getCPass();
        mGender = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getGender();
        mCountry = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getCountry();
        mGovernorate = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getGovernorate();
        mBirthDate = CompleteInfoFragmentStArgs.fromBundle(getArguments()).getDateOfBirth();

        binding.registerInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUserData()){
                    Intent intent = new Intent(requireActivity(), CheckPointActivity.class);
                    startActivity(intent);
                    requireActivity().finish();
                }
            }
        });
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
            inputsDataString();
            if (!mUserState.isEmpty()  && !binding.regsInfoDayAcTv.getEditableText().toString().isEmpty()
                    && !binding.regsInfoTimeAcTv.getEditableText().toString().isEmpty()
                    && !binding.regsInfoShiekhAcTv.getEditableText().toString().isEmpty()) {
                binding.registerInfoBtn.setEnabled(true);
            } else {
                binding.registerInfoBtn.setEnabled(false);
            }
        }
    };


    private boolean validateUserData(){
        inputsDataString();
        if (mUserState.isEmpty()){
            binding.regsInfoStStateAcTv.setError("برجاء تحديد نوع الاشتراك", null);
            binding.regsInfoStStateAcTv.requestFocus();
            return false;
        }
        else if (mUserState.isEmpty()){
            binding.regsInfoStStateAcTv.setError("برجاء اختيار اليوم المناسب للجلسه اسبوعيا", null);
            binding.regsInfoStStateAcTv.requestFocus();
            return false;
        }
        else if (binding.regsInfoDayAcTv.getEditableText().toString().isEmpty()){
            binding.regsInfoDayAcTv.setError("برجاء اختيار اليوم المناسب للجلسه اسبوعيا", null);
            binding.regsInfoDayAcTv.requestFocus();
            return false;
        }
        else if (binding.regsInfoTimeAcTv.getEditableText().toString().isEmpty()){
            binding.regsInfoTimeAcTv.setError("برجاء اختيار التوقيت المناسب للجلسه اسبوعيا", null);
            binding.regsInfoTimeAcTv.requestFocus();
            return false;
        }
        else if (binding.regsInfoShiekhAcTv.getEditableText().toString().isEmpty()){
           binding.regsInfoShiekhAcTv.setError("برجاء اختيار الشيخ", null);
           binding.regsInfoShiekhAcTv.requestFocus();
           return false;
       }
       else {
            return true;
        }
    }

    private void inputsDataString() {
//        mSuitableDay = daysArray.indexOf(binding.regsInfoDayAcTv.getEditableText().toString())+ 1 ;
//        mSuitableTime = timesArray.indexOf(binding.regsInfoTimeAcTv.getEditableText().toString())+ 1;
//        mShiekhName = shiekhNamesArray.indexOf(binding.regsInfoShiekhAcTv.getEditableText().toString())+ 1;

        mUserState = (binding.regsInfoStStateAcTv.getEditableText().toString().equals("اشتراك جديد"))? "new":"old";

        binding.regsInfoDayAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSuitableDay = position + 1;
                Log.d(TAG, "inputsDataString: "+ (position+1));
            }
        });

        binding.regsInfoTimeAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSelectedShiekh = position + 1;
            }
        });

        binding.regsInfoShiekhAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mSuitableTime = position + 1;
            }
        });

        binding.regsInfoClassAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mCurrentClass = position + 1;
            }
        });
    }

    private void sSpinnerEntities() {
        binding.regsInfoStStateAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.new_user_state
                , R.layout.list_item_auto_complete_tv));
        binding.regsInfoStStateAcTv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String stateType = parent.getItemAtPosition(position).toString();
                switch (stateType) {
                    case "اشتراك جديد":
                        binding.regsInfoQuranAmountTil.setVisibility(View.VISIBLE);
                        binding.regsInfoClassTil.setVisibility(View.GONE);
                        return;
                    case "مشترك سابقا":
                        binding.regsInfoQuranAmountTil.setVisibility(View.GONE);
                        binding.regsInfoClassTil.setVisibility(View.VISIBLE);
                        return;
                    default:
                        binding.regsInfoQuranAmountTil.setVisibility(View.GONE);
                        binding.regsInfoClassTil.setVisibility(View.GONE);
                }
            }
        });

        binding.regsInfoClassAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.classes
                , R.layout.list_item_auto_complete_tv));

        binding.regsInfoDayAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.days
                , R.layout.list_item_auto_complete_tv));


        binding.regsInfoTimeAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.time
                , R.layout.list_item_auto_complete_tv));

        ArrayList<String> shiekhName = new ArrayList<String>() {{
            add("لا أعرف احد");
            add("الشيخ ياسر");
            add("الشيخ محمد عبد الغنى");
            add("الشيخ عماد");
            add("الشيخ محمد عبد المنعم");
        }};
        binding.regsInfoShiekhAcTv.setAdapter(new ArrayAdapter<String>
                (requireContext(), R.layout.list_item_auto_complete_tv,
                        shiekhName));
    }
}