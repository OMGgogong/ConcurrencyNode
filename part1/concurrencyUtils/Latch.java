package com.hz.fh.concurrency.practice.part1.concurrencyUtils;

import java.util.concurrent.CountDownLatch;

/**
 * 闭锁
 * @author Administrator
 *
 */
public class Latch {

	public long timeTasks (int nThreads ,final Runnable task) throws InterruptedException{
		
		final CountDownLatch startGate = new CountDownLatch(1);
		final CountDownLatch endGate = new CountDownLatch(nThreads);
		for(int i =0; i<nThreads;i++){
			Thread t = new Thread(){
				public void run(){
					try {
						startGate.await();
						try{
							task.run();
						} finally{
							endGate.countDown();
						}
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
				}
			};
			t.start();
			long start = System.nanoTime();
			startGate.countDown();
			endGate.await();
			long end = System.nanoTime();
			return end - start;
		}
		
		return nThreads;
	}
	
	
}
