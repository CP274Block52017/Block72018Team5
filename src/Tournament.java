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

}
