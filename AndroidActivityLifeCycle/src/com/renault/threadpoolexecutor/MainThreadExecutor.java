/**
 * 
 */
package com.renault.threadpoolexecutor;

import java.util.concurrent.Executor;

import android.os.Handler;
import android.os.Looper;

/**
 * @author z017954
 * 
 */
public class MainThreadExecutor implements Executor {

	private final Handler handler = new Handler(Looper.getMainLooper());

	@Override
	public void execute(Runnable command) {

		handler.post(command);
	}

}
