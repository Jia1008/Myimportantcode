package com.briup.mimearaylist;

public interface List<T> {
	public void add(T e);
	public T get(int index);
	public boolean remove(int index);
	public int size();
}
