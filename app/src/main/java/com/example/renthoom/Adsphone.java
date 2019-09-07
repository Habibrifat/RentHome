package com.example.renthoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Adsphone extends AppCompatActivity {

    EditText phn;
    Button editN;
    public static String serPhn = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adsphone);
        this.setTitle("Edit Adds");

        phn = findViewById(R.id.adsPhn);

       editN = findViewById(R.id.goEdit);
       editN.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               startActivity(new Intent(Adsphone.this,EditAds.class));
               serPhn = phn.getText().toString();
           }
       });



    }
}
