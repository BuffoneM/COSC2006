import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class testclass {

	public static void main(String[] args) {

		String name = "DataSet1.txt";
		File file = new File(name);
		
		readFile(file);
		
	}
	
	public static void readFile(File file) {
		
		try {
			Scanner input = new Scanner(file);
			
			while(input.hasNext()) {
				System.out.println(input.nextInt());
				System.out.println(input.nextDouble());
			}
			
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("ERROR READING THE FILE!");
		}
		
	}

}
