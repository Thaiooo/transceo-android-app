package com.transceo.app.android;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class SubscriptionActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_subscription);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		return false;
	}

}
