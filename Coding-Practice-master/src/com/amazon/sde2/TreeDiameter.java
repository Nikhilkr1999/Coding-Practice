package com.amazon.sde2;

public class TreeDiameter {

	static int max = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeDiameter t = new TreeDiameter();
		TreeNodeExtended bt = t.new TreeNodeExtended(1, 0, 0);
		bt.left = t.new TreeNodeExtended(2, 0 ,0);
		bt.right = t.new TreeNodeExtended(5, 0 ,0);
		
		bt.left.left = t.new TreeNodeExtended(4, 0 ,0);
		bt.left.right = t.new TreeNodeExtended(3, 0 , 0);
		bt.left.left.right = t.new TreeNodeExtended(9, 0 ,0);
		
		bt.right.left = t.new TreeNodeExtended(8, 0 ,0 );
		bt.right.right = t.new TreeNodeExtended(6, 0 ,0);
		getDiameter(bt);
		System.out.println(max);

	}
	
	class TreeNodeExtended extends TreeNode {
		int leftCount;
		int rightCount;
		int total;
		
		public TreeNodeExtended(int value, int left, int right) {
			super(value);
			this.leftCount = left;
			this.rightCount = right;
		}
	}
	public static int  getDiameter(TreeNodeExtended root) {
		if(root == null) {
			return 0;
		}
		
		root.leftCount =  getDiameter((TreeNodeExtended)root.left);
		root.rightCount = getDiameter((TreeNodeExtended)root.right);
		TreeNodeExtended rootNode = (TreeNodeExtended) root;
		int left = 0;
		int right = 0;
		if(root.left != null) {
			left = ((TreeNodeExtended)root.left).total;
		}
		
		if(root.right != null) {
			right = ((TreeNodeExtended)root.right).total;
		}
		rootNode.total = left + right + 1;
		System.out.println(max);
		if(rootNode.total > max) {
			max = rootNode.total;
			return max;
		} else {
			rootNode.total = left > right ? left + 1: right + 1;
			return rootNode.total;
		}
		 
	}

}
 