package com.example.ertaqiwratel.presentation.activities.homeDesitnations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentStudentBinding;
import com.example.ertaqiwratel.presentation.activities.adapter.PagerAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.Objects;

public class StudentFragment extends Fragment {

    private FragmentStudentBinding binding;
    private String studentName;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStudentBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setViewPager();
        setHasOptionsMenu(true);
        view.getRootView().findViewById(R.id.back_toolbar_ll)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Navigation.findNavController(requireActivity(), R.id.nav_host_fragment).navigateUp();
                    }
                });
        view.getRootView().findViewById(R.id.user_bar_name)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // open dialog with student info
                    }
                });

        if (getArguments() != null) {
            studentName = StudentFragmentArgs.fromBundle(getArguments()).getStudentName();
        } else {
            studentName = "";
        }
        TextView studentNametv = view.getRootView().findViewById(R.id.user_bar_name);
        studentNametv.setText(studentName);
    }


    private void setViewPager() {
        Fragment[] fragments = new Fragment[]{
                new StudentScheduleFragment(true),
                new StudentChatRoomFragment()
        };
        String[] names = new String[]{
                "جدول الطالب",
                "محادثه مع الطالب"
        };
        PagerAdapter adapter = new PagerAdapter(getChildFragmentManager(),
                FragmentPagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT, fragments, names);
        binding.viewPager.setAdapter(adapter);
        binding.tablayout.setupWithViewPager(binding.viewPager);
        binding.tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        Objects.requireNonNull(binding.tablayout.getTabAt(0)).setIcon(R.drawable.calendar);
        Objects.requireNonNull(binding.tablayout.getTabAt(1)).setIcon(R.drawable.message);
    }

    @Override
    public void onCreateOptionsMenu(@NonNull Menu menu, @NonNull MenuInflater inflater) {
        inflater.inflate(R.menu.chat_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.myshiekh_video_call:

                return true;
            case R.id.myshiekh_audio_call:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }

}