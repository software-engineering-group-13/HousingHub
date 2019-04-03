package com2027.housinghub;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //Retrieves data from other activities which return to this activity when a pressable
        //item is activated. In most cases a button.
        Intent intent = getIntent();
        if (intent.getBooleanExtra(StudentActivity.DIALOG_STUDENT, false) || intent.getBooleanExtra(VerifyActivity.DIALOG_LANDLORD, false)) {
            openDialog(0);
        }

        //Sets the background to the image by finding the imageView through its id, the image chosen
        //is in the drawable folder name background
        ImageView background = findViewById(R.id.imLoginBackground);
        background.setImageResource(R.drawable.background);

        //On press the login button will execute the code contained within the onClick function.
        Button login =  findViewById(R.id.btLogin);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        EditText username = findViewById(R.id.etLoginUsername);
        EditText password = findViewById(R.id.etLoginPassword);

        //On press the account textview will execute the code contained within the onClick function.
        TextView NoAccount = findViewById(R.id.tvNoAccount);
        NoAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates an intent and starts a new activity
                Intent accountAct = new Intent(LoginActivity.this, AccountActivity.class);
                startActivity(accountAct);
            }
        });

    }

    /**
     * Function creates a dialog box, the contents of the box is determined by the inputted
     * parameter
     * @param type
     *          an integer which determins the contents of the dialog box
     */
    protected void openDialog(int type) {
        //Dialog box will be displayed on this activity
        AlertDialog.Builder builder = new AlertDialog.Builder(LoginActivity.this);
        if (type == 0) {
            //Sets the title, message and button of the dialog box
            builder.setTitle("Verification Email Sent!")
                    .setMessage("Please check your email to verify your account.")
                    .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Closes the dialog
                        }
                    });
        } else if (type == 1) {
            //Sets the title, message and button of the dialog box
            builder.setTitle("Recovery Email Sent!")
                    .setMessage("Please check your email to recover your account.")
                    .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Closes the dialog
                        }
                    });
        } else {
            //Sets the title, message and button of the dialog box
            builder.setTitle("An error occurred!")
                    .setMessage("Something happend, our top engineers will fix it soon. Thank you for your patience")
                    .setPositiveButton("CONFIRM", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            //Closes the dialog
                        }
                    });
        }
        //Shows the dialog box
        builder.create().show();
    }

}
