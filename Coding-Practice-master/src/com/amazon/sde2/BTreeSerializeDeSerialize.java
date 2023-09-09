package com.amazon.sde2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BTreeSerializeDeSerialize {

	
	 
	public static void main(String[] args) {
		Integer[] arr = new Integer[30];
		System.out.println("array size ::: " + arr.length);
		arr[0] = 0;
		// TODO Auto-generated method stub
		TreeNode bt = new TreeNode(1);
		bt.left = new TreeNode(2);
		bt.right = new TreeNode(5);
		
		bt.left.left = new TreeNode(4);
		bt.left.right = new TreeNode(3);
		
		bt.right.left = new TreeNode(8);
		bt.right.right = new TreeNode(6);
		serialize(bt, 1, arr);
		System.out.println(Arrays.deepToString(arr));
		TreeNode t = new TreeNode(arr[1]);
		deSerialize(arr, 1, t);
		System.out.println("Going to do inorder...");
		inOrder(t);
	}
	
	public static void serialize(TreeNode root, Integer index, Integer[] arr) {
		if(root == null) {
			System.out.println("null");
			arr[index] = (Integer) null;
			return;
		}
		
		arr[index] = root.value;
		serialize(root.left, index*2, arr);
		serialize(root.right, index*2 + 1, arr);
	}
	
	public static void deSerialize(Integer[] arr, int index, TreeNode root) {
		//System.out.println("Index ::: " + index + "  arr [i] ::: " + arr[index] );
		if(arr[index] == null) {
			if(index % 2 == 0) {
				root.left = null;
			}
			
			if(index % 2 != 0) {
				root.right = null;
			}
			return;
		}
		
		
		
		
		
		
		if(index % 2 == 0) {
			root.left = new TreeNode(arr[index]);
			root = root.left;
		}
		
		if(index % 2 != 0) {
			root.right = new TreeNode(arr[index]);
			root = root.right;
		}
		deSerialize(arr, index * 2, root);
		deSerialize(arr, index * 2 + 1, root);
		
	}
	
	public static void inOrder(TreeNode root) {
		if(root == null) {
			return;
		}
		
		inOrder(root.left);
		System.out.println(root.value);
		inOrder(root.right);
	}

}
