package com.example.ertaqiwratel.presentation.activities.destinations;

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
import com.example.ertaqiwratel.presentation.activities.adapter.MessageAdapter;
import com.example.ertaqiwratel.presentation.activities.pojo.MessageResponse;

import java.util.ArrayList;

public class MyChiehkFragment extends Fragment {
    private NavController navController;
    private MessageAdapter messageAdapter;
    private FragmentMyChiehkBinding chiehkBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        setHasOptionsMenu(true);
        navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
        chiehkBinding = FragmentMyChiehkBinding.inflate(inflater, container, false);
        return chiehkBinding.getRoot();
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
        view.getRootView().findViewById(R.id.mychiekh_bar_name)
                .setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        navController.navigate(R.id.action_myChiehkFrament_to_myChiekhInfo);
                    }
                });

        messageAdapter = new MessageAdapter(new ArrayList<MessageResponse>());
        chiehkBinding.chiekhRvMessages.setAdapter(messageAdapter);
        chiehkBinding.chiekhBtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mMessage = chiehkBinding.chiekhEtMessage.getText().toString().trim();
                if (mMessage != null && !mMessage.isEmpty()) {
                    MessageResponse userMessage = new MessageResponse();
                    userMessage.setUserName("Me");
                    userMessage.setSender("Me");
                    userMessage.setMessage(mMessage);

                    messageAdapter.addSingleItem(userMessage);
                    chiehkBinding.chiekhEtMessage.setText("");
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

                return true;
            case R.id.myshiekh_audio_call:

                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

    }
}