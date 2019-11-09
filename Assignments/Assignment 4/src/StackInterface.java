/*
 * Assignment 4
 * Michael Buffone
 * November 8th, 2019
 * 
 * Interface implemented by calculator stack
 */

public interface StackInterface<T> {
	
	public boolean isEmpty();
	public void createStack();
	public void push(T item);
	public void popAll();
	public T peek();
	public T pop();

	
}