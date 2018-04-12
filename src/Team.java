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
	
	public Team(String teamName) {
		this.teamName = teamName;
		teamMembers = new ArrayList<String>();
	}
	
	public String getName() {
		return teamName;
	}
	
	public void addPlayer(String playerName) {
		teamMembers.add(playerName);
	}
	
	public String getMembers() {
		String members = "";
		for (String player: teamMembers) {
			if (members.equals("")) {
				members = player;
			}
			else {
				members = members + "\n" + player;
			}
		}
		return members;
	}
	
	public String toString() {
		return getMembers();
	}

}
