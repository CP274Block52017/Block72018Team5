import java.util.ArrayList;

/**
 * @author Nicole
 * @author Kelli
 * @author Emma
 */
public class Tournament {
	
	private String name;
	private int numTeams;
	private TournamentWinnerStrategy winnerStrategy;
	private ArrayList<Team> teams;

	private Team winner;
	
	public Tournament(String name, int numTeams, TournamentWinnerStrategy winnerStrategy) {
		this.name = name;
		this.numTeams = numTeams;
		this.winnerStrategy = winnerStrategy;
		teams = new ArrayList<Team>();
	}

	
	public TournamentWinnerStrategy getWinnerStrategy() {
		return winnerStrategy;
	}
	
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	public int getNumTeams() {
		return numTeams;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
}