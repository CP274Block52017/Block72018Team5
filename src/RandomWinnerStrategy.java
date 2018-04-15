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
	
	public String getName() {
		return "Random Winner";
	}
	
}