package com.example.ertaqiwratel.registration.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertaqiwratel.home.adapters.ReadingsAdapter;
import com.example.ertaqiwratel.databinding.FragmentReadingsBinding;
import com.example.ertaqiwratel.home.pojo.ReadingsModel;

import java.util.ArrayList;
import java.util.List;

public class ReadingsFragment extends Fragment {
    private FragmentReadingsBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentReadingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecycler();
    }

    private void setRecycler(){
        List<ReadingsModel> list = new ArrayList<ReadingsModel>(){{
           add(new ReadingsModel("نافع المدني", "قالون", "ورش"));
           add(new ReadingsModel(" ابن كثير المكي", "البزي", "قنبل"));
           add(new ReadingsModel("أبي عمرو البصري", "الدوري", "السوسي"));
           add(new ReadingsModel(" ابن عامر الشامي", "هشام", "ابن ذكوان"));
           add(new ReadingsModel("عاصم الكوفي", "شعبة", "حفص"));
           add(new ReadingsModel("حمزة الكوفي", "خلف بن هشام", "خلاد بن خالد"));
           add(new ReadingsModel("الكسائي", "أبو الحارث الليث", "حفص بن عمر الدوري"));
           add(new ReadingsModel(" أبي جعفر المدني", "عيسى بن وردان المدني", "ابن جمّاز"));
           add(new ReadingsModel("يعقوب الحضرمي", "رويس", "روح بن عبد المؤمن"));
           add(new ReadingsModel("خلف العاشر", "إسحاق بن إبراهيم", "إدريس بن عبد الكريم الحداد"));
        }};

        binding.readingsRv.setAdapter(new ReadingsAdapter(list));
    }
}