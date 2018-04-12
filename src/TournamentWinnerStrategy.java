import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public interface TournamentWinnerStrategy {
	
	public Team determineWinner(ArrayList<Team> teams);
	
	public String getName();

}
