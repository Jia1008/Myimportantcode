package com.briup.ThreadPool;

import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;

//�Զ���ܾ�����
public class MyRejected implements RejectedExecutionHandler{

	
	
	public MyRejected() {
		
	}

	@Override
	public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
		// TODO Auto-generated method stub
		System.out.println("�Զ��崦������");
		System.out.println("��ǰ���ܾ�����Ϊ��"+r.toString());
	}
	
}
