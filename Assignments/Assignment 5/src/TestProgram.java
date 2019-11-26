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
		
		// Populate the queue with x random numbers
		for(int i = 0; i < 50; i++) {
			int random = (0 + (int)(Math.random() * 101));
			Integer x = random;
			test.enqueue(x);
		}
		System.out.println("Size of the queue: " + test.size());
		test.print();
		
		// Try to sort the queue given that it is populated
		try {
			test.sort();
		}
		catch(EmptyStructureException ese) {
			System.out.println(ese.getMessage());
		}
		
		System.out.println();
		test.print();
	
	}

}
