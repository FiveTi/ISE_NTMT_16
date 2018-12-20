package com.example.admin.restaurantmanagement.RestaurantMenu.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.RestaurantMenuActivity;

public class OrderFragment extends Fragment {
    ImageView imgOrderFoodInfo, imgAdd, imgMinus, imgCloseOrder;
    TextView txtOrderFoodName, txtOrderFoodDetail,txtNumOrderFood;
    Button btnOrderFoodPrice;
    String orderPrice = "100000";


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.order_activity, container, false);
        imgOrderFoodInfo = view.findViewById(R.id.imgOrderFoodInfo);
        imgAdd = view.findViewById(R.id.imgAdd);
        imgMinus = view.findViewById(R.id.imgMinus);
        imgCloseOrder = view.findViewById(R.id.imgCloseOrder);
        btnOrderFoodPrice = view.findViewById(R.id.btnOrderFoodPrice);
        txtOrderFoodName = view.findViewById(R.id.txtOrderFoodName);
        txtOrderFoodDetail = view.findViewById(R.id.txtOrderFoodDetail);
        txtNumOrderFood = view.findViewById(R.id.txtNumOrderFood);

        imgMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                minusFood();
            }
        });

        imgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addFood();
            }
        });

        imgCloseOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment myFragment=new FoodMenuFragment();
                RestaurantMenuActivity appCompatActivity = (RestaurantMenuActivity) getActivity();
                appCompatActivity.getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.container, myFragment)
                        .addToBackStack(null)
                        .commit();
            }
        });

        btnOrderFoodPrice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                RestaurantMenuActivity restaurantMenuActivity = (RestaurantMenuActivity) getActivity();
////                Fragment orderFragment = restaurantMenuActivity.getSupportFragmentManager().findFragmentById(R.id.fragmentOrder);
////                restaurantMenuActivity.getSupportFragmentManager()
////                        .beginTransaction()
////                        .remove(orderFragment)
////                        .commit();

            }
        });
        return view;
    }

    private void minusFood() {
        int temp = Integer.parseInt(txtNumOrderFood.getText().toString());
        if (temp == 0) return;
        else {
            txtNumOrderFood.setText(String.valueOf(temp - 1));
            int res = Integer.parseInt(String.valueOf(temp - 1)) *  Integer.parseInt(orderPrice);
            btnOrderFoodPrice.setText("+ " + String.valueOf(res) + "d");
        }
    }

    private void addFood() {
        int temp = Integer.parseInt(txtNumOrderFood.getText().toString());
        txtNumOrderFood.setText(String.valueOf(temp + 1));
        int res = Integer.parseInt(String.valueOf(temp + 1)) *  Integer.parseInt(orderPrice);
        btnOrderFoodPrice.setText("+ " + String.valueOf(res) + "d");
    }

}
