
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
	}
}