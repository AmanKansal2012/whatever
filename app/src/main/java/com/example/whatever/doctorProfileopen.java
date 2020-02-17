package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class doctorProfileopen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profileopen);
    }

    public void book(View view) {
        Intent lintent=new Intent(doctorProfileopen.this,CT.class);
        startActivity(lintent);
    }
}
