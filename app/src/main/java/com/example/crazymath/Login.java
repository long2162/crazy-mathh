package com.example.crazymath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.freakingmath.R;

public class Login extends AppCompatActivity {
    SQLiteDatabase db;
    EditText username,password;
    Button btnlogin,btnregister;
    Cursor check;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login2);
        username =(EditText) findViewById(R.id.et_Name);
        password = (EditText)findViewById(R.id.et_Pass);
        btnlogin = (Button)findViewById(R.id.btn_login);
        btnregister=(Button)findViewById(R.id.tv_link_reg);

        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String name= username.getText().toString();
                String pass =password.getText().toString();
                if (name.equals("") || pass.equals("")){
                    Toast.makeText(Login.this,"Điền đủ thông tin",Toast.LENGTH_SHORT).show();
                }else {
                    db=openOrCreateDatabase("Crazymath.sqlite",MODE_PRIVATE,null);
                    check =db.rawQuery("Select * from users Where username= ? and password = ?",new String[]{name,pass});
                    if (check.getCount()>0){
                        Toast.makeText(Login.this,"Đăng nhâp thành công",Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(),Typeofplay.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(Login.this,"Tài khoản hoặc mật khẩu không chính xác",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        btnregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),register.class);
                startActivity(intent);
            }
        });

    }
}