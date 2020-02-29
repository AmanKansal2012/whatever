package com.example.whatever;


        import androidx.annotation.NonNull;
        import androidx.appcompat.app.AppCompatActivity;


        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

        import android.widget.EditText;
        import android.widget.Toast;


        import com.firebase.client.Firebase;
        import com.google.android.gms.tasks.OnCompleteListener;
        import com.google.android.gms.tasks.Task;
        import com.google.firebase.auth.FirebaseAuth;
        import com.google.firebase.auth.FirebaseUser;
        import com.google.firebase.database.DatabaseReference;
        import com.google.firebase.database.FirebaseDatabase;
        import com.spark.submitbutton.SubmitButton;

        import java.util.HashMap;

public class Emergencyap extends AppCompatActivity {
    public EditText editname;
    public EditText editno;

    SubmitButton btn;

    private DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emergencyap);

        editno=findViewById(R.id.number);
        btn=findViewById(R.id.submitButton);
        editname=findViewById(R.id.names);




        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=editname.getText().toString();
                String number=editno.getText().toString();
                FirebaseUser currentUser= FirebaseAuth.getInstance().getCurrentUser();
                assert currentUser != null;
                String uid =currentUser.getUid();
                HashMap<String,String> hashMap=new HashMap<>();
                hashMap.put("name",name);
                hashMap.put("number",number);
                databaseReference.child("Emergency").child(uid).setValue(hashMap).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        Toast.makeText(Emergencyap.this, "successfully uploaded", Toast.LENGTH_SHORT).show();

                        Intent intent=new Intent(Emergencyap.this,Pay.class);

                        startActivity(intent);

                    }

                });
            }
        });

    }



}
