package com.transceo.app.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.EditText;

public class FragmentReservation extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_section_reservation,
				container, false);

		// =====================================================================================
		EditText editDate = (EditText) rootView.findViewById(R.id.edit_date);
		editDate.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					showDatePickerDialog(v);
					return true;
				}
				return false;
			}
		});

		EditText editTime = (EditText) rootView.findViewById(R.id.edit_time);
		editTime.setOnTouchListener(new OnTouchListener() {
			public boolean onTouch(View v, MotionEvent event) {
				if (event.getAction() == MotionEvent.ACTION_DOWN) {
					showTimePickerDialog(v);
					return true;
				}

				return false;
			}
		});
		return rootView;
	}

	public void showDatePickerDialog(View view) {
		EditText editDate = (EditText) view;
		DatePickerFragment newFragment = new DatePickerFragment(editDate);
		newFragment.show(getFragmentManager(), "datePicker");
	}

	public void showTimePickerDialog(View view) {
		EditText editTime = (EditText) view;
		TimePickerFragment newFragment = new TimePickerFragment(editTime);
		newFragment.show(getFragmentManager(), "timePicker");
	}
}
