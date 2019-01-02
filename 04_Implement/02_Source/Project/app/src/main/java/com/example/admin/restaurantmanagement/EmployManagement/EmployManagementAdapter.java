package com.example.admin.restaurantmanagement.EmployManagement;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.FoodManagement.MenuManagementActivity;
import com.example.admin.restaurantmanagement.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class EmployManagementAdapter extends Adapter {
    List<EmployManagementInfo> employManagementInfoList;
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
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        ImageView imgEmploy = view.findViewById(R.id.imgEmploy);
        TextView txtEmployName = view.findViewById(R.id.txtEmployName);
        TextView txtEmployPhone = view.findViewById(R.id.txtEmployPhone);
        ImageView imgDeleteEmploy = view.findViewById(R.id.imgDeleteEmploy);
        ImageView imgEditEmploy = view.findViewById(R.id.imgEditEmploy);

        EmployManagementInfo employManagementInfo = employManagementInfoList.get(i);


        txtEmployName.setText(employManagementInfo.getEmployName());
        txtEmployPhone.setText(employManagementInfo.getPhone());
        Picasso.get().load(employManagementInfo.getUrl()).into(imgEmploy);

        imgDeleteEmploy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteEmployee(v.getContext(), viewHolder.getAdapterPosition());
            }
        });

        imgEditEmploy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
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

    public AlertDialog.Builder DeleteEmployee(final Context context, final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("XÓA MÓN ĂN");
        builder.setMessage("Bạn có chắc muốn xóa \""+ employManagementInfoList.get(position).getEmployName() +"\" không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                EmployManagement employManagement = new EmployManagement(context);
                employManagement.DeleteEmployee(employManagementInfoList.get(position));


            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
        return builder;
    }
}
