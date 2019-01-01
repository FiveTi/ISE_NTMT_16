package com.example.admin.restaurantmanagement.RestaurantMenu.Adapter;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.OrderActivity.OrderActivity;
import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Fragment.FoodMenuFragment;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter {
    ArrayList<MenuInfo> menuFoodList;
    Bundle menuBundle;
    public static FoodMenuFragment foodMenuFragment;
    Integer posFood;
    public FoodMenuAdapter(ArrayList<MenuInfo> menuInfos, FoodMenuFragment foodMenuFragment) {
        this.menuFoodList = menuInfos;
        this.foodMenuFragment = foodMenuFragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_menu_food, viewGroup, false);
        return new MyFoodMenuViewHolder(view);
    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final MyFoodMenuViewHolder myFoodMenuViewHolder = (MyFoodMenuViewHolder) viewHolder;

        MenuInfo menuInfo = menuFoodList.get(i);
        myFoodMenuViewHolder.txtMenuNameFood.setText(menuInfo.getFoodName());
        myFoodMenuViewHolder.txtMemuPrice.setText(menuInfo.getPrice() + "d");
        Picasso.get().load(menuInfo.getUrl()).into(myFoodMenuViewHolder.imgMenuFood);

//        final Integer posFood = i;
        myFoodMenuViewHolder.imgAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //foodMenuFragment.showDetail();
                Intent iEditFood= new Intent(v.getContext(), OrderActivity.class);
                Bundle bEditFood = new Bundle();
                bEditFood.putSerializable("infoFood", menuFoodList);
                bEditFood.putInt("position", viewHolder.getAdapterPosition());
                bEditFood.putInt("type", 0);
                iEditFood.putExtras(bEditFood);
                //foodManagementFragment.getActivity().finish();
                v.getContext().startActivity(iEditFood);
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuFoodList.size();
    }

    private class MyFoodMenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuFood, imgAddFood;
        TextView txtMenuNameFood, txtMemuPrice;

        public MyFoodMenuViewHolder(View view) {
            super(view);
            imgMenuFood = view.findViewById(R.id.imgOrderFood);
            txtMenuNameFood = view.findViewById(R.id.txtMenuFoodName);
            txtMemuPrice = view.findViewById(R.id.txtOrderFoodPrice);
            imgAddFood = view.findViewById(R.id.imgbMenuAddFood);
        }
    }
}
