package com.example.crazymath;


import android.content.Intent;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.Button;

import com.example.freakingmath.R;

public class MainActivity extends Activity {
    private Button btntacgia, choingay;

    private Database database;
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        anhxa();
        database.Create(this);


        btntacgia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Tacgia();
            }
        });
        choingay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this, Login.class);
                startActivity(intent);
            }
        });
    }
    public void Tacgia()
    {
        Dialog dialog= new Dialog(this);
        dialog.setContentView(R.layout.dialog_tacgia);
        dialog.show();
    }
    public void anhxa()
    {
        database =  new Database(this,"",null,1);
        btntacgia=(Button)findViewById(R.id.tacgia);
        choingay=(Button)findViewById(R.id.choingay);
    }
}
