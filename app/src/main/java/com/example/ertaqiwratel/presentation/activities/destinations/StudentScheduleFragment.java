package com.example.ertaqiwratel.presentation.activities.destinations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentStudentScheduleBinding;
import com.example.ertaqiwratel.presentation.activities.adapter.TimeTableAdapter;
import com.example.ertaqiwratel.presentation.activities.pojo.TimeTableModel;

import java.util.ArrayList;
import java.util.List;

public class StudentScheduleFragment extends Fragment {

    private FragmentStudentScheduleBinding scheduleFragmentBinding;
    private List<TimeTableModel> modelList;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        scheduleFragmentBinding = FragmentStudentScheduleBinding.inflate(inflater, container, false);
        return scheduleFragmentBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        boolean user_type = StudentScheduleFragmentArgs.fromBundle(getArguments()).getUserType();
        if (user_type) {
            scheduleFragmentBinding.fabAddScheduleItem.setVisibility(View.VISIBLE);
            scheduleFragmentBinding.fabAddScheduleItem
                    .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addNewDayFragment));
        }
        TimeTableAdapter adapter = new TimeTableAdapter(modelList, user_type);
        scheduleFragmentBinding.rvStudentSchedule.setAdapter(adapter);
        scheduleFragmentBinding.rvStudentSchedule.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    private void initData() {
        modelList = new ArrayList<>();
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));
        modelList.add(new TimeTableModel("الأربعاء", "8 فبراير", "20 شعبان", "10/6"
                , "10/7", "10/10", "10/5"));

    }
}