import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
 * Assignment 3
 * Michael Buffone
 * Test program by creating a linked list of type student
 */

public class TestProgram {
	
	public static void main(String[] args) {
		
		System.out.println("----------- Data Set 1 -----------");
		File file = new File("DataSet1.txt");
		LinkedList<Student> list = new LinkedList<Student>();
		readFile(file, list);
		list.print();
		
		System.out.println("\n----------- Data Set 2 -----------");
		File file2 = new File("DataSet2.txt");
		LinkedList<Student> list2 = new LinkedList<Student>();
		readFile(file2, list2);
		list2.print();
		
	}
	
	// Read the file and populate a linked list with the student objects
	public static void readFile(File file, LinkedList<Student> list) {
		
		try {
			// Create link to the scanner
			Scanner input = new Scanner(file);
			
			// Populate the linked list with student objects using data from the file
			while(input.hasNext()) {
				
				int stuNum = input.nextInt();
				double mark = input.nextDouble();
				list.addFirst(new Student(stuNum, mark));
				
			}
			
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("ERROR READING THE FILE!");
		}
		
	}

}


// Test data
/*
Student s1 = new Student();
System.out.println(s1.toString());

Student s2 = new Student(1234, 55.5);
System.out.println(s2.toString());

System.out.println("----------------------------------------");
LinkedList<Student> list = new LinkedList<Student>();
list.addLast(s1);
//list.addFirst(s1);
list.addFirst(s2);
list.addFirst(new Student(12345, 99));
list.print();

System.out.println("----------------------------------------");
list.deleteFirst();
list.print();

System.out.println("----------------------------------------");
list.addLast(new Student(5555, 45));
list.print();

System.out.println("----------------------------------------");
list.deleteLast();
list.print();
*/