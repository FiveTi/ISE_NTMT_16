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

import java.util.ArrayList;
import java.util.List;

public class EmployManagementAdapter extends Adapter {
    List<EmployManagementInfo> employManagementInfoList = new ArrayList<>();
    Context context;

    String employName[] = {"Nguyen Van A", "Nguyen Van B", "Nguyen Van AB", "Nguyen Van AC", "Nguyen Van Milan", "Nguyen Van MU", "Nguyen Van AQ", "Nguyen Van"};
    String employDate[] = {"Nhan vien 01", "Bo", "Pho", "Heo", "Gà", "Vịt", "De", "Cừu"};
    Integer employImage[] = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8};

    public EmployManagementAdapter(){
        for(int i=0;i<employName.length;i++){
            EmployManagementInfo employManagementInfo= new EmployManagementInfo(employImage[i],employName[i],employDate[i]);
            employManagementInfoList.add(employManagementInfo);
        }
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
        ImageView imgEmploy = view.findViewById(R.id.imgEmployManage);
        TextView txtEmployName = view.findViewById(R.id.txtEmployNameManage);
        TextView txtDateManage = view.findViewById(R.id.txtEmployGenderManage);

        EmployManagementInfo employManagementInfo = employManagementInfoList.get(i);
        imgEmploy.setImageResource(employManagementInfo.getImgEmploy());
        txtEmployName.setText(employManagementInfo.getEmployName());
        txtDateManage.setText(employManagementInfo.getPhone());

    }

    @Override
    public int getItemCount() {
        return employImage.length;
    }

    private class MyEmployViewHolder extends RecyclerView.ViewHolder {
        public MyEmployViewHolder(View view) {
            super(view);
        }
    }
}
