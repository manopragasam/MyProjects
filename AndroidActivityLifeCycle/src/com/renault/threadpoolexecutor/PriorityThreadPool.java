/**
 * 
 */
package com.renault.threadpoolexecutor;

import java.util.concurrent.ThreadFactory;

import android.os.Process;

/**
 * @author z017954
 * 
 */
public class PriorityThreadPool implements ThreadFactory {

	private int threadPriority;

	public PriorityThreadPool(int threadPriority) {
		this.threadPriority = threadPriority;
	}

	@Override
	public Thread newThread(final Runnable runnable) {
		Runnable wraaperRunnable = new Runnable() {

			@Override
			public void run() {
				try {
					Process.setThreadPriority(threadPriority);
				} catch (Throwable e) {
					System.err.println(e.getMessage());
				}
				runnable.run();
			}
		};
		return new Thread(wraaperRunnable);
	}

}
