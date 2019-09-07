package com.example.renthoom;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthWeakPasswordException;

public class Register extends AppCompatActivity  {


    private EditText registeremail,registerpassword,registerconfirm;
    private Button btn_register ,btn_informaion;
    private FirebaseAuth mAuth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setTitle("Register");


        mAuth = FirebaseAuth.getInstance();

        progressBar = findViewById(R.id.progressbarId);
        //registername = findViewById(R.id.registernameId);
        registeremail = findViewById(R.id.registeremaild);
        registerpassword = findViewById(R.id.registerpasswordId);
        registerconfirm = findViewById(R.id.confirmpasswordId);
        btn_register = findViewById(R.id.buttonregisterId);
       // btn_informaion = findViewById(R.id.informationId);

        btn_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String email = registeremail.getText().toString().trim();
                String password = registerpassword.getText().toString().trim();
                String confirmpassword = registerconfirm.getText().toString().trim();


                if(email.isEmpty()){
                    registeremail.setError("Enter an email address");
                    registeremail.requestFocus();
                    return;
                }
                if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){

                    registeremail.setError("Enter a valid email address");
                    registeremail.requestFocus();
                    return;
                }

                if(password.isEmpty()){
                    registerpassword.setError("Enter a password");
                    registerpassword.requestFocus();
                    return;
                }
                if(password.length()<6){
                    registerpassword.setError("Minimum length of password show");
                    registerpassword.requestFocus();
                    return;
                }
                if(confirmpassword.isEmpty()){
                    registerconfirm.setError("Enter a password");
                    registerconfirm.requestFocus();
                    return;
                }
                if(confirmpassword.length()<6){
                    registerconfirm.setError("Minimum length of password show");
                    registerconfirm.requestFocus();
                    return;
                }

                progressBar.setVisibility(View.VISIBLE);


                if(password.equals(confirmpassword)){


                    mAuth.createUserWithEmailAndPassword(email, password)
                            .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {

                                        progressBar.setVisibility(View.GONE);

                                        Toast.makeText(getApplicationContext(), "Register is successful", Toast.LENGTH_SHORT).show();
                                        startActivity(new Intent(getApplicationContext(),Login.class));

                                    } else {


                                        if(task.getException() instanceof FirebaseAuthWeakPasswordException) {

                                            Toast.makeText(getApplicationContext(), " User is already Registered", Toast.LENGTH_SHORT).show();

                                        }else{

                                            Toast.makeText(getApplicationContext(), " Error"+task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                        }

                                    }


                                }
                            });


                }else{
                    Toast.makeText(getApplicationContext(), " Confirm password is not matched", Toast.LENGTH_SHORT).show();

                }


            }
        });

        /*btn_informaion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this , Dashboard.class);
                startActivity(intent);
            }
        });*/


    }

}
