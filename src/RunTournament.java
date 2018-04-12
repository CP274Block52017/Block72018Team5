import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nicole
 *
 */
public class RunTournament {
	
	private static final int MAX_PARTICIPANTS = 8;
	private static final int MAX_TEAM_SIZE = 5;
	private static final int NUMBER_STRATEGIES = 1;
	private static final int RANDOM_STRATEGY = 1;
	
	private static Tournament newTournament;
	private static TournamentWinnerStrategy chosenStrategy;
	
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
	
	private static Team createTeam(Scanner scan) {
		String teamName = askName("\nWhat do you want to name your team?", scan);
		Team newTeam = new Team(teamName, null);
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
	
	private static String askName(String prompt, Scanner scan) {
 		System.out.println(prompt);
 	 	String name = scan.next();
 	 	scan.nextLine();
 	 	return name;
 	 }

 	 	
 	private static int askNumberOfTeams(Scanner scan) {
 		int numParticipants = 0;
 		Boolean validAnswer = false;
 		while (!validAnswer) {
	 		try {
	 			System.out.println("How many participants do you want in your tournament (2, 4, or 8)?");
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
		
 	private static int askStrategy(Scanner scan) {
 		int chosenStrategy = 0;
 		Boolean validAnswer = false;
 		while(!validAnswer) {
 			System.out.println("Choose a strategy to determine the winner of the tournament from the following options: ");
 			System.out.println("1: Random Selection");
 			System.out.print("> ");
 			try {
 				chosenStrategy = scan.nextInt();
 				scan.nextLine();
 				
 				switch (chosenStrategy) {
 				case RANDOM_STRATEGY:
 					chosenStrategy = RANDOM_STRATEGY;
 					validAnswer = true;
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
	 	
 	private static void createTournament(Scanner scan) {
 		Boolean confirmTournament = false;
 		while(!confirmTournament) {
 			String tournamentName = askName("\nWhat do you want to name your tournament?", scan);
 			int numParticipants = askNumberOfTeams(scan);
 			int strategyChoice = askStrategy(scan);
 			chosenStrategy = WinnerStrategyFactory.getWinnerStrategy(strategyChoice);
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
 		Boolean exitTournamentGenerator = false;
 		while(!exitTournamentGenerator) {
			System.out.println("Welcome to the tournament game!");
			Scanner scan = new Scanner(System.in);
			Boolean yesCreate = askYesNo("Would you like to create a new tournament? (yes or no)", scan);
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
			System.out.println("The winner is: " + winningTeam.getTeamName());
			Boolean startAgain = askYesNo("\nWould you like to start a new tournament?\n", scan);
			if(!startAgain) {
				System.out.println("Thanks for playing! Come back soon!");
				exitTournamentGenerator = true;
			}
 		}
	}

}

