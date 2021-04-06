package com.example.uidesignfinalsper.SeeMore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.uidesignfinalsper.Maps.MapsActivity2;
import com.example.uidesignfinalsper.R;
import com.example.uidesignfinalsper.MainActivities.SwipeLeftActivityRestaurants;

public class Restaurants_SeeMore extends AppCompatActivity {

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants__see_more);

        Button btn = (Button)findViewById(R.id.button_back2);
        Button btn_search = (Button)findViewById(R.id.button_search2);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Restaurants_SeeMore.this, SwipeLeftActivityRestaurants.class));
            }
        });
        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Restaurants_SeeMore.this, MapsActivity2.class));
            }
        });

        int images[] = {R.drawable.rest1, R.drawable.rest2, R.drawable.rest3,R.drawable.rest4,R.drawable.rest5};

        viewFlipper = findViewById(R.id.flipper2);

        int i;
        for(i=0; i<images.length; i++) {
            flipperImg(images[i]);
        }
    }

    public void flipperImg(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right );

    }
    }
