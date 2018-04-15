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
				"Sport varchar(50), " +
				"Name varchar(50), " +
				"Height int, " +
				"GamesPlayed int, " +
				"Wins int, " +
				"Losses int, " +
				"Year int, " +
				"primary key (Name));";
			statement.execute(playerTable);
			
			//add all of the players to the table
			String insertPlayers = "insert into Players (Sport, Name, Height, GamesPlayed, Wins, Losses, Year) values "
					+ "('Basketball', 'Joran Meltzer', 63, 25, 2, 23, 2), "
					+ "('Basketball', 'Kaylyn Radtke', 67, 25, 2, 23, 3), "
					+ "('Basketball', 'Payton Katich', 66, 25, 2, 23, 3), "
					+ "('Basketball', 'Casey Torbet', 67, 25, 2, 23, 3), "
					+ "('Basketball', 'Evan Underbrink', 71, 19, 2, 23, 1), "
					+ "('Basketball', 'Christina Bowman', 65, 9, 2, 23, 4), "
					+ "('Basketball', 'Korbyn Ukasiuk', 72, 14, 2, 23, 1), "
					+ "('Basketball', 'CooXooEii Black', 79, 26, 11, 15, 2), "
					+ "('Basketball', 'Edmund Pendleton', 75, 23, 11, 15, 3), "
					+ "('Basketball', 'Chris Martin', 77, 26, 11, 15, 3), "
					+ "('Basketball', 'Nabeel Elabdeia', 75, 5, 11, 15, 1), "
					+ "('Basketball', 'John Hatch', 79, 26, 11, 15, 3), "
					+ "('Volleyball', 'Anna Gurolnick', 62, 34, 28, 6, 2), "
					+ "('Volleyball', 'Lizzy Counts', 65, 34, 28, 6, 2), "
					+ "('Volleyball', 'Abbe Holtze', 70, 21, 28, 6, 4), "
					+ "('Volleyball', 'Glenna Yancey', 76, 33, 28, 6, 4), "
					+ "('Volleyball', 'Aria Dudley', 71, 16, 28, 6, 3), "
					+ "('Volleyball', 'Jordan Mullen', 68, 25, 28, 6, 1), "
					+ "('Lacrosse', 'Sam Mathai', 75, 8, 10, 6, 4), "
					+ "('Lacrosse', 'Tom Haller', 72, 15, 10, 6, 2), "
					+ "('Lacrosse', 'Robbie Stern', 76, 16, 10, 6, 3), "
					+ "('Lacrosse', 'Coby Petau', 70, 16, 10, 6, 1), "
					+ "('Lacrosse', 'Parker Woo', 71, 16, 10, 6, 2), "
					+ "('Lacrosse', 'Carter Richerdson', 72, 10, 10, 6, 2), "
					+ "('Lacrosse', 'Nate Sweet', 75, 9, 10, 6, 3), "
					+ "('Lacrosse', 'Conner Hanney', 70, 16, 10, 6, 4), "
					+ "('Lacrosse', 'Matt Rockwell' 5, 70, 10, 6, 3), "
					+ "('Lacrosse', 'Steph Kelly', 72, 20, 15, 5, 3), "
					+ "('Lacrosse', 'Zoe Frolik', 66, 15, 15, 5, 3), "
					+ "('Lacrosse', 'Ellie Meyer', 68, 20, 15, 5, 2), "
					+ "('Lacrosse', 'Lydia French', 66, 20, 15, 5, 4), "
					+ "('Lacrosse', 'Lauren Pejza', 68, 13, 15, 5, 1), "
					+ "('Lacrosse', 'Avery Melville', 66, 7, 15, 5, 1), "
					+ "('Soccer', 'Clara Richter', 70, 18, 8, 11, 2), "
					+ "('Soccer', 'Kelli Sullivan', 65, 19, 8, 11, 3), "
					+ "('Soccer', 'Lauren Milliet' , 61, 19, 8, 11, 2), "
					+ "('Soccer', 'Catie McDonald', 66, 13, 8, 11, 1), "
					+ "('Soccer', 'Molly Hiniker', 68, 8, 8, 11, 1), "
					+ "('Soccer', 'Chanisse Hendrix', 64, 19, 8, 11, 4), "  
					+ "('Soccer', 'Ali Basom', 64, 16, 8, 11, 3), "
					+ "('Soccer', 'Dana Gornick', 71, 19, 8, 11, 4), "
					+ "('Soccer', 'Keenan Amer', 63, 20, 16, 3, 2), "
					+ "('Soccer', 'Jack McCormick', 75, 18, 16, 3, 4), "
					+ "('Soccer', 'Josh Raizner', 67, 8, 16, 3, 1), "
					+ "('Soccer', 'Hayden Cogswell', 68, 16, 16, 3, 1), "
					+ "('Soccer', 'Griffin Wesley', 71, 18, 16, 3, 2), "
					+ "('Soccer', 'Sam Markin', 70, 15, 16, 3, 3), "
					+ "('Soccer', 'Daniel Kruger', 74, 10, 16, 3, 2), "
					+ "('Hockey', 'Luc Gerdes', 72, 36, 8, 24, 4), "
					+ "('Hockey', 'Alex Berdardinelli', 69, 35, 8, 24, 1), "
					+ "('Hockey', 'Trey Bradley', 69, 9, 8, 24, 2), "
					+ "('Hockey', 'Teemu Kivihalme', 72, 36, 8, 24, 3), "
					+ "('Hockey', 'Trevor Gooch', 73, 21, 8, 24, 2), "
					+ "('Hockey', 'Max St. Pierre', 74, 7, 8, 24, 1),  "
					+ "('Hockey', 'Cole McCaskill', 73, 30, 8, 24, 2),  "
					+ "('Tennis', 'Jenna McDonald', 65, 40, 6, 14, 2)";
			int countInserted = statement.executeUpdate(insertPlayers);
			System.out.println(countInserted + " players inserted.\n");
			
			String getEverything = "select Sport, Name, Height, GamesPlayed, Wins, Losses, Year from Players";
			System.out.println("The SQL Query is: " + getEverything);
			System.out.println();
			
			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getEverything);
			
			System.out.println("The players selected are: ");;
			int rowCount = 0;
			while(allPlayers.next()) {
				String sport = allPlayers.getString("Sport");
				String name = allPlayers.getString("Name");
				int height = allPlayers.getInt("Height");
				System.out.println(sport + ", " + name + ", " + height);;
				rowCount++;
			}
			System.out.println("Total number of records = " + rowCount);
			
			
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
	}
	
	public static ArrayList<Players> getPlayers() {
		System.out.println(players);
		return players;
	}
	
}

