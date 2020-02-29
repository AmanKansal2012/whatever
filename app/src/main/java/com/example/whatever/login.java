package com.example.whatever;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
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

public class login extends AppCompatActivity {


    EditText editText_email;
    EditText editText_password;
    EditText editText_name;
    Button button_login;
    TextView signup_txt;
    private ProgressDialog mLoginProgress;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        editText_email=findViewById(R.id.editText_email);
        editText_password=findViewById(R.id.editText_password);
        editText_name=findViewById(R.id.editText_name);
        mLoginProgress = new ProgressDialog(this);
        button_login=findViewById(R.id.button_login);
        signup_txt=findViewById(R.id.signup_text);
        mAuth = FirebaseAuth.getInstance();
        button_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                final String Username = editText_name.getText().toString();
                String password = editText_password.getText().toString();
                final String email = editText_email.getText().toString();
                if (!TextUtils.isEmpty(email) || !TextUtils.isEmpty(password)) {
                    mLoginProgress.setTitle("Logging In");
                    mLoginProgress.setMessage("Please wait while we check your credentials.");
                    mLoginProgress.setCanceledOnTouchOutside(false);
                    mLoginProgress.show();


                    loginUser(email, password);

                }


            }
        });




    }

    private void loginUser(String email, String password) {
        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(login.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            mLoginProgress.dismiss();

                            String current_user_id = mAuth.getCurrentUser().getUid();
                            Toast.makeText(login.this, "Hey Welcome Back", Toast.LENGTH_SHORT).show();


                            Intent lintent = new Intent(login.this,Voice.class);
                            lintent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                            startActivity(lintent);
                            finish();


                        } else {

                            Toast.makeText(login.this, "Failed to login", Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });


    }

    public void signup_text(View view) {
        Intent intent=new Intent(login.this,register.class);
        startActivity(intent);
        finish();
    }
}

