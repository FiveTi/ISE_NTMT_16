package com.example.admin.restaurantmanagement.TableDiagram;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import com.example.admin.restaurantmanagement.Login.LoginActivity;
import com.example.admin.restaurantmanagement.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class TableDiagramActivity extends AppCompatActivity {
    private GridView gvTableDiagram;
    private FirebaseAuth firebaseAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.table_diagram_activity);
        inItView();
        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser() == null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        //lấy ra user hiện tại
        FirebaseUser user = firebaseAuth.getCurrentUser();

        TableDiagramAdapter tableDiagramAdapter = new TableDiagramAdapter(this);
        gvTableDiagram.setAdapter(tableDiagramAdapter);
        gvTableDiagram.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
    }

    //quay trở lại màn hình đăng nhập
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode==event.KEYCODE_BACK){
            returnToLogin(TableDiagramActivity.this);
        }
        return super.onKeyDown(keyCode, event);
    }

    public AlertDialog.Builder returnToLogin(Context context){
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("ĐĂNG XUẤT");
        builder.setMessage("Bạn có chắc muốn đăng xuất?");
        builder.setPositiveButton("Có", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                firebaseAuth.signOut();
                finish();
                startActivity(new Intent(TableDiagramActivity.this, LoginActivity.class));
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
