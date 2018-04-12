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
	private static final int NUMBER_STRATEGIES = 1;
	private static final int RANDOM_STRATEGY = 1;
	
	private Tournament newTournament;
	
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
	
	private static boolean createTeam(String prompt, Scanner scan) {
 		boolean enoughPlayers = false;
 		while (!enoughPlayers) {
 			System.out.println(prompt);
 			return false;
 		}
 		return false;
 	}
 	
 	private static String askTournamentName(Scanner scan) {
 		System.out.println("What do you want to name your tournament?");
 	 	String tournamentName = scan.nextLine();
 	 	return tournamentName;
 	 	}
 	 	
 	private static int askNumberOfTeams(Scanner scan) {
 		int numParticipants = 0;
 		Boolean validAnswer = false;
 		while (!validAnswer) {
	 		try {
	 			System.out.println("How many participants do you want in your tournament?");
	 	 		numParticipants = scan.nextInt();
	 	 		scan.nextLine();
	 	 		if ((numParticipants > 0) && (numParticipants < MAX_PARTICIPANTS)) {
	 	 			validAnswer = true;
	 	 		}
	 		}
	 		catch(InputMismatchException ex) {
				scan.nextLine();
			}
			if (!validAnswer) {
				System.out.println("Invalid selection -- enter a number between 1 and " + MAX_PARTICIPANTS);
			}
	 	}
 		return numParticipants;
	}
		
 	private static int askStrategy(Scanner scan) {
 		int chosenStrategy = 0;
 		Boolean validAnswer = false;
 		while(!validAnswer) {
 			System.out.println("Choose a strategy to determine the winner of the tournament from the following options: ");
 			System.out.println("1: Random Selection");
 			System.out.println("> ");
 			try {
 				chosenStrategy = scan.nextInt();
 				scan.nextLine();
 				
 				switch (chosenStrategy) {
 				case RANDOM_STRATEGY:
 					chosenStrategy = RANDOM_STRATEGY;
 				default: 
 					System.out.println("Invalid selection -- enter a number between 1 and " + NUMBER_STRATEGIES);
 				}
 			}
 			catch (InputMismatchException ex) {
 				scan.nextLine();
 				System.out.println("Invalid selection -- enter a number between 1 and " + NUMBER_STRATEGIES);
 			}
 		}
 		return chosenStrategy;
	 }
	 	
 	private static void createTournament(Scanner scan) {
 		Boolean confirmTournament = false;
 		while(!confirmTournament) {
 			String tournamentName = askTournamentName(scan);
 			int numParticipants = askNumberOfTeams(scan);
 			int strategyChoice = askStrategy(scan);
 			TournamentWinnerStrategy chosenStrategy = new RandomWinner();
 			System.out.println("Tournament Name: " + tournamentName);
 			System.out.println("Number of Teams/Participants: " + numParticipants);
 			System.out.println("Strategy to determine winner: " + chosenStrategy.getName());
 			Boolean isCorrect = askYesNo("Is this the correct information for your tournament?", scan);
 			if (!isCorrect) {
 				System.out.println("Please edit your tournament information.");
 			}
 			else {
 				newTournament = new Tournament(tournamentName, numParticipants, chosenStrategy);
 				confirmTournament = true;
 			}
 		}
 	}
 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the tournament game!");
		Scanner scan = new Scanner(System.in);
		Boolean yesTournament = askYesNo("Would you like to create a new tournament? ", scan);
		if (yesTournament) {
			createTournament(scan);
		}
	}

}
