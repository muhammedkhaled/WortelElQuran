package com.example.ertaqiwratel.home.adapters;

import android.app.TimePickerDialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TimePicker;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.home.pojo.TimePerDayModel;

import java.util.Calendar;
import java.util.List;

public class TimeChildAdapter extends RecyclerView.Adapter<TimeChildAdapter.TimeVH>{

    public List<TimePerDayModel> list ;
    public Context mContext;

    public TimeChildAdapter(List<TimePerDayModel> list) {
        this.list = list;
    }

    public void updateItem(int position, TimePerDayModel timeModel){
        notifyItemChanged(position, timeModel);
    }

    public void addItem(TimePerDayModel model){
        if (list.size() <= 3){
            list.add(model);
            notifyDataSetChanged();
        }
    }

    public void remove(int position){
        if (list.size() > 1){
            list.remove(position);
            notifyItemRemoved(position);
        }
    }

    @NonNull
    @Override
    public TimeVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeChildAdapter.TimeVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sh_time_child, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull final TimeVH holder, int position) {
        TimePerDayModel model = list.get(position);

        holder.add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addItem(new TimePerDayModel());
            }
        });

        holder.delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                remove(holder.getAdapterPosition());
            }
        });

        holder.from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();

                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(holder.itemView.getContext(), R.style.DatePickerTheme ,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        holder.from.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.show();
            }
        });

        holder.to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar mcurrentTime = Calendar.getInstance();
                int hour = mcurrentTime.get(Calendar.HOUR_OF_DAY);
                int minute = mcurrentTime.get(Calendar.MINUTE);
                TimePickerDialog mTimePicker;
                mTimePicker = new TimePickerDialog(holder.itemView.getContext(), R.style.DatePickerTheme ,new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int selectedHour, int selectedMinute) {
                        holder.to.setText( selectedHour + ":" + selectedMinute);
                    }
                }, hour, minute, false);//Yes 24 hour time
                mTimePicker.show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class TimeVH extends RecyclerView.ViewHolder {
        public Button from, to;
        public ImageButton delete ,add;

        public TimeVH(@NonNull View itemView ) {
            super(itemView);
            from = itemView.findViewById(R.id.start_picker_btn);
            to = itemView.findViewById(R.id.end_picker_btn);
            add = itemView.findViewById(R.id.add_btn);
            delete = itemView.findViewById(R.id.delete_btn);
        }

    }
}
