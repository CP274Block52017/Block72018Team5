import java.util.ArrayList;
/**
 * This interface provides the methods needed to create
 * multiple concrete implementations for different strategies to
 * choose the winner of the tournament. Allows for the use of
 * the strategy pattern.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public interface TournamentWinnerStrategy {
	
	/**
	 * Determines the winning team of the tournament. 
	 * @param teams
	 * @return
	 */
	public Team determineWinner(Team firstTeam, Team secondTeam);
	
	/**
	 * Provides the name of the winning team.
	 * @return
	 */
	public String getName();

}
