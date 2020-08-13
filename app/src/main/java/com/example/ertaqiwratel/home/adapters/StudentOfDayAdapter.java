package com.example.ertaqiwratel.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.utils.OnItemClickListener;
import com.example.ertaqiwratel.home.pojo.StudentOfDayModel;

import java.util.List;

public class StudentOfDayAdapter extends RecyclerView.Adapter<StudentOfDayAdapter.studentsVH> {
    final List<StudentOfDayModel> scheduleList;
    private OnItemClickListener mOnItemClickListener;

    public StudentOfDayAdapter(List<StudentOfDayModel> scheduleList) {
        this.scheduleList = scheduleList;
    }

    public void setmOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public studentsVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new studentsVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_of_day_item, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull studentsVH holder, int position) {
        StudentOfDayModel schedule = scheduleList.get(position);
        holder.studentName.setText(schedule.getStudentName());
        holder.studentTime.setText(schedule.getStudentTime());
    }

    @Override
    public int getItemCount() {
        if (scheduleList.size() == 0 || scheduleList == null) {
            return 0;
        } else {
            return scheduleList.size();
        }
    }


    public static class studentsVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView studentName, studentTime;
        OnItemClickListener mOnItemClickListener;

        public studentsVH(@NonNull View itemView, OnItemClickListener mOnItemClickListener) {
            super(itemView);
            studentName = itemView.findViewById(R.id.student_name);
            studentTime = itemView.findViewById(R.id.student_time);
            this.mOnItemClickListener = mOnItemClickListener;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClicked(v, getAdapterPosition());
        }
    }
}
