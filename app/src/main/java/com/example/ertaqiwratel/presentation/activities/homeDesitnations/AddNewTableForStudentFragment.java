package com.example.ertaqiwratel.presentation.activities.homeDesitnations;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmnetAddNewDayBinding;

public class AddNewTableForStudentFragment extends Fragment implements AdapterView.OnItemSelectedListener {

    private FragmnetAddNewDayBinding binding;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmnetAddNewDayBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        spinners();
    }

    private void spinners() {
        binding.newSuraAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.rate
                , R.layout.item_auto_complete_tv));
        binding.neerPastSuraAcTV.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.rate
                , R.layout.item_auto_complete_tv));
        binding.farPastSuraAcTV.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.rate
                , R.layout.item_auto_complete_tv));
        binding.metonAcTV.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.rate
                , R.layout.item_auto_complete_tv));
        binding.attendencAcTv.setAdapter(ArrayAdapter.createFromResource(requireContext(), R.array.attendance_state
                , R.layout.item_auto_complete_tv));
        binding.attendencAcTv.setOnItemSelectedListener(this);
        binding.newSuraAcTv.setOnItemSelectedListener(this);
        binding.farPastSuraAcTV.setOnItemSelectedListener(this);
        binding.neerPastSuraAcTV.setOnItemSelectedListener(this);
        binding.metonAcTV.setOnItemSelectedListener(this);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getActivity(), parent.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}