package com.briup.BinTree;

import java.util.LinkedList;
import java.util.List;

public class BinTreeTraverse2 {
	 private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
	 private static List<Node> nodeList = null;  
	 //�ڲ��ࣺ�ڵ� 
	 private static class Node {  
        Node leftChild;  
        Node rightChild;  
        int data;  
  
        public Node(int newData) {  
            leftChild = null;  
            rightChild = null;  
            data = newData;  
        }  
    }  
	 
	public void createBinTree(){
		nodeList=new LinkedList<Node>();
		//��һ������һ��ת��Ϊnode�ڵ�
		for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
			nodeList.add(new Node(array[nodeIndex]));
		}
		
		// ��ǰlastParentIndex-1�����ڵ㰴�ո��ڵ��뺢�ӽڵ�����ֹ�ϵ����������  
		for(int parentIndex=0;parentIndex<array.length/2-1;parentIndex++){
			//����
			nodeList.get(parentIndex).leftChild=nodeList.get(parentIndex*2+1);
			//�Һ���
			nodeList.get(parentIndex).rightChild=nodeList.get(parentIndex*2+2);
		}
		 // ���һ�����ڵ�:��Ϊ���һ�����ڵ����û���Һ��ӣ����Ե����ó�������
		 int lastParentIndex = array.length / 2 - 1;  
	        // ����  
	        nodeList.get(lastParentIndex).leftChild = nodeList  
	                .get(lastParentIndex * 2 + 1);  
	        // �Һ���,�������ĳ���Ϊ�����Ž����Һ���  
	        if (array.length % 2 == 1) {  
	            nodeList.get(lastParentIndex).rightChild = nodeList  
	                    .get(lastParentIndex * 2 + 2);  
	        }  
	}
	
	/**
	 * �������
	 */
	public static void preOrderTraverse(Node node){
		if(node==null){
			return;
		}
		System.out.print(node.data+" ");
		preOrderTraverse(node.leftChild);
		preOrderTraverse(node.rightChild);
	}
	/**
	 * �������
	 * @param args
	 */
	public static void inOrderTraverse(Node node){
		if(node==null)
			return;
		inOrderTraverse(node.leftChild);
		System.out.print(node.data+" ");
		inOrderTraverse(node.rightChild);
	}
	/**
	 * �������
	 * @param args
	 */
	public static void postOrderTraverse(Node node){
		if(node==null)
			return;
		postOrderTraverse(node.leftChild);
		postOrderTraverse(node.rightChild);
		System.out.print(node.data+" ");
	}
	
	/**
	 * �������
	 * @param args
	 */
	public static void levelOrderTraverse(Node node){
		if(node==null)
			return;
		LinkedList<Node> queue=new LinkedList<Node>();
		Node fnode=null;
		queue.offer(node);//���뵽β�ڵ�
		while(!queue.isEmpty()){
			fnode=queue.poll();//�Ƴ�ͷ���
			System.out.print(fnode.data+" ");
			if(fnode.leftChild!=null){
				queue.offer(fnode.leftChild);
			}
			if(fnode.rightChild!=null){
				queue.offer(fnode.rightChild);
			}
		}
	}
	
	public static void main(String[] args) {
		 BinTreeTraverse2 binTree = new BinTreeTraverse2();  
	        binTree.createBinTree();  
	        // nodeList�е�0����������ֵ��Ϊ���ڵ�  
	        Node root = nodeList.get(0);  
	        System.out.println(root.data);
	        System.out.println("���������");  
	        //preOrderTraverse(root);  
	        //inOrderTraverse(root);
	       // postOrderTraverse(root);
	        levelOrderTraverse(root);
	        System.out.println();  
	}
}
