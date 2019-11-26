/*
 *	Assignment 5
 * 	Michael Buffone
 * 	November 26th, 2019
 * 
 * 	Interface implemented by MyQueue
 */

public interface IntegerQueue {
	public int size();
	public boolean isEmpty();
	public Integer first() throws EmptyStructureException;
	public Integer dequeue() throws EmptyStructureException;
	public void enqueue(Integer N);
}
