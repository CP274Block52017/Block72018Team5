import java.util.ArrayList;

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
	private static int wins;
	private static int losses;
	private static int year;
	
	/**
	 * Constructor for Player class.
	 * @param name - name of the player.
	 */
	public Players(String sport, String name, String gender, int height, int wins, int losses, int year) {
		this.name = name;
		this.sport = sport;
		this.height = height;
		this.wins = wins;
		this.losses = losses;
		this.year = year;
		this.gender = gender;
	}
	
	public static String getName() {
		return name;
	}
	
	public static String getSport() {
		return sport;
	}
	
	public static int getHeight() {
		return height;
	}
	
	public static int getWins() {
		return wins;
	}
	
	public static int getLosses() {
		return losses;
	}
	
	public static int getYear() {
		return year;
	}
	
	public static String getGender() {
		return gender;
	}
	
}
