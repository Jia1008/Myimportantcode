package com.briup.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

class SerializableObject implements Serializable {  
    private static final long serialVersionUID = 1L;  
} 

class Prototype implements Cloneable,Serializable{

	private static final long serialVersionUID = 1L;
	private String string;  
	//这个是在上面声明的一个类
	private SerializableObject obj;
	
	//浅复制
	public Prototype clone(){
		Prototype prototype=null;
		try {
			prototype=(Prototype) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prototype;
	}
	
	//深复制
	public Object deepClone() throws IOException, ClassNotFoundException{
		//写入当前对象的二进制流
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		//读出二进制流产生的新对象
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return ois.readObject();
	}

	public String getString() {
		return string;
	}

	public void setString(String string) {
		this.string = string;
	}

	public SerializableObject getObj() {
		return obj;
	}

	public void setObj(SerializableObject obj) {
		this.obj = obj;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
}

class ConcretePrototype extends Prototype{  
  
	private static final long serialVersionUID = 1L;

	public void show(){  
        System.out.println("原型模式实现类");  
    }  
} 

public class PrototypeModel {
	public static void main(String[] args){
		ConcretePrototype cp = new ConcretePrototype();  
        for(int i=0; i< 10; i++){  
            ConcretePrototype clonecp;
			try {
				clonecp = (ConcretePrototype)cp.deepClone();
				  clonecp.show();  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }  
	}
}
