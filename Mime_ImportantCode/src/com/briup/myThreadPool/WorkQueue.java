package com.briup.myThreadPool;

import java.util.LinkedList;

public class WorkQueue {
	private final int nThreads;// �����߳�����
	private final PoolWorker[] threads;// �����߳�����
	private final LinkedList<Runnable> queue;// �������

	public WorkQueue(int nThreads) {
		this.nThreads = nThreads;
		queue = new LinkedList<Runnable>();
		threads = new PoolWorker[nThreads];
		for (int i = 0; i < threads.length; i++) {
			threads[i] = new PoolWorker();
			threads[i].start();// ���������̵߳�ʱ��ִ��
			System.out.println("�����߳�" + i);
		}
	}

	public void execute(Runnable r) {// ������������̳߳������߳�
		synchronized (queue) {
			queue.addLast(r);// ����������������
			queue.notify();// ����һ���������߳�
		}
	}

	/**
	 * ģ�͹����߳�
	 */
	private class PoolWorker extends Thread {
		public void run() {
			Runnable r;// ���������ʾ�����������ȡ�õĶ�ͷ����
			while (true) {
				synchronized (queue) {
					while (queue.isEmpty()) {// �����ǰ�����������û�����񣬾�������������߳�
						try {
							queue.wait();
							System.out.println("�ȴ�����");
						} catch (InterruptedException ignored) {
							System.out.println("�쳣�ж�");
						}
					}
					r = (Runnable) queue.removeFirst();// ȡ����������еĶ�ͷ����
				}
				try {
					r.run();// ִ������
				} catch (RuntimeException e) {
					System.out.println("����ʱ�쳣");
					// ����ִ�е��쳣��Ϣ
				}
			}
		}
	}
}
