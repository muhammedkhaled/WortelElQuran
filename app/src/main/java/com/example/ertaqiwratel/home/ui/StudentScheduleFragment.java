package com.example.ertaqiwratel.home.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentStudentScheduleBinding;
import com.example.ertaqiwratel.utils.OnItemClickListener;
import com.example.ertaqiwratel.home.adapters.TimeTableAdapter;
import com.example.ertaqiwratel.home.pojo.TimeTableModel;

import java.util.ArrayList;
import java.util.List;

public class StudentScheduleFragment extends Fragment implements OnItemClickListener {

    private FragmentStudentScheduleBinding binding;
    private List<TimeTableModel> modelList;
    private boolean user_type;

    public StudentScheduleFragment(boolean user_type) {
        this.user_type = user_type;
    }

    public StudentScheduleFragment() {
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        binding = FragmentStudentScheduleBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        setRecyclerView();
    }

    private void setRecyclerView() {
        if (getArguments() != null) {
            user_type = StudentScheduleFragmentArgs.fromBundle(getArguments()).getUserType();
        }

        if (user_type) {
            binding.fabAddScheduleItem.setVisibility(View.VISIBLE);
            binding.fabAddScheduleItem
                    .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addNewDayFragment));
        }

        TimeTableAdapter adapter = new TimeTableAdapter(modelList, user_type, this);
        binding.rvStudentSchedule.setAdapter(adapter);

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

    @Override
    public void onItemClicked(View view, int position) {
        // todo there is an issue when useing navigation from viewPager fragment to another destination
//        StudentScheduleFragmentDirections.ActionStudentScheduleFragmentToAddNewDayFragment action =
//                StudentScheduleFragmentDirections.actionStudentScheduleFragmentToAddNewDayFragment();
//        action.setTitle("تحديد مستوى القراءه");
//        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(action);

    }
}