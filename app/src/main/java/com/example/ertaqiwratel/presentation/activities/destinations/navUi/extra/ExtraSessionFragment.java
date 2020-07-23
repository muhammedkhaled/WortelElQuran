package com.example.ertaqiwratel.presentation.activities.destinations.navUi.extra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentExtraSessionBinding;
import com.example.ertaqiwratel.presentation.activities.adapter.ExtraSessionAdapter;
import com.example.ertaqiwratel.presentation.activities.pojo.AvailableChiekhModel;

import java.util.ArrayList;
import java.util.List;

public class ExtraSessionFragment extends Fragment {
    private FragmentExtraSessionBinding extraSessionBinding;
    private List<AvailableChiekhModel> chiekhModelList = new ArrayList<>();

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        extraSessionBinding = FragmentExtraSessionBinding.inflate(inflater, container, false);
        return extraSessionBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initData();
        ExtraSessionAdapter adapter = new ExtraSessionAdapter(chiekhModelList);
        extraSessionBinding.extraRv.setAdapter(adapter);

    }


    private void initData() {

        AvailableChiekhModel model1 = new AvailableChiekhModel();
        model1.setName("الشيخ/ محمد خالد");
        model1.setIgaza("حفص عن عاصم");
        model1.setRequestState("تم القبول");
        chiekhModelList.add(model1);

        AvailableChiekhModel model = new AvailableChiekhModel();
        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        chiekhModelList.add(model);

        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        chiekhModelList.add(model);

        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        chiekhModelList.add(model);

        model.setName("الشيخ/ محمد خالد");
        model.setIgaza("حفص عن عاصم");
        model.setRequestState("");
        chiekhModelList.add(model);


    }
}