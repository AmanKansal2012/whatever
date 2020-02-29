package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class confirm extends AppCompatActivity {
     EditText pname;
     EditText pid;
     Button Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        pname=(EditText) findViewById(R.id.pname);
            pid=(EditText) findViewById(R.id.pid);
            Confirm=(Button) findViewById(R.id.Confirm);
            Confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dN=pname.getText().toString();
                    String pN=pid.getText().toString();
                   Intent intent=new Intent(confirm.this,showappoint.class);
                  intent.putExtra("Patient :",dN);
                  intent.putExtra("PayID :",pN);
                  startActivity(intent);
                }
            });

    }


}





