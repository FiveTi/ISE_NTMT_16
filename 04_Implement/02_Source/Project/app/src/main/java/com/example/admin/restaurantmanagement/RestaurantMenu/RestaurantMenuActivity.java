package com.example.admin.restaurantmanagement.RestaurantMenu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.example.admin.restaurantmanagement.R;

public class RestaurantMenuActivity extends AppCompatActivity {
    private TabLayout tabLayoutMenu;
    private  ViewPager viewPagerMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.restaurant_menu_activity);
        InitView();

        tabLayoutMenu.setupWithViewPager(viewPagerMenu);
        FragmentManager fragmentManager = getSupportFragmentManager();
        MenuAdapter menuAdapter = new MenuAdapter(fragmentManager);
        viewPagerMenu.setAdapter(menuAdapter);

    }

    private void InitView() {
        tabLayoutMenu = (TabLayout) findViewById(R.id.tabLayoutMenu);
        viewPagerMenu = (ViewPager) findViewById(R.id.viewPagerMenu);
        tabLayoutMenu.setTabMode(TabLayout.MODE_FIXED);
        tabLayoutMenu.setTabGravity(TabLayout.GRAVITY_FILL);
        tabLayoutMenu.setBackgroundResource(R.drawable.bg_table_diagram);
    }
}
