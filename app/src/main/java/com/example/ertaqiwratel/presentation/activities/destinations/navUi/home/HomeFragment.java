package com.example.ertaqiwratel.presentation.activities.destinations.navUi.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentStudentHomeBinding;

public class HomeFragment extends Fragment {
    private FragmentStudentHomeBinding studentHomeBinding;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        studentHomeBinding = FragmentStudentHomeBinding.inflate(inflater, container, false);
        return studentHomeBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        studentHomeBinding.homeMyshiekhMrl
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.myChiehkFrament, null));

        studentHomeBinding.homeScheduleMrl
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HomeFragmentDirections.ActionNavHomeToStudentScheduleFragment action =
                                HomeFragmentDirections.actionNavHomeToStudentScheduleFragment();
                        action.setUserType(false);
                        Navigation.findNavController(v).navigate(action);
                    }
                });

    }
}