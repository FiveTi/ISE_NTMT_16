package com.example.admin.restaurantmanagement.RestaurantMenu.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Adapter.FoodMenuAdapter;
import com.example.admin.restaurantmanagement.RestaurantMenu.RestaurantMenuActivity;

public class FoodMenuFragment extends Fragment {
    RecyclerView revFoodMenu;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_menu_fragment, container, false);
        revFoodMenu = (RecyclerView) view.findViewById(R.id.revMenuFood);
        FoodMenuAdapter foodMenuAdapter = new FoodMenuAdapter(this);
        revFoodMenu.setAdapter(foodMenuAdapter);
        revFoodMenu.setLayoutManager(new LinearLayoutManager(view.getContext()));


        return view;
    }

    public void showDetail() {
        Fragment myFragment=new OrderFragment();
        RestaurantMenuActivity appCompatActivity = (RestaurantMenuActivity) getActivity();
        appCompatActivity.getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, myFragment)
                .addToBackStack(null)
                .commit();
    }
}
