package com.briup.BinTree;

import java.util.LinkedList;
import java.util.List;


public class Test {
	private int[] array={1,2,3,4,5,6,7,8,9};
	private static List<Node> nodelist=null;
	
	static class Node{
		Node leftNode;
		Node rightNode;
		int data;
		public Node(int x){
			leftNode=null;
			rightNode=null;
			data=x;
		}
	}
	
	public void createNode(){
		nodelist=new LinkedList<Node>();
		for (int i = 0; i < array.length; i++) {
			nodelist.add(new Node(array[i]));
		}
		
		for(int j=0;j<array.length/2-1;j++){
			nodelist.get(j).leftNode=nodelist.get(j*2+1);
			nodelist.get(j).rightNode=nodelist.get(j*2+2);
		}
		int lastparent=array.length/2-1;
		nodelist.get(lastparent).leftNode=nodelist.get(lastparent*2+1);
		if(array.length%2==1){
			nodelist.get(lastparent).rightNode=nodelist.get(lastparent*2+2);
		}
	}
	
	public static void pre(Node node){
		if(node==null)
			return;
		System.out.print(node.data+" ");
		pre(node.leftNode);
		pre(node.rightNode);
	}
	/**
	 * 层序遍历
	 * @param args
	 */
	public static void level(Node node){
		if(node==null){
			return;
		}
		LinkedList<Node> list=new LinkedList<Test.Node>();
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
		 Test t=new Test();
		 t.createNode();
	        // nodeList中第0个索引处的值即为根节点  
	        Node root = nodelist.get(0);  
	        System.out.println(root.data);
	        /*System.out.println("先序遍历：");  
	        pre(root); */ 
	        System.out.println("层序遍历");
	        level(root);
	}
	
}
