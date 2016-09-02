package com.example.ohgi.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.Random;

public class GameActivity extends AppCompatActivity {
    Button btnPray;
    String[] omikuji = {"小吉", "中吉", "末吉", "大吉"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        btnPray = (Button) findViewById(R.id.btnPray);
        btnPray.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Random r = new Random();
                int n = r.nextInt(4);
                Toast.makeText(GameActivity.this, omikuji[n], Toast.LENGTH_SHORT).show();
            }
        });

    }
}
