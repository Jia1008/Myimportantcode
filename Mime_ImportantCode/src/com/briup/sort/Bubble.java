package com.briup.sort;
/**
 * 
 * @author �ȱȲ�������
 * ð������
 *��Ҫ�����һ�����У��Ե�ǰ��δ�ź���ķ�Χ�ڵ�ȫ���������϶��¶����ڵ�����������
      ���бȽϺ͵������ýϴ�������³�����С������ð������ÿ�������ڵ����ȽϺ�������
      ������������Ҫ���෴ʱ���ͽ����ǻ�����
 */
public class Bubble {
	public static void bubbleSort(){
		 int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4,62,99,98,54,56,17,18,23,34,15,35,25,53,51};
		 int temp=0;
		 for(int i=0;i<a.length-1;i++){
			 for(int j=0;j<a.length-1-i;j++){
				 if(a[j]>a[j+1]){
					 temp=a[j];
					 a[j]=a[j+1];
					 a[j+1]=temp;
				 }
			 }
		 }
		 for(int i=0;i<a.length;i++){
			 System.out.print(a[i]+" ");
		 }
	}
	public static void main(String[] args) {
		bubbleSort();
	}
}