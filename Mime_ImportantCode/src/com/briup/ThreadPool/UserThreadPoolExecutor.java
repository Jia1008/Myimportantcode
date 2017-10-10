package com.briup.ThreadPool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class UserThreadPoolExecutor {
	
	public static void main(String[] args) {
		/**
		 * ��ʹ���н����ʱ�������µ�������Ҫִ�У�����̳߳�ʵ���߳���С��corePoolSize�������ȴ����߳�
		 * ������corePoolSize����Ὣ����������
		 * �����������������߳���������maxnumPoolSize��ǰ���£������µ��߳�
		 * ���߳�������maxnumPoolSize,��ִ�оܾ����ԣ��������Զ��巽ʽ
		 */
		
		ThreadPoolExecutor pool=new ThreadPoolExecutor(
				1,  		//�����߳�
				2, 			//������
				60, 		//60
				TimeUnit.SECONDS,
				new ArrayBlockingQueue<Runnable>(3)  //�н����
				//new LinkedBlockingQueue<Runnable>()    //�޽����
				//, new DiscardOldestPolicy() 
				, new MyRejected()				//�Զ���ܾ�����
				);
		
		MyTask mt1=new MyTask(1, "����1");
		MyTask mt2=new MyTask(2, "����2");
		MyTask mt3=new MyTask(3, "����3");
		MyTask mt4=new MyTask(4, "����4");
		MyTask mt5=new MyTask(5, "����5");
		//MyTask mt6=new MyTask(6, "����6");
		
		pool.execute(mt1);
		pool.execute(mt2);
		pool.execute(mt3);
		pool.execute(mt4);
		pool.execute(mt5);
		//pool.execute(mt6);
		
		pool.shutdown();//ֹͣ�̳߳�
	}
}
