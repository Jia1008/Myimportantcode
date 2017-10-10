package com.briup.mapiterator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class SetIterator {
	
	public static void main(String[] args) {
		Set<String> set = new HashSet<String>();  
		set.add("tom");
		set.add("alias");
		set.add("kobe");
		set.add("tom");
		Iterator<String> it = set.iterator();  
		while (it.hasNext()) {  
		  String str = it.next();  
		  System.out.println(str);  
		}  
	}
}
