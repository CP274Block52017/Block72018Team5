import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * This class will create a database of athletes/players and their 
 * statistics to be used by the tournament strategies to determine
 * the winner of the tournament. Specific statistics and players
 * can be altered by any potential administrator of the game to fit
 * their desired tournament. 
 * For this project, Colorado College athletes were used. Their statistics and 
 * information was gathered from the Colorado College Athletics page.
 * @author emmablair
 *
 */
public class PlayerDatabase {
	
	public static final String PORT_NUMBER = "8889";
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Constructor is empty.
	 */
	public PlayerDatabase() {
		
	}
	
	/**
	 * 
	 * Creates the database and table of athletes and 
	 * heir information. This information will be used by the 
	 * tournament strategies.
	 * @param args
	 */
	public static void main(String[] args) {
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/ebookshop?user=root&password=root"); // MySQL
			Statement statement = conn.createStatement();
			) {		
			//create the database
			//String database = "create database AthletePlayers";
			//statement.execute(database);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/AthletePlayers?user=root&password=root"); // MySQL

			Statement statement = conn.createStatement();
		) {
			//create a table of all the players
			String playerTable = "create table Players ( " +
				"Name varchar(50), " +
				"Sport varchar(50), " +
				"Gender varchar(50), " +
				"Height (in.) int, " +
				"Games Played (2017-18) int, " +
				"Team's Wins int, " +
				"Team's Losses int, " +
				"Class Year int, " +
				"primary key (Name));";
			statement.execute(playerTable);
			
			//add all of the players to the table
			String insertPlayers = "insert into Players (Name, Sport, Gender, Height (in.), GamesPlayed (2017-18), Team's Wins, Team's Losses, Class Year) values "
					+ "('Joran Meltzer', 'Basketball', 63, 25, 2, 23, 2), "
					+ "('Kaylyn Radtke', 'Basketball', 67, 25, 2, 23, 3), "
					+ "('CooXooEii Black', 'Basketball', 79, 26, 11, 15, 2), "
					+ "('Edmund Pendleton', 'Basketball', 75, 23, 11, 15, 3), "
					+ "('Kelli Sullivan', 'Soccer', 65, 19, 8, 11, 3), "
					+ "('Anna Gurolnick', 'Volleyball', 62, 34, 28, 6, 2), "
					+ "('Lizzy Counts', 'Volleyball', 65, 34, 28, 6, 2), "
					+ "('Sam Mathai', 'Lacrosse', 75, 8, 10, 6, 4), "
					+ "('Tom Haller', 'Lacrosse', 72, 15, 10, 6, 2), "
					+ "('Jenna McDonald', 'Tennis', 65, 40, 6, 14, 2)";
			int countInserted = statement.executeUpdate(insertPlayers);
			System.out.println(countInserted + " players inserted.\n");
			
			String getEverything = "select Name, Sport, Gender, Height (in.), Games Played (2017-18),Team's Wins, Team's Losses, Class Year from Players";

			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getEverything);

			while (allPlayers.next()) {
				String name = allPlayers.getString("Name");
				String sport = allPlayers.getString("Sport");
				String gender = allPlayers.getString("Gender");
				int heightInches = allPlayers.getInt("Height (in.)");
				int gamesPlayed = allPlayers.getInt("GamesPlayed");
				int wins = allPlayers.getInt("Wins");
				int losses = allPlayers.getInt("Losses");
				int classYear = allPlayers.getInt("Class Year");
				players.add(new Player(name, sport, gender, heightInches, gamesPlayed, wins, losses, classYear));
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Gets all of the players entered into the database
	 * @return list of players
	 */
	public static ArrayList<Player> getPlayers() {
		return players;
	}
	
	/**
	 * Gets the number of players in the database
	 * @return number of players
	 */
	public int getNumPlayers() {
		return players.size();
	}
	
}

