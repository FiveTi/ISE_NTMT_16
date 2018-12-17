package com.example.admin.restaurantmanagement.FoodManagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.restaurantmanagement.R;

import java.util.Objects;

public class FoodManagementActivity extends AppCompatActivity {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_food_activity);

        toolbar = findViewById(R.id.nav_add_food);
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Food management");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.revFoodManage);
        FoodManagementAdapeter foodManagementAdapeter = new FoodManagementAdapeter();
        recyclerView.setAdapter(foodManagementAdapeter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_food_management, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.action_add_food_management){
            intent = new Intent(FoodManagementActivity.this, AddFoodManagementActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_add_drink_management){
            intent = new Intent(FoodManagementActivity.this, AddDrinkManagementActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
