/*
 * Assignment 3
 * Michael Buffone
 * Oct 30th, 2019
 * 
 * Test program by creating linked lists of students
 * with data from text files
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;


public class TestProgram {
	
	public static void main(String[] args) {
		
		System.out.println("----------- Data Set 1 -----------");
		File file = new File("test1.txt");
		LinkedList<Student> list = new LinkedList<Student>();
		readFile(file, list);
		list.print();
		list.median();
		
		System.out.println("\n----------- Data Set 2 -----------");
		File file2 = new File("test2.txt");
		LinkedList<Student> list2 = new LinkedList<Student>();
		readFile(file2, list2);
		list2.print();
		list2.median();
		
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
				list.addSorted(new Student(stuNum, mark));
				
			}
			
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("ERROR READING THE FILE!");
		}
		
	}

}
