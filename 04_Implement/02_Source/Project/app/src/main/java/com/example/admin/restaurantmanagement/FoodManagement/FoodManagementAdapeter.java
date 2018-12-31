package com.example.admin.restaurantmanagement.FoodManagement;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.Login.LoginActivity;
import com.example.admin.restaurantmanagement.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FoodManagementAdapeter extends RecyclerView.Adapter {
    public static final String FB_DATABASE_FOOD = "Menu/Food";
    ArrayList<MenuManagementInfo> foodManagementInfoList =  new ArrayList<>();
    Context context;

   public FoodManagementAdapeter(ArrayList<MenuManagementInfo> menuManagementInfoList){
        this.foodManagementInfoList =menuManagementInfoList;
   }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.tab_manage_food,viewGroup,false);
        return new MyFoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder viewHolder, int i) {
        View view = viewHolder.itemView;
        ImageView imgFood = (ImageView) view.findViewById(R.id.imgEmployManage);
        TextView txtFoodName = (TextView) view.findViewById(R.id.txtEmployNameManage);
        TextView txtPrice = (TextView) view.findViewById(R.id.txtEmployGenderManage);
        ImageView imgEdit = (ImageView) view.findViewById(R.id.imgbEditEmployManage);
        ImageView imgDelete = (ImageView) view.findViewById(R.id.imgAddEmploy);

        imgEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iEditFood= new Intent(v.getContext(), EditFoodManagementActivity.class);
                Bundle bEditFood = new Bundle();
                bEditFood.putSerializable("infoFood", foodManagementInfoList);
                bEditFood.putInt("position", viewHolder.getAdapterPosition());
                iEditFood.putExtras(bEditFood);
                v.getContext().startActivity(iEditFood);
            }
        });

        imgDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DeleteFood(v.getContext(), viewHolder.getAdapterPosition());
            }
        });

        MenuManagementInfo foodManagementInfo = foodManagementInfoList.get(i);
        txtFoodName.setText(foodManagementInfo.getFoodName());
        txtPrice.setText(foodManagementInfo.getPrice());
        Picasso.get().load(foodManagementInfo.getUrl()).into(imgFood);
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

    public AlertDialog.Builder DeleteFood(final Context context, final int position){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("XÓA MÓN ĂN");
        builder.setMessage("Bạn có chắc muốn xóa \""+ foodManagementInfoList.get(position).getFoodName() +"\" không?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                FirebaseDatabase database = FirebaseDatabase.getInstance();
                //Kết nối tới node có tên là contacts (node này do ta định nghĩa trong CSDL Firebase)
                DatabaseReference myRef = database.getReference(FB_DATABASE_FOOD);
                myRef.child(foodManagementInfoList.get(position).getFoodName()).setValue(null);

                Intent intent = new Intent(context, FoodManagementActivity.class);
                context.startActivity(intent);
            }
        });
        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
        return builder;
    }
}
