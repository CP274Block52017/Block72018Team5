import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.ResultSet;

/**
 * This class retrieves the information for all of the 
 * players that are currently in the database of athlete
 * players.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class GetPlayers {
	
	private static final String PORT_NUMBER = "8889";
	private static Players newPlayer; 
	
	private static String sport;
	private static String name;
	private static String gender;
	private static int heightInInches;
	private static int gamesPlayed;
	private static int teamWins;
	private static int teamLosses;
	private static int classYear;
	private static int rowCount;
	
	/**
	 * Gets the players entered into the database.
	 * @return
	 */
	public static void getPlayersNames() throws SQLException {
		for(int i = 0; i < GetPlayers.getPlayers().size(); i++) {
			System.out.println(GetPlayers.getPlayers().get(i).getName());
		}
	}
	
	/**
	 * Allows for the printing of the player information
	 * in the database if desired.
	 */
	public static void showInformation() throws SQLException {
		System.out.println("The players selected are: ");
		for(int i = 0; i < GetPlayers.getPlayers().size(); i++) {
			System.out.println("Name: " + GetPlayers.getPlayers().get(i).getName() + ", Sport: " + GetPlayers.getPlayers().get(i).getSport() + 
					", Gender: " + GetPlayers.getPlayers().get(i).getGender() + ", Height(in): " + GetPlayers.getPlayers().get(i).getHeight() + 
					", Games played: " + GetPlayers.getPlayers().get(i).getGamesPlayed() + 
					", Total wins: " +  GetPlayers.getPlayers().get(i).getWins() + ", Total losses: " + GetPlayers.getPlayers().get(i).getLosses() + 
					", Year in school: " + GetPlayers.getPlayers().get(i).getYear());;
			}
		System.out.println("Total number of records = " + rowCount);
	}
	
	public static ArrayList<Players> getPlayers() throws SQLException {
		ArrayList<Players> players = new ArrayList<Players>();
		Players newPlayer = new Players(name, sport, gender, heightInInches, gamesPlayed, teamWins, teamLosses, classYear);
		try (
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:" + PORT_NUMBER + 
					"/AthletePlayers?user=root&password=root");
			Statement statement = conn.createStatement();
		) {	
			
			String getEverything = "select Name, Sport, Gender, Height, GamesPlayed, Wins, Losses, Year from Players";
			ResultSet allPlayers;
			allPlayers = statement.executeQuery(getEverything);
			
			rowCount = 0;
			while(allPlayers.next()) {
				name = allPlayers.getString("Name");
				sport = allPlayers.getString("Sport");
				gender = allPlayers.getString("Gender");
				heightInInches = allPlayers.getInt("Height");
				gamesPlayed = allPlayers.getInt("GamesPlayed");
				teamWins = allPlayers.getInt("Wins");
				teamLosses = allPlayers.getInt("Losses");
				classYear = allPlayers.getInt("Year");
				players.add(newPlayer);
			}	
		} catch (SQLException ex) {
			ex.printStackTrace();
		}
		return players;
	}
	
	public static void main(String[] args) throws SQLException {
		GetPlayers.getPlayersNames();
	}

}
