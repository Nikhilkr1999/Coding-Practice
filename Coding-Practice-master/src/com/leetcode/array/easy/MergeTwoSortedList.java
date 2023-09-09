package com.leetcode.array.easy;

public class MergeTwoSortedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MergeTwoSortedList obj = new MergeTwoSortedList();
		ListNode l1 = obj.new ListNode();
		
		  l1.next = obj.new ListNode(2); l1.next.next = obj.new ListNode(4);
		 
		
		ListNode l2 = obj.new ListNode();
		
		  l2.next = obj.new ListNode(3); l2.next.next = obj.new ListNode(4);
		 
		ListNode res = obj.mergeTwoLists(l1, l2);
		while(res != null) {
			System.out.println("KK ::: " + res.val);
			res = res.next;
		}
	}

	public  ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode node = null;
        ListNode temp = node;
        if(l1 == null && l2 == null) {
        	return node;
        }
        if(l1 == null && l2 != null) {
        	return l2;
        }
        if(l1 != null && l2 == null) {
        	return l1;
        }
        
        while(l1 != null && l2 != null) {
        	if(node == null) {
        		node = new ListNode();
        	}
        	if(temp == null) {
        		temp = node;
        	}
        	if(l1.val == 101 && l2.val == 101) {
    			l1 = l1.next;
    			l2 = l2.next;
    		} else
        	if(l2.val > l1.val) {
        		node.next = new ListNode(l1.val);
        		node = node.next;
        		l1 = l1.next;
        	} else if(l1.val > l2.val){
        		
        		node.next = new ListNode(l2.val);
        		node = node.next;
        		l2 = l2.next;
        	} else {
        		
	        		node.next = new ListNode(l1.val);
	        		l1 = l1.next;
	        		node = node.next;
	        		node.next = new ListNode(l2.val);
	        		l2 = l2.next;
	        		node = node.next;
        		
        	}
        }
        
        while(l1 != null ) {
        	node.next = new ListNode(l1.val);
    		l1 = l1.next;
    		node = node.next;
        }
        while(l2 != null) {
        	node.next = new ListNode(l2.val);
    		l2 = l2.next;
    		node = node.next;
        }
    
        return temp != null && temp.next != null ? temp.next : temp;
    }
	
	
	
	  public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}//this.val = 101;}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }
	 
}
