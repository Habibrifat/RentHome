package com.example.renthoom;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static android.support.v4.os.LocaleListCompat.create;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    public static String contactToDonor = null;
    Context context;
    ArrayList<CustomListView> profile;

    public  MyAdapter(Context c , ArrayList<CustomListView> p){
        context = c;
        profile = p;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(context).inflate(R.layout.show_ad,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder holder, final int position) {
        holder.address.setText(profile.get(position).getAddress());
        holder.description.setText(profile.get(position).getDescription());
        holder.phoneon.setText(profile.get(position).getPhoneno());


    }
    @Override
    public int getItemCount() {
        return profile.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{

        TextView  address,description,phoneon;

        public MyViewHolder(View itemView){
            super(itemView);
            address = itemView.findViewById(R.id.address);
            description = itemView.findViewById(R.id.description);
            phoneon = itemView.findViewById(R.id.phoneNo);
        }
    }
}