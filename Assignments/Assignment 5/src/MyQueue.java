/*
 *	Assignment 5
 * 	Michael Buffone
 * 	November 26th, 2019
 * 
 * 	Queue class implements IntegerQueue and is used by TestProgram
 */

public class MyQueue implements IntegerQueue {
	
	// ****** Node definition ******
	private class Node {
		Integer item;
		Node next;
				
	public Node(Integer item) {
			this.item = item;
			next = null;
		}
	}
	
	// Queue variables
	private Node back, front;
	private int size;
	
	public MyQueue() {
		back = null;
		front = back;
		size = 0;
	}
	
	// ****** Utility functions ******
	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean isEmpty() {
		return front == null && back == null;
	}

	@Override
	public Integer first() throws EmptyStructureException {
		if(!isEmpty()) return front.item;
		else throw new EmptyStructureException("First: Queue is empty");
	}

	@Override
	public Integer dequeue() throws EmptyStructureException {
		if(!isEmpty()) {
			Integer current = front.item;
			if(front == back) {
				back = null;
				front = back;
			}
			else {
				front = front.next;
			}
			size = size - 1;
			return current;
		}
		else throw new EmptyStructureException("Dequeue: Queue is empty");
	}

	@Override
	public void enqueue(Integer N) {
		Node add = new Node(N);
		if(!isEmpty()) {
			back.next = add;
			back = add;
		}
		else {
			back = add;
			front = back;
		}
		size = size + 1;
	}
	
	public void print() {
		Node backup = front;
		while(front != null) {
			System.out.print(front.item + " ");
			front = front.next;
		}
		System.out.println("\nPrint done...");
		front = backup;
	}
	
	public void sort() {
		
	}

}
