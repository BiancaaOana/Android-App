package com.example.uidesignfinalsper.MainActivities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.uidesignfinalsper.R;
import com.example.uidesignfinalsper.SeeMore.Restaurants_SeeMore;

public class SwipeLeftActivityRestaurants extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_left_restaurants);

        Button btn = (Button)findViewById(R.id.button2);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SwipeLeftActivityRestaurants.this, Restaurants_SeeMore.class));
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
                    Intent i = new Intent(SwipeLeftActivityRestaurants.this, SwipeLeftActivityPlaces.class);
                    startActivity(i);
                } else if(x1 < x2){
                    Intent i = new Intent(SwipeLeftActivityRestaurants.this, SwipeLeftActivityHotels.class);
                    startActivity(i);
                }
                break;
        }
        return false;
    }
}