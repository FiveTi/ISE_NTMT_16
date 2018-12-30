package com.example.admin.restaurantmanagement.EmployManagement;

import android.app.SearchManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.admin.restaurantmanagement.FoodManagement.AddDrinkManagementActivity;
import com.example.admin.restaurantmanagement.FoodManagement.AddFoodManagementActivity;
import com.example.admin.restaurantmanagement.R;

import java.util.Objects;

public class EmployManagementActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private RecyclerView recyclerViewEmploy;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.management_employ_activity);
        inItView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

        EmployManagementAdapter employManagementAdapter  =new EmployManagementAdapter();
        recyclerViewEmploy.setAdapter(employManagementAdapter);
        recyclerViewEmploy.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_employ_management,menu);
        final SearchView searchView = (SearchView) MenuItemCompat.getActionView(menu.findItem(R.id.action_search_employ));
        SearchManager searchManager = (SearchManager) getSystemService(SEARCH_SERVICE);
        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.action_add_employ_management){
            Intent intent = new Intent(EmployManagementActivity.this,AddEmployManagementActivity.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }

    private void inItView() {
        recyclerViewEmploy = (RecyclerView) findViewById(R.id.revEmployManage);
        toolbar = findViewById(R.id.nav_employ_management);
    }
}
