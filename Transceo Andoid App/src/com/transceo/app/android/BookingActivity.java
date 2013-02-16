/*
 * Copyright 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.transceo.app.android;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

public class BookingActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_booking);

		EditText dateText = (EditText) findViewById(R.id.edit_date);
		EditText heureText = (EditText) findViewById(R.id.edit_time);
		TextView departLabel = (TextView) findViewById(R.id.text_depart);
		EditText adrDepartText = (EditText) findViewById(R.id.edit_adr_depart);
		EditText villeDepartText = (EditText) findViewById(R.id.edit_ville_depart);

		Display display = getWindowManager().getDefaultDisplay();
		Point size = new Point();
		display.getSize(size);
		int width = size.x - 40;

		dateText.setWidth(width / 3);
		heureText.setWidth(width / 3);
		departLabel.setWidth(width / 2);
		adrDepartText.setWidth(width / 2);
		villeDepartText.setWidth(width / 2);

		getWindow().setSoftInputMode(
				WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);
	}

}
