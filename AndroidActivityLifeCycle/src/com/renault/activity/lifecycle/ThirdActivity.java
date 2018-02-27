package com.renault.activity.lifecycle;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.renault.lifecycle.R;
import com.renault.service.lifecycle.ServiceLifeCycle;

/**
 * @author z017954
 * 
 */
public class ThirdActivity extends Activity {

	private static final String TAG = "ThirdActivity";

	private Button send;

	private TextView textView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		LocalBroadcastManager.getInstance(this).registerReceiver(
				broadcastReceiver, new IntentFilter("custom-event-intent"));
		setContentView(R.layout.activity_third);
		Log.v(TAG, "onCreate is Called");
		send = (Button) findViewById(R.id.mSendC);
		textView = new TextView(getApplicationContext());
		textView.setText(TAG);
		send.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SecondActivity activity = new SecondActivity();
				activity.finish();
				startService(new Intent(ThirdActivity.this,
						ServiceLifeCycle.class));
			}
		});
	}

	@Override
	protected void onStart() {
		super.onStart();
		Log.v(TAG, "onStart is Called");
	}

	@Override
	protected void onResume() {
		super.onResume();
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
		LocalBroadcastManager.getInstance(this).unregisterReceiver(
				broadcastReceiver);
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

	public BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {

		@Override
		public void onReceive(Context context, Intent intent) {
			String action = intent.getAction();

			if (action.equals("custom-event-intent")) {

				textView.setText(intent.getStringExtra("String"));
			}

		}
	};

}
