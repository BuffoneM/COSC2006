/*
 * Assignment 3
 * Michael Buffone
 * Test program by creating a linked list of type student
 */

public class TestProgram {
	
	public static void main(String[] args) {
		
		Student s1 = new Student();
		System.out.println(s1.toString());
		
		Student s2 = new Student(1234, 55.5);
		System.out.println(s2.toString());
		
		System.out.println("----------------------------------------");
		LinkedList<Student> list = new LinkedList<Student>();
		list.addFirst(s1);
		list.addFirst(s2);
		list.addFirst(new Student(12345, 99));
		
		list.print();
		
	}

}
