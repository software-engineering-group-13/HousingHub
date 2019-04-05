package com2027.housinghub;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class FeedActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        //THIS ACTIVITY IS ONLY HERE TO BE A TEMPLATE FOR THE ACTUAL FEED PAGE WHICH
        //IS BEING MADE BY BENITA.

        //GIVEN THE LOGIN ACTIVITY WILL NOT BE CONNECTED TO THE PROFILE PAGES IT MAKES
        //SENSE TO HAVE A MIDDLE MAN - i guess

        Button button = (Button) findViewById(R.id.buttontemp);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent buttontemp = new Intent(FeedActivity.this, StudentProfileActivity.class);
                startActivity(buttontemp);
            }
        });

        Button button1 = (Button) findViewById(R.id.buttontemp1);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    Intent buttontemp = new Intent(FeedActivity.this, LandlordProfileActivity.class);
                    startActivity(buttontemp);
            }
        });

    }
}
