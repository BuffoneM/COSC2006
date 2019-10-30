/*
 * Assignment 3
 * Michael Buffone
 * Generic linked list that can be used with any type of object
 * given that the object is comparable
 */
public class LinkedList<T extends Comparable<T>> {
	
	private class Node {
		T item;
		Node next;
		
		public Node(T item, Node next) {
			this.item = item;
			this.next = next;
		}
	}
	
	private Node head;
	
	public boolean isEmpty() {
		return head == null;
	}
	
	public void addFirst(T item) {
		head = new Node(item, head);
	}
	
	public void deleteFirst() throws ItemNotFoundException {
		if(isEmpty()) throw new ItemNotFoundException("List is empty!");
		head = head.next;
	}
	
	public void addLast(T item) {
		Node curr = head;
		Node prev = null;
		if(isEmpty()) head = new Node(item, head);
		
		while(curr != null) {
			prev = curr;
			curr = curr.next;
		}
		
		prev.next = new Node(item, curr);
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
	
	public void print() {
		print(head);
		
	}
	private void print(Node h) {
		if(h == null) return;
		System.out.println(h.toString());
		print(h.next);
	}

}
