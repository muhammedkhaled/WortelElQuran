package com.example.ertaqiwratel.home.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.utils.OnItemClickListener;
import com.example.ertaqiwratel.home.pojo.AvailableChiekhModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExtraSessionAdapter extends RecyclerView.Adapter<ExtraSessionAdapter.ExtraVH>{

    private List<AvailableChiekhModel> chiekhModelList;
    private OnItemClickListener mOnItemClickListener;

    public ExtraSessionAdapter(@NonNull List<AvailableChiekhModel> chiekhModelList, @NonNull OnItemClickListener mOnItemClickListener) {
        this.chiekhModelList = chiekhModelList;
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @NonNull
    @Override
    public ExtraVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExtraVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_extra_sh, parent, false), mOnItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ExtraVH holder, int position) {
        AvailableChiekhModel model = chiekhModelList.get(position);

        holder.chiekhName.setText(model.getName());
        holder.chiekhIgaza.setText(model.getIgaza());

    }

    @Override
    public int getItemCount() {
        return chiekhModelList.size();
    }

    static class ExtraVH extends RecyclerView.ViewHolder implements View.OnClickListener {
        CircleImageView circlerImageView;
        TextView chiekhName, chiekhIgaza;
        Button accept, reject;
        OnItemClickListener mOnItemClickListener;

        public ExtraVH(@NonNull View itemView, OnItemClickListener mOnItemClickListener) {
            super(itemView);

            circlerImageView = itemView.findViewById(R.id.extra_chiekh_img);
            chiekhName = itemView.findViewById(R.id.extra_chiekh_name);
            chiekhIgaza = itemView.findViewById(R.id.extra_chiekh_igaza);
            accept = itemView.findViewById(R.id.extra_accept);
            reject = itemView.findViewById(R.id.extra_reject);
            this.mOnItemClickListener = mOnItemClickListener;
            circlerImageView.setOnClickListener(this);
            accept.setOnClickListener(this);
            reject.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            mOnItemClickListener.onItemClicked(v, getAdapterPosition());
        }
    }
}
