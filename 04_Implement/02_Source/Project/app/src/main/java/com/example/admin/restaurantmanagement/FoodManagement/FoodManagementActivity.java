package com.example.admin.restaurantmanagement.FoodManagement;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.admin.restaurantmanagement.R;

public class FoodManagementActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_food_activity);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.revFoodManage);
        FoodManagementAdapeter foodManagementAdapeter = new FoodManagementAdapeter();
        recyclerView.setAdapter(foodManagementAdapeter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }
}
