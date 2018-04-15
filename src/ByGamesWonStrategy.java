import java.util.ArrayList;

public class ByGamesWonStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		int firstTeamGamesWonTotal = 0;
		int secondTeamGamesWonTotal = 0;
		ArrayList<Player> firstTeamMembers = firstTeam.getTeamMembersList();
		ArrayList<Player> secondTeamMembers = secondTeam.getTeamMembersList();
		for (int i = 0; i < firstTeam.getTeamSize(); i++) {
			firstTeamGamesWonTotal += firstTeamMembers.get(i).getTeamWins();
			secondTeamGamesWonTotal += secondTeamMembers.get(i).getTeamWins();
		}
		firstTeam.setLastRoundAverage(firstTeamGamesWonTotal/5);
		secondTeam.setLastRoundAverage(secondTeamGamesWonTotal/5);
		return RunTournament.determineWinningAverage(firstTeam, secondTeam);
	}
	
	public String getName() {
		return "Greatest Average Games Won Winner";
	}
	
}
