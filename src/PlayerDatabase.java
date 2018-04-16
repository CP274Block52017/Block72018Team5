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
					+ "('Payton Katich', 'Basketball', 'Female', 66, 25, 2, 23, 3), "
					+ "('Casey Torbet', 'Basketball', 'Female', 67, 25, 2, 23, 3), "
					+ "('Evan Underbrink', 'Basketball', 'Female', 71, 19, 2, 23, 1), "
					+ "('Christina Bowman', 'Basketball', 'Female', 65, 9, 2, 23, 4), "
					+ "('Korbyn Ukasiuk', 'Basketball', 'Female', 72, 14, 2, 23, 1), "
					+ "('CooXooEii Black', 'Basketball', 'Male', 79, 26, 11, 15, 2), "
					+ "('Edmund Pendleton', 'Basketball', 'Male', 75, 23, 11, 15, 3), "
					+ "('Chris Martin', 'Basketball', 'Male', 77, 26, 11, 15, 3), "
					+ "('Nabeel Elabdeia', 'Basketball', 'Male', 75, 5, 11, 15, 1), "
					+ "('John Hatch', 'Basketball', 'Male', 79, 26, 11, 15, 3), "
					+ "('Anna Gurolnick', 'Volleyball', 'Female',62, 34, 28, 6, 2), "
					+ "('Lizzy Counts', 'Volleyball', 'Female', 65, 34, 28, 6, 2), "
					+ "('Abbe Holtze', 'Volleyball', 'Female', 70, 21, 28, 6, 4), "
					+ "('Glenna Yancey', 'Volleyball', 'Female', 76, 33, 28, 6, 4), "
					+ "('Aria Dudley', 'Volleyball', 'Female', 71, 16, 28, 6, 3), "
					+ "('Jordan Mullen', 'Volleyball', 'Female', 68, 25, 28, 6, 1), "
					+ "('Sam Mathai', 'Lacrosse', 'Male', 75, 8, 10, 6, 4), "
					+ "('Tom Haller', 'Lacrosse', 'Male', 72, 15, 10, 6, 2), "
					+ "('Robbie Stern', 'Lacrosse', 'Male', 76, 16, 10, 6, 3), "
					+ "('Coby Petau', 'Lacrosse', 'Male', 70, 16, 10, 6, 1), "
					+ "('Parker Woo', 'Lacrosse', 'Male', 71, 16, 10, 6, 2), "
					+ "('Carter Richerdson', 'Lacrosse', 'Male', 72, 10, 10, 6, 2), "
					+ "('Nate Sweet', 'Lacrosse', 'Male', 75, 9, 10, 6, 3), "
					+ "('Conner Hanney', 'Lacrosse', 'Male', 70, 16, 10, 6, 4), "
					+ "('Matt Rockwell', 'Lacrosse', 'Male', 75, 70, 10, 6, 3), "
					+ "('Steph Kelly', 'Lacrosse', 'Female', 72, 20, 15, 5, 3), "
					+ "('Zoe Frolik', 'Lacrosse', 'Female', 66, 15, 15, 5, 3), "
					+ "('Ellie Meyer', 'Lacrosse', 'Female', 68, 20, 15, 5, 2), "
					+ "('Lydia French', 'Lacrosse', 'Female', 66, 20, 15, 5, 4), "
					+ "('Lauren Pejza','Lacrosse', 'Female', 68, 13, 15, 5, 1), "
					+ "('Avery Melville', 'Lacrosse', 'Female', 66, 7, 15, 5, 1), "
					+ "('Clara Richter', 'Soccer', 'Female', 70, 18, 8, 11, 2), "
					+ "('Kelli Sullivan', 'Soccer', 'Female', 65, 19, 8, 11, 3), "
					+ "('Lauren Milliet' , 'Soccer', 'Female', 61, 19, 8, 11, 2), "
					+ "('Catie McDonald', 'Soccer', 'Female', 66, 13, 8, 11, 1), "
					+ "('Molly Hiniker', 'Soccer', 'Female', 68, 8, 8, 11, 1), "
					+ "('Chanisse Hendrix', 'Soccer', 'Female', 64, 19, 8, 11, 4), "  
					+ "('Ali Basom', 'Soccer', 'Female', 64, 16, 8, 11, 3), "
					+ "('Dana Gornick', 'Soccer', 'Female', 71, 19, 8, 11, 4), "
					+ "('Keenan Amer', 'Soccer', 'Male', 63, 20, 16, 3, 2), "
					+ "('Jack McCormick', 'Soccer', 'Male', 75, 18, 16, 3, 4), "
					+ "('Josh Raizner', 'Soccer', 'Male', 67, 8, 16, 3, 1), "
					+ "('Hayden Cogswell', 'Soccer', 'Male', 68, 16, 16, 3, 1), "
					+ "('Griffin Wesley', 'Soccer', 'Male', 71, 18, 16, 3, 2), "
					+ "('Sam Markin', 'Soccer', 'Male', 70, 15, 16, 3, 3), "
					+ "('Daniel Kruger', 'Soccer', 'Male', 74, 10, 16, 3, 2), "
					+ "('Luc Gerdes', 'Hockey', 'Male', 72, 36, 8, 24, 4), "
					+ "('Alex Berdardinelli', 'Hockey', 'Male', 69, 35, 8, 24, 1), "
					+ "('Trey Bradley', 'Hockey', 'Male', 69, 9, 8, 24, 2), "
					+ "('Teemu Kivihalme', 'Hockey', 'Male', 72, 36, 8, 24, 3), "
					+ "('Trevor Gooch', 'Hockey', 'Male', 73, 21, 8, 24, 2), "
					+ "('Max St. Pierre', 'Hockey', 'Male', 74, 7, 8, 24, 1), "
					+ "('Cole McCaskill', 'Hockey', 'Male', 73, 30, 8, 24, 2)";
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


