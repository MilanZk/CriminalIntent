package com.example.milankokic.criminalintent;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.TimePicker;

import java.util.Calendar;
import java.util.Date;

public class TimePickerDialog extends DialogFragment {

    private TimePicker timePicker;
    private static final String ARG_TIME = "time";
    public static final String EXTRA_TIME = "com.example.criminalintent.time";
    private Date date;


    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        View v = getActivity().getLayoutInflater().inflate(R.layout.time_picker_dialog, null);
        timePicker = v.findViewById(R.id.timePicker);
        date = (Date) getArguments().get(ARG_TIME);
        final Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        timePicker.setCurrentHour(calendar.get(Calendar.HOUR_OF_DAY));
        timePicker.setCurrentMinute(calendar.get(Calendar.MINUTE));
        return new AlertDialog.Builder(getActivity())
                .setView(v)
                .setTitle(R.string.time_picker_title)
                .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        date.setHours(timePicker.getCurrentHour());
                        date.setMinutes(timePicker.getCurrentMinute());
                        sendResult(Activity.RESULT_OK, date);
                    }
                })
                .create();
    }

    public static TimePickerDialog newInstance(Date date) {

        Bundle args = new Bundle();
        args.putSerializable(ARG_TIME, date);
        TimePickerDialog fragment = new TimePickerDialog();
        fragment.setArguments(args);
        return fragment;
    }

    private void sendResult(int resultCode, Date time) {
        if (getTargetFragment() == null) {
            return;
        }
        Intent intent = new Intent();
        intent.putExtra(EXTRA_TIME, time);
        getTargetFragment().onActivityResult(getTargetRequestCode(), resultCode, intent);
    }
}
