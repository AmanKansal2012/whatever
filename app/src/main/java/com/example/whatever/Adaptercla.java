package com.example.whatever;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adaptercla extends RecyclerView.Adapter<Adaptercla.MyViewHolder> {
    ArrayList<userp> list;
    public Adaptercla(ArrayList<userp> list) {
        this.list = list;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardp, parent, false);
        return new Adaptercla.MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        MyViewHolder.pname.setText(list.get(position).getName());
        MyViewHolder.disease.setText(list.get(position).getDisease());
        MyViewHolder.history.setText(list.get(position).getHistory());
        MyViewHolder.presc.setText(list.get(position).getPrescribtion());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public static class MyViewHolder extends RecyclerView.ViewHolder {

    static TextView pname;
    static TextView disease;
    static  TextView presc;
    static TextView history;

    static RelativeLayout relate;


    public MyViewHolder(@NonNull View itemView) {
        super(itemView);
        pname = itemView.findViewById(R.id.pname);
        disease = itemView.findViewById(R.id.disease);
        presc=itemView.findViewById(R.id.prescr);
        history=itemView.findViewById(R.id.hist);
        relate = itemView.findViewById(R.id.doctor_view);


    }
}}