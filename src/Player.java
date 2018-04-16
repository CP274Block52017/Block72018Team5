
 /**
 * This class contains the methods and information for the players
 * on the teams in the tournaments and will be connected to the 
 * database of all the players.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class Player {
	
	private String name;
	private String sport;
	private String gender;
	private int heightInches;
	private int gamesPlayed;
	private int teamWins;
	private int teamLosses;
	private int classYear;
	
	/**
	 * Constructor for Player class.
	 * @param name - name of the player.
	 */
	public Player(String name, String sport, String gender, int heightInches, int gamesPlayed, int teamWins, int teamLosses, int classYear) {
		this.name = name;
		this.sport = sport;
		this.gender = gender;
		this.heightInches = heightInches;
		this.gamesPlayed = gamesPlayed;
		this.teamWins = teamWins;
		this.teamLosses = teamLosses;
		this.classYear = classYear;
	}
	
	/**
	* Allows for printing of player information
	* @return String - player information.
	*/
	public String toString() {
		return "\nName: " + name + "\nSport: " + sport + "\nGender: " + gender + "\nHeight (in.): " + heightInches + "\nGames Played (2017-18): " 
				+ gamesPlayed + "\nTeam's Wins: " + teamWins + "\nTeam's Losses: " + teamLosses + "\nClass Year: " + classYear;
	}
	
	/**
	* Gets the name of the player.
	* @return String - player name.
	*/
	public String getName() {
		return name;
	}

	/**
	* Sets the name of the player.
	* @param String - player name.
	*/
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	* Gets the sport of the player.
	* @return String - sport sport.
	*/
	public String getSport() {
		return sport;
	}

	/**
	* Sets the sport of the player.
	* @param String - player sport.
	*/
	public void setSport(String sport) {
		this.sport = sport;
	}

	/**
	* Gets the gender of the player.
	* @return String - player gender.
	*/
	public String getGender() {
		return gender;
	}

	/**
	* Sets the gender of the player.
	* @param String - player gender.
	*/
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	/**
	* Gets the height of the player.
	* @return int - player height.
	*/
	public int getHeightInches() {
		return heightInches;
	}

	/**
	* Sets the height of the player.
	* @param int - player height.
	*/
	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	/**
	* Gets the games played for the player.
	* @return int - games played.
	*/
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	/**
	* Sets the number of games played for the player.
	* @param int - games played.
	*/
	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	/**
	* Gets the team wins of the player.
	* @return int - team wins.
	*/
	public int getTeamWins() {
		return teamWins;
	}

	/**
	* Sets the team wins of the player.
	* @param int - team wins.
	*/
	public void setTeamWins(int teamWins) {
		this.teamWins = teamWins;
	}

	/**
	* Gets the team losses of the player.
	* @return int - team losses.
	*/
	public int getTeamLosses() {
		return teamLosses;
	}

	/**
	* Sets the team losses of the player.
	* @param int - team losses.
	*/
	public void setTeamLosses(int teamLosses) {
		this.teamLosses = teamLosses;
	}

	/**
	* Gets the class of the player.
	* @return int - player class year.
	*/
	public int getClassYear() {
		return classYear;
	}

	/**
	* Sets the class year of the player.
	* @param int - class year.
	*/
	public void setClassYear(int classYear) {
		this.classYear = classYear;
	}
	
}
