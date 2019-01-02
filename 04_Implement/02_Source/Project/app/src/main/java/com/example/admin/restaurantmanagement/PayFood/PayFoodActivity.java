package com.example.admin.restaurantmanagement.PayFood;

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
import android.widget.Toast;

import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.TableDiagram.TableDiagramActivity;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class PayFoodActivity extends AppCompatActivity {
    private DatabaseReference mData;

    Button btnPay;
    RecyclerView recyclerView;
    TextView txtPaySumPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_food_activity);
        inItView();

        PayFoodAdapter payFoodAdapter = new PayFoodAdapter();
        recyclerView.setAdapter(payFoodAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        txtPaySumPrice.setText("Thành tiền: " + payFoodAdapter.total());
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                payFood();
            }
        });

        mData=FirebaseDatabase.getInstance().getReference();
    }


    private void payFood() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(PayFoodActivity.this, R.style.Theme_AppCompat_DayNight_Dialog);
        builder.setMessage("Bạn có chắc muốn thanh toán?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                mData.child("Table/tb01/ListOder/").setValue(null);

                Toast.makeText(getApplicationContext(),"Thanh toán thành công",Toast.LENGTH_SHORT).show();

                mData.child("Table/tb01/name").setValue("tb01");

                Intent intent = new Intent(PayFoodActivity.this, TableDiagramActivity.class);
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
        recyclerView = (RecyclerView) findViewById(R.id.revPayFood);
        btnPay = (Button) findViewById(R.id.btnPay);
        txtPaySumPrice = (TextView) findViewById(R.id.txtPaySumPrice);
    }


}
