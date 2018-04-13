
/**
 * 
 */

/**
 * @author Nicole
 *
 */
public interface TournamentWinnerStrategy {
	
	public Team determineWinner(Team firstTeam, Team secondTeam);
	
	public String getName();

}
