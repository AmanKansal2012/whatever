package com.example.whatever;

import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;

        import android.os.Bundle;
        import android.text.TextUtils;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.Toast;

        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;

        import java.util.HashMap;

public class donersform extends AppCompatActivity {

    EditText senderName,senderNumber,senderBldgrp;
    Button btn;
    private DatabaseReference mUser= FirebaseDatabase.getInstance().getReference();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_donersform);
        senderName=findViewById(R.id.name);
        senderNumber=findViewById(R.id.number);
        senderBldgrp=findViewById(R.id.bloodGroup);
        btn=findViewById(R.id.button);
    }



    public void createUpload(String donername, String donernumber, String donerblood) {
      /*  FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        assert currentUser != null;
        String uid = currentUser.getUid();*/

        HashMap<String,String> donerDetails = new HashMap<>();
        donerDetails.put("Name",donername);
        donerDetails.put("Number",donernumber);
        donerDetails.put("Bloodgrp",donerblood);
        String mGroupId = mUser.push().getKey();
        assert mGroupId != null;
        mUser.child("Doners").child("don").child(mGroupId).setValue(donerDetails).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                Toast.makeText(donersform.this,"Details Uploaded Successfully",Toast.LENGTH_SHORT).show();

            }
        });
    }

    public void newdoner(View view) {
        String donername=senderName.getText().toString();
        String donernumber=senderNumber.getText().toString();
        String donerblood=senderBldgrp.getText().toString();
        if(!TextUtils.isEmpty(donername) ||!TextUtils.isEmpty(donernumber)||!TextUtils.isEmpty(donerblood)){

            createUpload(donername,donernumber,donerblood);

        }
    }
}
