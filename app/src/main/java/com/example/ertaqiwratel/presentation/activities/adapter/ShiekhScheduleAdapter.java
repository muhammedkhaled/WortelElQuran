package com.example.ertaqiwratel.presentation.activities.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.presentation.activities.OnItemClickListener;
import com.example.ertaqiwratel.presentation.activities.pojo.ShiekhScheduleModel;

import java.util.List;

public class ShiekhScheduleAdapter extends RecyclerView.Adapter<ShiekhScheduleAdapter.scheduleVH> {
    final List<ShiekhScheduleModel> scheduleList;
    private OnItemClickListener mOnItemClickListener;

    public ShiekhScheduleAdapter(List<ShiekhScheduleModel> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public scheduleVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new scheduleVH(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.shiekh_day_item, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull scheduleVH holder, int position) {
        ShiekhScheduleModel schedule = scheduleList.get(position);
        holder.day.setText(schedule.getDay());
    }

    @Override
    public int getItemCount() {
        if (scheduleList.size() == 0 || scheduleList == null) {
            return 0;
        } else {
            return scheduleList.size();
        }
    }


    public static class scheduleVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        final Button day;
        private OnItemClickListener mOnItemClickListener;

        public scheduleVH(@NonNull View itemView, OnItemClickListener mOnItemClickListener) {
            super(itemView);
            day = itemView.findViewById(R.id.day);
            this.mOnItemClickListener = mOnItemClickListener;
            day.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClicked(v, getAdapterPosition());
        }
    }
}
