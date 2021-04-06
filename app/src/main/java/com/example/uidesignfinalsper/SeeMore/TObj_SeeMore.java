package com.example.uidesignfinalsper.SeeMore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ViewFlipper;

import com.example.uidesignfinalsper.Maps.MapsActivity3;
import com.example.uidesignfinalsper.R;
import com.example.uidesignfinalsper.MainActivities.SwipeLeftActivityPlaces;

public class TObj_SeeMore extends AppCompatActivity {

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_t_obj__see_more);

        Button btn = (Button)findViewById(R.id.button_back3);

        Button btn_search = (Button)findViewById(R.id.button_search3);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TObj_SeeMore.this, SwipeLeftActivityPlaces.class));
            }
        });

        btn_search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(TObj_SeeMore.this, MapsActivity3.class));
            }
        });

        int images[] = {R.drawable.tur1, R.drawable.tur2, R.drawable.tur3,R.drawable.tur4,R.drawable.tur5};

        viewFlipper = findViewById(R.id.flipper3);

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
