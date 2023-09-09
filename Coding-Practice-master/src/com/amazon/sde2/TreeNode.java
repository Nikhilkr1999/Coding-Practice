package com.amazon.sde2;

class TreeNode {
	Integer value;
	TreeNode left;
	TreeNode right;
	boolean visited = false;
	int depth = 1;
	int weight = 0;
	
	TreeNode(Integer value){
		this.value = value;
		this.left = null;
		this.right = null;
	}
	
	public void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}

}