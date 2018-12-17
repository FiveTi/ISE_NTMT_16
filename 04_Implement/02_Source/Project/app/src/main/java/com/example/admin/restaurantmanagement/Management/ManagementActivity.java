package com.example.admin.restaurantmanagement.Management;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.admin.restaurantmanagement.EmployManagement.EmployManagementActivity;
import com.example.admin.restaurantmanagement.FoodManagement.AddFoodManagementActivity;
import com.example.admin.restaurantmanagement.FoodManagement.FoodManagementActivity;
import com.example.admin.restaurantmanagement.LoginActivity;
import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.TableManagement.TableManagementActivity;

public class ManagementActivity extends AppCompatActivity {
    Button btnLogOut, btnManageEmploy, btnManageFood, btnManageTable, btnStatistic;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_activity);
        inItView();

        btnManageFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagementActivity.this, FoodManagementActivity.class);
                    startActivity(intent);
            }
        });

        btnManageTable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagementActivity.this, TableManagementActivity.class);
                startActivity(intent);
            }
        });

        btnManageEmploy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagementActivity.this, EmployManagementActivity.class);
                startActivity(intent);
            }
        });

        btnStatistic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(ManagementActivity.this, .class);
//                startActivity(intent);
            }
        });

        btnLogOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ManagementActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

    }

    private void inItView() {
        btnLogOut = findViewById(R.id.btnLogOut);
        btnManageEmploy = findViewById(R.id.btnManageEmploy);
        btnManageFood = findViewById(R.id.btnManageFood);
        btnManageTable = findViewById(R.id.btnManageTable);
        btnStatistic = findViewById(R.id.btnStatistic);
    }
}
