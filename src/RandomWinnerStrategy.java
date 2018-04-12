import java.util.ArrayList;
import java.util.Collections;

/**
 * 
 */

/**
 * @author Nicole
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
