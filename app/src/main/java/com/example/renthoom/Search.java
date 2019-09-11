package com.example.renthoom;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class Search extends AppCompatActivity {


    Button search;
    RecyclerView recyclerView;
    Spinner location;

    FirebaseDatabase database;
    DatabaseReference databaseReference;
    ArrayList<CustomListView> list;
    MyAdapter adapter;
    String serLocation;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);
        this.setTitle("Search");

         location = findViewById(R.id.locationSearchID);



        search = findViewById(R.id.searchbuttonID);

        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                searchAd();
            }
        });
    }

   void searchAd(){

       recyclerView = findViewById(R.id.serAd);
       recyclerView.setLayoutManager(new LinearLayoutManager(this));
       list = new ArrayList<CustomListView>();

       serLocation = location.getSelectedItem().toString();
       Toast.makeText(this, serLocation, Toast.LENGTH_SHORT).show();


       database = FirebaseDatabase.getInstance();
       databaseReference = database.getReference("Ads");
       databaseReference.addValueEventListener(new ValueEventListener(){
           @Override
           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

               for (DataSnapshot parent : dataSnapshot.getChildren()) {

                   CustomListView p = parent.getValue(CustomListView.class);
                   boolean lc = false;
                   boolean bkc = false;
                   for (DataSnapshot checkLocation : parent.getChildren()){

                       if(checkLocation.toString().contains(serLocation)){
                           lc = true;
                           break;
                       }
                       else if(checkLocation.toString().contains("true")){
                           bkc = true;
                       }

                   }
                   if(lc && bkc){
                      list.add(p);
                   }
               }
               adapter = new MyAdapter(Search.this, list);
               recyclerView.setAdapter(adapter);

           }

           @Override
           public void onCancelled(@NonNull DatabaseError databaseError) {

           }
       });


   }
}
