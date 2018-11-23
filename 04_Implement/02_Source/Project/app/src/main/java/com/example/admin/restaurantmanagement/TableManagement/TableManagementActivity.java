package com.example.admin.restaurantmanagement.TableManagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.restaurantmanagement.EmployManagement.EmployManagementAdapter;
import com.example.admin.restaurantmanagement.R;

public class TableManagementActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_table_activity);

        RecyclerView recyclerViewTable = (RecyclerView) findViewById(R.id.revTableManage);
        TableManagementAdapter tableManagementAdapter  =new TableManagementAdapter();
        recyclerViewTable.setAdapter(tableManagementAdapter);
        recyclerViewTable.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
