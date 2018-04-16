
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
	
	public String toString() {
		return "\nName: " + name + "\nSport: " + sport + "\nGender: " + gender + "\nHeight (in.): " + heightInches + "\nGames Played (2017-18): " 
				+ gamesPlayed + "\nTeam's Wins: " + teamWins + "\nTeam's Losses: " + teamLosses + "\nClass Year: " + classYear;
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSport() {
		return sport;
	}

	public void setSport(String sport) {
		this.sport = sport;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getHeightInches() {
		return heightInches;
	}

	public void setHeightInches(int heightInches) {
		this.heightInches = heightInches;
	}

	public int getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(int gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public int getTeamWins() {
		return teamWins;
	}

	public void setTeamWins(int teamWins) {
		this.teamWins = teamWins;
	}

	public int getTeamLosses() {
		return teamLosses;
	}

	public void setTeamLosses(int teamLosses) {
		this.teamLosses = teamLosses;
	}

	public int getClassYear() {
		return classYear;
	}

	public void setClassYear(int classYear) {
		this.classYear = classYear;
	}
	
}