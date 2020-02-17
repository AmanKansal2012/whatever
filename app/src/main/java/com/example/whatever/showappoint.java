package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class showappoint extends AppCompatActivity {

TextView tv;
TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showappoint);
tv=(TextView) findViewById(R.id.showDoctor);
tv1=(TextView) findViewById(R.id.showPatient) ;
tv.setText("Doctor :"+getIntent().getStringExtra("Doctor :"));
tv1.setText("Patient:"+getIntent().getStringExtra("Patient:"));


    }

    public void pay(View view) {
        Intent intent=new Intent(showappoint.this,payappoint.class);

        startActivity(intent);
    }

    public void thanks(View view) {
        Intent intent=new Intent(showappoint.this,Thanks.class);

        startActivity(intent);
    }
}