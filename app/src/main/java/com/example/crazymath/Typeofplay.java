package com.example.crazymath;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.app.*;
import android.view.*;
import android.widget.Button;
import android.widget.Toast;

import com.example.freakingmath.R;

public class Typeofplay extends Activity {
    private Button back, onePlay, highscore, trueorfalse;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_typeofplay);
        anhxa();

        trueorfalse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Typeofplay.this, MucChoiToF.class);
                startActivity(intent);
            }
        });
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Typeofplay.this, MainActivity.class);
                startActivity(intent);
            }
        });
        highscore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(Typeofplay.this, HighScore.class) );
            }
        });
        onePlay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Typeofplay.this, onePlayer.class));
            }
        });
    }
    public void anhxa()
    {
        onePlay=(Button)findViewById(R.id.onePlay);
        back=(Button)findViewById(R.id.back);
        highscore =(Button)findViewById(R.id.highscore);
        trueorfalse=(Button)findViewById(R.id.trueorfalse);
    }
}
