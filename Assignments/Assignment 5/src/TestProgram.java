/*
 *	Assignment 5
 * 	Michael Buffone
 * 	November 26th, 2019
 * 
 * 	TestProgram that creates a MyQueue with random integers
 */

public class TestProgram {

	public static void main(String[] args) {
		
		MyQueue test = new MyQueue();
		for(int i = 1; i <= 5; i++) {
			Integer x = i;
			test.enqueue(x);
		}
		
		test.print();

	}

}
