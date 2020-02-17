package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class confirm extends AppCompatActivity {
     EditText drname;
     EditText yourname;
     Button Confirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        drname=(EditText) findViewById(R.id.drname);
            yourname=(EditText) findViewById(R.id.yourname);
            Confirm=(Button) findViewById(R.id.Confirm);
            Confirm.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String dN=drname.getText().toString();
                    String pN=yourname.getText().toString();
                   Intent intent=new Intent(confirm.this,showappoint.class);
                  intent.putExtra("Doctor :",dN);
                  intent.putExtra("Patient:",pN);
                  startActivity(intent);
                }
            });

    }
}





