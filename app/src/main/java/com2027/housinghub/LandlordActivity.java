package com2027.housinghub;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class LandlordActivity extends AppCompatActivity {

    private Button buttonRegister;
    private EditText editTextEmail;
    private EditText editTextPassword;

    private ProgressDialog progressDialog;

    private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landlord);

        firebaseAuth = FirebaseAuth.getInstance();

        progressDialog = new ProgressDialog(this);

        buttonRegister = (Button) findViewById(R.id.btLandlordVerifyAccount);

        editTextEmail = (EditText) findViewById(R.id.etEmailAddress);
        editTextPassword = (EditText) findViewById(R.id.etPassword);


        //Sets background imageview to the background image within the drawable folder
//        ImageView background = findViewById(R.id.imBackground);
//        background.setImageResource(R.drawable.background);

        //On press the camera image view will execute the code contained within the onClick function.
        ImageView camera = findViewById(R.id.imLandlordPictureCamera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Opens camera and allows the user to take photos.

            }
        });


        // When the Register Button is selected
        buttonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = editTextEmail.getText().toString().trim();
                String password = editTextPassword.getText().toString().trim();

                if(TextUtils.isEmpty(email)) {
                    //email is empty
                    editTextEmail.setError("Please Enter your email");
                    editTextEmail.requestFocus();
                    return;
                }
                if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    editTextEmail.setError("Please Enter a valid email");
                    editTextEmail.requestFocus();
                    return;
                }
                if(password.length() <6) {
                    editTextPassword.setError("Minimum length of password is 6");
                    editTextPassword.requestFocus();
                    return;
                }
                if (TextUtils.isEmpty(password)) {
                    //password is empty
                    editTextPassword.setError("Please Enter Your Password");
                    editTextPassword.requestFocus();
                    return;
                }
                // if validations are ok

                progressDialog.setMessage("Registering User...");
                progressDialog.show();

                firebaseAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(LandlordActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                progressDialog.hide();
                                if (task.isSuccessful()) {
                                    // user is successfully registered
                                    Toast.makeText(LandlordActivity.this, "Registered", Toast.LENGTH_SHORT).show();
                                } else {
                                    // failed to register
                                    if(task.getException() instanceof FirebaseAuthUserCollisionException) {
                                        Toast.makeText(LandlordActivity.this, "This email already exists", Toast.LENGTH_SHORT).show();
                                    } else {
                                        Toast.makeText(LandlordActivity.this, task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                            }
                        });

            }
        });



    }


}
