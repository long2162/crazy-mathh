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

public class register extends AppCompatActivity{

    SQLiteDatabase db;
    EditText name, email, pass,repass;
    Button btnregi,btnback;
    Cursor checkuser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        name = (EditText) findViewById(R.id.et_Name);
        email = (EditText) findViewById(R.id.et_Email);

        pass =(EditText) findViewById(R.id.et_Pass);
        repass =(EditText) findViewById(R.id.et_ComPass);

        btnregi=(Button)findViewById(R.id.btn_register);
        btnback=(Button)findViewById(R.id.tv_al_register);

        btnregi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username =name.getText().toString();
                String emails = email.getText().toString();
                String pas = pass.getText().toString();
                String repas=repass.getText().toString();
                if (username.equals("")||pas.equals("")||repas.equals("")){
                    Toast.makeText(register.this,"Điền đủ thông tin",Toast.LENGTH_SHORT).show();
                }else {
                    if (pas.equals(repas)){
                        db=openOrCreateDatabase("Crazymath.sqlite",MODE_PRIVATE,null);
                        checkuser =db.rawQuery("Select * from users Where username= ?",new String[]{username});
                        if(checkuser.getCount()>0){
                            Toast.makeText(register.this,"Tài khoản đã tồn tại",Toast.LENGTH_SHORT).show();
                        }else {
                            db = openOrCreateDatabase("Crazymath.sqlite", MODE_PRIVATE, null);
                            String sql = "Insert into users(username,email,password) values ('" + username + "','" + emails + "','"+ pas +"');";
                            db.execSQL(sql);
                            db.close();
                            Toast.makeText(register.this, "Đăng ký thành công", Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), Login.class);
                            startActivity(intent);
                        }
                    }else {
                        Toast.makeText(register.this,"Mật khẩu không khớp",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(getApplicationContext(),Login.class);
                startActivity(intent);
            }
        });
    }
}

