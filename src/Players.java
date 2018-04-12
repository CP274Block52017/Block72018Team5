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
	 * Name, Height, Age, # of Games Played, # of Minutes, Wins, Losses
	 * Hockey 
	 * Name, Height, Age, # of Games Played, # of Shots, Wins, Losses
	 * Soccer
	 * Name, Height, Age, # of Games Played, # of Minutes, Wins, Losses
	 * Lacrosse
	 * Name, Height, Age, # of Games Played, # of Minutes, Wins, Losses
	 * Tennis ??? 
	 * Name, Height, Age, Matches Played, Matches Played, Wins, Losses
	 * Volleyball
	 * Name, Height, Age, # of Games PLayed, Sets Played, Wins, Losses
	 */
	
	String name;
	
	/**
	 * Constructor for Player class.
	 * @param name - name of the player.
	 */
	public Players(String name) {
		this.name = name;
	}

}
