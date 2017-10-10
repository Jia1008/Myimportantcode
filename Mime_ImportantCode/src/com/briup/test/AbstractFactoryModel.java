package com.briup.test;

interface Sender{
	public void Send();
}

class MailSender implements Sender{

	@Override
	public void Send() {
		// TODO Auto-generated method stub
		System.out.println("�����ʼ���");
	}
	
}

class SmsSender implements Sender{

	@Override
	public void Send() {
		// TODO Auto-generated method stub
		System.out.println("���Ͷ���");
	}
	
}

class WX implements Sender{

	@Override
	public void Send() {
		// TODO Auto-generated method stub
		System.out.println("΢�ŷ���");
	}
	
}

interface Provider {  
    public Sender produce();  
}  

class SendWXFactory implements Provider{

	@Override
	public Sender produce() {
		// TODO Auto-generated method stub
		return new WX();
	}
	
}

class SendMailFactory implements Provider {  
    public Sender produce(){  
        return new MailSender();  
    }  
}  

public class AbstractFactoryModel {
	public static void main(String[] args) {
		Provider provider=new SendMailFactory();
		Sender sender=provider.produce();
		sender.Send();
	}
}
