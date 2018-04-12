import java.util.ArrayList;
import java.util.Collections;

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

	public Team determineWinner(ArrayList<Team> teams) {
		Team winningTeam = null;
		if (teams.isEmpty()) {
			return null;
		} 
		else {
			Collections.shuffle(teams);
			winningTeam = teams.get(0);
		}
		return winningTeam;
	}
	
	public String getName() {
		return "Random Winner";
	}

}