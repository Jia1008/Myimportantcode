package com.briup.myThreadPool;

import java.util.LinkedList;

public class WorkQueue {
	private final int nThreads;// 工作线程数量
	private final PoolWorker[] threads;// 工作线程数组
	private final LinkedList<Runnable> queue;// 任务队列

	public WorkQueue(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedList<Runnable>();
		threads = new PoolWorker[nThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();// 创建工作线程的时候即执行
			System.out.println("创建线程" + i);
		}
	}

	public void execute(Runnable r) {// 这个方法是向线程池请求线程
		synchronized (queue) {
			queue.addLast(r);// 向任务队列添加任务
			queue.notify();// 唤醒一次阻塞的线程
		}
	}

	/**
	 * 模型工作线程
	 */
	private class PoolWorker extends Thread {
		public void run() {
			Runnable r;// 这个变量表示从任务队列中取得的队头任务
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {// 如果当前任务队列里面没有任务，就阻塞这个工作线程
						try {
							queue.wait();
							System.out.println("等待结束");
						} catch (InterruptedException ignored) {
							System.out.println("异常中断");
						}
					}
					r = (Runnable) queue.removeFirst();// 取出任务队列中的队头任务
				}
				try {
					r.run();// 执行任务
				} catch (RuntimeException e) {
					System.out.println("运行时异常");
					// 任务执行的异常信息
				}
			}
		}
	}
}
