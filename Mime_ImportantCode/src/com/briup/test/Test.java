package com.briup.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Test {
	public static void main(String[] args) {
		 /*List<Integer> list=new ArrayList<Integer>();  
	        list.add(1);  
	        list.add(2);  
	        list.add(3);  
	        list.add(4);  
	        list.add(5);
	        for (Integer i : list) {//这是迭代  
	            if(i==3){  
	                list.remove(new Integer(i));//引起异常的操作  
	            }  
	            System.out.println(i);
	       }  */
	        /* 
	     Iterator<Integer> iterator=list.iterator();
	     while(iterator.hasNext()){
	    	 Integer i=iterator.next();
	    	 if(i==3){
	    		 iterator.remove();
	    	 }
	     }
	     for(int i=0;i<list.size();i++){
	    	 System.out.print(list.get(i)+" ");
	     }*/
	        
	        List<String> famous = new ArrayList<String>();
	        famous.add("liudehua");
	        famous.add("madehua");
	        famous.add("liushishi");
	        famous.add("tangwei");
	       // for (String s : famous) {
	        for(int i=0;i<famous.size();i++){
	         //   if (s.equals("madehua")) {
	                famous.remove(famous.get(i));
	          //  }
	        }
	        System.out.println(famous);
	       /* ArrayList<String> list = new ArrayList<String>(Arrays.asList("a","b","c","d"));
	        for(int i=0;i<list.size();i++){
	            list.remove(i);
	        }
	        System.out.println(list);*/
	      
	}
}
