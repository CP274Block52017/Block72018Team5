import java.util.ArrayList;
/**
 * This class contains the methods for creating
 * a tournament. 
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

	
	/**
	 * Constructor contains needed information for creating
	 * a new tournament.
	 * @param name - name of the tournament.
	 * @param numTeams - number of teams in the tournament.
	 * @param winnerStrategy - strategy to determine the winner.
	 */
	public Tournament(String name, int numTeams, TournamentWinnerStrategy winnerStrategy) {
		this.name = name;
		this.numTeams = numTeams;
		this.winnerStrategy = winnerStrategy;
		teams = new ArrayList<Team>();
	}

	/**
	 * Gets the chosen winner strategy.
	 * @return TournamentWinerStrategy - strategy to determine the winner.
	 */
	public TournamentWinnerStrategy getWinnerStrategy() {
		return winnerStrategy;
	}
	
	/**
	 * Adds a team to the list of teams in the tournament.
	 * @param team - team to add to the tournament.
	 */
	public void addTeam(Team team) {
		teams.add(team);
	}
	
	/**
	 * Gets the number of teams in the tournament.
	 * @return int - number of teams in the tournament.
	 */
	public int getNumTeams() {
		return numTeams;
	}
	
	/**
	 * Gets the teams in the tournament.
	 * @return ArrayList<Team> - teams in the tournament.
	 */
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	/**
	 * Allows us to set winner of tournament if we want to
	 * @param winner of the tournament
	 */
	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
}

