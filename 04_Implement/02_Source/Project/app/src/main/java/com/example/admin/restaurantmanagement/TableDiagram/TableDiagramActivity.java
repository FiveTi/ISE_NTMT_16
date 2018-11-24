package com.example.admin.restaurantmanagement.TableDiagram;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.PopupMenu;

import com.example.admin.restaurantmanagement.FoodManagement.FoodManagementAdapeter;
import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.RestaurantMenu.RestaurantMenuActivity;
import com.example.admin.restaurantmanagement.SelectedFood.SelectedFoodActivity;

public class TableDiagramActivity extends AppCompatActivity {
    GridView gvTableDiagram;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_diagram_activity);
        inItView();

        TableDiagramAdapter tableDiagramAdapter = new TableDiagramAdapter(this);
        gvTableDiagram.setAdapter(tableDiagramAdapter);
        gvTableDiagram.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    private void showCancel() {
        final AlertDialog.Builder builder = new AlertDialog.Builder(TableDiagramActivity.this,  R.style.Theme_AppCompat_DayNight_Dialog);
        builder.setMessage("Bạn có chắc muốn huỷ bàn?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

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
        gvTableDiagram = (GridView) findViewById(R.id.gvTable);
    }
}
