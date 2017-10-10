package com.briup.sort;
/**
 * 
 * @author 迦比布莱恩特
 *	插入排序
 * 排序过程的某一中间时刻，R被划分成两个子区间R[1．．i-1]（已排好序的有序区）和
R[i．．n]（当前未排序的部分，可称无序区）。
插入排序的基本操作是将当前无序区的第1个记录R[i]插人到有序区R[1．．i-1]中适当的
位置上，使R[1．．i]变为新的有序区。因为这种方法每次使有序区增加1个记录，通常称增量法。
插入排序与打扑克时整理手上的牌非常类似。摸来的第1张牌无须整理，此后每次从桌上的
牌(无序区)中摸最上面的1张并插入左手的牌(有序区)中正确的位置上。为了找到这个正确
的位置，须自左向右(或自右向左)将摸来的牌与左手中已有的牌逐一比较。
 */
public class Insertion {
	public static void insertionSort(){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		for(int i=0;i<a.length;i++){
			int indexValue=a[i];
			int index=i;
			while(index>0&&(indexValue<a[index-1])){
				a[index]=a[index-1];
				index--;
			}
			a[index]=indexValue;
		}
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i]+" ");
		}
	}
	
	public static void main(String[] args) {
		insertionSort();
	}
}
