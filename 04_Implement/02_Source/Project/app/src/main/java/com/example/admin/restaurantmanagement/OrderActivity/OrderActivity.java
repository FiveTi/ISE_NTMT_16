package com.example.admin.restaurantmanagement.OrderActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Adapter.FoodMenuAdapter;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    List<MenuInfo> menuInfoList = new ArrayList<>();
    ImageView imgOrderFoodInfo, imgAdd, imgMinus;
    TextView txtOrderFoodName, txtOrderFoodDetail,txtNumOrderFood;
    Button btnOrderFoodPrice;
    String orderPrice = "100000";
    Bundle foodBundle =new Bundle();
    private  String FOOD_MENU = "FOOD MENU";
    Integer posFood;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);

        getBundleFromMenu();
        inItView();


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
    }

    private void inItView() {
        imgAdd =findViewById(R.id.imgAdd);
        imgMinus = findViewById(R.id.imgMinus);
        imgOrderFoodInfo = findViewById(R.id.imgOrderFoodInfo);
        btnOrderFoodPrice = findViewById(R.id.btnOrderFoodPrice);
        txtOrderFoodName = findViewById(R.id.txtOrderFoodName);
        txtOrderFoodDetail = findViewById(R.id.txtOrderFoodDetail);
        txtNumOrderFood = findViewById(R.id.txtNumOrderFood);

        Picasso.get().load(menuInfoList.get(posFood).getUrl()).into(imgOrderFoodInfo);
        txtNumOrderFood.setText(menuInfoList.get(posFood).getFoodName());
        txtOrderFoodDetail.setText(menuInfoList.get(posFood).getDetail());
        btnOrderFoodPrice.setText(menuInfoList.get(posFood).getPrice());
    }

    private void getBundleFromMenu() {
        foodBundle = this.getIntent().getExtras();
        menuInfoList = (ArrayList<MenuInfo>) foodBundle.getSerializable(FOOD_MENU);
        posFood = foodBundle.getInt("posFood");
    }

    private void minusFood() {
        int temp = Integer.parseInt(txtNumOrderFood.getText().toString());
        if (temp == 1) return;
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
