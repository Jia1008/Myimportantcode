package com.briup.test;

interface Handler{
	public void operator();
}

class MyHandler implements Handler{

	private String name;  
    private Handler handler; 
	
    public MyHandler(String name){
    	this.name=name;
    }
    
	public Handler getHandler() {
		return handler;
	}

	public void setHandler(Handler handler) {
		this.handler = handler;
	}

	@Override
	public void operator() {
		// TODO Auto-generated method stub
		 System.out.println("name = "+name);  
        if(getHandler()!=null){  
            getHandler().operator();  
        }  
	}
	
}

public class ZerenLianModel {
	public static void main(String[] args) {
		 MyHandler h1 = new MyHandler("h1");  
	        MyHandler h2 = new MyHandler("h2");  
	        MyHandler h3 = new MyHandler("h3");  
	  
	        h1.setHandler(h2);  
	        h2.setHandler(h3);  
	  
	        h1.operator();  
	}
}
