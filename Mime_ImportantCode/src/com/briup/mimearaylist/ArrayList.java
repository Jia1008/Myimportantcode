package com.briup.mimearaylist;

public class ArrayList<T> implements List<T>{
	
	public T[] arr;
	int count=0;
	public ArrayList(){
		arr=(T[]) new Object [10];
	}
	public ArrayList(int length){
		arr=(T[]) new Object [length];
	}
	//判断容量，扩容
	private void ensureCapacity(){
		if(count>=arr.length){
			T[] array=(T[]) new Object [count+10];
			System.arraycopy(arr, 0, array, 0, arr.length);
			arr=array;
		}
	}

	@Override
	public void add(T e) {
		// TODO Auto-generated method stub
		ensureCapacity();
		arr[count]=e;
		count++;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		return arr[index];
	}

	@Override
	public boolean remove(int index) {
		// TODO Auto-generated method stub
		if(index<0||index>=count){
			System.out.println("输入数据不合法");
			return false;
		}else{
			//String x=arr[index-1];
			for(int i=index;i<count;i++){
				arr[i-1]=arr[i];
			}
			count--;
			arr[count]=null;
		}
		return true;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub
		return count;
	}
	
	public T[] getArray(){
		return arr;
	}
	public AchieveIterator achieveIterator()
	{
		return new AchieveIterator(this);
	}
	
}
