import java.util.ArrayList;

public class ByHeightStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		int firstTeamHeightTotal = 0;
		int secondTeamHeightTotal = 0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamHeightTotal += firstTeamMembers.get(i).getHeightInches();
			secondTeamHeightTotal += secondTeamMembers.get(i).getHeightInches();
		}
		firstTeam.setLastRoundAverage(firstTeamHeightTotal/5);
		secondTeam.setLastRoundAverage(secondTeamHeightTotal/5);
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
	public String getName() {
		return "Greatest Average Height Winner";
	}

}
