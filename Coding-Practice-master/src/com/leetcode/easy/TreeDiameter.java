package com.leetcode.easy;

public class TreeDiameter {

	private int maxDiameter = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeDiameter t = new TreeDiameter();
		TreeNodeExtended bt = t.new TreeNodeExtended(1);
		//bt.left = t.new TreeNodeExtended(2);
		bt.right = t.new TreeNodeExtended(5);
		/*
		 * bt.right = t.new TreeNodeExtended(5);
		 * 
		 * bt.left.left = t.new TreeNodeExtended(4); bt.left.right = t.new
		 * TreeNodeExtended(3); bt.left.left.right = t.new TreeNodeExtended(9);
		 * 
		 * bt.right.left = t.new TreeNodeExtended(8); bt.right.right = t.new
		 * TreeNodeExtended(6); bt.right.right.right = t.new TreeNodeExtended(6);
		 */
		
		t.diameterOfBinaryTree(bt);
		System.out.println(t.maxDiameter);
	}
	
	 public int diameterOfBinaryTree(TreeNodeExtended root) {
	 
		 if(root == null) {
			 return 0;
		 }
		 int leftDiameter = diameterOfBinaryTree(root.left);
		 int rightDiameter = diameterOfBinaryTree(root.right);
		 int diameter = leftDiameter + rightDiameter;
		 if(diameter > maxDiameter) {
			 maxDiameter = diameter;
		 }
		 root.diameter = diameter;
		 return leftDiameter > rightDiameter ? leftDiameter + 1: rightDiameter + 1;
	 }
	

	class TreeNodeExtended {
		Integer value;
		TreeNodeExtended left;
		TreeNodeExtended right;
		int diameter;
		
		TreeNodeExtended(Integer value){
			this.value = value;
			this.left = null;
			this.right = null;
		}
	}
}
