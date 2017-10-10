package com.briup.ThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

//自定义拒绝策略
public class MyRejected implements RejectedExecutionHandler{

	
	
	public MyRejected() {
		
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println("自定义处理。。。");
		System.out.println("当前被拒绝任务为："+r.toString());
	}
	
}
