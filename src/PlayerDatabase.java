import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

public class PlayerDatabase {
	
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
	
	public static final String PORT_NUMBER = "8889";
	
	private static ArrayList<Players> players = new ArrayList<Players>();
	
	public PlayerDatabase() {
		
	}
	
	public static void main(String[] args) {
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/ebookshop?user=root&password=root"); // MySQL
			Statement statement = conn.createStatement();
			) {		
			//create the database
//			String database = "create database AthletePlayers";
//			statement.execute(database);
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
				"StudentId int not null auto_increment, " +
				"Sport varchar(50), " +
				"Name varchar(50), " +
				"Height int, " +
				"GamesPlayed int, " +
				"Wins int, " +
				"Losses int, " +
				"Year int, " +
				"primary key (StudentId));";
			statement.execute(playerTable);
			
			//add all of the players to the table
			String insertPlayers = "insert into Players (Sport, Name, Height, GamesPlayed, Wins, Losses, Year) values "
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
			
			String getNames = "Select Name From Players";
			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getNames);
			
			while(allPlayers.next()) {
				Players player = new Players(allPlayers.getString("Name"));
				players.add(player);
			}
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<Players> getPlayers() {
		System.out.println(players);
		return players;
	}
	
}
