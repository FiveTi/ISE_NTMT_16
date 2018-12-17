package com.example.admin.restaurantmanagement.FoodManagement;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;

import java.util.ArrayList;
import java.util.List;

public class FoodManagementAdapeter extends RecyclerView.Adapter {
    List<MenuManagementInfo> foodManagementInfoList =  new ArrayList<>();
    Context context;

    String prices[] = {"120000d", "130000d", "110000d", "123300d", "190000d", "220000d", "320000d", "420000d"};
    String foods[] = {"Com", "Bo", "Pho", "Heo", "Gà", "Vịt", "De", "Cừu", "Sư tử"};
    Integer foodImage[] = {R.drawable.food1, R.drawable.food2,R.drawable.food3, R.drawable.food4, R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8};
    String foodType[] = {"Món chính"};

   public FoodManagementAdapeter(){
       for(int i=0;i<prices.length;i++){
           MenuManagementInfo foodManagementInfo = new MenuManagementInfo(foodImage[i],foods[i],prices[i],foodType[0]);
           foodManagementInfoList.add(foodManagementInfo);
       }
   }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_manage_food,viewGroup,false);
        return new MyFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        ImageView imgFood = (ImageView) view.findViewById(R.id.imgFoodManage);
        TextView txtFoodName = (TextView) view.findViewById(R.id.txtFoodNameManage);
        TextView txtTypeFood = (TextView) view.findViewById(R.id.txtTypeFoodManage);
        TextView txtPrice = (TextView) view.findViewById(R.id.txtPayPrice);

        MenuManagementInfo foodManagementInfo = foodManagementInfoList.get(i);
        imgFood.setImageResource(foodManagementInfo.getImgFood());
        txtFoodName.setText(foodManagementInfo.getFoodName());
        txtPrice.setText(foodManagementInfo.getPrice());
        txtTypeFood.setText(foodManagementInfo.getType());

    }

    @Override
    public int getItemCount() {
        return foodManagementInfoList.size();
    }

    private class MyFoodViewHolder extends RecyclerView.ViewHolder {
        public MyFoodViewHolder(View view) {
            super(view);

        }
    }
}
