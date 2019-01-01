package com.example.admin.restaurantmanagement.OrderActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.FoodManagement.MenuManagementInfo;
import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.Adapter.FoodMenuAdapter;
import com.example.admin.restaurantmanagement.RestaurantMenu.MenuInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class OrderActivity extends AppCompatActivity {
    private StorageReference mStorageRef;
    private DatabaseReference mDatabaseRef;

    ImageView imgOrderFoodInfo, imgAdd, imgMinus, imgClose;
    TextView txtOrderFoodName, txtOrderFoodDetail, txtNumOrderFood;
    Button btnOrderFoodPrice;

    public static final int REQUEST_CHOOSE_IMAGE = 1234;
    public static final String FB_STORAGE_FOOD = "Food/";
    public static final String FB_STORAGE_DRINK = "Drink/";
    public static final String FB_DATABASE_FOOD = "Menu/Food";
    public static final String FB_DATABASE_DRINK = "Menu/Drink";
    public int posFood;
    public int type; // 0 là đồ ăn, 1 là thức uống
    public String key;
    String orderPrice = "0";

    ArrayList<MenuInfo> food;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        inItView();
        Bundle foodBundle = null;
        getBundleFromMenu(foodBundle);

        txtOrderFoodName.setText(food.get(posFood).getFoodName());
        txtOrderFoodDetail.setText(food.get(posFood).getDetail());
        btnOrderFoodPrice.setText(food.get(posFood).getPrice());
        Picasso.get().load(food.get(posFood).getUrl()).into(imgOrderFoodInfo);

        orderPrice = food.get(posFood).getPrice();

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

        imgClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void inItView() {
        imgClose=findViewById(R.id.imgCloseOrder);
        imgAdd = findViewById(R.id.imgAdd);
        imgMinus = findViewById(R.id.imgMinus);
        imgOrderFoodInfo = findViewById(R.id.imgOrderFoodInfo);
        btnOrderFoodPrice = findViewById(R.id.btnOrderFoodPrice);
        txtOrderFoodName = findViewById(R.id.txtOrderFoodName);
        txtOrderFoodDetail = findViewById(R.id.txtOrderFoodDetail);
        txtNumOrderFood = findViewById(R.id.txtNumOrderFood);
    }

    private void getBundleFromMenu(Bundle foodBundle) {
        foodBundle = this.getIntent().getExtras();
        posFood = foodBundle.getInt("position");
        type = foodBundle.getInt("type");
        if (type == 0) {
            mStorageRef = FirebaseStorage.getInstance().getReference(FB_STORAGE_FOOD);
            mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_FOOD);
        } else {
            mStorageRef = FirebaseStorage.getInstance().getReference(FB_STORAGE_DRINK);
            mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_DRINK);
        }

        food = (ArrayList<MenuInfo>) foodBundle.getSerializable("infoFood");

        key = food.get(posFood).getFoodName();
    }

    private void minusFood() {
        int temp = Integer.parseInt(txtNumOrderFood.getText().toString());
        if (temp == 1) return;
        else {
            txtNumOrderFood.setText(String.valueOf(temp - 1));
            int res = Integer.parseInt(String.valueOf(temp - 1)) * Integer.parseInt(orderPrice);
            btnOrderFoodPrice.setText("+ " + String.valueOf(res) + "d");
        }
    }

    private void addFood() {
        int temp = Integer.parseInt(txtNumOrderFood.getText().toString());
        txtNumOrderFood.setText(String.valueOf(temp + 1));
        int res = Integer.parseInt(String.valueOf(temp + 1)) * Integer.parseInt(orderPrice);
        btnOrderFoodPrice.setText("+ " + String.valueOf(res) + "d");
    }

}
