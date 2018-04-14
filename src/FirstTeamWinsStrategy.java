import java.util.ArrayList;

public class FirstTeamWinsStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		return firstTeam;
	}

	public String getName() {
		return "First Team Wins";
	}
	
}
