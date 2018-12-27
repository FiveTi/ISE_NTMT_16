package com.example.admin.restaurantmanagement.RestaurantMenu.Fragment;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.admin.restaurantmanagement.FoodManagement.AddFoodManagementActivity;
import com.example.admin.restaurantmanagement.OrderActivity.OrderActivity;
import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Adapter.DrinkMenuAdapter;
import com.example.admin.restaurantmanagement.RestaurantMenu.Adapter.FoodMenuAdapter;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import com.example.admin.restaurantmanagement.RestaurantMenu.RestaurantMenuActivity;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class DrinkMenuFragment extends Fragment {
    private List<MenuInfo> menuInfoList = new ArrayList<>();
    RecyclerView revFoodMenu;
    private DatabaseReference mDatabaseRef;
    private ProgressDialog progressDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.food_menu_fragment, container, false);
        revFoodMenu = (RecyclerView) view.findViewById(R.id.revMenuFood);
        progressDialog = new ProgressDialog(container.getContext());
        progressDialog.setMessage("Vui lòng chờ giây lát...");
        progressDialog.show();

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(AddFoodManagementActivity.FB_DATABASE_DRINK);

        final DrinkMenuAdapter drinkMenuAdapter = new DrinkMenuAdapter(menuInfoList, this);
        revFoodMenu.setAdapter(drinkMenuAdapter);
        revFoodMenu.setLayoutManager(new LinearLayoutManager(getContext()));

        mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                progressDialog.dismiss();

                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    //ImageUpload class require default constructor
                    MenuInfo menuInfo = snapshot.getValue(MenuInfo.class);
                    menuInfoList.add(menuInfo);
                }
                drinkMenuAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        return view;
    }

    public void showDetail() {
//        Fragment myFragment=new OrderFragment();
//        RestaurantMenuActivity appCompatActivity = (RestaurantMenuActivity) getActivity();
//        appCompatActivity.getSupportFragmentManager()
//                .beginTransaction()
//                .add(R.id.container, myFragment)
//                .addToBackStack(null)
//                .commit();
        Intent intent = new Intent(getActivity(), OrderActivity.class);
        startActivity(intent);
    }
}
