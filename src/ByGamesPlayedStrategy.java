import java.util.ArrayList;

/**
 * This class is a concrete implementation of TournamentWinnerStrategy
 * that determines the winner between two given teams by 
 * taking the athletes' on the teams number of games played.
 * @author Nicole
 * @author Kelli
 * @author Emma
 */
public class ByGamesPlayedStrategy implements TournamentWinnerStrategy {

   /**
	* This method determines the winner between two given team by 
	* taking the games played of each team and then getting the average.
	* The winning team is the team with the greatest average number of games
	* played.
	* @param firstTeam - a team in the tournament.
	* @param secondTeam - another team in the tournament.
	* @return Team - the winning team.
	*/
	public Team determineWinner(Team firstTeam, Team secondTeam) {
		double firstTeamGamesPlayedTotal = 0.0;
		double secondTeamGamesPlayedTotal = 0.0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamGamesPlayedTotal += firstTeamMembers.get(i).getGamesPlayed();
			secondTeamGamesPlayedTotal += secondTeamMembers.get(i).getGamesPlayed();
		}
		firstTeam.setLastRoundAverage(firstTeamGamesPlayedTotal/firstTeam.getTeamSize());
		secondTeam.setLastRoundAverage(secondTeamGamesPlayedTotal/secondTeam.getTeamSize());
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
   /**
	* Gets the name of the strategy.
	* @return String - name of the strategy.
	*/
	public String getName() {
		return "Average Games Played";
	}

}
