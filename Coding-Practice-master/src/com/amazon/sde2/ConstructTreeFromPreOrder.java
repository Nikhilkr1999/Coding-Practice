package com.amazon.sde2;

public class ConstructTreeFromPreOrder {

	static TreeNode root = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] arr = new Integer[] {10,30,20,5,15};
		char[] leafArr = new char[] {'N', 'N', 'L', 'L', 'L'};
		constructTree(arr, leafArr, 0);
		root.inOrder(root);
		
		
	}
	static int index = 1;

	/*
	 * public static void constructTree(int[] valArr, char[] leafArr, int index,
	 * TreeNode root, boolean isLeft) { System.out.println(index + " " +
	 * root.value); try { Thread.sleep(500); } catch (InterruptedException e) { //
	 * TODO Auto-generated catch block e.printStackTrace(); } if(index <
	 * valArr.length) { if(root.left == null) { TreeNode node = new
	 * TreeNode(valArr[index]); root.left = node; root = root.left; } else {
	 * TreeNode node = new TreeNode(valArr[index]); root.right = node; root =
	 * root.right; } constructTree(valArr, leafArr, index+1, root, isLeft);
	 * if(leafArr[index] != 'L') {
	 * 
	 * } else { root.left = null; root.right = null; } }
	 * 
	 * }
	 */
	public static void constructTree(Integer[] valArr, char[] leafArr, int index) {
		if(index < valArr.length) {
			if(index == 0 && valArr[index] != null) {
				root = new TreeNode(valArr[index]);
			}
			constructTree(valArr, leafArr, index+1);
			
			if(root.left == null) {
				root.left = new TreeNode(valArr[index]);
				root = root.left;
			} else {
				root.right = new TreeNode(valArr[index]);
				root = root.right;
			}
			
			if(leafArr[index] == 'L') {
				
				//return;
			}
			
			System.out.println(root.value);
		}
		
		
	}

}
