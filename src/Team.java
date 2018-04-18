
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
	private ArrayList<Player> teamMembers;
	private double lastRoundAverage;
	
	/**
	 * Constructor for the Team class.
	 * @param teamName
	 */
	public Team(String teamName) {
		this.teamName = teamName;
		teamMembers = new ArrayList<Player>();
		lastRoundAverage = 0.0;
	}
	
	/**
	 * Gets the players that are on this team
	 * @return array list of the players on the team
	 */
	public ArrayList<Player> getTeamMembersList() {
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
	public void addPlayer(Player newPlayer) {
		teamMembers.add(newPlayer);
	}
	
	/**
	 * Gets the players on a team. 
	 * @return String - players on a team.
	 */
	public String getMembers() {
		String members = "";
		for (Player player: teamMembers) {
			if (members.equals("")) {
				members = player.getName();
			}
			else {
				members = members + "\n" + player.getName();
			}
		}
		return members;
	}
	
	/**
	 * gets the size of the team
	 * @return size of the team
	 */
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

	/**
	 * gets the average of the last round
	 * @return double - corresponds to last round's average
	 */
	public double getLastRoundAverage() {
		return lastRoundAverage;
	}

	/**
	 * set the average of the last round
	 * @param double - the average you want to set the last round to
	 */
	public void setLastRoundAverage(double lastRoundAverage) {
		this.lastRoundAverage = lastRoundAverage;

	}

}

