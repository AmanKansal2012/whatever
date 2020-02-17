package com.example.whatever;



        import android.app.Dialog;
        import android.app.TimePickerDialog;
        import android.os.Bundle;

        import androidx.annotation.NonNull;
        import androidx.annotation.Nullable;
        import androidx.fragment.app.DialogFragment;

        import java.util.Calendar;

public class TimePickerFragment extends DialogFragment {
    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        java.util.Calendar c= java.util.Calendar.getInstance();
        int hour=c.get(java.util.Calendar.HOUR_OF_DAY);
        int minute =c.get(Calendar.MINUTE);

        return new TimePickerDialog(getActivity(),(TimePickerDialog.OnTimeSetListener)getActivity(),hour,minute,android.text.format.DateFormat.is24HourFormat(getActivity()));
    }
}
