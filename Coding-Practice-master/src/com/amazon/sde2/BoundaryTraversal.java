package com.amazon.sde2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class BoundaryTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode bt = new TreeNode(20);
		bt.left = new TreeNode(8);
		bt.left.left = new TreeNode(4);
		bt.left.right = new TreeNode(12);
		bt.left.right.left = new TreeNode(10);
		bt.left.right.right = new TreeNode(12);
		
		bt.right = new TreeNode(22);
		
		
		
		
		bt.right.right = new TreeNode(25);
		bt.right.right.right = new TreeNode(38);
		boundaryTraversal(bt);
	}
	
	public static void boundaryTraversal(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		Queue<TreeNode> leftQueue = new LinkedList<TreeNode>();
		Stack<TreeNode> rightStack = new Stack<TreeNode>();
		while(!queue.isEmpty()) {
			int size = queue.size();
			for(int i = 0; i < size; i++) {
				boolean added = false;
				TreeNode node = queue.poll();
				if(i == 0) {
					leftQueue.add(node);
					added = true;
				}
				
				if(i == size - 1 && !added) {
					rightStack.add(node);
					added = true;
				}
				if(node.left == null && node.right == null && !added) {
					leftQueue.add(node);
				}
				if(node.left != null) {
					queue.add(node.left);
				}
				if(node.right != null) {
					queue.add(node.right);
				}
				
			}
		}
		
		while(!leftQueue.isEmpty()) {
			System.out.print(leftQueue.poll().value + " ");
		}
		
		while(!rightStack.isEmpty()) {
			System.out.print(rightStack.pop().value + " ");
		}
	}

}
