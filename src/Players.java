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
	
	/**
	 * Constructor for Player class.
	 * @param name - name of the player.
	 */
	public Players(String name) {
		this.name = name;
	}
	
	public static ArrayList<String> getAllPlayers() {
		ArrayList<String> player_names = new ArrayList<String>();
		for(int i = 0; i < PlayerDatabase.getPlayers().size(); i++) {
			player_names.add(PlayerDatabase.getPlayers().get(i).toString());
		}
		System.out.println(player_names);
		return player_names;
	}
	
	public static void main(String[] args) {
		getAllPlayers();
	}

}
