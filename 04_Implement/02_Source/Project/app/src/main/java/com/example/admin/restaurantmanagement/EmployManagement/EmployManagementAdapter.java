package com.example.admin.restaurantmanagement.EmployManagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EmployManagementAdapter extends Adapter {
    List<EmployManagementInfo> employManagementInfoList = new ArrayList<>();
    Context context;

    public EmployManagementAdapter(ArrayList<EmployManagementInfo> employManagementInfoList){
        this.employManagementInfoList=employManagementInfoList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_manage_employ,viewGroup,false);
        return new MyEmployViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        ImageView imgEmploy = view.findViewById(R.id.imgEmploy);
        TextView txtEmployName = view.findViewById(R.id.txtEmployName);
        TextView txtEmployPhone = view.findViewById(R.id.txtEmployPhone);

        EmployManagementInfo employManagementInfo = employManagementInfoList.get(i);


        txtEmployName.setText(employManagementInfo.getEmployName());
        txtEmployPhone.setText(employManagementInfo.getPhone());
        Picasso.get().load(employManagementInfo.getUrl()).into(imgEmploy);

    }

    @Override
    public int getItemCount() {
        return employManagementInfoList.size();
    }

    private class MyEmployViewHolder extends RecyclerView.ViewHolder {
        public MyEmployViewHolder(View view) {
            super(view);
        }
    }
}
