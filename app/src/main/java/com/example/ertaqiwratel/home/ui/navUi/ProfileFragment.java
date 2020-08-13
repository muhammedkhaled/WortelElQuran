package com.example.ertaqiwratel.home.ui.navUi;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.databinding.FragmnetProfileBinding;
import com.example.ertaqiwratel.utils.Prevalent;


public class ProfileFragment extends Fragment {
    private FragmnetProfileBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        binding = FragmnetProfileBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.profileEmailLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragmentDirections.ActionNavProfileToProfileBottomSheetFragment action =
                        ProfileFragmentDirections.actionNavProfileToProfileBottomSheetFragment(Prevalent.EMAIL);
                Navigation.findNavController(v).navigate(action);
            }
        });

        binding.profilePhoneLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragmentDirections.ActionNavProfileToProfileBottomSheetFragment action =
                        ProfileFragmentDirections.actionNavProfileToProfileBottomSheetFragment(Prevalent.PHONE_NUMBER);
                Navigation.findNavController(v).navigate(action);
            }
        });

        binding.profilePassLl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProfileFragmentDirections.ActionNavProfileToProfileBottomSheetFragment action =
                        ProfileFragmentDirections.actionNavProfileToProfileBottomSheetFragment(Prevalent.PASSWORD);
                Navigation.findNavController(v).navigate(action);
            }
        });

        setViews();
    }

    private void setViews() {
        if (Prevalent.CURRENT_ONLINE_USER.getUserType().equals("معلم")){
            binding.profileClassLl.setVisibility(View.GONE);
            binding.profileMychiekhNameTv.setText("حفص عن عاصم");
            binding.desMychiekhNameDescTv.setText("القراءات");
        }
    }
}
