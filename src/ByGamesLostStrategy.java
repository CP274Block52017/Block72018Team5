
import java.util.ArrayList;

public class ByGamesLostStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		double firstTeamGamesLostTotal = 0.0;
		double secondTeamGamesLostTotal = 0.0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamGamesLostTotal += firstTeamMembers.get(i).getTeamLosses();
			secondTeamGamesLostTotal += secondTeamMembers.get(i).getTeamLosses();
		}
		firstTeam.setLastRoundAverage(firstTeamGamesLostTotal/firstTeam.getTeamSize());
		secondTeam.setLastRoundAverage(secondTeamGamesLostTotal/secondTeam.getTeamSize());
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
	public String getName() {
		return "Average Games Lost";
	}

}
=======
import java.util.ArrayList;

public class ByGamesLostStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		int firstTeamGamesLostTotal = 0;
		int secondTeamGamesLostTotal = 0;
		ArrayList<Players> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Players> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamGamesLostTotal += firstTeamMembers.get(i).getTeamLosses();
			secondTeamGamesLostTotal += secondTeamMembers.get(i).getTeamLosses();
		}
		firstTeam.setLastRoundAverage(firstTeamGamesLostTotal/5);
		secondTeam.setLastRoundAverage(secondTeamGamesLostTotal/5);
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
	public String getName() {
		return "Greatest Average Games Lost Winner";
	}

}

