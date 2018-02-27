package com.renault.activity.lifecycle;

import org.w3c.dom.Text;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.renault.lifecycle.R;
import com.renault.parcelable.Student;

/**
 * @author z017954
 * 
 */
public class MainActivity extends Activity {

	private static final String TAG = "MainActivity";

	private Button send;

	private Student student;

	TextView textView[] = new TextView[5];

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Log.v(TAG, "onCreate is Called");
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.v(TAG, "onStart() is Called");
	}

	@Override
	protected void onResume() {
		super.onResume();
		setContentView(R.layout.activity_main);
		TextView textView = new TextView(getApplicationContext());
		textView.setText(TAG);
		send = (Button) findViewById(R.id.mSendA);
		student = new Student("Mohan", "11ma35", "Chrimpet", "M.Tech");
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this,
						SecondActivity.class);
				intent.putExtra("parcel", student);
				startActivity(intent);
			}
		});
		Log.v(TAG, "onResume is Called");
	}

	@Override
	protected void onPause() {
		super.onPause();
		Log.v(TAG, "onPause is Called");
	}

	@Override
	protected void onStop() {
		super.onStop();
		Log.v(TAG, "onStop is Called");
	}

	@Override
	protected void onRestart() {
		super.onRestart();
		Log.v(TAG, "onRestart is Called");
	}

	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.v(TAG, "onDestroy is Called");
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		Log.v(TAG, "onSaveInstanceState is Called");
	}

	@Override
	protected void onRestoreInstanceState(Bundle savedInstanceState) {
		super.onRestoreInstanceState(savedInstanceState);
		Log.v(TAG, "onRestoreInstanceState is Called");
	}
}
