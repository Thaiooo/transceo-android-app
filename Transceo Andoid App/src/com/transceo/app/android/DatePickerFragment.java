package com.transceo.app.android;

import java.util.Calendar;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.widget.DatePicker;
import android.widget.EditText;

public class DatePickerFragment extends android.support.v4.app.DialogFragment implements
		DatePickerDialog.OnDateSetListener {

	private EditText dateEditText;

	public DatePickerFragment(EditText anEditText) {
		super();
		dateEditText = anEditText;
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// Use the current date as the default date in the picker
		final Calendar c = Calendar.getInstance();
		int year = c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int day = c.get(Calendar.DAY_OF_MONTH);

		// Create a new instance of DatePickerDialog and return it
		DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(),
				this, year, month, day);
		long l = c.getTimeInMillis();
		DatePicker datePicker = datePickerDialog.getDatePicker();
		datePicker.setMinDate(l);
		datePicker.setSpinnersShown(true);
		datePicker.setCalendarViewShown(false);
		return datePickerDialog;
	}

	public void onDateSet(DatePicker view, int year, int month, int aDay) {
		String day;
		if (aDay < 10) {
			day = "0" + aDay;
		} else {
			day = "" + aDay;
		}
		dateEditText.setText(day + "/" + month + "/" + year);
	}
}