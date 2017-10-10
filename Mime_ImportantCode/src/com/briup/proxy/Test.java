package com.briup.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

public class Test {
	public static void main(String[] args) {
		//目标对象
		IStudentService target=new StudentServiceImpl();
		
		ClassLoader loader=target.getClass().getClassLoader();
		Class<?>[]  interfaces=target.getClass().getInterfaces();
		InvocationHandler h=new MyHandler(target);
		
		//1 目标对象的类加载器
		//2 目标对象所实现的接口
		//3 InvocationHandler接口的实现类对象
		//newProxyInstance的返回值,就是动态产生的目标对象所对应的代理对象
		IStudentService s=(IStudentService) Proxy.newProxyInstance(loader, interfaces, h);
		s.delete(1);
	}
}
