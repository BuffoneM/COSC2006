/*
 *	Assignment 5
 * 	Michael Buffone
 * 	November 26th, 2019
 * 
 * 	Exception used by MyQueue
 */

@SuppressWarnings("serial")
public class EmptyStructureException extends Exception {
	public EmptyStructureException(String s) {
		super(s);
	}
}
