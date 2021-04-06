package com.example.uidesignfinalsper.MainActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.uidesignfinalsper.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    float x1,x2,y1,y2;

    public boolean onTouchEvent(MotionEvent touchEvent){
        switch(touchEvent.getAction()){
            case MotionEvent.ACTION_DOWN:
                 x1 = touchEvent.getX();
                 y1 = touchEvent.getY();
                break;
            case MotionEvent.ACTION_UP:
                 x2 = touchEvent.getX();
                 y2 = touchEvent.getY();
                if(x1 > x2){
                Intent i = new Intent(MainActivity.this, SwipeLeftActivityHotels.class);
                startActivity(i);
            }
            break;
        }
        return false;
    }
}