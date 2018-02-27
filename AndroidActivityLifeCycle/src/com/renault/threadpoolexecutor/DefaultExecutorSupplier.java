/**
 * 
 */
package com.renault.threadpoolexecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import android.annotation.SuppressLint;
import android.os.Process;

/**
 * @author z017954
 * 
 */
public class DefaultExecutorSupplier {

	private final int NUMBER_CORE = Runtime.getRuntime().availableProcessors() * 2;

	private static DefaultExecutorSupplier instance;

	private ThreadPoolExecutor mForBackgroundTask;

	private ThreadPoolExecutor mForLightWeightTask;

	private Executor mMainThreadExecutor;

	public static DefaultExecutorSupplier getInstance() {

		if (instance == null) {
			synchronized (DefaultExecutorSupplier.class) {
				instance = new DefaultExecutorSupplier();
			}
		}

		return instance;
	}

	@SuppressLint("NewApi")
	private DefaultExecutorSupplier() {

		ThreadFactory threadFactory = new PriorityThreadPool(
				Process.THREAD_PRIORITY_BACKGROUND);

		mForBackgroundTask = new ThreadPoolExecutor(NUMBER_CORE, NUMBER_CORE,
				60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(),
				threadFactory);

		mForLightWeightTask = new ThreadPoolExecutor(NUMBER_CORE, NUMBER_CORE,
				60L, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>(),
				threadFactory);

		mMainThreadExecutor = new MainThreadExecutor();
	}

	public ThreadPoolExecutor getBackgroundTaks() {
		return mForBackgroundTask;
	}

	public ThreadPoolExecutor getLightWeightProcess() {
		return mForLightWeightTask;
	}

	public Executor getMainThreadTask() {
		return mMainThreadExecutor;
	}
}
