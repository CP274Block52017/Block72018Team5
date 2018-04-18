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
	private int maxNumTeams;
	private TournamentWinnerStrategy winnerStrategy;
	private ArrayList<Team> teams;
	private Team winner;

	
	/**
	 * Constructor contains needed information for creating
	 * a new tournament.
	 * @param name - name of the tournament.
	 * @param maxNumTeams - max number of teams in the tournament, as chosen by tournament master (equal to number of participants)
	 * @param winnerStrategy - strategy to determine the winner.
	 */
	public Tournament(String name, int maxNumTeams, TournamentWinnerStrategy winnerStrategy) {
		this.name = name;
		this.maxNumTeams = maxNumTeams;
		this.winnerStrategy = winnerStrategy;
		teams = new ArrayList<Team>();
	}

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
	
	public String getName() {
		return name;
	}

	public int getMaxNumTeams() {
		return maxNumTeams;
	}
	
	public ArrayList<Team> getTeams() {
		return teams;
	}
	
	/**
	 * Gets the names of the teams in the tournament.
	 * @return names of teams in the tournament.
	 */
	public ArrayList<String> getTeamNames() {
		ArrayList<String> teamNames = new ArrayList<String>();
		for (Team team : teams) {
			String teamName = team.getName();
			teamNames.add(teamName);
		}
		return teamNames;
	}
	
	/**
	 * Gets the current number of teams in the tournament.
	 * @return current number of teams in the tournament.
	 */
	public int getNumTeams() {
		return teams.size();
	}

	public void setWinner(Team winner) {
		this.winner = winner;
	}
	
}

