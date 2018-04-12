import java.util.ArrayList;
import java.util.Collections;

/**
 * @author Nicole
 * @author emmablair
 */
public class RandomWinner implements TournamentWinnerStrategy {
	
	private static Team winningTeam;
	
	public RandomWinner() {
		
	}

	public Team determineWinner(ArrayList<Team> teams) {
		if(teams.isEmpty()) {
			return null;
		} else {
			Collections.shuffle(teams);
			winningTeam = teams.get(0);
		}
		System.out.println("The winner is " + winningTeam.toString());
		return winningTeam;
	}

}
