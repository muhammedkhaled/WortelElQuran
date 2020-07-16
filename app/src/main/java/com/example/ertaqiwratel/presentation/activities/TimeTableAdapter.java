package com.example.ertaqiwratel.presentation.activities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.presentation.activities.pojo.TimeTableModel;

import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.TimeViewHolder> {
    final List<TimeTableModel> tableList;

    public TimeTableAdapter(List<TimeTableModel> tableList) {
        this.tableList = tableList;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.table_item1, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull TimeViewHolder holder, int position) {
        TimeTableModel tableModel = tableList.get(position);
        holder.day.setText(tableModel.getDay());
        holder.regularDate.setText(tableModel.getRegularDate());
        holder.higriDate.setText(tableModel.getHigriDate());
        holder.rateNearPast.setText(tableModel.getRateNearPast());
        holder.rateFarPast.setText(tableModel.getRateFarPast());
        holder.rateMetn.setText(tableModel.getRateMetn());
        holder.rateNewSave.setText(tableModel.getRateNewSave());
//        holder.ivEdit.setVisibility(View.GONE);

        boolean isExpandable = tableModel.isExpandable();
        //holder.expandable.setVisibility(isExpandable ? View.VISIBLE : View.GONE);
        if (isExpandable) {
            holder.expandable.setVisibility(View.VISIBLE);
            holder.ivExpandable.setImageResource(R.drawable.up_arrow);
        } else {
            holder.expandable.setVisibility(View.GONE);
            holder.ivExpandable.setImageResource(R.drawable.down_arrow);
        }

    }

    @Override
    public int getItemCount() {
        return tableList.size();
    }

    public class TimeViewHolder extends RecyclerView.ViewHolder {
        final TextView day;
        final TextView regularDate;
        final TextView higriDate;
        final TextView rateFarPast;
        final TextView rateNearPast;
        final TextView rateMetn;
        final TextView rateNewSave;
        final CheckBox check;
        final RelativeLayout expandable;
        final LinearLayout topTitle;
        final ImageView ivExpandable;
        final ImageView ivEdit;

        public TimeViewHolder(@NonNull View itemView) {
            super(itemView);
            day = itemView.findViewById(R.id.tv_day_name);
            regularDate = itemView.findViewById(R.id.tv_regular_date);
            higriDate = itemView.findViewById(R.id.tv_higri_date);
            rateNewSave = itemView.findViewById(R.id.tv_rate_new_save);
            rateFarPast = itemView.findViewById(R.id.tv_rate_far_past);
            rateMetn = itemView.findViewById(R.id.tv_rate_metn);
            rateNearPast = itemView.findViewById(R.id.tv_rate_near_past);
            check = itemView.findViewById(R.id.check_box);
            topTitle = itemView.findViewById(R.id.top_title);
            expandable = itemView.findViewById(R.id.expandable);
            ivExpandable = itemView.findViewById(R.id.iv_arrow_expand);
            ivEdit = itemView.findViewById(R.id.iv_edit);


            topTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeTableModel tableModel = tableList.get(getAdapterPosition());
                    tableModel.setExpandable(!tableModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }
    }
}
