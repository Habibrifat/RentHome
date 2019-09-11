package com.example.renthoom;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Information_menu extends AppCompatActivity {


    private Button saveDataButton,loadDataButton;
    private EditText addresstext,amounttext,phonenotext,descriptiontext;
    private Spinner spinnermonth,spinnerlocation;
    DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_information_menu);
        this.setTitle("Created Ads");

        databaseReference = FirebaseDatabase.getInstance().getReference("Ads");

        saveDataButton = findViewById(R.id.savebutttonId);
       // loadDataButton = findViewById(R.id.loadbutttonId);
        amounttext = findViewById(R.id.amountID);
        addresstext = findViewById(R.id.addressID);
        phonenotext = findViewById(R.id.phonenoID);
        descriptiontext = findViewById(R.id.dscriptionID);
        spinnermonth= findViewById(R.id.spinnermonthID);
        spinnerlocation= findViewById(R.id.spinnerlocationID);

       /* loadDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                     Intent intent = new Intent(Information_menu.this,Details.class);
                     startActivity(intent);
            }
        });*/

        saveDataButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });

    }


    public void saveData(){

        String amount = amounttext.getText().toString().trim();
        String address = addresstext.getText().toString().trim();
        String phoneno = phonenotext.getText().toString().trim();
        String description = descriptiontext.getText().toString().trim();
        String spinneritem = spinnermonth.getSelectedItem().toString();
        String spinnerloc = spinnerlocation.getSelectedItem().toString();



       // String key = databaseReference.push().getKey();

        Information information = new Information(address,amount,phoneno,description,spinneritem,spinnerloc,"true");

        databaseReference.child(phoneno).setValue(information);
        Toast.makeText(getApplicationContext(), " Information is added",Toast.LENGTH_LONG).show();

        amounttext.setText("");
        addresstext.setText("");
        phonenotext.setText("");
        descriptiontext.setText("");

    }



}
