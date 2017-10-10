package com.briup.BinTree;

import java.util.LinkedList;
import java.util.List;

public class KK {
	private int[] array={1,2,3,4,5,6,7,8,9};
	private static List<Node> nodelist=null;
	private static class Node{
		Node leftNode;
		Node rightNode;
		int data;
		public Node(int data){
			this.data=data;
		}
	}
	
	public void createNode(){
		nodelist=new LinkedList<Node>();
		for(int i=0;i<array.length;i++){
			nodelist.add(new Node(array[i]));
		}
		
		for(int j=0;j<array.length/2-1;j++){
			//×óº¢×Ó
			nodelist.get(j).leftNode=nodelist.get(j*2+1);
			//ÓÒº¢×Ó
			nodelist.get(j).rightNode=nodelist.get(j*2+2);
		}
		
		int lastparent=array.length/2-1;
		nodelist.get(lastparent).leftNode=nodelist.get(lastparent*2+1);
		if(array.length % 2 == 1){
			nodelist.get(lastparent).rightNode=nodelist.get(lastparent*2+2);
		}
	}
	
	public static void preOrderTraverse(Node node){
		if(node==null){
			return;
		}
		System.out.print(node.data+" ");
		preOrderTraverse(node.leftNode);
		preOrderTraverse(node.rightNode);
	}
	
	public static void levelTraverse(Node node){
		if(node==null){
			return;
		}
		LinkedList<Node> list=new LinkedList<KK.Node>();
		Node fnode=null;
		list.offer(node);
		while(!list.isEmpty()){
			fnode=list.poll();
			System.out.print(fnode.data+" ");
			if(fnode.leftNode!=null){
				list.offer(fnode.leftNode);
			}
			if(fnode.rightNode!=null){
				list.offer(fnode.rightNode);
			}
		}
	}
	
	
	
	public static void main(String[] args) {
		KK k=new KK();
		k.createNode();
		//k.preOrderTraverse(nodelist.get(0));
		k.levelTraverse(nodelist.get(0));
	}
}
