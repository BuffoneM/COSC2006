/*
 * Assignment 3
 * Michael Buffone
 * Oct 30th, 2019
 * 
 * Interface implemented by linked list
 */

public interface Interface<T> {

	public boolean isEmpty();
	public void addFirst(T item);
	public void addLast(T item);	
	public void addSorted(T item);	
	public void deleteFirst();	
	public void deleteLast();	
	public void print();
	public void median();
	
}
