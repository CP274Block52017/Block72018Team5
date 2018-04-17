import java.util.ArrayList;
/**
*This class is a concrete implementation of TournamentWinnerStrategy
*that determines the winner between two given teams by 
*taking the athletes' on the teams number of games lost.
* @author Nicole
* @author Kelli
* @author Emma
*/
public class ByHeightStrategy implements TournamentWinnerStrategy {
	
	/**
	* This method determines the winner between two given teams
	* by taking the average height of the team and comparing them
	* and then returning the team with the higher average as the winner.
	* @param firstTeam - a team in the tournament.
	* @param secondTeam - another team in the tournament.
	* @return Team - the winning team.
	*/
	public Team determineWinner(Team firstTeam, Team secondTeam) {
		double firstTeamHeightTotal = 0.0;
		double secondTeamHeightTotal = 0.0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamHeightTotal += firstTeamMembers.get(i).getHeightInches();
			secondTeamHeightTotal += secondTeamMembers.get(i).getHeightInches();
		}
		firstTeam.setLastRoundAverage(firstTeamHeightTotal/firstTeam.getTeamSize());
		secondTeam.setLastRoundAverage(secondTeamHeightTotal/secondTeam.getTeamSize());
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
	/**
	* Gets the name of the strategy.
	* @return String - name of the strategy.
	*/
	public String getName() {
		return "Average Height";
	}

}

