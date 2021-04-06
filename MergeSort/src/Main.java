import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scn = new Scanner (System.in);
		Merge mer = new Merge();
		int num, userInput;
		boolean runAgain=true;
		
		try {
			//start by adding one integer to the array
			System.out.println("Please add one number to the array: ");
			num = scn.nextInt();
			mer.addArray(num);
			
		}catch(java.util.InputMismatchException e) {
			System.out.println("Please only enter integers. 0 will be put in the beginning of the array.");
			System.out.println();
			mer.addArray(0);
		}
		
		
		while (runAgain) {
			
			try {
				//ask user what they want to do 
				scn = new Scanner(System.in);
				System.out.println("What would you like to do? Please enter: "
						+ "\n1 to search for a specific number. "
						+ "\n2 to add a number to the array (please add no more than 10). "
						+ "\n3 to end program.");
				userInput = scn.nextInt();
				
				switch(userInput) {
				
					//search using binary search
					case 1: userInput=1;
						System.out.println("Please enter the number you want to search for: ");
						num = scn.nextInt();
						mer.binSearch(num);
						
						runAgain=true;
						break;
					
					//add numbers
					case 2: userInput=2;
						System.out.println("Please enter a number to add to the array.");
						num = scn.nextInt();
						mer.addArray(num);
						
						runAgain=true;
						break;
					
					//end program	
					case 3: userInput=3;
						runAgain=false;
						break;
						
					//default case for if user enters a number that is not an option	
					default:
						System.out.println("Please only entered the specified numbers, program will continue.");
						System.out.println();
						runAgain=true;
				}
			
			}catch(java.util.InputMismatchException e) {
				System.out.println("Please only enter integers. Program is ending.");
				runAgain=false;
			}
		}
		
		scn.close();
		
	}

}
