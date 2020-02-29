package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class typeapp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_typeapp);
    }

    public void general(View view) {
        Intent intent=new Intent(typeapp.this,dp.class);

        startActivity(intent);
    }

    public void emergency(View view) {
        Intent intent=new Intent(typeapp.this,Emergencyap.class);

        startActivity(intent);
    }
}
