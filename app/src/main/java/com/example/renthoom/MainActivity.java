package com.example.renthoom;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        if(!isConnected(MainActivity.this)) buildDialog(MainActivity.this).show();
        else {
           Toast.makeText(MainActivity.this,"Welcome", Toast.LENGTH_SHORT).show();
            setContentView(R.layout.activity_main);
            new java.util.Timer().schedule(
                    new java.util.TimerTask() {
                        @Override
                        public void run() {
                            startActivity(new Intent(MainActivity.this,Login.class));
                            finish();
                        }
                    }, 3000
            );
        }

    }

    //Check Net Connection
    public boolean isConnected(Context context){
        ConnectivityManager connectivityManager =(ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if(networkInfo !=null && networkInfo.isConnected()){
            android.net.NetworkInfo wifi = connectivityManager.getNetworkInfo(connectivityManager.TYPE_WIFI);
            android.net.NetworkInfo mobile = connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE);

            if((mobile != null && mobile.isConnectedOrConnecting()) || (wifi != null && wifi.isConnectedOrConnecting()))
                return true;
            else
                return false;
        }else
            return false;
    }

    //Show MessageDialog
    public AlertDialog.Builder buildDialog(Context c) {
        AlertDialog.Builder builder = new AlertDialog.Builder(c);
        builder.setTitle("No Internet Connection");
        builder.setMessage("You need to have Mobile Data or wifi to access this.press ok or Exit");

        builder.setPositiveButton("ok", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               finish();
            }
        });

        return builder;
    }

}
