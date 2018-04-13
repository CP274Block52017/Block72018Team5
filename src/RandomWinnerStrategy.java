import java.util.ArrayList;
import java.util.Random;

/**
 * @author Nicole
 * @author Emma
 * @author Kelli
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