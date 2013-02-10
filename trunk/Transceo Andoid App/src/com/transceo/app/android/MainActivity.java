package com.transceo.app.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText mailText;
	private EditText passwordText;
	private ProgressBar progressBar;
	private Button connectionButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mailText = (EditText) findViewById(R.id.edit_mail);
		passwordText = (EditText) findViewById(R.id.edit_password);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		connectionButton = (Button) findViewById(R.id.button_connection);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
	public void sendMessage(View view) {

		final Intent intent = new Intent(this, BookingActivity.class);

		String mail = mailText.getText().toString();
		String password = passwordText.getText().toString();

		// Masquer le clavier
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);

		if (mail == null || mail.trim().equals("")) {
			Toast.makeText(this, "Veuillez indiquer votre mail",
					Toast.LENGTH_SHORT).show();
			// return;
		}

		if (password == null || password.trim().equals("")) {
			Toast.makeText(this, "Veuillez indiquer votre mot de passe",
					Toast.LENGTH_SHORT).show();
			// return;
		}

		progressBar.setVisibility(View.VISIBLE);
		mailText.setVisibility(View.INVISIBLE);
		passwordText.setVisibility(View.INVISIBLE);
		connectionButton.setVisibility(View.INVISIBLE);

		new Thread(new Runnable() {
			public void run() {
				try {

					// TODO Controle du login mot de passe
					// Thread.sleep(1000 * 5);

					// if (true) {

					// }

					// test();

					// startActivity(intent);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}).start();

		// intent.putExtra(EXTRA_MESSAGE, mail);

	}

	private void test() {
		progressBar.setVisibility(View.INVISIBLE);
		mailText.setVisibility(View.VISIBLE);
		passwordText.setVisibility(View.VISIBLE);
		connectionButton.setVisibility(View.VISIBLE);
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);

		// Checks whether a hardware keyboard is available
		if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_NO) {
			Toast.makeText(this, "keyboard visible", Toast.LENGTH_SHORT).show();
		} else if (newConfig.hardKeyboardHidden == Configuration.HARDKEYBOARDHIDDEN_YES) {
			Toast.makeText(this, "keyboard hidden", Toast.LENGTH_SHORT).show();
		}
	}
}
