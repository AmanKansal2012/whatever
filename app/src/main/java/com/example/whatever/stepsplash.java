package com.example.whatever;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.google.firebase.auth.FirebaseAuth;



public class stepsplash extends AppCompatActivity {
    ImageView splashscreen;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stepsplash);
        splashscreen = findViewById(R.id.run);
        Animation animation = AnimationUtils.loadAnimation(stepsplash.this, R.anim.myanimm);
        splashscreen.startAnimation(animation);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent homeinent = new Intent(stepsplash.this, step.class);
                startActivity(homeinent);
                finish();




            }





        }, 3000);

    }


}
