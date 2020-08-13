package com.example.ertaqiwratel.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.home.pojo.SingleTextModel;

import java.util.List;

public class NotificationAdapter extends RecyclerView.Adapter<NotificationAdapter.NotificationViewHolder> {
    private List<SingleTextModel> list;

    public NotificationAdapter(List<SingleTextModel> list) {
        this.list = list;
    }

    public void addSingleItem(SingleTextModel notification) {
        list.add(notification);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public NotificationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new NotificationViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.notification_list_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull NotificationViewHolder holder, int position) {
        SingleTextModel model = list.get(position);
        holder.NotificationListTv.setText(model.getText());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class NotificationViewHolder extends RecyclerView.ViewHolder {
        TextView NotificationListTv;
        public NotificationViewHolder(@NonNull View itemView) {
            super(itemView);
            NotificationListTv = itemView.findViewById(R.id.notification_list_tv);
        }
    }
}
