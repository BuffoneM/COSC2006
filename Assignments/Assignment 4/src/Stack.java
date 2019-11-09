/*
 * Assignment 3
 * Michael Buffone
 * November 8th, 2019
 * 
 * Generic stack that can be used with any type of object
 * given that the object is comparable
 * 
 * This stack implements StackInterface and is used by InfixExpression
 * and PostfixExpression
 */
public class Stack<T> implements StackInterface<T> {
	
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
	
	
	
	@Override
	public void createStack() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void push(T item) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T pop() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void popAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public T peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
