import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

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
	
	/**
	 * Constructor is empty.
	 */
	public CreatePlayerDatabase() {
		
	}
	
	public static void createDatabase() {
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
	
	public static void createTable() {
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
	
	public static void addPlayers() {
		try (
			Connection conn = DriverManager.getConnection(
				"jdbc:mysql://localhost:" + PORT_NUMBER + 
				"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {
		String insertPlayers = "insert into Players (Name, Sport, Gender, Height, GamesPlayed, Wins, Losses, Year) values "
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
		System.out.println(countInserted + " players inserted.\n");
		} catch (SQLException ex) {
			ex.printStackTrace();
		}	
	}
	
	/**
	 * Creates the database and table of athletes and 
	 * their information. This information will be used by the 
	 * tournament strategies.
	 * @param args
	 */
	public static void main(String[] args) {
		CreatePlayerDatabase.createDatabase();
		CreatePlayerDatabase.createTable();
		CreatePlayerDatabase.addPlayers();
	}
}
