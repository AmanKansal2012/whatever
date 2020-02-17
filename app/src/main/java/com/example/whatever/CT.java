package com.example.whatever;


import androidx.appcompat.app.AppCompatActivity;
        import androidx.fragment.app.DialogFragment;

        import android.app.TimePickerDialog;
        import android.content.Intent;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
        import android.widget.TimePicker;

public class CT extends AppCompatActivity implements TimePickerDialog.OnTimeSetListener {


    private static final String TAG="CT";
    private TextView theDate;
    private Button btnGocalendar;
     Button proceed;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ct);
        Button button=(Button) findViewById(R.id.button);
        proceed =findViewById(R.id.pay);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                DialogFragment timePicker=new TimePickerFragment();
                timePicker.show(getSupportFragmentManager(),"time picker");
            }
        });
        theDate=(TextView) findViewById(R.id.dt);
        btnGocalendar=(Button) findViewById(R.id.btnGoCalendar);
        btnGocalendar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CT.this,Calendar.class);
                startActivity(intent);
            }
        });

        Intent incomingIntent=getIntent();
        final String date=incomingIntent.getStringExtra("date");
        theDate.setText(date);




    }
    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute){
        TextView textView=(TextView)findViewById(R.id.textView);
        textView.setText("Hour: "+ hourOfDay+"Minute: "+minute);

    }

  public void proceed(View view) {
       Intent intent=new Intent(CT.this,confirm.class);

       startActivity(intent);
   }
}
