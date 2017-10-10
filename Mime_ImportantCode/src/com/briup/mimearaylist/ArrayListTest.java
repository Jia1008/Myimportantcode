package com.briup.mimearaylist;

public class ArrayListTest {
	public static void main(String[] args) {
		ArrayList<Book> list=new ArrayList<Book>();
//		list.add("kobe");
//		list.add("zhangsan");
//		list.add("lisi");
//		list.add("wangwu");
//		list.add("qwe");
//		list.add("asd");
//		list.add(1);
//		list.add(2);
//		list.add(3);
//		list.add(4);
//		list.add(5);
//		list.remove(3);
		list.add(new Book(1, "kobe", 28f));
		list.add(new Book(2, "zhangsna", 78f));
		list.add(new Book(3, "lisi", 48f));
		list.add(new Book(4, "hemnden", 89f));
		AchieveIterator<Book> iterator=list.achieveIterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next());
		}
	}
}
