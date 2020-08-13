package com.example.ertaqiwratel.home.ui.navUi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.home.adapters.ShiekhScheduleAdapter;
import com.example.ertaqiwratel.databinding.FragmentHomeBinding;
import com.example.ertaqiwratel.home.pojo.SingleTextModel;
import com.example.ertaqiwratel.utils.OnItemClickListener;
import com.example.ertaqiwratel.utils.Prevalent;

import java.util.ArrayList;

public class HomeFragment extends Fragment implements OnItemClickListener {
    private FragmentHomeBinding binding;
    private ArrayList<SingleTextModel> scheduleList;

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

        if (Prevalent.CURRENT_ONLINE_USER.getUserType().equals("معلم")) {
            binding.homeShiehkScheduleLl.setVisibility(View.VISIBLE);
            binding.homeStudentConsL.setVisibility(View.GONE);
            initRecycler();
        } else {
            binding.homeShiehkScheduleLl.setVisibility(View.GONE);
            binding.homeStudentConsL.setVisibility(View.VISIBLE);
        }
    }

    private void initRecycler() {
        scheduleList = new ArrayList<SingleTextModel>() {{
            add(new SingleTextModel("السبت"));
            add(new SingleTextModel("الثلاثاء"));
            add(new SingleTextModel("الخميس"));
        }};

        ShiekhScheduleAdapter adapter = new ShiekhScheduleAdapter(scheduleList);
        adapter.setmOnItemClickListener(this);
        binding.homeShiehkScheduleRv.setAdapter(adapter);

    }

    @Override
    public void onItemClicked(View view, int position) {
        HomeFragmentDirections.ActionNavHomeToStudentPerDayFragment action =
                HomeFragmentDirections.actionNavHomeToStudentPerDayFragment(scheduleList.get(position).getText());
        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigate(action);
    }
}