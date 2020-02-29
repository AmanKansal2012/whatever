package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;

public class dashboard extends AppCompatActivity {
    ImageView appointimage;
    ImageView stethoscope;
    Button book;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        appointimage=findViewById(R.id.appointment);
        stethoscope=findViewById(R.id.doctor);
        book=findViewById(R.id.book);


    }

    public void appointment_dash(View view) {
        Intent intent=new Intent(dashboard.this,typeapp.class);

        startActivity(intent);



    }


    public void doctor_dash(View view) {
        Intent lintent=new Intent(dashboard.this,dp.class);
        startActivity(lintent);
    }

    public void blood(View view) {
        Intent bintent=new Intent(dashboard.this,blood.class);
        startActivity(bintent);
    }

    public void sms(View view) {
        Intent sintent=new Intent(dashboard.this,sms.class);
        startActivity(sintent);
    }

    public void aboutd(View view) {
        Intent dintent=new Intent(dashboard.this,AboutD.class);
        startActivity(dintent);

    }

    public void service(View view) {
        Intent zintent=new Intent(dashboard.this,Main2Activity.class);
        startActivity(zintent);
    }

    public void report(View view) {
        Intent rintent=new Intent(dashboard.this,reports.class);
        startActivity(rintent);
    }

    public void step(View view) {
        Intent rintent=new Intent(dashboard.this,stepsplash.class);
        startActivity(rintent);
    }

    public void bmi(View view) {
        Intent rintent=new Intent(dashboard.this,bmi.class);
        startActivity(rintent);
    }

    public void hospital(View view) {
        Intent rintent=new Intent(dashboard.this,hospital.class);
        startActivity(rintent);
    }

    public void sos(View view) {
        Intent rintent=new Intent(dashboard.this,ambulance.class);
        startActivity(rintent);
    }

    public void logout(View view) {
        FirebaseAuth.getInstance().signOut();
        Intent rintent=new Intent(dashboard.this,register.class);
        startActivity(rintent);
    }
}
