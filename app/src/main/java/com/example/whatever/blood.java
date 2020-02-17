package com.example.whatever;
import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;

        import android.widget.ImageView;

public class blood extends AppCompatActivity {
    ImageView image1,image2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_blood);
        image1=findViewById(R.id.needblood);
        image2=findViewById(R.id.donateblood);
        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(blood.this,donersform.class);
                startActivity(intent);

            }
        });
    }

    public void wantBlood(View view) {
        Intent intent=new Intent(blood.this,showDoners.class);
        startActivity(intent);

    }

   /* public void donateBlood(View view) {
        Intent intent=new Intent(MainActivity.this,donersform.class);
        startActivity(intent);

    }*/

   /* public void needBlood(View view) {
    }*/
}
