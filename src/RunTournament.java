import java.io.IOException;

/**
 * This class generates the database and 
 * creates the first GUI window to start the tournament game.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */

public class RunTournament {
 	
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
	 * This is the main method that runs the tournament game from the first GUI.
	 * @param args
	 */
	public static void main(String[] args) throws IOException {
		PlayerDatabase.generateDatabase();
		
		new GUIWelcomeWindow();
	}
}