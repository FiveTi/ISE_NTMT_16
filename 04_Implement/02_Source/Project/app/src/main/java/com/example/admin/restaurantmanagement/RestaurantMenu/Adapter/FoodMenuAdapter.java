package com.example.admin.restaurantmanagement.RestaurantMenu.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import java.util.ArrayList;
import java.util.List;

public class FoodMenuAdapter extends RecyclerView.Adapter {
    List<MenuInfo> menuInfoList = new ArrayList<>();
    String prices[] = {"120000d", "130000d", "110000d", "123300d", "190000d", "220000d", "320000d", "420000d"};
    String foodNames[] = {"Com", "Bo", "Pho", "Heo", "Gà", "Vịt", "De", "Cừu"};
    Integer foodImage[] = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4,
            R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8};

    public FoodMenuAdapter() {
        int tmp = 0;
        for (int i = 0; i < prices.length; i++) {
            MenuInfo menuInfo = new MenuInfo(foodImage[i], foodNames[i], prices[i]);
            menuInfoList.add(menuInfo);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_menu_food, viewGroup, false);
        return new MyFoodMenuViewHolder(view);

    }


    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        ImageView imgMenuFood = (ImageView) view.findViewById(R.id.imgMemuFood);
        TextView txtMenuNameFood = (TextView) view.findViewById(R.id.txtMenuNameFood);
        TextView txtMemuPrice = (TextView) view.findViewById(R.id.txtMenuPriceFood);

        MenuInfo menuInfo = menuInfoList.get(i);
        imgMenuFood.setImageResource(menuInfo.getImgFood());
        txtMenuNameFood.setText(menuInfo.getFoodName());
        txtMemuPrice.setText(menuInfo.getPrice());
    }

    @Override
    public int getItemCount() {
        return menuInfoList.size();
    }

    private class MyFoodMenuViewHolder extends RecyclerView.ViewHolder {
        public MyFoodMenuViewHolder(View view) {
            super(view);
        }
    }
}
