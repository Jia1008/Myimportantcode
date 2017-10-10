package com.briup.Thread;

import java.util.Date;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class FutureCallable {
	
	public static void main(String[] args) {
		Callable<String> callable=new SomeCallable();
		FutureTask<String> futureTask=new FutureTask<String>(callable);
		Thread thread=new Thread(futureTask);
		thread.start();
		try {
			Object o=futureTask.get();
			System.out.println(o);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

class SomeCallable implements Callable<String>{

	@Override
	public String call() throws Exception {
		Date date=new Date();
		System.out.println("运行了。。。");
		return "时间为:"+date;
	}
	
}