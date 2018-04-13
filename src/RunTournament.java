import java.util.ArrayList;
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
		Boolean confirmTeam = false;
		Team newTeam = null;
		//outer loop so that user can go back and edit/make new team if unhappy with initial entries
		while (!confirmTeam) {
			String teamName = askName("\nWhat do you want to name your team?", scan);
			newTeam = new Team(teamName);
	 		int teamSize = 0;
	 		//inner loop adds players to team until team is full
	 		while (teamSize < MAX_TEAM_SIZE) {
	 			String player = askName("\nWhich player do you want to add to your team?", scan);
	 			newTeam.addPlayer(player);
	 			System.out.println(player + " was added to Team " + teamName);
	 			teamSize++;
	 		}
	 		//checks if user is happy with team; if not, go back and edit
	 		if (teamSize == MAX_TEAM_SIZE) {
	 			System.out.println("\nTeam " + teamName + " is full!");
	 			System.out.println("\nTeam Name: " + teamName);
	 	 		System.out.println("\nTeam members:");
	 	 		System.out.println(newTeam);
	 	 		Boolean isCorrect = askYesNo("Is this the correct information for your team?\n", scan);
	 			if (!isCorrect) {
	 				System.out.println("\nPlease edit your team information.");
	 			}
	 			else {
	 				confirmTeam = true;
	 			}
	 		}
	 		else {
	 			System.out.println((MAX_TEAM_SIZE - teamSize) + " more players needed to make a complete team. Please add another player:");
	 		}
		}
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
	 	
 	private static void createTournament(Scanner scan) {
 		Boolean confirmTournament = false;
 		while(!confirmTournament) {
 			String tournamentName = askName("\nWhat do you want to name your tournament?", scan);
 			int numParticipants = askNumberOfTeams(scan);
 			chosenStrategy = WinnerStrategyFactory.getWinnerStrategy(askStrategy(scan));
 			System.out.println("\nTournament Name: " + tournamentName);
 			System.out.println("Number of Teams/Participants: " + numParticipants);
 			System.out.println("Strategy to determine winner: " + chosenStrategy.getName());
 			//checks if user is happy with tournament; if not, go back and edit
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
 
 	private static Team determineRoundWinners(TournamentWinnerStrategy strategy, ArrayList<Team> teams, Scanner scan) {
 		ArrayList<Team> nextRoundTeams = new ArrayList<Team>();
 		Team winningTeam = null;
 		for (int i = 0; i < teams.size(); i += 2) {
 			System.out.println("\nTeam Matchup: " + teams.get(i).getName() + " vs. " + teams.get(i + 1).getName());
 			winningTeam = strategy.determineWinner(teams.get(i), teams.get(i + 1));
 			System.out.println("Team " + winningTeam.getName() + " has won the matchup!");
 			nextRoundTeams.add(winningTeam);
 		}
 		if (nextRoundTeams.size() != 1) {
 			System.out.println("\nNext round's matchups: ");
 	 		for (int i = 0; i < nextRoundTeams.size(); i += 2) {
 	 			System.out.println(nextRoundTeams.get(i).getName() + " vs. " + nextRoundTeams.get(i + 1).getName());
 	 		}
 	 		Boolean yesContinue = askYesNo("\nWould you like to continue to the next round?\n", scan);
 			if (yesContinue) {
 				determineRoundWinners(strategy, nextRoundTeams, scan);
 			}
 			else {
 				System.out.println("Tournament terminated!");
 			}
 		}
 		return winningTeam;
 	}

	/**
	 * The main method that runs the tournament.
	 * @param args
	 */
	public static void main(String[] args) {
		Boolean exitTournamentGenerator = false;
		System.out.println("Welcome to the tournament game!");
 		while(!exitTournamentGenerator) {
			Scanner scan = new Scanner(System.in);
			
			Boolean yesCreate = askYesNo("\nWould you like to create a new tournament?\n", scan);
			if (yesCreate) {
				createTournament(scan);
			}
			else {
				break;
			}
			
			int numTeams = 0;
			System.out.println("Need to add " + (newTournament.getNumTeams() - numTeams) + " more teams to run tournament. Please add another team:");
			while (numTeams < newTournament.getNumTeams()) {
				Team newTeam = createTeam(scan);
				newTournament.addTeam(newTeam);
				System.out.println("\nTeam " + newTeam.getName() + " added to tournament.");
				System.out.println("\nTournament Teams:");
				for (Team team: newTournament.getTeams()) {
					System.out.println("\nTeam " + team.getName() + ":");
					System.out.println(team);
				}
				numTeams++;
				if (numTeams == newTournament.getNumTeams()) {
					System.out.println("\nTournament is ready to start!");
				}
				else {
					System.out.println("\nNeed to add " + (newTournament.getNumTeams() - numTeams) + " more teams to run tournament. Please add another team:");
				}
			}
			
			Team tournamentWinner = determineRoundWinners(chosenStrategy, newTournament.getTeams(), scan);
			newTournament.setWinner(tournamentWinner);
			System.out.println(tournamentWinner.getName() + " has won the tournament!");
			
			Boolean startAgain = askYesNo("\nWould you like to start a new tournament?\n", scan);
			if(!startAgain) {
				exitTournamentGenerator = true;
			}
		}
 		System.out.println("\nThanks for playing! Come back soon!");
	}

}

