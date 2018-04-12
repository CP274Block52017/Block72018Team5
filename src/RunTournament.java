import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class RunTournament {
	
	private static final int MAX_PARTICIPANTS = 8;
	
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
	
	public static boolean createTeam(String prompt, Scanner scan) {
 		boolean enoughPlayers = false;
 		while (!enoughPlayers) {
 			System.out.println(prompt);
 			return false;
 		}
 		return false;
 	}
 	
 	public static String getTournamentName(Scanner scan) {
 		scan = new Scanner(System.in);
 		System.out.println("What do you want to name your tournament?");
 	 	String tournamentName = scan.nextLine();
 	 	return tournamentName;
 	 	}
 	 	
 	 	public static int getNumberOfTeams(Scanner scan) {
 	 		scan = new Scanner(System.in);
 	 		int numParticipants = 0;
 	 		Boolean validAnswer = false;
 	 		while (!validAnswer) {
		 		try {
		 			System.out.println("How many participants do you want in your tournament?");
		 	 		numParticipants = scan.nextInt();
		 	 		scan.nextLine();
		 	 		if ((numParticipants > 0) &&(numParticipants < MAX_PARTICIPANTS)) {
		 	 			validAnswer = true;
		 	 		}
		 		}
		 		catch(InputMismatchException ex) {
					scan.nextLine();
				}
				if (!validInput) {
					System.out.println("Invalid selection -- enter a number between 1 and " + colors.length);
				}
		 		return numberOfParticipants;
 	 	}
 		}
 		
 	
 	public static void getStrategy() {
 		winnerStrategy = null;
 	}
 	
 	public static void createTournament() {
 		boolean confirmTournament = false;
 		while(!confirmTournament) {
 			tournamentName = getTournamentName();
 			numberOfParticipants = getNumberofTeams();
 			getStrategy();
 			System.out.println("Is this the correct information for your tournament?");
 			System.out.println("Tournament Name: " + tournamentName);
 			System.out.println("Number of Teams: " + numberOfParticipants);
 			System.out.println("Strategy to determine winner: " + "default");
 			Scanner scan = new Scanner(System.in);
 			String answer = scan.next(); 
 			if (answer.equalsIgnoreCase("Yes")) {
 				Tournament tournament = new Tournament(tournamentName, numberOfParticipants, winnerStrategy);
 				confirmTournament = true; 
 			} 
 			else if (answer.equalsIgnoreCase("No")) { 
 				confirmTournament = false;
 			} 
 			else { 
 				System.out.println("\nInvalid entry. Please enter 'yes' or 'no'."); 
 			}
 		}

 		
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
