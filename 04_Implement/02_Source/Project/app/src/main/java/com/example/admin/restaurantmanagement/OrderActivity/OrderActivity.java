package com.example.admin.restaurantmanagement.OrderActivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;

public class OrderActivity extends AppCompatActivity {
    ImageView imgOrderFoodInfo, imgAdd, imgMinus;
    TextView txtOrderFoodName, txtOrderFoodDetail,txtNumOrderFood;
    Button btnOrderFoodPrice;
    String orderPrice = "100000";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_activity);
        imgOrderFoodInfo = findViewById(R.id.imgOrderFoodInfo);
        imgAdd =findViewById(R.id.imgAdd);
        imgMinus = findViewById(R.id.imgMinus);

        btnOrderFoodPrice = findViewById(R.id.btnOrderFoodPrice);

        txtOrderFoodName = findViewById(R.id.txtOrderFoodName);
        txtOrderFoodDetail = findViewById(R.id.txtOrderFoodDetail);
        txtNumOrderFood = findViewById(R.id.txtNumOrderFood);

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

//    @Nullable
//    @Override
//    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        View view = inflater.inflate(R.layout.order_fragment,container,false);
//        imgOrderFoodInfo = view.findViewById(R.id.imgOrderFoodInfo);
//        imgAdd = view.findViewById(R.id.imgAdd);
//        imgMinus = view.findViewById(R.id.imgMinus);
//
//        btnOrderFoodPrice = view.findViewById(R.id.btnOrderFoodPrice);
//
//        txtOrderFoodName = view.findViewById(R.id.txtOrderFoodName);
//        txtOrderFoodDetail = view.findViewById(R.id.txtOrderFoodDetail);
//        txtNumOrderFood = view.findViewById(R.id.txtNumOrderFood);
//
//        imgMinus.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                minusFood();
//            }
//        });
//
//        imgAdd.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                addFood();
//            }
//        });
//
//        return view;
//    }

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
