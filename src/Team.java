import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Nicole
 *
 */
public class Team {
	
	private String teamName;
	private ArrayList<String> teamMembers;
	
	public Team(String teamName, ArrayList<String> teamMembers) {
		this.teamName = teamName;
		this.teamMembers = teamMembers;
	}

	public String getTeamName() {
		return teamName;
	}

	public void addPlayer(String playerName) {
		teamMembers.add(playerName);
	}

}
