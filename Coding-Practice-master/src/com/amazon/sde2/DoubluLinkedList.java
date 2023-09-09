package com.amazon.sde2;

public class DoubluLinkedList {
	
	class Node {
		int value;
		Node next;
		Node prev;
		
		Node(int value, Node prev, Node next) {
			this.value = value;
			this.prev = prev;
			this.next = next;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DoubluLinkedList dlist = new DoubluLinkedList();
		Node n1 = dlist.new Node(1, null, null);
		Node n2 =  dlist.new Node(2, n1, null);
		n1.next = n2;
		Node n3 = dlist.new Node(3, n2, null);
		n2.next = n3;
		traverseList(n1);
		n1 = deleteNode(n1, 1);
		traverseList(n1);
	}
	
	public static void traverseList(Node head) {
		while(head != null) {
			System.out.print(head.value + " ");
			head = head.next;
		}
	}
	public static Node deleteNode(Node head, Integer x) {
		Node tempHead = head;
		if(head == null) {
			System.out.println("Head is null");
			return tempHead;
		}
		if(x == 1) {
			System.out.println("Deleting node ::: " + head.value);
			head = head.next;
			head.prev = null;
			tempHead = head;
			return tempHead;
		}
		Integer i = 1;
		Node temp = head;
		while(temp != null && i <= x) {
			if(i == x) {
				System.out.println("Deleting node ::: " + temp.value);
				temp.prev.next = temp.next;
				return tempHead;
			}
			i++;
			temp = temp.next;
		}
		System.err.println("Given index " + x + " does not exists");
		return tempHead;
	}
	
	

}
