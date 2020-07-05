package com.example.ertaqiwratel.presentation.activities.navUi.admin;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.presentation.activities.MessageAdapter;
import com.example.ertaqiwratel.presentation.activities.MessageResponse;

import java.util.ArrayList;

public class AdminChatFragment extends Fragment {
    private static final String TAG = "chatFragment";

    private EditText etMessage;
    private Button btnSend;
    private RecyclerView mRecyclerView;

    private LinearLayoutManager mLayoutManger;
    private MessageAdapter mAdapter;

    private AdminChatViewModel adminChatViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        adminChatViewModel =
                ViewModelProviders.of(this).get(AdminChatViewModel.class);
        View root = inflater.inflate(R.layout.fragment_chat, container, false);
        adminChatViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        etMessage = view.findViewById(R.id.etMessage);
        btnSend = view.findViewById(R.id.btnSend);
        mRecyclerView = view.findViewById(R.id.rv_messages);

        mLayoutManger = new LinearLayoutManager(getContext());
        mRecyclerView.setLayoutManager(mLayoutManger);
        mAdapter = new MessageAdapter(new ArrayList<MessageResponse>());
        mRecyclerView.setAdapter(mAdapter);

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mMessage = etMessage.getText().toString().trim();
                if (mMessage != null && !mMessage.isEmpty()) {
                    MessageResponse userMessage = new MessageResponse();
                    userMessage.setUserName("Me");
                    userMessage.setSender("Me");
                    userMessage.setMessage(mMessage);

                    mAdapter.addSingleItem(userMessage);
                    etMessage.setText("");
                } else {
                    Toast.makeText(getContext(), "اكتب رساله", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}