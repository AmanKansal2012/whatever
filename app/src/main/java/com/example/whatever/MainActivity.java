package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    ImageView splashscreen;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        splashscreen = findViewById(R.id.logo);
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.myanim);
        splashscreen.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeinent = new Intent(MainActivity.this, register.class);
                startActivity(homeinent);
                finish();




                }





        }, 3000);

    }


}
