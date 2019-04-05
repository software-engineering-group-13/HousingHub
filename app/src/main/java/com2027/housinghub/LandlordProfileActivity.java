package com2027.housinghub;

import android.net.Uri;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class LandlordProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord_profile);

        //Sets background imageview to the background image within the drawable folder
        ImageView background = (ImageView) findViewById(R.id.imageBackground1);
        background.setImageResource(R.drawable.background);

        ImageView edit = (ImageView) findViewById(R.id.imageButton1);
        edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //setContentView(R.layout.xd);
                //set to edit activity fragment
            }
        });

    }

}
