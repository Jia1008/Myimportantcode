package com.briup.mimearaylist;

public class AchieveIterator<T> implements Iterator<T>{
	private T[] arr;
	private int index;
	private ArrayList<T> arrayList;
	
	public AchieveIterator(ArrayList<T> arrayList) {
		this.arrayList = arrayList;
		arr=(T[]) arrayList.getArray();
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(arr[index]!=null){
			if(arr[index++]!=null){
				return true;
			}else{
				return false;
			}
		}else{
			return false;
		}
	}

	public T next() {
		// TODO Auto-generated method stub
		return (T) arr[index-1];
	}

}
