package com.briup.sort;
/**
 * 
 * @author 迦比布莱恩特
 *	快速排序
 *把整个序列看做一个数组，把第零个位置看做中轴，和最后一个比，如果比它小交换，比它大不做任何处理；
 *交换了以后再和小的那端比，比它小不交换，比他大交换。这样循环往复，一趟排序完成，左边就是比中轴小的，
 *右边就是比中轴大的，然后再用分治法，分别对这两个独立的数组进行排序。
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
