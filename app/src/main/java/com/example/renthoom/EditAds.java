package com.example.renthoom;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.SwitchCompat;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class EditAds extends AppCompatActivity {


    DatabaseReference databaseReference;
    private EditText addresstext,amounttext,phonenotext,descriptiontext;
    private Spinner spinnermonth,spinnerlocation;
    SwitchCompat aSwitch;
    String checkAds;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_ads);
        this.setTitle("Edit Adds");

        amounttext = findViewById(R.id.amountID1);
        addresstext = findViewById(R.id.addressID1);
        phonenotext = findViewById(R.id.phonenoID1);
        descriptiontext = findViewById(R.id.dscriptionID1);
        spinnermonth= findViewById(R.id.spinnermonthID1);
        spinnerlocation= findViewById(R.id.spinnerlocationID1);
        aSwitch =  findViewById(R.id.switch1);

        databaseReference = FirebaseDatabase.getInstance().getReference("Ads");
        aSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b) {
                    databaseReference.child(Adsphone.serPhn).child("bookingCheck").setValue("true");
                    checkAds = "true";
                }else{
                    databaseReference.child(Adsphone.serPhn).child("bookingCheck").setValue("false");
                    checkAds = "false";
                }
            }
        });
        databaseReference.child(Adsphone.serPhn).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for (DataSnapshot data : dataSnapshot.getChildren()){
                    if("address".equals(data.getKey())){
                        addresstext.setText(data.getValue().toString());
                    }
                    else if("amount".equals(data.getKey())){
                        amounttext.setText(data.getValue().toString());
                    }
                    else if("description".equals(data.getKey())){
                        descriptiontext.setText(data.getValue().toString());
                    }
                    else if("phoneno".equals(data.getKey()))
                    {
                        phonenotext.setText(data.getValue().toString());

                    }else if("bookingCheck".equals(data.getKey())){
                        if("true".equals(data.getValue())){
                            aSwitch.setChecked(true);
                            aSwitch.setText("Ads(Enable)");
                        }else{
                            aSwitch.setChecked(false);
                            aSwitch.setText("Ads(Disable)");
                        }
                    }

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        Button save = findViewById(R.id.savebutttonId1);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String address = addresstext.getText().toString();
                String amount = amounttext.getText().toString();
                String phoneno = phonenotext.getText().toString();
                String description = descriptiontext.getText().toString();
                String spinneritem = spinnermonth.getSelectedItem().toString();
                String spinnerloc = spinnerlocation.getSelectedItem().toString();

                Information information = new Information(address,amount,phoneno,description,spinneritem,spinnerloc,checkAds);/*address,amount*/

                databaseReference.child(phoneno).setValue(information);
                Toast.makeText(getApplicationContext(), " Information is added",Toast.LENGTH_LONG).show();

            }
        });




    }





}
