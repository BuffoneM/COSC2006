/*
 * Assignment 3
 * Michael Buffone
 * Oct 30th, 2019
 * 
 * Generic linked list that can be used with any type of object
 * given that the object is comparable
 * 
 * The addSorted, isEmpty, and print methods are used for assignment 3
 * -the other methods are implemented for code reuse
 */

public class LinkedList<T extends Comparable<T>> implements Interface<T> {
	
	// Node definition
	private class Node {
		T item;
		Node next;
		
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	private Node head;
	
	
	// ****** Linked list methods ******
	public boolean isEmpty() {
		return head == null;
	}
	
	
	// ****** Adding methods ******
	public void addFirst(T item) {
		head = new Node(item, head);
	}
	
	public void addLast(T item) {
		Node curr = head;
		Node prev = null;
		if(isEmpty()) {
			head = new Node(item, head);
			return;
		}
		
		while(curr != null) {
			prev = curr;
			curr = curr.next;
		}
		
		prev.next = new Node(item, curr);
	}
	
	public void addSorted(T item) {
		Node curr = head;
		Node prev = null;
		
		if(isEmpty() || item.compareTo(head.item) == 1) {
			head = new Node(item, head);
			return;
		}
		
		// Add the item at the correct position in the list
		// -> item has a higher value than the next node
		while(curr != null) {
		
			prev = curr;
			curr = curr.next;
			if(curr == null) {
				prev.next = new Node(item, null);
				return;
			}
			else if(item.compareTo(curr.item) == 1 || item.compareTo(curr.item) == 0) {
				prev.next = new Node(item, curr);
				return;
			}
				
		}
	}
	
	
	// ****** Deleting methods ******
	public void deleteFirst() throws ItemNotFoundException {
		if(isEmpty()) throw new ItemNotFoundException("List is empty!");
		head = head.next;
	}
	
	public void deleteLast() throws ItemNotFoundException {
		if(isEmpty()) throw new ItemNotFoundException("List is empty!");
		Node curr = head;
		Node prev = null;
		
		while(curr.next != null) {
			prev = curr;
			curr = curr.next;
		}
		
		if(prev != null) prev.next = curr.next;
		else head = curr.next;
		
	}
	
	
	// ****** Print method(s) ******
	public void print() {
		print(head);
	}
	
	private void print(Node h) {
		if(h == null) return;
		System.out.println(h.item);
		print(h.next);
	}

	
	// ****** Utility method(s) ******
	public void median() {
		int x = 0;
		x = length(head, x) / 2;
		System.out.println("...\nMedian at location (" + (x + 1) + "):\n" + locateNode(head, x));
	
	}
	
	// Calculate the length of the list
	private int length(Node h, int x) {
		if(h != null) {
			return length(h.next, ++x);
		}
		return x;
	}
	
	// Find the node in the median position
	private T locateNode(Node h, int x) {
		if(x != 0) {
			return locateNode(h.next, --x);
		}
		return h.item;
	}
	
}
