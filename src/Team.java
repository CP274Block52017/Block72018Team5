import java.util.ArrayList;
/**
 * This class provides the methods for the teams in
 * of the tournament. 
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class Team {
	
	private String teamName;
	private ArrayList<Players> teamMembers;
	private ArrayList<String> playerNames;
	
	/**
	 * Constructor for the Team class.
	 * @param teamName
	 */
	public Team(String teamName) {
		this.teamName = teamName;
		teamMembers = new ArrayList<Players>();
		playerNames = new ArrayList<String>();
	}
	
	/**
	 * This method provides the name of a team.
	 * @return
	 */
	public String getName() {
		return teamName;
	}
	
	/**
	 * This method adds the players to a team.
	 * @param playerName - name of a player.
	 */
	public void addPlayer(String playerName) {
		playerNames.add(playerName);
	}
	
	/**
	 * Gets the players on a team. 
	 * @return String - players on a team.
	 */
	public String getMembers() {
		String members = "";
		for (Players player: teamMembers) {
//			if (player.getName().equals("")) {
//				members = player;
//			}
//			else {
//				members = members + "\n" + player;
//			}
			members = player.getName();
		}
		return members;
	}
	
	/**
	 * Method to print out the players
	 * of a team.
	 * @return String - players on a team.
	 */
	public String toString() {
		return getMembers();
	}

}