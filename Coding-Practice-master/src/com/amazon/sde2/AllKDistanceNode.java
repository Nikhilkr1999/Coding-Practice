package com.amazon.sde2;

public class AllKDistanceNode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		TreeNode bt = new TreeNode(1);
		bt.left = new TreeNode(2);
		bt.right = new TreeNode(5);
		
		bt.left.left = new TreeNode(4);
		bt.left.right = new TreeNode(3);
		
		bt.right.left = new TreeNode(8);
		bt.right.right = new TreeNode(6);
		int k = 2;
		getKDistanceNode(bt, 0, k);
	}
	
	public static void getKDistanceNode(TreeNode root, int distance, int k) {
		if(root == null) {
			return;
		}
		
		
		
		getKDistanceNode(root.left, distance+1, k);
		if(distance == k) {
			System.out.println(root.value);
		}
		getKDistanceNode(root.right, distance+1, k);
	}

}
