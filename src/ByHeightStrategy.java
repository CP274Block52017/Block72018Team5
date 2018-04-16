import java.util.ArrayList;

public class ByHeightStrategy implements TournamentWinnerStrategy {

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
	
	public String getName() {
		return "Average Height";
	}

}

