package com.briup.sort;
/**
 * 
 * @author �ȱȲ�������
 * ѡ������
 * ��Ҫ�����һ�����У�ѡ����С��һ�������һ��λ�õ���������Ȼ����ʣ�µ�����������
         ��С����ڶ���λ�õ������������ѭ���������ڶ����������һ�����Ƚ�Ϊֹ��
 */
public class Selection {
	//����һ
	public static void selectionSort(){
		 int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		 for(int i=0;i<a.length-1;i++){
			 int x=a[i];
			 int y=i;
			 for(int j=i+1;j<a.length;j++){
				 if(x>a[j]){
					 x=a[j];
					 y=j;
				 }
			 }
			 int temp=a[i];
			 a[i]=a[y];
			 a[y]=temp;
		 }
		 for(int i=0;i<a.length;i++){
			 System.out.print(a[i]+" ");
		 }
	}
	//������
	public static void selectionSort2(){
		int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		int temp=0;
		for(int i=0;i<a.length;i++){
			int x=i;
			for(int j=a.length-1;j>i;j--){
				if(a[x]>a[j]){
					x=j;
				}
			}
			temp=a[i];
			a[i]=a[x];
			a[x]=temp;
		}
		 for(int i=0;i<a.length;i++){
			 System.out.print(a[i]+" ");
		 }
	}
	
	public static void main(String[] args) {
		//selectionSort();
		selectionSort2();
	}
}
