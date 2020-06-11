package com.example.ertaqiwratel.presentation.activities.destinations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertaqiwratel.databinding.FragmentTimeTableBinding;
import com.example.ertaqiwratel.presentation.activities.TimeTableAdapter;
import com.example.ertaqiwratel.presentation.activities.pojo.TimeTableModel;

import java.util.ArrayList;
import java.util.List;

public class TimeTableFragment extends Fragment {
    List<TimeTableModel> modelList;
    private FragmentTimeTableBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTimeTableBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initData();
        setRecyclerView();
    }
    private void setRecyclerView() {
        TimeTableAdapter adapter = new TimeTableAdapter(modelList);
        binding.rvTimeTable.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
        binding.rvTimeTable.setLayoutManager(new LinearLayoutManager(getActivity()));
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