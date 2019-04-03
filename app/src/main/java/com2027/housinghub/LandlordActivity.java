package com2027.housinghub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class LandlordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord);


        //Sets background imageview to the background image within the drawable folder
        ImageView background = findViewById(R.id.imBackground);
        background.setImageResource(R.drawable.background);

        //On press the camera imageview will execute the code contained within the onClick function.
        ImageView camera = findViewById(R.id.imLandlordPictureCamera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens camera and allows the user to take photos.

            }
        });

        //On press the verify button will execute the code contained within the onClick function.
        Button verify = findViewById(R.id.btLandlordVerifyAccount);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates an intent and starts a new activity
                Intent verifyact = new Intent(LandlordActivity.this, VerifyActivity.class);
                startActivity(verifyact);
            }
        });

    }
}
