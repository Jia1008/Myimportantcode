package com.briup.mapiterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;


public class MapIterator {
	public static void mapIterator(List<Map<String, String>> list){
		for(int i=0;i<list.size();i++){
			Map<String, String> it=list.get(i);
			for (Map.Entry<String, String> e : it.entrySet()) {
				System.out.println(e.getKey()+"  "+e.getValue());
			}
		}
	}
	public static void map1Iterator(List<Map<String, String>> list){
		for(int i=0;i<list.size();i++){
			Map<String, String> map=list.get(i);
			Set<Map.Entry<String, String>> map1=map.entrySet();
			Iterator<Entry<String, String>> it=map1.iterator();
			while(it.hasNext()){
				Map.Entry<String, String> entry=it.next();
				if(entry.getKey().equals("name")){
					System.out.println(entry.getKey()+"   "+entry.getValue());
				}else if(entry.getKey().equals("passwd")){
					System.out.println(entry.getKey()+"   "+entry.getValue());
				}
			}
		}
	}
	public static void main(String[] args) {
		List<Map<String, String>> list=new ArrayList<Map<String,String>>();
		Map<String, String> map=new HashMap<String, String>();
		map.put("name", "张三");
		map.put("passwd", "123");
		list.add(map);
		Map<String, String> map1=new HashMap<String, String>();
		map1.put("name", "李四");
		map1.put("passwd", "1234");
		list.add(map1);
		Map<String, String> map2=new HashMap<String, String>();
		map2.put("name", "王五");
		map2.put("passwd", "12345");
		list.add(map2);
		map1Iterator(list);
	}
}
