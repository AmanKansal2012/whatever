package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class hospitalthumnail extends AppCompatActivity {

    TextView txtview;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hospitalthumnail);
        txtview=findViewById(R.id.hospital_txt);
        btn=findViewById(R.id.hospital_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(hospitalthumnail.this,register.class);
                startActivity(intent);
                finish();


            }
        });

    }
}