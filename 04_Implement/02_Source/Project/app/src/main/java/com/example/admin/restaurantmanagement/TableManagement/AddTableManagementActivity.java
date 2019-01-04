package com.example.admin.restaurantmanagement.TableManagement;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.example.admin.restaurantmanagement.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AddTableManagementActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText  edtTableName;
    private FirebaseAuth firebaseAuth;

    private DatabaseReference mDatabaseRef;
    public static final String FB_DATABASE_TABLE = "Table";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_table_management_activity);
        inItView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        mDatabaseRef = FirebaseDatabase.getInstance().getReference(FB_DATABASE_TABLE);

        toolbar.setTitle("Thêm bàn ăn");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_employ_management, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_save) {
            addTable();
        }

        return true;
    }



    private void addTable() {
        String name = edtTableName.getText().toString();

        if(name.isEmpty()){
            edtTableName.setError("Bạn cần nhập tên");
            edtTableName.requestFocus();
            return;
        }

                    TableManagementInfo tableManagementInfo = new TableManagementInfo(edtTableName.getText().toString());

                    //Save image info into firebase database
                    mDatabaseRef.child(edtTableName.getText().toString()).setValue(tableManagementInfo);

                    //Finish màn hình hiện tại và chuyển về màn hình quản lý món ăn
                    Intent intent = new Intent(AddTableManagementActivity.this, TableManagementActivity.class);
                    finish();
                    startActivity(intent);
                }


    private void inItView() {
        toolbar = (Toolbar) findViewById(R.id.nav_add_table_management);        edtTableName = findViewById(R.id.edt_name_table);

    }
}
