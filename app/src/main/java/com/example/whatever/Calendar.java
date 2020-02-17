package com.example.whatever;



        import android.content.Intent;
        import android.os.Bundle;
        import android.util.Log;
        import android.widget.CalendarView;

        import androidx.annotation.Nullable;
        import androidx.appcompat.app.AppCompatActivity;

public class Calendar extends AppCompatActivity {
    private static final String TAG="Calendar";
    private CalendarView mCalendarView;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        mCalendarView=(CalendarView) findViewById(R.id.calendarView);
        mCalendarView.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange( CalendarView view, int i, int i1, int i2) {
                String date = (i1+1) + "/" + i2 + "/" + i;
                Log.d(TAG, "onSelectedDayChange: mm/dd/yyyy" + date);
                Intent intent=new Intent(Calendar.this,CT.class);
                intent.putExtra("date",date);
                startActivity(intent);
            }
        }) ;

    }
}

