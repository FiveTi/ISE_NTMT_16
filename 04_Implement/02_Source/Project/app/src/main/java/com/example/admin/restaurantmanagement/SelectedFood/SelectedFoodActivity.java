package com.example.admin.restaurantmanagement.SelectedFood;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.RestaurantMenuActivity;
import com.example.admin.restaurantmanagement.TableDiagram.TableDiagramActivity;

public class SelectedFoodActivity extends AppCompatActivity {
    Button btnAddFood, btnPay;
    RecyclerView recyclerView;
    TextView txtSelectedSumPrice;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.selected_food_activity);
        inItView();

        SelectedFoodAdapter selectedFoodAdapter = new SelectedFoodAdapter();
        recyclerView.setAdapter(selectedFoodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        txtSelectedSumPrice.setText("Thành tiền: " + selectedFoodAdapter.total());
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payFood();
            }
        });
    }



    private void payFood() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(SelectedFoodActivity.this,  R.style.Theme_AppCompat_DayNight_Dialog);
        builder.setMessage("Bạn có chắc muốn  thanh toán?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Intent intent =  new Intent(SelectedFoodActivity.this, TableDiagramActivity.class);
                startActivity(intent);
            }
        });

        builder.setNegativeButton("Không", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        builder.show();
    }

    private void inItView() {
        recyclerView = (RecyclerView) findViewById(R.id.revSelectedFood);
        btnAddFood = (Button) findViewById(R.id.btnAddFood);
        btnPay = (Button) findViewById(R.id.btnPay);
        txtSelectedSumPrice = (TextView) findViewById(R.id.txtSeletedSumPrice);
    }


}
