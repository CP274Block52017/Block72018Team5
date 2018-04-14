
 /**
 * This class contains the methods and information for the players
 * on the teams in the tournaments and will be connected to the 
 * database of all the players.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class Players {
	
	private static String name;
	private static String sport;
	private static String gender;
	private static int height;
	private static int gamesPlayed;
	private static int wins;
	private static int losses;
	private static int year;
	
	/**
	 * Constructor for Player class.
	 * @param name - name of the player.
	 */
	public Players(String name, String sport, String gender, int height, int gamesPlayed, int wins, int losses, int year) {
		this.name = name;
		this.sport = sport;
		this.height = height;
		this.gamesPlayed = gamesPlayed;
		this.wins = wins;
		this.losses = losses;
		this.year = year;
		this.gender = gender;
	}
	
	public String getName() {
		return name;
	}
	
	public static void setName(String newName) {
		name = newName;
	}
	
	public String getSport() {
		return sport;
	}
	
	public String getGender() {
		return gender;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int getGamesPlayed() {
		return gamesPlayed;
	}
	
	public int getWins() {
		return wins;
	}
	
	public int getLosses() {
		return losses;
	}
	
	public int getYear() {
		return year;
	}
	
}
