
public class Student implements Comparable {
	
	private int stuNum = 0;
	private double mark = 0;
	
	public Student(int stuNum, double mark) {
		this.stuNum = stuNum;
		this.mark = mark;
	}
	
	// Getters and Setters
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

	@Override
	public int compareTo(Object o) {
		if(o instanceof Student) {
			//if(((Student) o).getStuNum()))
		}
		return 0;
	}

}
