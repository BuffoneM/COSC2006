/* 
- Michael Buffone
- Sept. 14th 2019
- COSC2006A19F Assignment 1
- This program will load data from a file and complete operations on the data
 */
import java.io.*;
import java.util.Scanner;

public class Assignment1 {


	private static Scanner in = new Scanner(System.in);

	private static int numAccounts = 0;
	private static int[] accountNum = new int[200];
	private static char[] accountType = new char[200];
	private static double[] accountBal = new double[200];

	public static void main(String[] args) {


		// Create the file object and read the data into the arrays
		File file = new File("a1data.txt");
		readFile(file);
		
		// User menu
		while(true) {

			String input = "";
			do {
				System.out.println("John's 24-Hour Bank service options:");
				System.out.println("1. (S) Search for an account");
				System.out.println("2. (P)  Print total balances");
				System.out.println("3. (Q)                  Quit");
				input = in.nextLine();
				if(!(input.equals("S") || input.equals("P") || input.equals("Q"))) {
					System.out.println("Invalid input, refer the the options in the parentheses.\n");
				}
			} while(!(input.equals("S") || input.equals("P") || input.equals("Q")));

			// Initiating sort method
			insertionSort(accountNum, accountType, accountBal);

			// Search option based on user selection
			if(input.equals("S")) {

				System.out.println("\nFor broad searching ('0' for account number - 'X' for an account type)");
				int userAccount = 0;
				char userType = 0;
				try {
					System.out.print("Enter an account number: ");
					userAccount = in.nextInt();
					System.out.print("Enter an account type: ");
					userType = in.next().charAt(0);
					searchAccounts(userAccount, userType);
				}
				catch(Exception e) {
					System.out.println("Invalid input, exiting to menu.\n");
					String s = "";
					s=in.nextLine(); // Clear the string buffer
				}

			}

			// Print function
			else if(input.equals("P")) {
				calculateTotalBalance();
			}
			else {
				System.out.println("Exiting the program.");
				System.exit(0);
			}

		}

	}
	// Read the data into the arrays
	public static void readFile (File file) {

		// Attempt scanner connection to the file
		try {
			Scanner input = new Scanner(file);

			int i = 0;
			while(input.hasNext()) {
				try {
					accountNum[i] = input.nextInt();
					accountType[i] = input.next().charAt(0);
					accountBal[i] = input.nextDouble();
					i++;
				}
				catch(Exception e) {
					System.out.println("Error with data order!");
					System.exit(0);
				}
			}
			numAccounts = i;
			input.close();
		}
		catch(FileNotFoundException fnfe) {
			System.out.println("Error reading the data file!");
		}
	}


	/* 
	 * Reference to learn the sort algorithm
	 * https://www.youtube.com/watch?v=Dl0PASPTfQw
	 */ 
	// Use the insertion sort method to sort the array
	public static void insertionSort(int[] accNum, char[] accType, double[] accBal) {
		for(int i = 1; i < numAccounts; i++) {

			int key = accNum[i];
			char key2 = accType[i];
			double key3 = accBal[i];
			int j = i - 1;

			// Move all of the bigger account numbers over
			while(j >= 0 && accNum[j] > key) {
				accNum[j+1] = accNum[j];
				accType[j+1] = accType[j];
				accBal[j+1] = accBal[j];
				j--;
			}

			// These are the smallest values and will therefore be placed at the front of the sort
			accNum[j+1] = key;
			accType[j+1] = key2;
			accBal[j+1] = key3;

		}
	}


	public static void searchAccounts(int userAccount, char userType) {

		boolean found = false;

		// Most broad case (display all accounts and types)
		if(userAccount == 0 && userType == 'X') {
			System.out.println("\nAccount number:\t\tAccount type:\t\tAccount balance:");
			for(int i = 0; i < numAccounts; i++) {
				System.out.println(accountNum[i] + "\t\t\t" + accountType[i] + "\t\t\t$" + accountBal[i]);
			}
		}

		// Display all accounts with the same type
		else if(userAccount == 0) {

			System.out.println("\nAccount number:\t\tAccount type:\t\tAccount balance:");
			for(int i = 0; i < numAccounts; i++) {
				if(accountType[i] == userType) {
					System.out.println(accountNum[i] + "\t\t\t" + accountType[i] + "\t\t\t$" + accountBal[i]);
					found = true;
				}
			}
			if(!found) System.out.println("The account could not be found.");

		}

		// Display all of the accounts an account has
		else if(userType == 'X') {

			System.out.println("\nAccount number:\t\tAccount type:\t\tAccount balance:");
			int i = 0;
			while(i < numAccounts) {
				if(accountNum[i] == userAccount) {
					System.out.println(accountNum[i] + "\t\t\t" + accountType[i] + "\t\t\t$" + accountBal[i]);
					found = true;
				}
				else if(accountNum[i] > userAccount) break;
				i++;
			}
			if(!found) System.out.println("The account could not be found.");

		}

		// Search for a specific account number and account type
		else {

			System.out.println("\nAccount number:\t\tAccount type:\t\tAccount balance:");
			int i = 0;
			while(i < numAccounts) {
				if((accountNum[i] == userAccount) && (accountType[i] == userType)) {
					System.out.println(accountNum[i] + "\t\t\t" + accountType[i] + "\t\t\t$" + accountBal[i]);
					found = true;
				}
				else if(accountNum[i] > userAccount) break;
				i++;			
			}
			if(!found) System.out.println("The account could not be found.");

		}

		String s = "";
		s = in.nextLine();
		System.out.println("\n...Returning to main menu\n"); // Used for menu spacing
	}


	public static void calculateTotalBalance() {

		System.out.println("\nAccount number:\t\tSum balance:");
		
		double totalBal = 0;
		int oldAccount = -1;
		
		// Compare the account behind the one we are comparing because when we reach the end of the array
		// where there are only '0' values, we'll run out of values to look at..
		for(int i = 0; i < numAccounts; i++) {
			
			if(accountNum[i] != oldAccount) {
				totalBal = Math.round(totalBal * 100) / 100.00;	

				if(i > 0) {
					//System.out.printf(oldAccount + "\t\t\t$.2f%n", totalBal);
					System.out.println(oldAccount + "\t\t\t$" + totalBal);	
				}
				
				oldAccount = accountNum[i];
				totalBal = 0;
			}
			
			totalBal += accountBal[i];
		
		}
		if(numAccounts > 0) {
			totalBal = Math.round(totalBal * 100) / 100.00;		
			System.out.println(oldAccount + "\t\t\t$" + totalBal);
			//System.out.printf(oldAccount + "\t\t\t$.2f%n", totalBal);

		}


		System.out.println("\n...Returning to main menu\n"); // Used for menu spacing
	}


	// Test method to print all account information
	public static void printAllInfo() {

		System.out.println("Account information:");
		for(int i = 0; i < numAccounts; i++) {
			System.out.println(accountNum[i] + "\t\t" + accountType[i] + "\t\t$" + accountBal[i]);
		}
		insertionSort(accountNum, accountType, accountBal);
		System.out.println("\n2nd Account information:");
		for(int i = 0; i < numAccounts; i++) {
			System.out.println(accountNum[i] + "\t\t" + accountType[i] + "\t\t$" + accountBal[i]);
		}
	}
}



