package com.briup.mydefineexception;

public class OwnExceptionSource {
	public void a(int b) throws OwnException{
		if(b==0){
			throw new OwnException("����Ϊ1");
		}
		System.out.println("�����쳣��");
	}
	
}
