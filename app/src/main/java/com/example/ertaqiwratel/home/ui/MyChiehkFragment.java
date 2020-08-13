package com.example.ertaqiwratel.home.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.databinding.FragmentMyChiehkBinding;
import com.example.ertaqiwratel.home.adapters.MessageAdapter;
import com.example.ertaqiwratel.home.pojo.MessageResponse;

import java.util.ArrayList;

public class MyChiehkFragment extends Fragment {
    private NavController navController;
    private MessageAdapter messageAdapter;
    private FragmentMyChiehkBinding binding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        binding = FragmentMyChiehkBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.getRootView().findViewById(R.id.back_toolbar_ll)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigateUp();
                    }
                });
        view.getRootView().findViewById(R.id.user_bar_name)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_myChiehkFrament_to_info_dialog);
                    }
                });

        messageAdapter = new MessageAdapter(new ArrayList<MessageResponse>());
        binding.chiekhRvMessages.setAdapter(messageAdapter);
        binding.chiekhBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mMessage = binding.chiekhEtMessage.getText().toString().trim();
                if (mMessage != null && !mMessage.isEmpty()) {
                    MessageResponse userMessage = new MessageResponse();
                    userMessage.setUserName("Me");
                    userMessage.setSender("Me");
                    userMessage.setMessage(mMessage);

                    messageAdapter.addSingleItem(userMessage);
                    binding.chiekhEtMessage.setText("");
                } else {
                    Toast.makeText(getContext(), "اكتب رساله", Toast.LENGTH_SHORT).show();
                }
            }
        });
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
                navController.navigate(R.id.videoCallFragment);
                return true;
            case R.id.myshiekh_audio_call:
                navController.navigate(R.id.voiceCallFragment);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}