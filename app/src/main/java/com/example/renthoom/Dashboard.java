package com.example.renthoom;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class Dashboard extends AppCompatActivity  {

      private Button btn_createdId,btn_showall;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        this.setTitle("DashBoard");

        btn_createdId = (Button) findViewById(R.id.buttoncreatedAdds);
        btn_showall =(Button) findViewById(R.id.buttonshowallId);


        btn_createdId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Dashboard.this,"Created you adds",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard.this , Information_menu.class);
                startActivity(intent);

            }
        });

        btn_showall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(Dashboard.this,"show all adds",Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Dashboard.this , Details.class);
                startActivity(intent);

            }
        });
        Button editAds = findViewById(R.id.editAds);
        editAds.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Adsphone.class));
            }
        });

        Button search = findViewById(R.id.search);
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Dashboard.this,Search.class));
            }
        });

    }


}

