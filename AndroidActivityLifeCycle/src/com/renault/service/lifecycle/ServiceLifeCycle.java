/**
 * 
 */
package com.renault.service.lifecycle;

import com.renault.application.LifeCycleApplication;

import android.app.Application;
import android.app.Service;
import android.content.Intent;
import android.os.Handler;
import android.os.IBinder;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

/**
 * @author z017954
 * 
 */
public class ServiceLifeCycle extends Service {

	private final String TAG = "ServiceLifeCycle";

	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onCreate() {
		super.onCreate();
		Log.v(TAG, "onCreate is Called");
	}

	@Override
	@Deprecated
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		Log.v(TAG, "onStart() is Called");
	}

	@Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		Log.v(TAG, "onStartCommand() is Called");

		new Handler().postDelayed(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				sendDataToActivity();
			}
		}, 1000);

		return START_STICKY;
	}

	@Override
	public void onDestroy() {
		Log.v(TAG, "onDestroy() is Called");
		super.onDestroy();
	}

	private void sendDataToActivity() {
		Intent intent = new Intent("custom-event-intent");
		intent.putExtra("String", "Mohan");
		LocalBroadcastManager.getInstance(LifeCycleApplication.instance)
				.sendBroadcast(intent);
	}

	void startImplicityIntent() {
		Intent intent = new Intent();
		intent.setAction(Intent.ACTION_SEND);

	}

}
