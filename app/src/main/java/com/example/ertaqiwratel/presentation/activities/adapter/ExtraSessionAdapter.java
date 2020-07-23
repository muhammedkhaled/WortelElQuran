package com.example.ertaqiwratel.presentation.activities.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.solver.widgets.ConstraintHorizontalLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ertaqiwratel.R;
import com.example.ertaqiwratel.presentation.activities.pojo.AvailableChiekhModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class ExtraSessionAdapter extends RecyclerView.Adapter<ExtraSessionAdapter.ExtraVH>{

    private List<AvailableChiekhModel> chiekhModelList;

    public ExtraSessionAdapter(List<AvailableChiekhModel> chiekhModelList) {
        this.chiekhModelList = chiekhModelList;
    }


    @NonNull
    @Override
    public ExtraVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ExtraVH(LayoutInflater.from(parent.getContext()).inflate(R.layout.extra_item, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ExtraVH holder, int position) {
        AvailableChiekhModel model = chiekhModelList.get(position);

        holder.chiekhName.setText(model.getName());
        holder.chiekhIgaza.setText(model.getIgaza());

        if (model.getRequestState().equals("تم القبول")){
            holder.sendRequest.setVisibility(View.GONE);
            holder.callParent.setVisibility(View.VISIBLE);
        }else {
            holder.sendRequest.setVisibility(View.VISIBLE);
            holder.callParent.setVisibility(View.GONE);
        }

    }

    @Override
    public int getItemCount() {
        return chiekhModelList.size();
    }

    class ExtraVH extends RecyclerView.ViewHolder {
        CircleImageView circlerImageView;
        TextView chiekhName, chiekhIgaza;
        Button sendRequest;
        ConstraintLayout callParent;

        public ExtraVH(@NonNull View itemView) {
            super(itemView);

            circlerImageView = itemView.findViewById(R.id.extra_chiekh_img);
            chiekhName = itemView.findViewById(R.id.extra_chiekh_name);
            chiekhIgaza = itemView.findViewById(R.id.extra_chiekh_igaza);
            sendRequest = itemView.findViewById(R.id.extra_send_request_btn);
            callParent = itemView.findViewById(R.id.consl_call);
        }
    }
}
