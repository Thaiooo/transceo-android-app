package com.transceo.app.android;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

	private EditText mailText;
	private EditText passwordText;
	private ProgressBar progressBar;
	private Button connectionButton;

	private String mail;
	private String password;

	public static final String MESSAGE_MAIL = "main.activity.mail";

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mailText = (EditText) findViewById(R.id.edit_mail);
		passwordText = (EditText) findViewById(R.id.edit_password);
		progressBar = (ProgressBar) findViewById(R.id.progress_bar);
		connectionButton = (Button) findViewById(R.id.button_connection);

		TextView t2 = (TextView) findViewById(R.id.label_subsciption);
		t2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SubscriptionActivity.class);
				startActivity(intent);
			}
		});

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	/** Called when the user clicks the Send button */
	public void login(View view) {

		// Masquer le clavier
		InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(this.getCurrentFocus().getWindowToken(), 0);

		boolean isSuccess = checkFields();

		if (isSuccess) {
			hideComponent();

			new Thread(new Runnable() {
				public void run() {
					try {
						// TODO Controle du login mot de passe
						Thread.sleep(1000 * 1);
						int status = 0;
						if (!mail.equals("a")) {
							status = 1;
						} else if (!password.equals("a")) {
							status = 2;
						}

						showComponent(status);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		}
	}

	private boolean checkFields() {
		mail = mailText.getText().toString();
		password = passwordText.getText().toString();

		if (mail == null || mail.trim().equals("")) {
			Toast.makeText(this, "Veuillez indiquer votre mail",
					Toast.LENGTH_SHORT).show();
			return false;
		}

		if (password == null || password.trim().equals("")) {
			Toast.makeText(this, "Veuillez indiquer votre mot de passe",
					Toast.LENGTH_SHORT).show();
			return false;
		}
		return true;
	}

	private void hideComponent() {
		progressBar.setVisibility(View.VISIBLE);
		mailText.setVisibility(View.INVISIBLE);
		passwordText.setVisibility(View.INVISIBLE);
		connectionButton.setVisibility(View.INVISIBLE);
	}

	private void showComponent(final int aStatus) {
		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				// code exécuté par l'UI thread
				progressBar.setVisibility(View.INVISIBLE);
				mailText.setVisibility(View.VISIBLE);
				passwordText.setVisibility(View.VISIBLE);
				connectionButton.setVisibility(View.VISIBLE);

				switch (aStatus) {
				case 0:
					String mail = mailText.getText().toString();
					Intent intent = new Intent(MainActivity.this,
							BookingActivity.class);
					intent.putExtra(MESSAGE_MAIL, mail);
					startActivity(intent);
					break;

				case 1:
					Toast.makeText(MainActivity.this, "Adresse mail invalide",
							Toast.LENGTH_LONG).show();
					break;

				case 2:
					Toast.makeText(MainActivity.this, "Password invalide",
							Toast.LENGTH_LONG).show();

					break;
				}

			}
		});

	}

}
