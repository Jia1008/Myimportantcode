package com.briup.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * ����lock�������ֲ�ͬ��ȡ���ķ���
 * 
 * @author vonym
 *
 */
public class LockTest {
	private Lock lock = new ReentrantLock();

	// ��õĻ�ȡ������
	/**
	 * lock()��unlock()�����������¸�ʽ l.lock();
	 * try { 
	 * // access the resource protected by this lock 
	 * } finally { 
	 * 	  l.unlock(); 
	 * }
	 */
	public void insert_lock(Thread thread) {
		lock.lock();
		try {
			System.out.println(thread.getName() + "�õ�����");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(thread.getName() + "�ͷ�����");
			lock.unlock();
		}
	}
	//tryLock()����,�з���ֵ
	public void insert_try(Thread thread) {
		if (lock.tryLock()) {
			try {
				System.out.println(thread.getName() + "�õ�����");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(thread.getName() + "�ͷ�����");
				lock.unlock();
			}
		} else {
			System.out.println(thread.getName() + "�õ���ʧ�ܣ�");
		}

	}
	//tryLock(long,TimeUnit)���з���ֵ
	public void insert_try2(Thread thread) {
		try {
			if (lock.tryLock(2, TimeUnit.SECONDS)) {
				try {
					System.out.println(thread.getName() + "�õ�����");
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(thread.getName() + "�ͷ�����");
					lock.unlock();
				}
			} else {
				System.out.println(thread.getName() + "�õ���ʧ�ܣ�");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//lockInterruptibly()
	public void insert_inter(Thread thread) {
		try {
			lock.lockInterruptibly();
			System.out.println(thread.getName() + "�õ�����");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(thread.getName() + "��ȡ��ʧ�ܣ�");
		} finally {
			System.out.println(thread.getName() + "�ͷ�����");
			lock.unlock();
		}
	}

	public static void main(String[] args) {
		final LockTest test = new LockTest();
		new Thread() {
			public void run() {
				test.insert_inter(Thread.currentThread());
			};
		}.start();
		new Thread() {
			public void run() {
				test.insert_inter(Thread.currentThread());
				Thread.currentThread().interrupt();
			};
		}.start();
	}
}