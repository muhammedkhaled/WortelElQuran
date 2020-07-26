package com.example.ertaqiwratel.presentation.activities.homeDesitnations.navUi.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentHomeBinding;
import com.example.ertaqiwratel.presentation.activities.OnItemClickListener;
import com.example.ertaqiwratel.presentation.activities.adapter.ShiekhScheduleAdapter;
import com.example.ertaqiwratel.presentation.activities.pojo.ShiekhScheduleModel;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements OnItemClickListener {
    private FragmentHomeBinding binding;
    private ArrayList<ShiekhScheduleModel> scheduleList ;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.homeMyshiekhMrl
                .setOnClickListener(Navigation.createNavigateOnClickListener(R.id.myChiehkFrament, null));

        binding.homeScheduleMrl
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        HomeFragmentDirections.ActionNavHomeToStudentScheduleFragment action =
                                HomeFragmentDirections.actionNavHomeToStudentScheduleFragment(false);
                        Navigation.findNavController(v).navigate(action);
                    }
                });

        // todo we get from userData after successful login
        String userType = "شيخ";

        if (userType.equals("شيخ")){
            binding.homeShiehkScheduleLl.setVisibility(View.VISIBLE);
            binding.homeStudentConsL.setVisibility(View.GONE);
            initRecycler();
        }else{
            binding.homeShiehkScheduleLl.setVisibility(View.GONE);
            binding.homeStudentConsL.setVisibility(View.VISIBLE);
        }
    }

    private void initRecycler(){
        scheduleList = new ArrayList<ShiekhScheduleModel>(){{
            add(new ShiekhScheduleModel("السبت"));
            add(new ShiekhScheduleModel("الثلاثاء"));
            add(new ShiekhScheduleModel("الخميس"));
        }};

        ShiekhScheduleAdapter adapter = new ShiekhScheduleAdapter(scheduleList);
        adapter.setmOnItemClickListener(this);
        binding.homeShiehkScheduleRv.setAdapter(adapter);

    }

    @Override
    public void onItemClicked(View view, int position) {
        HomeFragmentDirections.ActionNavHomeToStudentPerDayFragment action =
                HomeFragmentDirections.actionNavHomeToStudentPerDayFragment(scheduleList.get(position).getDay());
        Navigation.findNavController(view).navigate(action);
    }
}