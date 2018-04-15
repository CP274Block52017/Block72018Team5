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
	private int lastRoundAverage;
	
	/**
	 * Constructor for the Team class.
	 * @param teamName
	 */
	public Team(String teamName) {
		this.teamName = teamName;
		teamMembers = new ArrayList<Players>();
		lastRoundAverage = 0;
	}
	
	public ArrayList<Players> getTeamMembersList() {
		return teamMembers;
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
	public void addPlayer(Players newPlayer) {
		teamMembers.add(newPlayer);
	}
	
	/**
	 * Gets the players on a team. 
	 * @return String - players on a team.
	 */
	public String getMembers() {
		String members = "";
		for (Players player: teamMembers) {
			if (members.equals("")) {
				members = player.getName();
			}
			else {
				members = members + "\n" + player.getName();
			}
		}
		return members;
	}
	
	public int getTeamSize() {
		return teamMembers.size();
	}
	
	/**
	 * Method to print out the players
	 * of a team.
	 * @return String - players on a team.
	 */
	public String toString() {
		return getMembers();
	}

	public int getLastRoundAverage() {
		return lastRoundAverage;
	}

	public void setLastRoundAverage(int lastRoundAverage) {
		this.lastRoundAverage = lastRoundAverage;
	}

}