package com.example.whatever;
import androidx.appcompat.app.AppCompatActivity;

        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {
    TextView txt1,txt2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        txt1=findViewById(R.id.machines);
        txt2=findViewById(R.id.facilities);
        txt2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,facilities.class);
                startActivity(intent);
            }
        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Main2Activity.this,machines.class);
                startActivity(intent);


            }
        });
    }

    public void sos(View view) {
        Intent intent=new Intent(Main2Activity.this,ambulance.class);
        startActivity(intent);
    }
}
