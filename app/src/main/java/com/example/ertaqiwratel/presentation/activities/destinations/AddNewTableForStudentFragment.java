package com.example.ertaqiwratel.presentation.activities.destinations;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Toast;

import com.example.ertaqiwratel.databinding.FragmnetAddNewDayBinding;

public class AddNewTableForStudentFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmnetAddNewDayBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmnetAddNewDayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinners();
    }

    private void spinners() {
        /*ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(requireActivity(), R.array.rate
                , android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);*/

        binding.spinnerAttendance.setOnItemSelectedListener(this);
        binding.spinnerNewSura.setOnItemSelectedListener(this);
        binding.spinnerFarPastSura.setOnItemSelectedListener(this);
        binding.spinnerNeerPastSura.setOnItemSelectedListener(this);
        binding.spinnerMeton.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}