package com.briup.test;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 测试lock类中四种不同获取锁的方法
 * 
 * @author vonym
 *
 */
public class LockTest {
	private Lock lock = new ReentrantLock();

	// 最常用的获取锁方法
	/**
	 * lock()和unlock()方法必须以下格式 l.lock();
	 * try { 
	 * // access the resource protected by this lock 
	 * } finally { 
	 * 	  l.unlock(); 
	 * }
	 */
	public void insert_lock(Thread thread) {
		lock.lock();
		try {
			System.out.println(thread.getName() + "得到了锁");
			Thread.sleep(3000);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println(thread.getName() + "释放了锁");
			lock.unlock();
		}
	}
	//tryLock()方法,有返回值
	public void insert_try(Thread thread) {
		if (lock.tryLock()) {
			try {
				System.out.println(thread.getName() + "得到了锁");
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				System.out.println(thread.getName() + "释放了锁");
				lock.unlock();
			}
		} else {
			System.out.println(thread.getName() + "得到锁失败！");
		}

	}
	//tryLock(long,TimeUnit)，有返回值
	public void insert_try2(Thread thread) {
		try {
			if (lock.tryLock(2, TimeUnit.SECONDS)) {
				try {
					System.out.println(thread.getName() + "得到了锁");
					Thread.sleep(1000);
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					System.out.println(thread.getName() + "释放了锁");
					lock.unlock();
				}
			} else {
				System.out.println(thread.getName() + "得到锁失败！");
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	//lockInterruptibly()
	public void insert_inter(Thread thread) {
		try {
			lock.lockInterruptibly();
			System.out.println(thread.getName() + "得到了锁");
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			System.out.println(thread.getName() + "获取锁失败！");
		} finally {
			System.out.println(thread.getName() + "释放了锁");
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