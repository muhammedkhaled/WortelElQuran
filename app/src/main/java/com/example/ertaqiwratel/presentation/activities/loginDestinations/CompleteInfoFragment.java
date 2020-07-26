package com.example.ertaqiwratel.presentation.activities.loginDestinations;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentCompleteInfoBinding;
import com.example.ertaqiwratel.presentation.activities.homeDesitnations.MainActivity;

import java.util.ArrayList;

public class CompleteInfoFragment extends Fragment {
    private FragmentCompleteInfoBinding binding;
    private String mUserState, mSuitableDay, mSuitableTime, mShiekhName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentCompleteInfoBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        sSpinnerEntities();

        binding.registerInfoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (validateUserData()){
                    Toast.makeText(requireContext(), "done", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(requireActivity(), MainActivity.class);
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
            if (!mUserState.isEmpty()  && !mSuitableDay.isEmpty() && !mSuitableTime.isEmpty() && !mShiekhName.isEmpty()) {
                binding.registerInfoBtn.setEnabled(true);
            } else {
                binding.registerInfoBtn.setEnabled(false);
            }
        }
    };


    private boolean validateUserData(){
        inputsDataString();

       if (mSuitableDay.isEmpty()){
            binding.regsInfoDayAcTv.setError("برجاء اختيار اليوم المناسب للجلسه اسبوعيا", null);
            binding.regsInfoDayAcTv.requestFocus();
            return false;
        }else if (mSuitableTime.isEmpty()){
            binding.regsInfoTimeAcTv.setError("برجاء اختيار التوقيت المناسب للجلسه اسبوعيا", null);
            binding.regsInfoTimeAcTv.requestFocus();
            return false;
        }else if (mUserState.isEmpty()){
            binding.regsInfoStStateAcTv.setError("برجاء تحديد نوع الاشتراك", null);
            binding.regsInfoStStateAcTv.requestFocus();
            return false;
        }else {
            return true;
        }
    }

    private void inputsDataString() {
        mUserState = binding.regsInfoStStateAcTv.getEditableText().toString().trim();
        mSuitableDay = binding.regsInfoDayAcTv.getEditableText().toString().trim();
        mSuitableTime = binding.regsInfoTimeAcTv.getEditableText().toString().trim();
        mShiekhName = binding.regsInfoShiekhAcTv.getEditableText().toString().trim();
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