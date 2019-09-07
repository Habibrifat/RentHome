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
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity implements View.OnClickListener {

    private EditText txtEmail, txtPasseord;
    private Button btn_login,btn_adds;
    private TextView txt_btn;
    private ProgressBar progressBar;
    private FirebaseAuth mAuth;
    public static String userEmail = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        this.setTitle("Login");

        mAuth = FirebaseAuth.getInstance();
        txtEmail = (EditText) findViewById(R.id.loginemailID);
        txtPasseord = (EditText) findViewById(R.id.loginpasswordID);
        txtPasseord = (EditText) findViewById(R.id.loginpasswordID);
        btn_login = (Button) findViewById(R.id.login_buttonID);
        btn_adds = (Button) findViewById(R.id.availableadds_buttonID);
        progressBar = findViewById(R.id.progressbarId);
        txt_btn = findViewById(R.id.btn_textID);

        btn_login.setOnClickListener(this);
        txt_btn.setOnClickListener(this);
        btn_adds.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_buttonID:
                userLogin();
                break;

            case R.id.btn_textID:
                Intent intent = new Intent(getApplicationContext(),Register.class);
                startActivity(intent);
                break;
            case R.id.availableadds_buttonID:
                Intent adds = new Intent(getApplicationContext(),Details.class);
                startActivity(adds);
                break;


        }

    }

    private void userLogin() {

        String email = txtEmail.getText().toString().trim();
        userEmail = txtEmail.getText().toString();
        String password = txtPasseord.getText().toString().trim();


        if (email.isEmpty()) {
            txtEmail.setError("Enter an email address");
            txtEmail.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {

            txtEmail.setError("Enter a valid email address");
            txtEmail.requestFocus();
            return;
        }

        if (password.isEmpty()) {
            txtPasseord.setError("Enter a password");
            txtPasseord.requestFocus();
            return;
        }
        if (password.length() < 6) {

            txtPasseord.setError("Minimum length of password show");
            txtPasseord.requestFocus();
            return;

        }

        progressBar.setVisibility(View.VISIBLE);

        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                progressBar.setVisibility(View.GONE);
                if(task.isSuccessful()){
                    Intent intent = new Intent(getApplicationContext(),Dashboard.class);
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    startActivity(intent);
                }else{
                    Toast.makeText(getApplicationContext(), " Login UnSuccessful", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }

}
