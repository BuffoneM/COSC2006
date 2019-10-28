
public class TestProgram {

	public static void main(String[] args) {
		
		LinkedList<String> list1 = new LinkedList<String>();
		list1.addFirst("1");
		list1.addFirst("2");
		list1.addFirst("3");
		list1.addLast("4");
		list1.print();
		System.out.println();
		
		list1.deleteFirst();
		list1.print();
		System.out.println();
		
		list1.deleteLast();
		list1.print();
		System.out.println();
		
		System.out.println("Complete.");
		
	}
}
