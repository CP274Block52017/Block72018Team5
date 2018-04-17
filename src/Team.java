
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
	 * @param teamName - name of the team
	 */
	public Team(String teamName) {
		this.teamName = teamName;
		teamMembers = new ArrayList<Player>();
		lastRoundAverage = 0.0;
	}
	/**
	*This method returns the lists of players that are on this team
	*@return Array list of players on the team
	**/
	
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
	*Gets the size of the team
	*@return number of players on team
	**/
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
	*returns the average for the last round
	*@return the last round average
	**/
	public double getLastRoundAverage() {
		return lastRoundAverage;
	}
	/**
	* Sets the average for the last round
	*@param the average number for the last round we want to set
	**/		
	public void setLastRoundAverage(double lastRoundAverage) {
		this.lastRoundAverage = lastRoundAverage;
	}

}

