package com.example.whatever;

        import android.view.LayoutInflater;
        import android.view.View;
        import android.view.ViewGroup;
        import android.widget.RelativeLayout;
        import android.widget.TextView;

        import androidx.annotation.NonNull;
        import androidx.recyclerview.widget.RecyclerView;

        import java.util.ArrayList;

public class Adaptclass  extends RecyclerView.Adapter<Adaptclass.MyViewHolder> {

    ArrayList<Availdoners> list;
    public Adaptclass(ArrayList<Availdoners> list) {
        this.list = list;


    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardd, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        MyViewHolder.name.setText(list.get(position).getName());
        MyViewHolder.desc.setText(list.get(position).getNumber());
        MyViewHolder.bg.setText(list.get(position).getBloodgrp());



    }

    @Override
    public int getItemCount() {
        return list.size();    }



    public static class MyViewHolder extends RecyclerView.ViewHolder {

        static TextView name;
        static TextView desc;
        static TextView bg;
        static RelativeLayout relate;


        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            desc = itemView.findViewById(R.id.description);
            relate=itemView.findViewById(R.id.doctor_view);
            bg=itemView.findViewById(R.id.bloodGroup);





        }
    }






}

