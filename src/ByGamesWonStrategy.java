

import java.util.ArrayList;

public class ByGamesWonStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		double firstTeamGamesWonTotal = 0.0;
		double secondTeamGamesWonTotal = 0.0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamGamesWonTotal += firstTeamMembers.get(i).getTeamWins();
			secondTeamGamesWonTotal += secondTeamMembers.get(i).getTeamWins();
		}
		firstTeam.setLastRoundAverage(firstTeamGamesWonTotal/firstTeam.getTeamSize());
		secondTeam.setLastRoundAverage(secondTeamGamesWonTotal/secondTeam.getTeamSize());
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
	public String getName() {
		return "Average Games Won";
	}
	
}
