
import java.util.ArrayList;

public class ByClassYearStrategy implements TournamentWinnerStrategy {

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
	
	public String getName() {
		return "Average Class Year";
	}

}

