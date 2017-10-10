package com.briup.mydefineexception;

public class OwnExceptionSource {
	public void a(int b) throws OwnException{
		if(b==0){
			throw new OwnException("除数为1");
		}
		System.out.println("我有异常吗？");
	}
	
}
