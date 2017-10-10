package com.briup.test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Prototypes implements Cloneable,Serializable{

	private static final long serialVersionUID = 1L;
	private String name="tom";
	//浅复制
	public Prototypes clone(){
		Prototypes prototype=null;
		try {
			prototype=(Prototypes) super.clone();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return prototype;
	}
	//深复制
	public Object deepClones() throws Exception{
		ByteArrayOutputStream bos=new ByteArrayOutputStream();
		ObjectOutputStream oos=new ObjectOutputStream(bos);
		oos.writeObject(this);
		
		ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
		ObjectInputStream ois=new ObjectInputStream(bis);
		return ois.readObject();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}

class ConcretePrototypes extends Prototypes{  
	  
	private static final long serialVersionUID = 1L;

	public void show(){  
        System.out.println("原型模式实现类"+super.clone().getName());  
    }  
} 


public class InitModel {
	public static void main(String[] args) {
		ConcretePrototypes cp = new ConcretePrototypes();  
        for(int i=0; i< 10; i++){  
            ConcretePrototypes clonecp;
			try {
				clonecp = (ConcretePrototypes) cp.clone();
				  clonecp.show();  
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
        }  
        Map<String, String> map=new ConcurrentHashMap<String, String>();
        Map<String, String> m=new HashMap<String, String>();
	}
}
