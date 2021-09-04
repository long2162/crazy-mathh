package com.example.crazymath;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.example.freakingmath.R;

public class MucChoiToF extends Activity {
    private Button back, easy, normal,difficult;
    private int mucchoi;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_muc_choi);
        anhxa();
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MucChoiToF.this, Typeofplay.class);
                startActivity(intent);
            }
        });
        easy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MucChoiToF.this, trueorfalse.class);
                intent.putExtra("mucchoi",10);
                startActivity(intent);
            }
        });
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MucChoiToF.this, trueorfalse.class);
                intent.putExtra("mucchoi",100);
                startActivity(intent);
            }
        });
        difficult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MucChoiToF.this, trueorfalse.class);
                intent.putExtra("mucchoi",1000);
                startActivity(intent);
            }
        });
    }
    private void anhxa()
    {
        back=(Button)findViewById(R.id.back);
        easy=(Button)findViewById(R.id.easy);
        normal=(Button)findViewById(R.id.normal);
        difficult=(Button)findViewById(R.id.difficult);
    }
}
