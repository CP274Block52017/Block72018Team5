import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class RunTournament {
	
	
	private static boolean askYesNo(String prompt, Scanner scan) {
		boolean isYes = false;
		boolean validAnswer = false;
		while (!validAnswer) {
			System.out.print(prompt);
			String answer = scan.next();
			if (answer.equalsIgnoreCase("Yes")) {
				isYes = true;
				validAnswer = true;
			}
			else if (answer.equalsIgnoreCase("No")) {
				isYes = false;
				validAnswer = true;
			}
			else {
				System.out.println("\nInvalid entry. Please enter 'yes' or 'no'.");
			}
		}
		return isYes;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the tournament game!");
		Scanner scan = new Scanner(System.in);
		System.out.println("IsYes: " + askYesNo("Would you like to create a new tournament? ", scan));
	}

}
