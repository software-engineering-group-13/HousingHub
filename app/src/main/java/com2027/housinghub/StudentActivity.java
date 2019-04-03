package com2027.housinghub;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class StudentActivity extends AppCompatActivity {

    public static final String DIALOG_STUDENT = "";
    protected Integer REQUEST_CAMERA = 1;
    protected Integer SELECT_FILE = 0;
    protected ImageView camera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student);

        //Sets background imageview to the background image within the drawable folder
        ImageView background = findViewById(R.id.imBackground);
        background.setImageResource(R.drawable.background);

        //On press the camera imageview will execute the code contained within the onClick function.
        camera =  findViewById(R.id.imStudentActivityCamera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens camera and allows the user to take photos.
                final CharSequence[] selection = {"Camera", "Gallery"};

                AlertDialog.Builder builder = new AlertDialog.Builder(StudentActivity.this);
                builder.setTitle("Select option:")
                        .setItems(selection, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                if(selection[which].equals("Camera")) {
                                    Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                                    startActivityForResult(intent, REQUEST_CAMERA);
                                } else if (selection[which].equals("Gallery")) {
                                    Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                                    intent.setType("image/*");
                                    startActivityForResult(intent.createChooser(intent, "Select File"), SELECT_FILE);
                                }
                            }
                        });
                builder.setPositiveButton("CLOSE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Closes the dialog
                    }
                });
                builder.create().show();
            }
        });

        //On press the verify button will execute the code contained within the onClick function.
        Button verify =  findViewById(R.id.btVerifyYourAccountStudent);
        verify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creates an intent and starts a new activity, returns a boolean value to inform
                //the login activity to display the dialog box associated with this activity.
                Intent verifyact = new Intent(StudentActivity.this, LoginActivity.class);
                verifyact.putExtra(DIALOG_STUDENT, true);
                startActivity(verifyact);
            }
        });

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == Activity.RESULT_OK) {
            if (requestCode == REQUEST_CAMERA) {
                Bundle bundle = data.getExtras();
                final Bitmap bmp = (Bitmap) bundle.get("data");
                camera.setImageBitmap(bmp);
            } else if (requestCode == SELECT_FILE) {
                Uri selectImage = data.getData();
                camera.setImageURI(selectImage);
            }
        }
    }

}
