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
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class CreatePlayerDatabase {
	
	public static final String PORT_NUMBER = "8889";
	public static ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Constructor is empty.
	 */
	public CreatePlayerDatabase() {
		
	}
	
	/**
	 * Creates a database to store all of the players/athletes.
	 */
	private static void createDatabase() {
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + 
				"/?user=root&password=root");
			Statement statement = conn.createStatement();
		) {		
			//create the database
			String database = "create database AthletePlayers";
			statement.execute(database);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Creates a table with the specified attributes for each player.
	 */
	private static void createTable() {
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + 
				"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {
			//create a table of all the players
			String playerTable = "create table Players ( " +
				"Name varchar(50), " +
				"Sport varchar(50), " +
				"Gender varchar(50), " +
				"Height int, " +
				"GamesPlayed int, " +
				"Wins int, " +
				"Losses int, " +
				"Year int, " +
				"primary key (Name));";
			statement.execute(playerTable);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	/**
	 * Adds all of the players and their attributes to the database. Should 
	 * be 55 total inserted into the Players table.
	 */
	private static void addPlayers() {
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + 
				"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {
		String insertPlayers = "insert into Players (Name, Sport, Gender, Height, GamesPlayed, Wins, Losses, Year) values "
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
		System.out.println(countInserted + " players inserted.\n");
		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	/**
	 * Creates players with the given attributes of each player in
	 * the database and stores them all in an arraylist.
	 */
	public static ArrayList<Player> getPlayers() {
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {	
			String getEverything = "select Name, Sport, Gender, Height, GamesPlayed, Wins, Losses, Year from Players";
			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getEverything);
			
			int rowCount = 0;
			while(allPlayers.next()) {
				String name = allPlayers.getString("Name");
				String sport = allPlayers.getString("Sport");
				String gender = allPlayers.getString("Gender");
				int heightInInches = allPlayers.getInt("Height");
				int gamesPlayed = allPlayers.getInt("GamesPlayed");
				int teamWins = allPlayers.getInt("Wins");
				int teamLosses = allPlayers.getInt("Losses");
				int classYear = allPlayers.getInt("Year");
				players.add(new Player(name, sport, gender, heightInInches, gamesPlayed, teamWins, teamLosses, classYear));
				rowCount++;
			}		
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return players;
	}
	
	public static ArrayList<Player> getPlayerList() {
		return players;
	}
	
	public static Player findPlayer(String playerName) {
		for (Player player : players) {
			if (playerName.equals(player.getName())) {
				return player;
			}
		}
		return null;
	}
	
	public static void showInformation() {
		System.out.println("The players in database are: ");;
		int rowCount = 1;
		for(int i = 0; i < players.size(); i++) {
			System.out.println("Name: " + players.get(i).getName() + ", Sport: " + players.get(i).getSport() 
								+ ", Gender: " + players.get(i).getGender() + ", Height in inches: " + players.get(i).getHeightInches() 
								+ ", Games played: " + players.get(i).getGamesPlayed() + ", Total wins: " + players.get(i).getGamesPlayed()  + ", Total losses: " 
								+ players.get(i).getTeamWins() + ", Year in school: " + players.get(i).getTeamLosses());;
			System.out.println("Player Total = " + rowCount);
			rowCount++;
		}
		System.out.println("Total number of players = " + (rowCount - 1));
	}
	
	/**
	 * Creates the database and table of athletes and 
	 * their information. This information will be used by the 
	 * tournament strategies.
	 * @param args
	 */
	public static void main(String[] args) {
//		CreatePlayerDatabase.createDatabase();
//		CreatePlayerDatabase.createTable();
//		CreatePlayerDatabase.addPlayers();
		CreatePlayerDatabase.getPlayers();
		CreatePlayerDatabase.getPlayerList();
		//CreatePlayerDatabase.showInformation();
	}
	
}

