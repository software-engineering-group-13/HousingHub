package com2027.housinghub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class VerifyActivity extends AppCompatActivity {

    public static final String DIALOG_LANDLORD = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_verify);

        //Sets background imageview to the background image within the drawable folder
        ImageView background = findViewById(R.id.imVerifyBackground);
        background.setImageResource(R.drawable.background);

        //On press the camera imageview will execute the code contained within the onClick function.
        ImageView camera = findViewById(R.id.imVerifyCamera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens camera and allows the user to take photos.

            }
        });

        //On press the verify button will execute the code contained within the onClick function.
        Button completeVerify = (Button) findViewById(R.id.btCompleteVerification);
        completeVerify .setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates an intent and starts a new activity, returns a boolean value to inform
                //the login activity to display the dialog box associated with this activity.
                Intent verifyact = new Intent(VerifyActivity.this, LoginActivity.class);
                verifyact.putExtra(DIALOG_LANDLORD, true);
                startActivity(verifyact);
            }
        });

    }
}
