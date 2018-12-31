package com.example.admin.restaurantmanagement.FoodManagement;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.restaurantmanagement.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FoodManagementActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private DatabaseReference mDatabaseRef;
    private ProgressDialog progressDialog;
    RecyclerView recyclerView;
    private ArrayList<MenuManagementInfo> menuManagementInfoList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_food_activity);
        recyclerView = (RecyclerView) findViewById(R.id.revFoodManage);
        menuManagementInfoList = new ArrayList<>();

        toolbar = findViewById(R.id.nav_add_employ_management);

        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Quản lý món ăn");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed(); // Implemented by activity
            }
        });


        mDatabaseRef = FirebaseDatabase.getInstance().getReference(AddFoodManagementActivity.FB_DATABASE_FOOD);

        progressDialog = new ProgressDialog(FoodManagementActivity.this);
        progressDialog.setMessage("Vui lòng chờ giây lát...");
        progressDialog.show();

        final FoodManagementAdapeter foodManagementAdapeter = new FoodManagementAdapeter(menuManagementInfoList);
        recyclerView.setAdapter(foodManagementAdapeter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //ImageUpload class require default constructor
                    MenuManagementInfo menuManagementInfo = snapshot.getValue(MenuManagementInfo.class);
                    menuManagementInfoList.add(menuManagementInfo);
                }
                foodManagementAdapeter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {
                progressDialog.dismiss();

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_food_management, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        if (item.getItemId() == R.id.action_add_food_management) {
            intent = new Intent(FoodManagementActivity.this, AddFoodManagementActivity.class);
            startActivity(intent);
        }
        if (item.getItemId() == R.id.action_add_drink_management) {
            intent = new Intent(FoodManagementActivity.this, AddDrinkManagementActivity.class);
            startActivity(intent);
        }
        return true;
    }
}
