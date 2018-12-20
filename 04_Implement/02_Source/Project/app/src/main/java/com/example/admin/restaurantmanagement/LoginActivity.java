package com.example.admin.restaurantmanagement;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.restaurantmanagement.FoodManagement.AddFoodManagementActivity;
import com.example.admin.restaurantmanagement.FoodManagement.FoodManagementActivity;
import com.example.admin.restaurantmanagement.Management.ManagementActivity;
import com.example.admin.restaurantmanagement.TableDiagram.TableDiagramActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (user == null || pass == null) {
                    Toast.makeText(LoginActivity.this, "Tài khoản và mật khẩu không được rỗng", Toast.LENGTH_SHORT).show();
                }
                else if (!user.equals(pass)) {
                    Toast.makeText(LoginActivity.this, "Tài khoản và mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                }
//                else if(pass.length()<6){
//                    Toast.makeText(LoginActivity.this, "Mật khẩu không được ngắn hơn 6 ký tự", Toast.LENGTH_SHORT).show();
//                }
                else if (user.equals("1")&& pass.equals("1")) {
                    Intent intent = new Intent(LoginActivity.this, ManagementActivity.class);
                    startActivity(intent);
                } else if (user.equals("0")&& pass.equals("0")) {
                    Intent intent = new Intent(LoginActivity.this, TableDiagramActivity.class);
                    startActivity(intent);
                }
            }

        });

    }
}
