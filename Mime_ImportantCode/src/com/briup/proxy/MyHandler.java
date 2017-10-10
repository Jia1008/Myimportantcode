package com.briup.proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;


public class MyHandler implements InvocationHandler{
	private StudentLogger logger = new StudentLogger();
	private Object target;
	
	public MyHandler(Object target) {
		this.target=target;
	}
	
	
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		logger.log(method.getName()+"÷¥––¡À");
		Object value=method.invoke(target, args);
		return value;
	}

}
