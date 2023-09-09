package com.amazon.sde2;

import java.util.ArrayList;
import java.util.List;

public class BTreeMatrix {

	static int height = 0;
	static List<List<String>> arr = new ArrayList<List<String>>();
	public static void main(String[] args) {
		TreeNode bt = new TreeNode(1);
		bt.left = new TreeNode(2);
		bt.right = new TreeNode(5);
		
		bt.left.left = new TreeNode(3);
		//bt.left.right = new TreeNode(4);
		
		//bt.right.left = new TreeNode(8);
		//bt.right.right = new TreeNode(6);
		//bt.right.right.right = new TreeNode(9);
		
		bt.left.left.left = new TreeNode(4);
		getHeight(bt, 0);
		System.out.println(height);
		initializeArr();
		populateTreeArray(bt, 0, (int)Math.pow(2, height) - 1);
		System.out.println(arr);
	}
	public static void getHeight(TreeNode root, int count) {
		if(root == null) {
			return ;
		}
		
		getHeight(root.left, count + 1);
		getHeight(root.right, count+1);
		if(count > height) {
			height = count;
		}
	}
	
	public static void initializeArr() {
		
		int row = (int)Math.pow(2, height + 1);
		for(int i = 0; i < height + 1; i++) {
			arr.add(i, new ArrayList<String>());
			for(int j = 0; j < row; j++) {
				arr.get(i).add(j, "");
			}
		}
	}
	
	
	public static void populateTreeArray(TreeNode root, int row, int col) {
		if(root == null) {
			return;
		}
		
		//set the value of the node at arr[row][col] index
		arr.get(row).set(col, root.value.toString());
		
		//calculate the left and right move from the node to below row. Height will be 
		int move = (int) Math.pow(2, height-(row+1));
		
		populateTreeArray(root.left, row+1, col - move);
		populateTreeArray(root.right, row + 1, col + move);
	}

}
