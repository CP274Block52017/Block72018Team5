public class FirstTeamWinsStrategy implements TournamentWinnerStrategy {

	public Team determineWinner(Team firstTeam, Team secondTeam) {
		return firstTeam;
	}

	public String getName() {
		return "First Team Wins";
	}

	public int getWinningAverage() {
		return 0;
	}

	public int getLosingAverage() {
		return 0;
	}
	
	

}
