package com.briup.BinTree;

import java.util.LinkedList;
import java.util.List;

public class BinTreeTraverse2 {
	 private int[] array = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };  
	 private static List<Node> nodeList = null;  
	 //内部类：节点 
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
		//将一个数组一次转换为node节点
		for(int nodeIndex=0;nodeIndex<array.length;nodeIndex++){
			nodeList.add(new Node(array[nodeIndex]));
		}
		
		// 对前lastParentIndex-1个父节点按照父节点与孩子节点的数字关系建立二叉树  
		for(int parentIndex=0;parentIndex<array.length/2-1;parentIndex++){
			//左孩子
			nodeList.get(parentIndex).leftChild=nodeList.get(parentIndex*2+1);
			//右孩子
			nodeList.get(parentIndex).rightChild=nodeList.get(parentIndex*2+2);
		}
		 // 最后一个父节点:因为最后一个父节点可能没有右孩子，所以单独拿出来处理
		 int lastParentIndex = array.length / 2 - 1;  
	        // 左孩子  
	        nodeList.get(lastParentIndex).leftChild = nodeList  
	                .get(lastParentIndex * 2 + 1);  
	        // 右孩子,如果数组的长度为奇数才建立右孩子  
	        if (array.length % 2 == 1) {  
	            nodeList.get(lastParentIndex).rightChild = nodeList  
	                    .get(lastParentIndex * 2 + 2);  
	        }  
	}
	
	/**
	 * 先序遍历
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
	 * 中序遍历
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
	 * 后序遍历
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
	 * 层序遍历
	 * @param args
	 */
	public static void levelOrderTraverse(Node node){
		if(node==null)
			return;
		LinkedList<Node> queue=new LinkedList<Node>();
		Node fnode=null;
		queue.offer(node);//加入到尾节点
		while(!queue.isEmpty()){
			fnode=queue.poll();//移除头结点
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
	        // nodeList中第0个索引处的值即为根节点  
	        Node root = nodeList.get(0);  
	        System.out.println(root.data);
	        System.out.println("先序遍历：");  
	        //preOrderTraverse(root);  
	        //inOrderTraverse(root);
	       // postOrderTraverse(root);
	        levelOrderTraverse(root);
	        System.out.println();  
	}
}
