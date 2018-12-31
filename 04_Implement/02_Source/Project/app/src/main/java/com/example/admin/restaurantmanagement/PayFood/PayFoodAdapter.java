package com.example.admin.restaurantmanagement.PayFood;

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

public class PayFoodAdapter extends RecyclerView.Adapter {
    List<PayFoodInfo> payFoodInfoList = new ArrayList<>();
    String counts[] = {"1", "2", "4", "5", "1", "2", "4", "6"};
    String prices[] = {"120000d", "130000d", "110000d", "123300d", "190000d", "220000d", "320000d", "420000d"};
    String foodNames[] = {"Com", "Bo", "Pho", "Heo", "Gà", "Vịt", "De", "Cừu"};
    Integer foodImage[] = {R.drawable.food1, R.drawable.food2, R.drawable.food3, R.drawable.food4,
            R.drawable.food5, R.drawable.food6, R.drawable.food7, R.drawable.food8};
    String sum;


    public PayFoodAdapter() {
        int tmp = 0;
        for (int i = 0; i < prices.length; i++) {

            PayFoodInfo payFoodInfo = new PayFoodInfo(foodNames[i], prices[i], counts[i], foodImage[i]);

            int count = Integer.parseInt(counts[i]);
            int price = Integer.parseInt(prices[i].substring(0, prices.length - 2));
            int cost = count * price;
            tmp+=cost;
            sum = String.valueOf(cost);
            payFoodInfo.setSum(sum);
            payFoodInfoList.add(payFoodInfo);

        }
        this.sum = String.valueOf(tmp);
    }

    public int total() {
        int tmp = 0;
        for (int i = 0; i < prices.length; i++) {
            int count = Integer.parseInt(counts[i]);
            int price = Integer.parseInt(prices[i].substring(0, prices.length - 2));
            int cost = count * price;
            tmp+=cost;
        }
        return tmp;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_pay_food, viewGroup, false);
        return new MyPayFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        MyPayFoodViewHolder holder = (MyPayFoodViewHolder) viewHolder;

        PayFoodInfo payFoodInfo = payFoodInfoList.get(i);
        holder.imgFood.setImageResource(payFoodInfo.getImgFood());
        holder.txtFoodName.setText(payFoodInfo.getFoodName());
        holder.txtCount.setText("Số lượng: " + payFoodInfo.getCount());
        holder.txtPrice.setText(payFoodInfo.getPrice());
        holder.txtSumEachFood.setText(payFoodInfo.getSum()+"d");
    }

    @Override
    public int getItemCount() {
        return payFoodInfoList.size();
    }

    private class MyPayFoodViewHolder extends RecyclerView.ViewHolder {
        ImageView imgFood;
        TextView txtFoodName, txtSumEachFood, txtCount, txtPrice;

        public MyPayFoodViewHolder(View view) {
            super(view);
            imgFood = view.findViewById(R.id.imgPayFood);
            txtFoodName = view.findViewById(R.id.txtPayFood);
            txtSumEachFood = view.findViewById(R.id.txtSumEachFood);
            txtCount = view.findViewById(R.id.txtFoodNumber);
            txtPrice = view.findViewById(R.id.txtOrderFoodPrice);

        }
    }
}
