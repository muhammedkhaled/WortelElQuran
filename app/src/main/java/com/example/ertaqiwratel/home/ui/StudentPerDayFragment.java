package com.example.ertaqiwratel.home.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.databinding.FragmentStudentPerDayBinding;
import com.example.ertaqiwratel.utils.OnItemClickListener;
import com.example.ertaqiwratel.home.adapters.StudentOfDayAdapter;
import com.example.ertaqiwratel.home.pojo.StudentOfDayModel;

import java.util.ArrayList;

public class StudentPerDayFragment extends Fragment implements OnItemClickListener {

    private FragmentStudentPerDayBinding binding;
    private ArrayList<StudentOfDayModel> students;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentStudentPerDayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initRecycler();
    }

    private void initRecycler() {
        students = new ArrayList<StudentOfDayModel>() {{
            add(new StudentOfDayModel(" محمد خالد عبد العزيز محمد", "من 04.00 م - الى 04.30 م"));
            add(new StudentOfDayModel("احمد ابراهيم", "من 04.30 م - الى 05.00 م"));
            add(new StudentOfDayModel("عبدالله محمد", "من 05.00 م - الى 05.30 م"));
            add(new StudentOfDayModel("احمد محمد", "من 05.30 م - الى 06.00 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 06.00 م - الى 06.30 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 07.00 م - الى 07.30 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 07.30 م - الى 08.00 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 08.30 م - الى 09.00 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 08.30 م - الى 09.00 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 08.30 م - الى 09.00 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 08.30 م - الى 09.00 م"));
            add(new StudentOfDayModel("ياسر مجدى", "من 08.30 م - الى 09.00 م"));
        }};

        StudentOfDayAdapter dayAdapter = new StudentOfDayAdapter(students);
        dayAdapter.setmOnItemClickListener(this);
        binding.studentPerDayRv.setAdapter(dayAdapter);
    }

    @Override
    public void onItemClicked(View view, int position) {
        // navigate to student schedule and chat

        StudentPerDayFragmentDirections.ActionStudentPerDayFragmentToStudentFragment2 action =
                StudentPerDayFragmentDirections.actionStudentPerDayFragmentToStudentFragment2(students.get(position).getStudentName());

        Navigation.findNavController(view).navigate(action);
    }
}