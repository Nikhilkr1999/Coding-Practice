package com.leetcode.design;

import java.util.LinkedList;

public class StackOperation {

	
	LinkedList<Node> stack = new LinkedList<Node>();
	Node top = null;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StackOperation oper = new StackOperation();
		System.out.println("Min ::: " + oper.getMin());
		oper.push(-2);
		oper.push(0);
		oper.push(-3);
		System.out.println("Min ::: " + oper.getMin());
		oper.pop();
		System.out.println("top ::: " + oper.top());
		System.out.println("Min ::: " + oper.getMin());
	}
	
	public StackOperation() {
        
    }
    
	public void push(int val) {
    	Node n;
        if(top == null) {
        	n = new Node(val, val);
        } else {
        	int min = val < top.min ? val : top.min;
        	n = new Node(val, min);
        }
        stack.addFirst(n);
    	top = n;
    }
    
    public void pop() {
        if(stack != null && !stack.isEmpty()) {
        	stack.pop();
        	top = stack.isEmpty() ? null : stack.getFirst();
        }
    }
    
    public Integer top() {
        if(top != null) {
        	return top.val;
        }
        return null;
    }
    
    public Integer getMin() {
    	if(top != null) {
    		return top.min;
    	}else {
    		return null;
    	}
        
    }
    
    class Node {
    	int val;
    	int min;
    	public Node(int val, int min) {
    		this.val = val;
    		this.min = min;
    	}
    }

}
 