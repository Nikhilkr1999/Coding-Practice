package com.amazon.sde2;

public class BiggestBSTInBTree {
	static Integer max = Integer.MIN_VALUE;
	static TreeNodeExtended bst = null;
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BiggestBSTInBTree bt = new BiggestBSTInBTree();
		TreeNodeExtended node1 = bt.new TreeNodeExtended(1);
		node1.left = bt.new TreeNodeExtended(14);
		node1.left.left = bt.new TreeNodeExtended(9);
		node1.left.right = bt.new TreeNodeExtended(16);
		
		node1.right = bt.new TreeNodeExtended(3);
		node1.right.left = bt.new TreeNodeExtended(2);
		node1.right.right = bt.new TreeNodeExtended(5);
		node1.right.right.left = bt.new TreeNodeExtended(8);
		node1.right.right.right = bt.new TreeNodeExtended(7);
		node1.right.right.right.right = bt.new TreeNodeExtended(10);
		node1.right.right.right.right.right = bt.new TreeNodeExtended(15);
		node1.right.right.right.right.right.right = bt.new TreeNodeExtended(18);
		getBiggestBST(node1);
		System.out.println(max);
		System.out.println(bst.value);
		
	}
	
	class TreeNodeExtended{
		int value;
		TreeNodeExtended left;
		TreeNodeExtended right;
		int total;
		public TreeNodeExtended(int value) {
			this.value = value;
		}
	}
	
	public static void getBiggestBST(TreeNodeExtended root) {
		if(root == null) {
			return;
		}
		
		getBiggestBST(root.left);
		getBiggestBST(root.right);
		int total = 0;
		int isBST = 0;
		if(root.left != null ) {
			if(root.value > root.left.value) {
				total += root.left.total;
				isBST++;
			}
			
		} else {
			isBST++;
		}
		
		if(root.right != null ) {
			if(root.value < root.right.value) {
				total += root.right.total ;
				isBST++;
			}
			
		} else {
			isBST++;
		}
		if(isBST == 2) {
			root.total = total + 1;
			if(root.total > max) {
				max = root.total;
				bst = root;
			}
		}
		
	}

}
