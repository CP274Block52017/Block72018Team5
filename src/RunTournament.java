import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the prompts for user input and uses it to 
 * provide input to create the tournament. 
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class RunTournament {
	
	private static final int MAX_PARTICIPANTS = 8;
	private static final int MAX_TEAM_SIZE = 5;
	private static final int NUMBER_STRATEGIES = 1;
	private static final int RANDOM_STRATEGY = 1;
	
	private static Tournament newTournament;
	private static TournamentWinnerStrategy chosenStrategy;
	
	/**
	 * This method gets user input on whether or not they would like to
	 * create a new tournament.
	 * @param prompt - the prompt to ask the user a question.
	 * @param scan - the input from the user.
	 * @return boolean - returns true or false depending on the user's answer.
	 */
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
	 * This method prompts the user by asking if they would like to create a team.
	 * @param scan - user input.
	 * @return Team - an instance of team.
	 */
	private static Team createTeam(Scanner scan) {
		String teamName = askName("\nWhat do you want to name your team?", scan);
		Team newTeam = new Team(teamName);
 		int teamSize = 0;
 		while (teamSize < MAX_TEAM_SIZE) {
 			String player = askName("\nWhich player do you want to add to your team?", scan);
 			newTeam.addPlayer(player);
 			System.out.println(player + " was added to Team " + teamName);
 			teamSize++;
 		}
 		System.out.println("Team " + teamName + " is full!");
 		return newTeam;
 	}
	
	/**
	 * This method gets the names entered by the user.
	 * @param prompt - the prompt to ask the user for a question.
	 * @param scan - user input.
	 * @return String - the name inputed by the user.
	 */
 	private static String askName(String prompt, Scanner scan) {
 		System.out.println(prompt);
 	 	String name = scan.next();
 	 	scan.nextLine();
 	 	return name;
 	 }
 	 	
 	/**
 	 * This method asks the user for the number of teams they would like 
 	 * to create for the tournament.
 	 * @param scan - user input.
 	 * @return int - number of teams to create.
 	 */
 	private static int askNumberOfTeams(Scanner scan) {
 		int numParticipants = 0;
 		Boolean validAnswer = false;
 		while (!validAnswer) {
	 		try {
	 			System.out.println("\nHow many participants do you want in your tournament?");
	 	 		numParticipants = scan.nextInt();
	 	 		scan.nextLine();
	 	 		if ((numParticipants > 0) && (numParticipants <= MAX_PARTICIPANTS)) {
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
		
 	/**
 	 * This method prompts the user for the strategy they would like 
 	 * to use to determine the winner of the tournament.
 	 * @param scan - user input.
 	 * @return int - number correlating to the desired strategy.
 	 */
 	private static int askStrategy(Scanner scan) {
 		int chosenStrategy = 0;
 		Boolean validAnswer = false;
 		while(!validAnswer) {
 			System.out.println("\nChoose a strategy to determine the winner of the tournament from the following options: ");
 			System.out.println("1: Random Selection");
 			System.out.println("> ");
 			try {
 				chosenStrategy = scan.nextInt();
 				scan.nextLine();
 				switch (chosenStrategy) {
 				case RANDOM_STRATEGY:
 					validAnswer = true;
 					chosenStrategy = RANDOM_STRATEGY;
 					break;
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
	 	
 	/**
 	 * This method is used to create a tournament given the 
 	 * information the user has inputed. 
 	 * @param scan - user input.
 	 */
 	private static void createTournament(Scanner scan) {
 		Boolean confirmTournament = false;
 		while(!confirmTournament) {
 			String tournamentName = askName("\nWhat do you want to name your tournament?", scan);
 			int numParticipants = askNumberOfTeams(scan);
 			chosenStrategy = WinnerStrategyFactory.getWinnerStrategy(askStrategy(scan));
 			System.out.println("\nTournament Name: " + tournamentName);
 			System.out.println("Number of Teams/Participants: " + numParticipants);
 			System.out.println("Strategy to determine winner: " + chosenStrategy.getName());
 			Boolean isCorrect = askYesNo("Is this the correct information for your tournament?\n", scan);
 			if (!isCorrect) {
 				System.out.println("\nPlease edit your tournament information.");
 			}
 			else {
 				newTournament = new Tournament(tournamentName, numParticipants, chosenStrategy);
 				confirmTournament = true;
 			}
 		}
 	}
 

	/**
	 * The main method that runs the tournament.
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Welcome to the tournament game!");
		Scanner scan = new Scanner(System.in);
		
		Boolean yesCreate = askYesNo("\nWould you like to create a new tournament?\n", scan);
		if (yesCreate) {
			createTournament(scan);
		}
		
		int numTeams = 0;
		while (numTeams < newTournament.getNumTeams()) {
			yesCreate = askYesNo("\nWould you like to add a new team?\n", scan);
			newTournament.addTeam(createTeam(scan));
			//print teams w/members and names
			//if # teams = max, break loop
			numTeams++;
			yesCreate = askYesNo("\nWould you like to add a new team?\n", scan);
		}
		
		Team winningTeam = chosenStrategy.determineWinner(null);
		System.out.println("The winner is: " + winningTeam.getName());
	}

}
