package com.example.admin.restaurantmanagement.Login;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.BlurBuilder;
import com.example.admin.restaurantmanagement.Management.ManagementActivity;
import com.example.admin.restaurantmanagement.R;
import com.example.admin.restaurantmanagement.TableDiagram.TableDiagramActivity;

public class LoginActivity extends AppCompatActivity {
    EditText edtUser, edtPass;
    Button btnLogin;
    ConstraintLayout constraintLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.login_activity);

        constraintLayout = (ConstraintLayout) findViewById(R.id.login_container);
        edtUser = findViewById(R.id.edtUser);
        edtPass = findViewById(R.id.edtPass);
        btnLogin = findViewById(R.id.btnLogin);

        Bitmap originalBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.bg_restaurant);
        Bitmap blurredBitmap = BlurBuilder.blur( this, originalBitmap );
        constraintLayout.setBackground(new BitmapDrawable(getResources(), blurredBitmap));

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();
                if (user == null || pass == null) {
                    Toast.makeText(LoginActivity.this, "Tài khoản và mật khẩu không được rỗng", Toast.LENGTH_SHORT).show();
                } else if (!user.equals(pass)) {
                    Toast.makeText(LoginActivity.this, "Tài khoản và mật khẩu không trùng khớp", Toast.LENGTH_SHORT).show();
                }
//                else if(pass.length()<6){
//                    Toast.makeText(LoginActivity.this, "Mật khẩu không được ngắn hơn 6 ký tự", Toast.LENGTH_SHORT).show();
//                }
                else if (user.equals("1") && pass.equals("1")) {
                    Intent intent = new Intent(LoginActivity.this, ManagementActivity.class);
                    startActivity(intent);
                } else if (user.equals("0") && pass.equals("0")) {
                    Intent intent = new Intent(LoginActivity.this, TableDiagramActivity.class);
                    startActivity(intent);
                }
            }

        });


    }


}
