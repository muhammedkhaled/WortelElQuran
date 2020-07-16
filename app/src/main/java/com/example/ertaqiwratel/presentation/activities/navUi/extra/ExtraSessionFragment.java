package com.example.ertaqiwratel.presentation.activities.navUi.extra;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.ertaqiwratel.R;

public class ExtraSessionFragment extends Fragment {

    private ExtraSessionViewModel extraSessionViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        extraSessionViewModel =
                ViewModelProviders.of(this).get(ExtraSessionViewModel.class);
        View root = inflater.inflate(R.layout.fragment_extra_session, container, false);
        final TextView textView = root.findViewById(R.id.text_gallery);
        extraSessionViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                textView.setText(s);
            }
        });
        return root;
    }
}