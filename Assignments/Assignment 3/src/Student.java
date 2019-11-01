/*
 * Assignment 3
 * Michael Buffone
 * Oct 30th, 2019
 * 
 * Student class that implements comparable so it can be generically used
 * by the linked list
 */

public class Student implements Comparable<Student> {
	
	private int stuNum = 0;
	private double mark = 0;
	
	// Constructors
	public Student() {
		this.stuNum = 0;
		this.mark = 0;
	}
	
	public Student(int stuNum, double mark) {
		this.stuNum = stuNum;
		this.mark = mark;
	}
	
	// ****** Getters and Setters ******
	public int getStuNum() {
		return stuNum;
	}
	public void setStuNum(int stuNum) {
		this.stuNum = stuNum;
	}
	
	public double getMark() {
		return mark;
	}
	public void setMark(double mark) {
		this.mark = mark;
	}

	// ****** Utility methods ******
	@Override
	public int compareTo(Student o) {
		if(this.getMark() < o.getMark()) {
			return -1;
		}			
		else if(this.getMark() > o.getMark()) {
			return 1;
		}
		return 0;
	}
	
	@Override
	public String toString() {
		String temp = String.format("%-20s" ,"ID: " + getStuNum());
		temp += "\tMark: " + getMark();
		return temp;
	}

}
