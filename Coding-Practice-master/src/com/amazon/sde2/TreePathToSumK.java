package com.amazon.sde2;

import java.util.ArrayList;
import java.util.Vector;

public class TreePathToSumK {

	static ArrayList<Integer> arr = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode bt = new TreeNode(1);
		bt.left = new TreeNode(2);
		bt.right = new TreeNode(5);
		
		bt.left.left = new TreeNode(4);
		bt.left.right = new TreeNode(3);
		
		bt.right.left = new TreeNode(8);
		bt.right.right = new TreeNode(6);
		
		int k = 8, sum = 0;
		//getPathToKSum(bt, sum, k);
		ArrayList<Integer> arr= new ArrayList<Integer>();
		paths(bt, arr, k, sum);
		System.out.println(arr);
		

	}
	
	public static void paths(TreeNode root,ArrayList<Integer> l,int k,int sum){
	       
	       if(root==null)
	    	   return;
	       
	      
	       
	       paths(root.left,l,k,sum);
	       l.add(root.value);
	       sum+=root.value;
	       System.out.println(sum);
	       if(sum==k){
	           
	               for(int i=0;i<l.size();i++)
	               System.out.print(l.get(i)+" ");
	               
	               System.out.println();
	           
	           
	       }
	       paths(root.right,l,k,sum);
	       sum -= root.value;
	       l.remove(root.value);
	    }
	
	static void printKPath(TreeNode root, int k) 
	{ 
	    path = new Vector<Integer>();
	    printKPathUtil(root, k); 
	} 
	static void printVector( Vector<Integer> v, int i) 
	{ 
	    for (int j = i; j < v.size(); j++) 
	        System.out.print( v.get(j) + " "); 
	        System.out.println(); 
	} 
	
	
	
	static Vector<Integer> path = new Vector<Integer>();
	  
	// This function prints all paths that have sum k 
	static void printKPathUtil(TreeNode root, int k) 
	{ 
	    // empty node 
	    if (root == null) 
	        return; 
	  
	    // add current node to the path 
	    path.add(root.value); 
	  
	    // check if there's any k sum path 
	    // in the left sub-tree. 
	    printKPathUtil(root.left, k); 
	  
	    // check if there's any k sum path 
	    // in the right sub-tree. 
	    printKPathUtil(root.right, k); 
	  
	    // check if there's any k sum path that 
	    // terminates at this node 
	    // Traverse the entire path as 
	    // there can be negative elements too 
	    int f = 0; 
	    for (int j = path.size() - 1; j >= 0; j--) 
	    { 
	        f += path.get(j); 
	  
	        // If path sum is k, print the path 
	        if (f == k) 
	            printVector(path, j); 
	    } 
	  
	    // Remove the current element from the path 
	    path.remove(path.size() - 1); 
	} 
	
	public static  void getPathToKSum(TreeNode t, int sum, int k) {
		if(t == null) {
			return;
		}
		
		arr.add(t.value);
		getPathToKSum(t.left, sum, k);
		System.out.println(arr);
		getPathToKSum(t.right, sum, k);
		int sumKK = 0;
		for(int i = arr.size() - 1; i >= 0; i--) {
			sumKK += arr.get(i);
			if(sumKK == k) {
				System.out.println("arr ::: " + arr);
				
				System.out.println(arr.subList(i, arr.size()));
				break;
			} 
		}
		if(sumKK > k)
			arr.remove(arr.size() - 1);
		
		
	}

}
