package com.lab8.touchlab;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity implements View.OnTouchListener {
    private float xCur, yCur, xD, yD, xU, yU;
    private TextView tw;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tw = (TextView) findViewById(R.id.textView);

        tw.setOnTouchListener(this);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        xCur = event.getX();
        yCur = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                xD = xCur;
                yD = yCur;
                break;
            case MotionEvent.ACTION_MOVE:
                break;
            case MotionEvent.ACTION_UP:
                xU = xCur;
                yU = yCur;
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }

        tw.setText(String.format("Down: %.1f %.1f\nMove: %.1f %.1f\nUp: %.1f %.1f", xD, yD, xCur, yCur, xU, yU));

        return true;
    }
}
