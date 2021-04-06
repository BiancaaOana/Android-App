package com.example.uidesignfinalsper.SeeMore;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

import com.example.uidesignfinalsper.Maps.MapsActivity1;
import com.example.uidesignfinalsper.R;
import com.example.uidesignfinalsper.MainActivities.SwipeLeftActivityHotels;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;

public class Hotels_SeeMore extends AppCompatActivity {

    private static final String TAG = "Hotels_SeeMore";

    private static final int ERROR_DIALOG_REQUEST = 9001;
    private static final String[] Countries = new String[]{
            "Alba Iulia", "Brasov", "Galati", "Cluj"
    };

    ViewFlipper viewFlipper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotels__see_more);

        Button btn = (Button)findViewById(R.id.button_back1);
//        Button btn_search = (Button)findViewById(R.id.button_search1) ;

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(Hotels_SeeMore.this, SwipeLeftActivityHotels.class));
            }
        });

//        btn_search.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(Hotels_SeeMore.this, MapsActivity1.class));
//            }
//        });


        int images[] = {R.drawable.hotel1, R.drawable.hotel2, R.drawable.hotel3,R.drawable.hotel4,R.drawable.hotel5};

        viewFlipper = findViewById(R.id.flipper1);

        int i;
        for(i=0; i<images.length; i++) {
            flipperImg(images[i]);
        }

        if(isServiceOK()){
            init();
        }
    }

    private boolean isServiceOK() {
        Log.d(TAG, "isServicesOK: checking google services version");

        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Hotels_SeeMore.this);

        if(available == ConnectionResult.SUCCESS){
            //everything is fine and the user can make map requests
            Log.d(TAG, "isServicesOK: Google Play Services is working");
            return true;
        }
        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
            //an error occured but we can resolve it
            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Hotels_SeeMore.this, available, ERROR_DIALOG_REQUEST);
            dialog.show();
        }else{
            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
        }
        return false;
    }


    public void flipperImg(int image){
        ImageView imageView = new ImageView(this);
        imageView.setBackgroundResource(image);

        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(4000);
        viewFlipper.setAutoStart(true);

        viewFlipper.setInAnimation(this, android.R.anim.slide_in_left);
        viewFlipper.setOutAnimation(this, android.R.anim.slide_out_right );

        AutoCompleteTextView editText = findViewById(R.id.autoCompleteTextView);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, Countries);
        editText.setAdapter(adapter);
    }




    private void init(){
        Button btnMap = (Button) findViewById(R.id.button_search1);
        btnMap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Hotels_SeeMore.this, MapsActivity1.class);
                startActivity(intent);
            }
        });
    }


//    public boolean isServicesOK(){
//        Log.d(TAG, "isServicesOK: checking google services version");
//
//        int available = GoogleApiAvailability.getInstance().isGooglePlayServicesAvailable(Hotels_SeeMore.this);
//
//        if(available == ConnectionResult.SUCCESS){
//            //everything is fine and the user can make map requests
//            Log.d(TAG, "isServicesOK: Google Play Services is working");
//            return true;
//        }
//        else if(GoogleApiAvailability.getInstance().isUserResolvableError(available)){
//            //an error occured but we can resolve it
//            Log.d(TAG, "isServicesOK: an error occured but we can fix it");
//            Dialog dialog = GoogleApiAvailability.getInstance().getErrorDialog(Hotels_SeeMore.this, available, ERROR_DIALOG_REQUEST);
//            dialog.show();
//        }else{
//            Toast.makeText(this, "You can't make map requests", Toast.LENGTH_SHORT).show();
//        }
//        return false;
//    }


}