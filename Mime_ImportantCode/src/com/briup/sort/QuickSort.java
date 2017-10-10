package com.briup.sort;
/**
 * 
 * @author �ȱȲ�������
 *	��������
 *���������п���һ�����飬�ѵ����λ�ÿ������ᣬ�����һ���ȣ��������С���������������κδ���
 *�������Ժ��ٺ�С���Ƕ˱ȣ�����С�������������󽻻�������ѭ��������һ��������ɣ���߾��Ǳ�����С�ģ�
 *�ұ߾��Ǳ������ģ�Ȼ�����÷��η����ֱ�������������������������
 */
public class QuickSort {
	
	public int getMiddle(int[] a,int low,int high){
		int temp=a[low];
		while(low<high){
			while(low<high&&a[high]>=temp){
				high--;
			}
			a[low]=a[high];
			while(low<high&&a[low]<=temp){
				low++;
			}
			a[high]=a[low];
		}
		a[low]=temp;
		return low;
	}
	public void quickSort(int[] a,int low,int high){
		if(low<high){
			int middle=getMiddle(a,low,high);
			quickSort(a, 0, middle-1);
			quickSort(a, middle+1, high);
		}
	}
	
	public static void main(String[] args) {
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		QuickSort qk=new QuickSort();
		qk.quickSort(a, 0, a.length-1);
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
}
