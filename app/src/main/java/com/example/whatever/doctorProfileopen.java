package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class doctorProfileopen extends AppCompatActivity {
    TextView text1,text2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_profileopen);
        text1=findViewById(R.id.gotname);
        text2=findViewById(R.id.gotdesc);
        Bundle mbundle=getIntent().getExtras();
        if(mbundle!=null){
            text1.setText(mbundle.getString("name"));
            text2.setText(mbundle.getString("desc"));
        }

    }

    public void book(View view) {
        Intent lintent=new Intent(doctorProfileopen.this,CT.class);
        startActivity(lintent);
    }
}
