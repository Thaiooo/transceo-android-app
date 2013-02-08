package com.transceo.app.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {
		Intent intent = new Intent(this, BookingActivity.class);
		// EditText mailText = (EditText) findViewById(R.id.edit_mail);
		// EditText passwordText = (EditText) findViewById(R.id.edit_password);
		// String mail = mailText.getText().toString();
		// String password = passwordText.getText().toString();
		// intent.putExtra(EXTRA_MESSAGE, mail);

		startActivity(intent);
	}
}
