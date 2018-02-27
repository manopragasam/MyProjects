package com.renault.application;

import android.app.Application;

public class LifeCycleApplication extends Application {

	public static LifeCycleApplication instance;

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
		instance = this;
	}

}
