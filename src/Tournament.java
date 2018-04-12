
/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Tournament {
	
	private String name;
	private int numTeams;
	private TournamentWinnerStrategy winnerStrategy;
	
	public Tournament(String name, int numTeams, TournamentWinnerStrategy winnerStrategy) {
		this.name = name;
		this.numTeams = numTeams;
		this.winnerStrategy = winnerStrategy;
	}
}
