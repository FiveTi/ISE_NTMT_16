package com.example.admin.restaurantmanagement.TableManagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class TableManagementAdapter extends RecyclerView.Adapter {
    List<TableManagementInfo> tableManagementInfoList = new ArrayList<>();
    Context context;

    String tableName[] = {"Nguyen Van A", "Nguyen Van B", "Nguyen Van AB", "Nguyen Van AC", "Nguyen Van Milan", "Nguyen Van MU", "Nguyen Van AQ", "Nguyen Van"};

    public TableManagementAdapter(){
        for(int i=0;i<tableName.length;i++){
            TableManagementInfo tableManagementInfo= new TableManagementInfo(tableName[i]);
            tableManagementInfoList.add(tableManagementInfo);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_manage_table,viewGroup,false);
        return new MyTableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        TextView txtTableName = (TextView) view.findViewById(R.id.txtTableNameManage);
        TableManagementInfo tableManagementInfo = tableManagementInfoList.get(i);
        txtTableName.setText(tableManagementInfo.getTableName());
    }

    @Override
    public int getItemCount() {
        return tableName.length;
    }

    private class MyTableViewHolder extends RecyclerView.ViewHolder {
        public MyTableViewHolder(View view) {
            super(view);
        }
    }
}
