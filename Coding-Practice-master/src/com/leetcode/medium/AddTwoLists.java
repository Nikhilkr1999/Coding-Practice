package com.leetcode.medium;

public class AddTwoLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		if(l1 == null && l2 == null) {
			return null;
		}
		if(l1 == null && l2 != null) {
			return l2;
		}
		if(l1 != null && l2 == null) {
			return l1;
		}
		
		ListNode result = new ListNode();
		ListNode finalResult = result;
		int extra = 0;
		while(l1 != null && l2 != null) {
			
			int sum = l1.val + l2.val;
			sum = sum + extra;
			if(sum >= 10) {
				extra = sum/10;
				sum = sum % 10;
			} else {
				extra = 0;
			}
			result.next = new ListNode(sum);
			result = result.next;
			l1 = l1.next;
			l2 = l2.next;
					
		}
		while(l1 != null) {
			int sum = l1.val + extra;
			if(sum >= 10) {
				extra = sum/10;
				sum = sum % 10;
			}else {
				extra = 0;
			}
			result.next = new ListNode(sum);
			result = result.next;
			l1 = l1.next;
		}
		
		while(l2 != null) {
			int sum = l2.val + extra;
			if(sum >= 10) {
				extra = sum/10;
				sum = sum % 10;
			}else {
				extra = 0;
			}
			result.next = new ListNode(sum);
			result = result.next;
			l2 = l2.next;
		}
		if(extra != 0) {
			result.next = new ListNode(extra);
			result = result.next;
		}
		return finalResult.next;
    }
	
	public class ListNode {
	      int val;
	      ListNode next;
	      ListNode() {}//this.val = 101;}
	      ListNode(int val) { this.val = val; }
	      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	  }

}
