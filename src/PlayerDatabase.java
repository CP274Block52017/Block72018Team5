import java.io.File;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;
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
public class PlayerDatabase {
	
	public static final String PORT_NUMBER = "3306";
	
	private static ArrayList<Player> players = new ArrayList<Player>();
	
	/**
	 * Constructor is empty.
	 */
	public PlayerDatabase() {
		
	}
	
	/**
	*This method actually creates the database using mySQL 
	**/
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
	
	/**
	*This method adds all the schema we want in our database
	*It creates a table of players containing their name, sport, gender, height
	*games played, teams wins, team losses, class year, and it makes the name the
	*primary key of this table is going to be the player name
	**/
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
	
	/**
	*This method puts the players into the table we generated above
	*in the database that we have already created. We got this information
	*about CC athletes from the 2016-2017 season, but the athletes are read in
	*from a file which can be replaced with a another file containing a different set of
	*athletes from another school.
	**/
	private static void addPlayersToDatabase() {
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + 
				"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {
			File athletesFile = new File("athletes.txt");
			int countInserted = 0;
			//add all of the players from the file to the table
			try {
				Scanner scan = new Scanner(athletesFile);
				while (scan.hasNextLine()) {
					String currentAthlete = scan.nextLine();
					String insertPlayer = "insert ignore into Players (Name, Sport, Gender, Height, GamesPlayed, TeamWins, TeamLosses, ClassYear) value "
							+ "("+currentAthlete+")";
					countInserted += statement.executeUpdate(insertPlayer);
				}
			} 
			catch (FileNotFoundException exception) {
				System.out.println(exception);
			}
			if (countInserted > 0) {
				System.out.println(countInserted + " players inserted.\n");
			}
		} 
		catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	/**This method grabs the players from our database
	*and getting their inforamtion
	**/
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
		
	/** This method searches the arraylist of players for 
	*a specific player to see if there is a match
	*@param name of the player we want to find
	*@return player - the player we want
	**/
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
	 * Calls the methods to create the database and table of athletes and 
	 * their information, as well as store the players in an arraylist. 
	 * This information will be used by the tournament strategies.
	 */
	public static void generateDatabase() {
		createDatabase();
		createTable();
		addPlayersToDatabase();		
		getPlayersFromDatabase();
	}
	
}

