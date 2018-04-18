import java.util.Random;

/**
 * This class contains is a concrete implementation of
 * TournamentWinnerStrategy and decided the winning team of the tournament
 * randomly.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class RandomWinnerStrategy implements TournamentWinnerStrategy {
	
   /**
	* This method determines the winner between the two teams randomly
	* @param first team playing
	* @param second team playing
	* @return the team who one
	*/
	public Team determineWinner(Team firstTeam, Team secondTeam) {
		Random rand = new Random();
		int winningTeamIndicator = rand.nextInt(2);
		if (winningTeamIndicator == 0) {
			return firstTeam;
		}
		else {
			return secondTeam;
		}
	}
	
   /**
	* Gets the name of this strategy
	* @return name of this strategy
	*/
	public String getName() {
		return "Random Winner";
	}
	
}