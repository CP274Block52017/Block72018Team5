<<<<<<< HEAD
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
	
	public static final String PORT_NUMBER = "3306";
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Constructor is empty.
	 */
	public PlayerDatabase() {
		
	}
	
	private static void createDatabase() {
		try (
			Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:" + PORT_NUMBER + "/?user=root&password=root");
			Statement statement = conn.createStatement();
		) {		
			//create the database
			String database = "create database if not exists AthletePlayers";
			statement.execute(database);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void createTable() {
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/AthletePlayers?user=root&password=root"); // MySQL

			Statement statement = conn.createStatement();
		) {
			//create a table of all the players
			String playerTable = "create table if not exists Players ( " +
				"Name varchar(50), " +
				"Sport varchar(50), " +
				"Gender varchar(50), " +
				"Height int, " +
				"GamesPlayed int, " +
				"TeamWins int, " +
				"TeamLosses int, " +
				"ClassYear int, " +
				"primary key (Name));";
			statement.execute(playerTable);
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	private static void addPlayersToDatabase() {
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + 
				"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {
			//add all of the players to the table
			String insertPlayers = "insert ignore into Players (Name, Sport, Gender, Height, GamesPlayed, TeamWins, TeamLosses, ClassYear) values "
					+ "('Joran Meltzer', 'Basketball', 'Female', 63, 25, 2, 23, 2), "
					+ "('Kaylyn Radtke', 'Basketball', 'Female', 67, 25, 2, 23, 3), "
					+ "('CooXooEii Black', 'Basketball', 'Male', 79, 26, 11, 15, 2), "
					+ "('Edmund Pendleton', 'Basketball', 'Male', 75, 23, 11, 15, 3), "
					+ "('Kelli Sullivan', 'Soccer', 'Female', 65, 19, 8, 11, 3), "
					+ "('Anna Gurolnick', 'Volleyball', 'Female', 62, 34, 28, 6, 2), "
					+ "('Lizzy Counts', 'Volleyball', 'Female', 65, 34, 28, 6, 2), "
					+ "('Sam Mathai', 'Lacrosse', 'Male', 75, 8, 10, 6, 4), "
					+ "('Tom Haller', 'Lacrosse', 'Male', 72, 15, 10, 6, 2), "
					+ "('Jenna McDonald', 'Tennis', 'Female', 65, 40, 6, 14, 2)";
			int countInserted = statement.executeUpdate(insertPlayers);
			if (countInserted != 0) {
				System.out.println(countInserted + " players inserted.\n");
			}
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	private static void getPlayersFromDatabase() {
		try (
				Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/AthletePlayers?user=root&password=root");
				Statement statement = conn.createStatement();
		) {
			String getEverything = "select Name, Sport, Gender, Height, GamesPlayed, TeamWins, TeamLosses, ClassYear from Players";
	
			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getEverything);
	
			while (allPlayers.next()) {
				String name = allPlayers.getString("Name");
				String sport = allPlayers.getString("Sport");
				String gender = allPlayers.getString("Gender");
				int heightInches = allPlayers.getInt("Height");
				int gamesPlayed = allPlayers.getInt("GamesPlayed");
				int wins = allPlayers.getInt("TeamWins");
				int losses = allPlayers.getInt("TeamLosses");
				int classYear = allPlayers.getInt("ClassYear");
				players.add(new Player(name, sport, gender, heightInches, gamesPlayed, wins, losses, classYear));
			}
		}
		catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	/**
	 * Gets all of the players entered into the database
	 * @return list of players
	 */
	public static ArrayList<Player> getPlayersList() {
		return players;
	}
	
	public static Player findPlayer(String playerName) {
		for (Player player : players) {
			if (playerName.equalsIgnoreCase(player.getName())) {
				return player;
			}
		}
		return null;
	}
	
	/**
	 * Gets the number of players in the database
	 * @return number of players
	 */
	public static int getNumPlayers() {
		return players.size();
	}
	
	
	/**
	 * 
	 * Creates the database and table of athletes and 
	 * their information. This information will be used by the 
	 * tournament strategies.
	 */
	public static void generateDatabase() {
		createDatabase();
		createTable();
		addPlayersToDatabase();		
		getPlayersFromDatabase();
	}

	
}

