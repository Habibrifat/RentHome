package com.example.renthoom;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;


public class CustomAdapter extends ArrayAdapter<Information> {

    private Activity context;
    private List<Information> informationList;



    public CustomAdapter(Activity context, List<Information> informationList) {
        super(context, R.layout.sample_layout,informationList );
        this.context = context;
        this.informationList = informationList;


    }
    @NonNull
    @Override
    public View getView(int position,  View convertView, ViewGroup parent) {


        LayoutInflater layoutInflater = context.getLayoutInflater();
        View view = layoutInflater.inflate(R.layout.sample_layout,null,true);

        Information information = informationList.get(position);

        TextView t1 = view.findViewById(R.id.textViewaddressId);
        TextView t2 = view.findViewById(R.id.textViewamountId);
        TextView t3= view.findViewById(R.id.textViewphonenoId);
        TextView t4 = view.findViewById(R.id.textViewdescriptionId);
        TextView t5 = view.findViewById(R.id.catagoryId);
        TextView t6 = view.findViewById(R.id.locationId);

        t1.setText("Address : "+information.getAddress());
        t2.setText("Amount :"+information.getAmount());
        t3.setText("Phoneno :"+information.getPhoneno());
        t4.setText("Description :"+information.getDescription());
        t5.setText("Month :"+information.getCatagorymonth());
        t6.setText("Location :"+information.getLocation());

        return view;

    }




}
