package com.example.ertaqiwratel.presentation.activities;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.StringRes;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ertaqiwratel.R;

public class OnBoardingFragment extends Fragment {
    private static final String ARG_POSITION = "slider-position";
    /*@StringRes
    private static final int[] PAGE_TITLES =
            new int[] { R.string.intro_headline_1, R.string.intro_headline_2};*/
    @StringRes
    private static final int[] PAGE_TEXT =
            new int[] { R.string.intro_text_1, R.string.intro_text_2, R.string.intro_text_3};
    @StringRes
    private static final int[] PAGE_IMAGE =
            new int[] { R.drawable.intro_img1, R.drawable.intro_img2, R.drawable.intro_img3};

    private int position;

    public OnBoardingFragment() {
        // Required empty public constructor
    }

    public static OnBoardingFragment newInstance(int position) {
        OnBoardingFragment fragment = new OnBoardingFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_POSITION, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_POSITION);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_on_boarding, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        ImageView introImg = view.findViewById(R.id.intro_img);
        TextView title = view.findViewById(R.id.intro_headline);
        TextView text = view.findViewById(R.id.intro_text);


        title.setText("صاحب القرأن");
        text.setText(PAGE_TEXT[position]);
        introImg.setImageResource(PAGE_IMAGE[position]);
    }
}