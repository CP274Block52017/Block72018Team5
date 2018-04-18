import java.util.ArrayList;

 /**
  * This is one of the strategies we are using to decide the winner of our tournament
  * This one takes the players of both teams and averages the year of all the players to determine whoever has the
  * higher average team whoever does will 
  * @author Nicole
  * @author Emma
  * @author Kelli
  */
public class ByClassYearStrategy implements TournamentWinnerStrategy {

   /**
	* This method determines the winner between the two teams and returns the 
	* the team who won based upon the average class year each team
	* @param firstTeam - a team in the tournament.
	* @param secondTeam - another team in the tournament.
	* @return Team - the winning team.
	*/
	public Team determineWinner(Team firstTeam, Team secondTeam) {
		double firstTeamClassYearTotal = 0.0;
		double secondTeamClassYearTotal = 0.0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamClassYearTotal += firstTeamMembers.get(i).getClassYear();
			secondTeamClassYearTotal += secondTeamMembers.get(i).getClassYear();
		}
		firstTeam.setLastRoundAverage(firstTeamClassYearTotal/firstTeam.getTeamSize());
		secondTeam.setLastRoundAverage(secondTeamClassYearTotal/secondTeam.getTeamSize());
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
   /**
	* Gets the name of the strategy.
	* @return String - name of the strategy.
	*/
	public String getName() {
		return "Average Class Year";
	}

}
