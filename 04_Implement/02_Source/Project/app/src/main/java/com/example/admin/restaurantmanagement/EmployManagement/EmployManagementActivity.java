package com.example.admin.restaurantmanagement.EmployManagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toolbar;

import com.example.admin.restaurantmanagement.R;

public class EmployManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_employ_activity);

        RecyclerView recyclerViewEmploy = (RecyclerView) findViewById(R.id.revEmployManage);
        EmployManagementAdapter employManagementAdapter  =new EmployManagementAdapter();
        recyclerViewEmploy.setAdapter(employManagementAdapter);
        recyclerViewEmploy.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
