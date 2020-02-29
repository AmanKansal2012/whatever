package com.example.whatever;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Objects;

public class register extends AppCompatActivity {

    EditText editText_email;
    EditText editText_password;
    EditText editText_name;
    Button button_register;
    TextView login_txt;
    private ProgressDialog mRegProgress;
    private FirebaseAuth mAuth;
    DatabaseReference databaseReference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        editText_email = findViewById(R.id.editText_email);
        editText_password = findViewById(R.id.editText_password);
        editText_name = findViewById(R.id.editText_name);
        button_register = findViewById(R.id.button_register);
        mRegProgress = new ProgressDialog(this);
        login_txt = findViewById(R.id.login_text);
        mAuth = FirebaseAuth.getInstance();
        databaseReference = FirebaseDatabase.getInstance().getReference("Users");
        button_register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Username = editText_name.getText().toString();
                String password = editText_password.getText().toString();
                final String email = editText_email.getText().toString();
                if (TextUtils.isEmpty(email)) {
                    Toast.makeText(register.this, "Please Enter Email", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(password)) {
                    Toast.makeText(register.this, "Please Enter Password", Toast.LENGTH_SHORT).show();

                } else if (TextUtils.isEmpty(Username)) {
                    Toast.makeText(register.this, "Please Enter Username", Toast.LENGTH_SHORT).show();

                } else if (password.length() < 6) {
                    Toast.makeText(register.this, "Please enter more than 6 digit password", Toast.LENGTH_SHORT).show();
                }
                mRegProgress.setTitle("Registering User");
                mRegProgress.setMessage("Please wait while we create your account !");
                mRegProgress.setCanceledOnTouchOutside(false);
                mRegProgress.show();


                mAuth.createUserWithEmailAndPassword(email, password)
                        .addOnCompleteListener(register.this, new OnCompleteListener<AuthResult>() {
                            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    FirebaseUser currentuser=FirebaseAuth.getInstance().getCurrentUser();
                                    assert currentuser != null;
                                    String uid = currentuser.getUid();

                                    user information = new user(
                                            Username, email,uid

                                    );
                                    FirebaseDatabase.getInstance().getReference("PatientsRegister")
                                            .child(Objects.requireNonNull(FirebaseAuth.getInstance().getCurrentUser()).getUid())
                                            .setValue(information).addOnCompleteListener(new OnCompleteListener<Void>() {
                                        @Override
                                        public void onComplete(@NonNull Task<Void> task) {
                                            mRegProgress.dismiss();

                                            Toast.makeText(register.this, "Registration Complete", Toast.LENGTH_SHORT).show();
                                            startActivity(new Intent(getApplicationContext(), dashboard.class));


                                        }
                                    });


                                } else {

                                    Toast.makeText(register.this, "Registration Failed", Toast.LENGTH_SHORT).show();

                                }

                                // ...
                            }
                        });


            }
        });


    }


    public void login_text(View view) {
       Intent intent=new Intent(register.this,login.class);
       startActivity(intent);
       finish();
    }
}
