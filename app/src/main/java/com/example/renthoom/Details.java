package com.example.renthoom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Details extends AppCompatActivity {

    private ListView listView;
    DatabaseReference databaseReference;
    private List<Information> informationList;
    private CustomAdapter customAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        this.setTitle("Show All Ads");

        databaseReference = FirebaseDatabase.getInstance().getReference("Ads");

        informationList = new ArrayList<>();
        customAdapter = new CustomAdapter(Details.this,informationList);


        listView = findViewById(R.id.listViewID);

        //PhoneCall();

    }
    

    @Override
    protected void onStart() {

        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                informationList.clear();
                boolean check = true;
                for(DataSnapshot dataSnapshot1 : dataSnapshot.getChildren() )

                {for (DataSnapshot dataSnapshot2 : dataSnapshot1.getChildren()){
                    if(dataSnapshot2.getKey().equals("bookingCheck")){

                        if( "false".equals(dataSnapshot2.getValue()))
                            check = false;
                        else
                            check = true;

                    }
                }
                    if(check) {
                        check = true;
                        Information information = dataSnapshot1.getValue(Information.class);
                        informationList.add(information);
                    }
                }
                listView.setAdapter(customAdapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        super.onStart();
    }


  /* public void PhoneCall(){

        Button phonecall = findViewById(R.id.phoneCallButton);
        phonecall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent callIntent = new Intent(Intent.ACTION_CALL);
                TextView phoneno = findViewById(R.id.phonenoID1);
                callIntent.setData(Uri.parse("tel: "+phoneno.getText().toString()));

                if(ActivityCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CALL_PHONE)
                        != PackageManager.PERMISSION_GRANTED){
                    Toast.makeText(Details.this," Please Grant Permission To Call",Toast.LENGTH_SHORT);

                }
                else{
                    startActivity(callIntent);
                }
            }
        });

    }*/





}




