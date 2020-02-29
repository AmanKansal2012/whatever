package com.example.whatever;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class showappoint extends AppCompatActivity {

    TextView tv;
    TextView tv1;
    Button btn;
    private DatabaseReference muser = FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showappoint);
        tv = findViewById(R.id.showPay);
        tv1 = findViewById(R.id.showPatient);
        tv.setText("PayID :" + getIntent().getStringExtra("PayID :"));
        tv1.setText("Patient :" + getIntent().getStringExtra("Patient :"));
        btn = findViewById(R.id.button3);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String pttname = tv1.getText().toString();
                String pttid = tv.getText().toString();
                if (!TextUtils.isEmpty(pttname)) {

                    createpaylater(pttname, pttid);

                }


            }
        });


    }

    private void createpaylater(String pttname, String pttid) {
        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        assert currentUser != null;
        String uid = currentUser.getUid();
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name", pttname);
        hashMap.put("number", pttid);
        hashMap.put("id", uid);
        muser.child("Appointments").child(uid).setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(showappoint.this, "Successfully uploaded", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(showappoint.this, Thanks.class);
                startActivity(intent);


            }
        });


    }


    public void pay(View view) {
        Intent intent = new Intent(showappoint.this, Pay.class);

        startActivity(intent);
    }
}