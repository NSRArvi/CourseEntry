package com.example.courseentry.pickers;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class DatePicker extends DialogFragment implements DatePickerDialog.OnDateSetListener {
    private OnDatePickListner listner;

    public DatePicker(OnDatePickListner listner) {
        this.listner = listner;
    }




    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        final Calendar calendar = Calendar.getInstance(Locale.getDefault());
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(), this, year, month, day);
    }

    @Override
    public void onDateSet(android.widget.DatePicker datePicker, int userYear, int userMonth, int userDay) {
        final Calendar calendar = Calendar.getInstance();
        calendar.set(userYear,userMonth,userDay);
        final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        final String selectedDate =  sdf.format(calendar.getTime());
        listner.onDatePicked(selectedDate);

        Log.d("DATE", selectedDate);
    }

    public interface OnDatePickListner{
        void onDatePicked(String date);
    }

}
