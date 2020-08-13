package com.example.ertaqiwratel.home.ui;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ertaqiwratel.home.adapters.NotificationAdapter;
import com.example.ertaqiwratel.databinding.FragmentNotificationsBinding;
import com.example.ertaqiwratel.home.pojo.SingleTextModel;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {
    private FragmentNotificationsBinding binding;
    private NotificationAdapter adapter;
    private List<SingleTextModel> list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        binding = FragmentNotificationsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        setRecyclerView();
        rvVisibility();

    }

    private void setRecyclerView(){

        list = new ArrayList<SingleTextModel>(){{
            add(new SingleTextModel("تم قبول الجلسه مع الشيخ عماد"));
            add(new SingleTextModel("الشيخ محمد يعتذر عن الجلسه"));
            add(new SingleTextModel("الشيخ احمد يعتذر عن الجلسه"));
            add(new SingleTextModel("الشيخ ابراهيم يعتذر عن الجلسه"));
        }};
        adapter = new NotificationAdapter(list);
        binding.notificationsRv.setAdapter(adapter);

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT )
        {
            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target)
            {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir)
            {
                int i = viewHolder.getAdapterPosition();
                list.remove(i);
                adapter.notifyItemRemoved(i);
                rvVisibility();
            }

        }).attachToRecyclerView(binding.notificationsRv);

    }
    private void rvVisibility(){
        if (list.size() == 0){
            binding.notificationsRv.setVisibility(View.GONE);
            binding.notificationConL.setVisibility(View.VISIBLE);
        }else {
            binding.notificationsRv.setVisibility(View.VISIBLE);
            binding.notificationConL.setVisibility(View.GONE);
        }
    }
}