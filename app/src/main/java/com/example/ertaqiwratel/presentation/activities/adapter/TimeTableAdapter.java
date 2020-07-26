package com.example.ertaqiwratel.presentation.activities.adapter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AutoCompleteTextView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.presentation.activities.OnItemClickListener;
import com.example.ertaqiwratel.presentation.activities.pojo.TimeTableModel;

import java.util.List;

public class TimeTableAdapter extends RecyclerView.Adapter<TimeTableAdapter.TimeViewHolder> {
    final List<TimeTableModel> tableList;
    private boolean user_type;
    private OnItemClickListener mOnItemClickListener;

    public TimeTableAdapter(List<TimeTableModel> tableList, boolean user_type, OnItemClickListener mOnItemClickListener) {
        this.tableList = tableList;
        this.user_type = user_type;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public TimeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TimeViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.student_schedule_item, parent, false), mOnItemClickListener);
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

        if (user_type) {
            holder.ivEdit.setVisibility(View.VISIBLE);
        } else {
            holder.ivEdit.setVisibility(View.GONE);
        }

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

    public class TimeViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        final TextView day;
        final TextView regularDate;
        final TextView higriDate;
        final AutoCompleteTextView rateFarPast;
        final AutoCompleteTextView rateNearPast;
        final AutoCompleteTextView rateMetn;
        final AutoCompleteTextView rateNewSave;
        final AutoCompleteTextView check;
        final ConstraintLayout expandable;
        final LinearLayout topTitle;
        final ImageView ivExpandable;
        final ImageButton ivEdit;
        private OnItemClickListener mOnItemClickListener;

        public TimeViewHolder(@NonNull View itemView, OnItemClickListener mOnItemClickListener) {
            super(itemView);
            day = itemView.findViewById(R.id.tv_day_name);
            regularDate = itemView.findViewById(R.id.tv_regular_date);
            higriDate = itemView.findViewById(R.id.tv_higri_date);
            rateNewSave = itemView.findViewById(R.id.new_sura_acTv);
            rateFarPast = itemView.findViewById(R.id.far_past_sura_acTV);
            rateMetn = itemView.findViewById(R.id.metoon_acTv);
            rateNearPast = itemView.findViewById(R.id.neer_past_sura_acTV);
            check = itemView.findViewById(R.id.attendenc_acTv);
            topTitle = itemView.findViewById(R.id.top_title);
            expandable = itemView.findViewById(R.id.expandable);
            ivExpandable = itemView.findViewById(R.id.iv_arrow_expand);
            ivEdit = itemView.findViewById(R.id.iv_edit);
            this.mOnItemClickListener = mOnItemClickListener;

            Bundle bundle = new Bundle();
            bundle.putString("title", "تحديد مستوى القراءه");
            ivEdit.setOnClickListener(Navigation.createNavigateOnClickListener(R.id.addNewDayFragment, bundle));


            topTitle.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    TimeTableModel tableModel = tableList.get(getAdapterPosition());
                    tableModel.setExpandable(!tableModel.isExpandable());
                    notifyItemChanged(getAdapterPosition());
                }
            });
        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClicked(v, getAdapterPosition());
        }
    }
}
