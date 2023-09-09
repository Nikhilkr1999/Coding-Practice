package com.amazon.sde2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

public class LowestCommonRoot {
	static boolean isFound;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode bt = new TreeNode(1);
		bt.left = new TreeNode(2);
		bt.right = new TreeNode(5);
		
		bt.left.left = new TreeNode(4);
		bt.left.right = new TreeNode(3);
		
		bt.right.left = new TreeNode(8);
		bt.right.right = new TreeNode(6);
		ArrayList<Integer> firstArr = new ArrayList<Integer>();
		ArrayList<Integer> secondArr = new ArrayList<Integer>();
		isFound = false;
		preOrder(bt, 3, firstArr);
		isFound = false;
		System.out.println("=============================================");
		preOrder(bt, 6, secondArr);
		int latestRoot = -1;
	
		System.out.println(firstArr);
		System.out.println("=============================================");
		System.out.println(secondArr);
		
		for(int i = 0 ; i < firstArr.size() && i < secondArr.size(); i++) {
			
		}
		System.out.println("No common Ancestor ::: " + latestRoot);
	}
	
	public static void preOrder(TreeNode root, Integer k, ArrayList<Integer> set) {
		if(root == null) {
			
			return;
		}
		
		//System.out.println("Root val ::: " + root.value + " ::: " + k + " ::: "+ isFound);
		
		if(root.value == k) {
			System.out.println(set);
			
			isFound = true;
			return;
		}
		
		set.add(root.value);
		if(!isFound) {
			//if(root.left != null)
				preOrder(root.left, k, set);
		}
		if(!isFound) {
			//if(root.right != null)
				preOrder(root.right, k, set);
		}
		System.out.println("root val :: " + root.value);
		set.remove(root.value);
		
	}

}
