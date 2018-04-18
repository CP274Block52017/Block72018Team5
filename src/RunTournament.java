import java.awt.EventQueue;
import java.io.IOException;
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
	private static final int NUMBER_STRATEGIES = 6;
	
	private static final int RANDOM_STRATEGY = 1;
	private static final int BY_HEIGHT_STRATEGY = 2;
	private static final int BY_GAMESPLAYED_STRATEGY = 3;
	private static final int BY_GAMESWON_STRATEGY = 4;
	private static final int BY_GAMESLOST_STRATEGY = 5;
	private static final int BY_CLASSYEAR_STRATEGY = 6;
	
	private static Tournament newTournament;
	private static TournamentWinnerStrategy chosenStrategy;
	private static Team finalWinningTeam;
	
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
			String answer = scan.nextLine();
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
	 * This method gets the names entered by the user from the GUI
	 * @param prompt - the prompt to ask the user for a question.
	 * @param scan - user input.
	 * @return String - the name inputed by the user.
	 */
	private static String askName(String prompt, Scanner scan) {
 		System.out.println(prompt);
 	 	String name = scan.nextLine();
 	 	return name;
 	 } 	 	 	

 	/**
 	 * This method determines the winner of each round and uses recursion to do
 	 * this method again and again until the tournament is complete
 	 * @param strategy to determine winner
 	 * @param teams that are playing in the tournament
 	 * @param new scan to get user input
 	 * @return the team that won
 	 */
 	private static Team determineRoundWinners(TournamentWinnerStrategy strategy, ArrayList<Team> teams, Scanner scan) {
 		ArrayList<Team> nextRoundTeams = new ArrayList<Team>();
 		Team winningTeam = null;
 		Team losingTeam = null;
 		Boolean isFinalRound = true;
 		
 		//determines winners for each matchup in current round, adds winners to list of teams advancing to next round
 		for (int i = 0; i < teams.size(); i += 2) {
 			System.out.println("\nTeam Matchup: " + teams.get(i).getName() + " vs. " + teams.get(i + 1).getName());
 			winningTeam = strategy.determineWinner(teams.get(i), teams.get(i + 1));
 			if (teams.get(i).getName().equals(winningTeam.getName())) {
 				losingTeam = teams.get(i + 1);
 			}
 			else {
 				losingTeam = teams.get(i);
 			}
 			System.out.println("Team " + winningTeam.getName() + " has won the matchup!");
 			if (!chosenStrategy.getName().equals("Random Winner")) {
 				System.out.println("Team " + winningTeam.getName() + " had a " + chosenStrategy.getName() + " of " + winningTeam.getLastRoundAverage() + " vs. the losing team's " + chosenStrategy.getName() + " of " + losingTeam.getLastRoundAverage());
 			}
 			nextRoundTeams.add(winningTeam);
 		}
 		
 		//recursive method calls itself if there is more than one team left in the tournament
 		if (nextRoundTeams.size() != 1) {
 			isFinalRound = false;
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
 		if (isFinalRound) {
 	 		finalWinningTeam = winningTeam;
 	 	}
 		return finalWinningTeam;
 	}
 	
 	/**
 	 * This method determines the winner of each an individual matchup between two teams.
 	 * It is used by the strategies which determine the winner based on different player attributes.
 	 * @param firstTeam - first team in matchup
 	 * @return secondTeam - second team in matchup
 	 */
 	public static Team determineWinningAverage(Team firstTeam, Team secondTeam) {
 		if (firstTeam.getLastRoundAverage() > secondTeam.getLastRoundAverage()) {
			return firstTeam;
		}
		else if (firstTeam.getLastRoundAverage() < secondTeam.getLastRoundAverage()) {
			return secondTeam;
		}
		else { // if teams are tied, pick a random winner
			RandomWinnerStrategy randomWinner = new RandomWinnerStrategy();
			return randomWinner.determineWinner(firstTeam, secondTeam);
		}
 	}


	/**
	 * This is the main method that runs the tournament.
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		PlayerDatabase.generateDatabase();
		
		Boolean exitTournamentGenerator = false;
		GUIWelcomeWindow welcomeWindow = new GUIWelcomeWindow();
		
		Scanner scan = new Scanner(System.in);
		//loop continues while tournament master wants to create a new tournament
 		while(!exitTournamentGenerator) {
			
			//Determine winners for each round of tournament, including final winner
			Team tournamentWinner = determineRoundWinners(chosenStrategy, newTournament.getTeams(), scan);
			newTournament.setWinner(tournamentWinner);
			System.out.println("Team " + tournamentWinner.getName() + " has won the tournament!");
			
			//Ask tournament master whether to start new tournament
			Boolean startAgain = askYesNo("\nWould you like to start a new tournament?\n", scan);
			if(!startAgain) {
				exitTournamentGenerator = true;
			}
		}
 		System.out.println("\nThanks for playing! Come back soon!");
	}
}


