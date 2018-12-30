package com.example.admin.restaurantmanagement.EmployManagement;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.admin.restaurantmanagement.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class AddEmployManagementActivity extends AppCompatActivity {
    private Toolbar toolbar;
    private EditText edtEmail, edtPass, edtPhone, edtName;
    private Button btnSelectImage;
    private ImageView imgEmploy;
    private static final int REQUEST_CHOOSE_IMAGE = 1234;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.add_employ_management_activity);
        inItView();
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar());
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        toolbar.setTitle("Thêm nhân viên");
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(firebaseAuth.getCurrentUser()!=null){

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_employ_management,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id==R.id.action_save_employ){
            addEmploy();
        }

        return super.onOptionsItemSelected(item);
    }

    private void addEmploy() {

    }

    private void inItView() {
        toolbar = (Toolbar) findViewById(R.id.nav_add_employ_management);
        edtEmail = findViewById(R.id.edt_email_employ);
        edtPass = findViewById(R.id.edt_pass_employ);
        edtPhone = findViewById(R.id.edt_phone_employ);
        edtName = findViewById(R.id.edt_name_employ);
    }
}
