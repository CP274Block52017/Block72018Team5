
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
=======
import java.util.ArrayList;

public class ByHeightStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		int firstTeamHeightTotal = 0;
		int secondTeamHeightTotal = 0;
		ArrayList<Players> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Players> secondTeamMembers = secondTeam.getTeamMembersList();
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

