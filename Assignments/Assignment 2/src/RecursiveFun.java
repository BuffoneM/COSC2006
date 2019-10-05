/* 
- Michael Buffone
- Oct. 5th 2019
- COSC2006A19F Assignment 2
- This program will have several recursive methods implemented, and utilize them
 */

public class RecursiveFun {

	public static void main(String[] args) {

	// 1. Triangle Pattern
		int numStar = 5;
		triangle(1, numStar);
		System.out.println();
		
	// 2. Triangle Pattern
		numbers("THERBLIG", 1);
		System.out.println();
		
	// 3. A Teddy Bear Picnic
		System.out.println("bear (84) is " + bears(84));
		System.out.println("bear (250) is " + bears(250));
		System.out.println("bear (41) is " + bears(41));
		System.out.println();
		
	// 4. One Binary Number
		binaryPrint(27);
		System.out.println("\n");
		
	// 5. Sequence of Binary Numbers
		binaryNumbers("00101", 2);
		
	}
	
	/*
	 * -Print the top half of the triangle where the base case declares that the recursion needs to keep happening
	 * -Once the base case cannot be reached, undo the recursion by printing the other strings
	 */
	public static void triangle(int numStars, int end) {
		String stringStar = "";
		
		// Top of the triangle
		for(int i = 0; i < numStars; i++) {
			stringStar += "*";
		}
		System.out.print(stringStar);
		System.out.println();
		
		// The base case itself recursively calls the method while its TRUE
		if(numStars < end) {
			triangle(numStars+1, end);
		}
		
		// Bottom of triangle
		System.out.print(stringStar);
		System.out.println();

	}
	
	// Print the prefix and add 1-9 decimal numbers with respect to the level
	public static void numbers (String prefix, int levels) {
		
		for(int i = 1; i <= 9; i++) {
			String solution = prefix + i + ".";
			
			if(levels == 1) System.out.println(solution);
			
			else {
				numbers(solution, levels-1);
			}
		}
	}

	// Check all possible solutions. AKA this problem is n^2
	public static boolean bears(int n) {

		// Winning / losing conditions
		if(n == 42) return true;
		if(n <= 0) return false;
		
		// If n is divisible by 2, return n / 2
		if((n % 2) == 0) {

			if(n/2 == 42) return true;
			if(bears(n/2) == true) return true;
		}
		
		// If n is divisible by 5, return 42 bears
		if((n % 5) == 0) {

			if(n - 42 == 42) return true;
			if(bears(n - 42) == true) return true;
		}
		
		// If n is divisible by 3 or 4, complete algorithm:
		if((n % 3) == 0 || (n % 4) == 0) {

			// Multiply the last two digits of n and return this many bears
			int lastDigit = n % 10;
			int secondLastDigit = (n % 100) / 10 ;
			n -= (lastDigit * secondLastDigit);

			if(n == 42) return true;
			if(bears(lastDigit * secondLastDigit) == true) return true;
		}
		
		return false;
	}
	
	// Decimal to binary converter using recursion
	public static void binaryPrint(int n) {
		if(n == 0) {
			System.out.print("0");
			return;
		}
	
		binaryPrint(n/2);

		if((n % 2) == 0) System.out.print("0");
		else System.out.print("1");
		
	}
	
	// Print the prefix and add binary numbers with respect to the level
	public static void binaryNumbers(String prefix, int k) {
		
		for(int i = 0; i <= 1; i++) {
			String solution = prefix + i;
			
			if(k == 1) System.out.println(solution);
			else {
				binaryNumbers(solution, k-1);
			}
		}
	}
}
