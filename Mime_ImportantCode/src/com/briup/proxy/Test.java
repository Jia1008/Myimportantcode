package com.briup.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		//Ŀ�����
		IStudentService target=new StudentServiceImpl();
		
		ClassLoader loader=target.getClass().getClassLoader();
		Class<?>[]  interfaces=target.getClass().getInterfaces();
		InvocationHandler h=new MyHandler(target);
		
		//1 Ŀ�������������
		//2 Ŀ�������ʵ�ֵĽӿ�
		//3 InvocationHandler�ӿڵ�ʵ�������
		//newProxyInstance�ķ���ֵ,���Ƕ�̬������Ŀ���������Ӧ�Ĵ������
		IStudentService s=(IStudentService) Proxy.newProxyInstance(loader, interfaces, h);
		s.delete(1);
	}
}
