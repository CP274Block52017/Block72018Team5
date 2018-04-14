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
	
	private static ArrayList<Players> players = new ArrayList<Players>();
	private static int rowCount;
	
	/**
	 * Constructor is empty.
	 */
	public PlayerDatabase() {
		
	}
	
	/**
	 * 
	 * Creates the database and table of athletes and 
	 * their information. This information will be used by the 
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
				"GamesPlayed int, " +
				"Wins int, " +
				"Losses int, " +
				"Class Year int, " +
				"primary key (Name));";
			statement.execute(playerTable);
			
			//add all of the players to the table
			String insertPlayers = "insert into Players (Name, Sport, Gender, Height, GamesPlayed, Wins, Losses, Year) values "
					+ "('Basketball', 'Joran Meltzer', 63, 25, 2, 23, 2), "
					+ "('Basketball', 'Kaylyn Radtke', 67, 25, 2, 23, 3), "
					+ "('Basketball', 'CooXooEii Black', 79, 26, 11, 15, 2), "
					+ "('Basketball', 'Edmund Pendleton', 75, 23, 11, 15, 3), "
					+ "('Soccer', 'Kelli Sullivan', 65, 19, 8, 11, 3), "
					+ "('Volleyball', 'Anna Gurolnick', 62, 34, 28, 6, 2), "
					+ "('Volleyball', 'Lizzy Counts', 65, 34, 28, 6, 2), "
					+ "('Lacrosse', 'Sam Mathai', 75, 8, 10, 6, 4), "
					+ "('Lacrosse', 'Tom Haller', 72, 15, 10, 6, 2), "
					+ "('Tennis', 'Jenna McDonald', 65, 40, 6, 14, 2)";
			int countInserted = statement.executeUpdate(insertPlayers);
			System.out.println(countInserted + " players inserted.\n");
			
			String getEverything = "select Name, Sport, Gender, Height, GamesPlayed, Wins, Losses, Year from Players";

			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getEverything);

			rowCount = 0;
			while(allPlayers.next()) {
				String name = allPlayers.getString("Name");
				String sport = allPlayers.getString("Sport");
				String gender = allPlayers.getString("Gender");
				int heightInches = allPlayers.getInt("Height (in.)");
				int gamesPlayed = allPlayers.getInt("GamesPlayed");
				int wins = allPlayers.getInt("Wins");
				int losses = allPlayers.getInt("Losses");
				int classYear = allPlayers.getInt("Class Year");
				rowCount++;
				players.add(new Player(name, sport, gender, heightInches, gamesPlayed, wins, losses, classYear))
			}
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	/**
	 * Gets the players entered into the database.
	 * @return
	 */
	public static ArrayList<Players> getPlayers() {
		System.out.println(players);
		return players;
	}
	
	/**
	 * Allows for the printing of the player information
	 * in the database if desired.
	 */
	public static void showInformation() {
		System.out.println("The players selected are: ");;
		System.out.println("Name: " + name + "\nSport: " + gender + "\nGender" + sport + "\nHeight(in): " + height + "\nGames played: " + gamesPlayed + 
				"\nTotal wins: " +  wins + "\nTotal losses: " + losses + "\nYear in school: " + year);;
		System.out.println("Total number of records = " + rowCount);
	}
	
}

