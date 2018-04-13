
import java.util.ArrayList;
/**
 *@author Nicole
 *@author Kelli
 *@author Emma
 */
public interface TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam);

	
	public String getName();

}

