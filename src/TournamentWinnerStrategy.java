
/**
 * This interface provides the methods needed to create
 * multiple concrete implementations for different strategies to
 * choose the winner of the tournament. Allows for the use of
 * the strategy pattern.
 * @author Nicole
 * @author Kelli
 * @author Emma
 */
public interface TournamentWinnerStrategy {
	
	/**
	 * Determines the winning team of the tournament. 
	 * @param first team in match up and second team in matchup
	 * @return the winner of the match up
	 */

	public Team determineWinner(Team firstTeam, Team secondTeam);

	/**
	 * Provides the name of the winning team.
	 * @return name
	 */
	public String getName();

}

