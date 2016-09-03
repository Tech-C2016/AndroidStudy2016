package com.example.yuya.janken;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends Activity implements OnClickListener {
    ImageButton gu, ch, pa;
    int hands[] = new int[3];
    ImageView user, com;
    TextView result;
    TextView match, win, lose, draw;
    int matchC, winC, loseC, drawC;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hands[0] = R.drawable.gu;
        hands[1] = R.drawable.ch;
        hands[2] = R.drawable.pa;
        user = (ImageView) findViewById(R.id.user);
        com = (ImageView) findViewById(R.id.com);
        gu = (ImageButton) findViewById(R.id.gu);
        ch = (ImageButton) findViewById(R.id.ch);
        pa = (ImageButton) findViewById(R.id.pa);
        result = (TextView) findViewById(R.id.result);
        match = (TextView) findViewById(R.id.match);
        win = (TextView) findViewById(R.id.win);
        lose = (TextView) findViewById(R.id.lose);
        draw = (TextView) findViewById(R.id.drow);
        gu.setOnClickListener(this);
        ch.setOnClickListener(this);
        pa.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Random random = new Random();
        int n = random.nextInt(3);
        int hand = 0;
        if (v == gu) {
            hand = 0;
        } else if (v == ch) {
            hand = 1;
        } else if (v == pa) {
            hand = 2;
        }
        user.setImageResource(hands[hand]);
        com.setImageResource(hands[n]);
        int syouhai = (hand - n) + 3;

        if (syouhai % 3 == 0) {
            result.setText("あいこ");
            matchC += 1;
            match.setText(matchC + "");
            drawC += 1;
            draw.setText(drawC + "");
        } else if (syouhai % 3 == 1) {
            result.setText("負け");
            matchC += 1;
            match.setText(matchC + "");
            loseC += 1;
            lose.setText(loseC + "");
        } else if (syouhai % 3 == 2) {
            result.setText("勝ち");
            matchC += 1;
            match.setText(matchC + "");
            winC += 1;
            win.setText(winC + "");
        }
    }
}