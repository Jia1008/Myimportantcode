package com.briup.mydefineexception;

public class OwnExceptionHandler {
	public static void main(String[] args) {
		OwnExceptionSource os=new OwnExceptionSource();
		try {
			os.a(0);
		} catch (OwnException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
