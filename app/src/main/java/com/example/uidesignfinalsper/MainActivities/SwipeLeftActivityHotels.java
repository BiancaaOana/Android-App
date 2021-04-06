package com.example.uidesignfinalsper.MainActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.uidesignfinalsper.R;
import com.example.uidesignfinalsper.SeeMore.Hotels_SeeMore;

public class SwipeLeftActivityHotels extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_left);

        Button btn = (Button)findViewById(R.id.button1);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwipeLeftActivityHotels.this, Hotels_SeeMore.class));
            }
        });
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
                    Intent i = new Intent(SwipeLeftActivityHotels.this, SwipeLeftActivityRestaurants.class);
                    startActivity(i);
                }else if(x1 < x2){
                Intent i = new Intent(SwipeLeftActivityHotels.this, MainActivity.class);
                startActivity(i);
            }
                break;
        }
        return false;
    }



}