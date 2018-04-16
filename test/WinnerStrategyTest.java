
import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;

/**
 * This test tests the FirstTeamWinsStrategy as of right now, which we created just for the tests cases 
 * because our original RandomWinnerStrategy is untestable since it returns a different winner each time.
 * The list containing the teams is shuffled before each test so that it's not the same exact team being 
 * first in the list and selected as the winner each time.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */

public class WinnerStrategyTest {
	
	private Team testTeam1;
	private Team testTeam2;
	private Team testTeam3;
	private Team testTeam4;
	
	@Before
	public void setUp() {
		testTeam1 = new Team("Test Team 1");
		testTeam2 = new Team("Test Team 2");
		testTeam3 = new Team("Test Team 3");
		testTeam4 = new Team("Test Team 4");
		testTeam1.addPlayer(new Player("Test Player 1", "Soccer", "Female", 75, 50, 20, 30, 2));
		testTeam1.addPlayer(new Player("Test Player 2", "Soccer", "Female", 60, 30, 20, 10, 3));
		testTeam1.addPlayer(new Player("Test Player 3", "Soccer", "Female", 65, 43, 23, 20, 4));
		
		testTeam2.addPlayer(new Player("Test Player 1", "Soccer", "Female", 45, 56, 21, 34, 2));
		testTeam2.addPlayer(new Player("Test Player 2", "Soccer", "Female", 61, 52, 22, 11, 2));
		testTeam2.addPlayer(new Player("Test Player 3", "Soccer", "Female", 65, 44, 26, 17, 4));
		
		testTeam3.addPlayer(new Player("Test Player 1", "Soccer", "Female", 75, 50, 20, 30, 2));
		testTeam3.addPlayer(new Player("Test Player 2", "Soccer", "Female", 75, 50, 20, 30, 2));
		testTeam3.addPlayer(new Player("Test Player 3", "Soccer", "Female", 75, 50, 20, 30, 2));
		
		testTeam4.addPlayer(new Player("Test Player 1", "Soccer", "Female", 61, 52, 22, 11, 3));
		testTeam4.addPlayer(new Player("Test Player 2", "Soccer", "Female", 61, 52, 22, 11, 3));
		testTeam4.addPlayer(new Player("Test Player 3", "Soccer", "Female", 61, 52, 22, 11, 3));
	}
	
	@Test
	public void testOnePlayerPerTeamByHeight() {
		TournamentWinnerStrategy testStrategy = new ByHeightStrategy();
		Team newTestTeam1 = new Team("Test Team 1");
		newTestTeam1.addPlayer(new Player("Test Player 1", "Soccer", "Female", 55, 37, 24, 11, 2));
		Team newTestTeam2 = new Team("Test Team 2");
		newTestTeam2.addPlayer(new Player("Test Player 2", "Soccer", "Female", 23, 27, 19, 10, 3));
		Team winningTestTeam = testStrategy.determineWinner(newTestTeam1, newTestTeam2);
		assertEquals(newTestTeam1, winningTestTeam);
	}
	
	@Test
	public void testOnePlayerPerTeamByGamesPlayed() {
		TournamentWinnerStrategy testStrategy = new ByGamesPlayedStrategy();
		Team newTestTeam1 = new Team("Test Team 1");
		newTestTeam1.addPlayer(new Player("Test Player 1", "Soccer", "Female", 55, 37, 24, 11, 2));
		Team newTestTeam2 = new Team("Test Team 2");
		newTestTeam2.addPlayer(new Player("Test Player 2", "Soccer", "Female", 23, 27, 19, 10, 3));
		Team winningTestTeam = testStrategy.determineWinner(newTestTeam1, newTestTeam2);
		assertEquals(newTestTeam1, winningTestTeam);
	}
	
	@Test
	public void testOnePlayerPerTeamByGamesWon() {
		TournamentWinnerStrategy testStrategy = new ByGamesWonStrategy();
		Team newTestTeam1 = new Team("Test Team 1");
		newTestTeam1.addPlayer(new Player("Test Player 1", "Soccer", "Female", 55, 37, 24, 11, 2));
		Team newTestTeam2 = new Team("Test Team 2");
		newTestTeam2.addPlayer(new Player("Test Player 2", "Soccer", "Female", 23, 27, 19, 10, 3));
		Team winningTestTeam = testStrategy.determineWinner(newTestTeam1, newTestTeam2);
		assertEquals(newTestTeam1, winningTestTeam);
	}
	
