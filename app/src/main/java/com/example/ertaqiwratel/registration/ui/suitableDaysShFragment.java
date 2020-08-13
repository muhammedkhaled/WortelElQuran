package com.example.ertaqiwratel.registration.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ertaqiwratel.home.adapters.DaysParentAdapter;
import com.example.ertaqiwratel.home.adapters.TimeChildAdapter;
import com.example.ertaqiwratel.databinding.FragmentSuitableDaysShBinding;
import com.example.ertaqiwratel.home.pojo.SHDaysModel;
import com.example.ertaqiwratel.home.pojo.TimePerDayModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class suitableDaysShFragment extends Fragment {
    private FragmentSuitableDaysShBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentSuitableDaysShBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        List<SHDaysModel> parentList = new ArrayList<SHDaysModel>() {{
            add(new SHDaysModel("السبت", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
            add(new SHDaysModel("الاحد", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
            add(new SHDaysModel("الاثنين", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
            add(new SHDaysModel("الثلاثاء", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
            add(new SHDaysModel("الاربعاء", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
            add(new SHDaysModel("الخميس", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
            add(new SHDaysModel("الجمعه", new TimeChildAdapter(new ArrayList<>(Arrays.asList(new TimePerDayModel())))));
        }};

        binding.suitableDaysParentRv.setAdapter(new DaysParentAdapter(parentList));
    }

}