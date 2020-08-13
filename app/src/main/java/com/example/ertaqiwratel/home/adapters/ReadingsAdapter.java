package com.example.ertaqiwratel.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.home.pojo.ReadingsModel;

import java.util.List;

public class ReadingsAdapter extends RecyclerView.Adapter<ReadingsAdapter.NotificationViewHolder> {
    private List<ReadingsModel> list;

    public ReadingsAdapter(List<ReadingsModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_readings,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        ReadingsModel model = list.get(position);
        holder.parent.setText(model.getParent());
        holder.child_1.setText(model.getChild_1());
        holder.child_2.setText(model.getChild_2());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView parent, child_1, child_2;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            parent = itemView.findViewById(R.id.parent);
            child_1 = itemView.findViewById(R.id.child_1);
            child_2 = itemView.findViewById(R.id.child_2);
        }
    }
}
