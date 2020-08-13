package com.example.ertaqiwratel.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.home.pojo.SHDaysModel;

import java.util.List;

public class DaysParentAdapter extends RecyclerView.Adapter<DaysParentAdapter.DaysVH> {
    private List<SHDaysModel> list;

    public DaysParentAdapter(List<SHDaysModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public DaysVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new DaysParentAdapter.DaysVH(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_sh_days_parent, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull DaysVH holder, int position) {
        SHDaysModel model = list.get(position);
        holder.childRv.setAdapter(model.getChildAdapter());
        holder.checkBoxDay.setText(model.getDayName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class DaysVH extends RecyclerView.ViewHolder {
        public CheckBox checkBoxDay;
        public RecyclerView childRv;

        public DaysVH(@NonNull View itemView) {
            super(itemView);
            checkBoxDay = itemView.findViewById(R.id.day_checkBox);
            childRv = itemView.findViewById(R.id.suitable_times_child_RV);

            checkBoxDay.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked) {
                        childRv.setVisibility(View.VISIBLE);
                    } else {
                        childRv.setVisibility(View.GONE);
                    }
                }
            });
        }
    }
}
