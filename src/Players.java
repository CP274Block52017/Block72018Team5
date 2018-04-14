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
	
	/**
	 * For the first iteration, we will only use names in order to test strategies
	 * before the database is completely set up.
	 * int height, int age, int gamePlayed, int minutes, int wins, int losses
	 * Possibles attributes for the players / athletes
	 * Basketball
	 * Name, Height, Age, # of Games Played, Wins, Losses
	 * Hockey 
	 * Name, Height, Age, # of Games Played, Wins, Losses
	 * Soccer
	 * Name, Height, Age, # of Games Played, Wins, Losses
	 * Lacrosse
	 * Name, Height, Age, # of Games Played, Wins, Losses
	 * Tennis ??? 
	 * Name, Height, Age, Matches Played, Wins, Losses
	 * Volleyball
	 * Name, Height, Age, # of Games PLayed, Wins, Losses
	 */
	
	String name;
	String sport;
	int height;
	int wins;
	int losses;
	int year;
	
	/**
	 * Constructor for Player class.
	 * @param name - name of the player.
	 */
	public Players(String sport, String name, int height, int wins, int losses, int year) {
		this.name = name;
		this.sport = sport;
		this.height = height;
		this.wins = wins;
		this.losses = losses;
		this.year = year;
	}
	
}
