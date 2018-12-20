package com.example.admin.restaurantmanagement.RestaurantMenu.Adapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Fragment.FoodMenuFragment;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter {
    List<MenuInfo> menuDrinkList;
    String prices[] = {"120000d", "130000d", "110000d", "123300d", "190000d", "220000d", "320000d", "420000d"};
    String foodNames[] = {"Husky", "Bo", "Pho", "Heo", "Gà", "Vịt", "De", "Cừu"};
    Integer foodImage[] = {R.drawable.ic_arrow_back_black_24dp, R.drawable.food2, R.drawable.food3, R.drawable.food4,
            R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8};
    Bundle menuBundle;
    FoodMenuFragment fragment;

    public FoodMenuAdapter(List<MenuInfo> menuInfos) {
        this.menuDrinkList = menuInfos;
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

        MenuInfo menuInfo = menuDrinkList.get(i);
        myFoodMenuViewHolder.txtMenuNameFood.setText(menuInfo.getFoodName());
        myFoodMenuViewHolder.txtMemuPrice.setText(menuInfo.getPrice());

        Picasso.get().load(menuInfo.getUrl()).into(myFoodMenuViewHolder.imgMenuFood);

        myFoodMenuViewHolder.imgAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                fragment.showDetail();
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuDrinkList.size();
    }

    private class MyFoodMenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuFood, imgAddFood;
        TextView txtMenuNameFood, txtMemuPrice;

        public MyFoodMenuViewHolder(View view) {
            super(view);
            imgMenuFood = view.findViewById(R.id.imgMenuFood);
            txtMenuNameFood = view.findViewById(R.id.txtMenuFoodName);
            txtMemuPrice = view.findViewById(R.id.txtMenuPayPrice);
            imgAddFood = view.findViewById(R.id.imgbMenuAddFood);
        }
    }
}