	@Test
	public void testOnePlayerPerTeamByGamesLost() {
		TournamentWinnerStrategy testStrategy = new ByGamesLostStrategy();
		Team newTestTeam1 = new Team("Test Team 1");
		newTestTeam1.addPlayer(new Player("Test Player 1", "Soccer", "Female", 55, 37, 24, 14, 2));
		Team newTestTeam2 = new Team("Test Team 2");
		newTestTeam2.addPlayer(new Player("Test Player 2", "Soccer", "Female", 23, 27, 19, 10, 3));
		Team winningTestTeam = testStrategy.determineWinner(newTestTeam1, newTestTeam2);
		assertEquals(newTestTeam1, winningTestTeam);
	}
	
	@Test
	public void testOnePlayerPerTeamByClassYear() {
		TournamentWinnerStrategy testStrategy = new ByClassYearStrategy();
		Team newTestTeam1 = new Team("Test Team 1");
		newTestTeam1.addPlayer(new Player("Test Player 1", "Soccer", "Female", 55, 37, 24, 11, 2));
		Team newTestTeam2 = new Team("Test Team 2");
		newTestTeam2.addPlayer(new Player("Test Player 2", "Soccer", "Female", 23, 27, 19, 10, 3));
		Team winningTestTeam = testStrategy.determineWinner(newTestTeam1, newTestTeam2);
		assertEquals(newTestTeam2, winningTestTeam);
	}
	
	@Test 
	public void testAllPlayersEqualOnTeamByHeight() {
		TournamentWinnerStrategy testStrategy = new ByHeightStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam3, testTeam4);
		assertEquals(testTeam3, winningTestTeam);
	}
	
	@Test 
	public void testAllPlayersEqualOnTeamByGamesPlayed() {
		TournamentWinnerStrategy testStrategy = new ByGamesPlayedStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam3, testTeam4);
		assertEquals(testTeam4, winningTestTeam);
	}
	
	@Test 
	public void testAllPlayersEqualOnTeamByGamesWon() {
		TournamentWinnerStrategy testStrategy = new ByGamesWonStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam3, testTeam4);
		assertEquals(testTeam4, winningTestTeam);
	}
	
	@Test 
	public void testAllPlayersEqualOnTeamByGamesLost() {
		TournamentWinnerStrategy testStrategy = new ByGamesLostStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam3, testTeam4);
		assertEquals(testTeam3, winningTestTeam);
	}
	
	@Test 
	public void testAllPlayersEqualOnTeamByClassYear() {
		TournamentWinnerStrategy testStrategy = new ByClassYearStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam3, testTeam4);
		assertEquals(testTeam4, winningTestTeam);
	}
	
	@Test
	public void testFivePlayerTeamsByHeight() {
		TournamentWinnerStrategy testStrategy = new ByHeightStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam1, testTeam2);
		assertEquals(testTeam1, winningTestTeam);
	}
	
	@Test
	public void testFivePlayerTeamsByGamesPlayed() {
		TournamentWinnerStrategy testStrategy = new ByGamesPlayedStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam1, testTeam2);
		assertEquals(testTeam2, winningTestTeam);
	}
	
	@Test
	public void testFivePlayerTeamsByGamesWon() {
		TournamentWinnerStrategy testStrategy = new ByGamesWonStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam1, testTeam2);
		assertEquals(testTeam2, winningTestTeam);
	}
	
	@Test
	public void testFivePlayerTeamsByGamesLost() {
		TournamentWinnerStrategy testStrategy = new ByGamesLostStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam1, testTeam2);
		assertEquals(testTeam2, winningTestTeam);
	}
	
	@Test
	public void testFivePlayerTeamsByClassYear() {
		TournamentWinnerStrategy testStrategy = new ByClassYearStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeam1, testTeam2);
		assertEquals(testTeam1, winningTestTeam);
	}

}


