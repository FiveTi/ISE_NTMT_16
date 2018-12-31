package com.example.admin.restaurantmanagement.RestaurantMenu.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Fragment.DrinkMenuFragment;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import com.squareup.picasso.Picasso;

import java.util.List;

public class DrinkMenuAdapter extends RecyclerView.Adapter{
    List<MenuInfo> menuInfoList;
    DrinkMenuFragment drinkMenuFragment;
    public DrinkMenuAdapter(List<MenuInfo> menuInfos, DrinkMenuFragment drinkMenuFragment) {
        this.menuInfoList = menuInfos;
        this.drinkMenuFragment =drinkMenuFragment;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_menu_food, viewGroup, false);
        return new DrinkMenuAdapter.MyDrinkMenuViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        final DrinkMenuAdapter.MyDrinkMenuViewHolder myFoodMenuViewHolder = (DrinkMenuAdapter.MyDrinkMenuViewHolder) viewHolder;

        MenuInfo menuInfo = menuInfoList.get(i);
        myFoodMenuViewHolder.txtMenuNameFood.setText(menuInfo.getFoodName());
        myFoodMenuViewHolder.txtMemuPrice.setText(menuInfo.getPrice()+"d");

        Picasso.get().load(menuInfo.getUrl()).into(myFoodMenuViewHolder.imgMenuFood);

        myFoodMenuViewHolder.imgAddFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               drinkMenuFragment.showDetail();
            }
        });
    }


    @Override
    public int getItemCount() {
        return menuInfoList.size();
    }

    private class MyDrinkMenuViewHolder extends RecyclerView.ViewHolder {
        ImageView imgMenuFood, imgAddFood;
        TextView txtMenuNameFood, txtMemuPrice;

        public MyDrinkMenuViewHolder(View view) {
            super(view);
            imgMenuFood = view.findViewById(R.id.imgEmployManage);
            txtMenuNameFood = view.findViewById(R.id.txtMenuFoodName);
            txtMemuPrice = view.findViewById(R.id.txtEmployGenderManage);
            imgAddFood = view.findViewById(R.id.imgbMenuAddFood);
        }
    }
}
