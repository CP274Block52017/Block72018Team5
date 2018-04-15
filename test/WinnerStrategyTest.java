import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;
import java.util.Collections;

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
	
	private TournamentWinnerStrategy testStrategy;
	private ArrayList<Team> testTeams;
	private ArrayList<Team> testAllStrategiesTeams;
	Team test1;
	Team test2;

	@Before
	public void setUp() {
		testTeams = new ArrayList<Team>();
		Team testTeam1 = new Team("Test Team 1");
		Team testTeam2 = new Team("Test Team 2");
		Team testTeam3 = new Team("Test Team 3");
		Team testTeam4 = new Team("Test Team 4");
		Team testTeam5 = new Team("Test Team 5");
		for (int i = 0; i <= 5; i++) {
			testTeam1.addPlayer(new Players("Emma", "Basketball", "Female", 69, 5, 10, 6, 2));
			testTeam2.addPlayer(new Players("Kelli", "Soccer", "Female", 66, 8, 10, 5, 3));
			testTeam3.addPlayer(new Players("Nicole", "Lacrosse", "Female", 65, 7, 15, 1, 2));
			testTeam4.addPlayer(new Players("Janet", "Golf", "Female", 55, 3, 7, 2, 4));
			testTeam5.addPlayer(new Players("Dan", "Tennis", "Male", 78, 9, 11, 6, 4));
		}
		
		testTeams.add(testTeam1);
		testTeams.add(testTeam2);
		testTeams.add(testTeam3);
		testTeams.add(testTeam4);
		testTeams.add(testTeam5);
		Collections.shuffle(testTeams);
		
		testAllStrategiesTeams = new ArrayList<Team>();
		test1 = new Team("Test 1");
		test1.addPlayer(new Players("Emma", "Basketball", "Female", 5, 6, 10, 5, 4));
		test1.addPlayer(new Players("Kelli", "Soccer", "Female", 7, 8, 12, 7, 3));
		test1.addPlayer(new Players("Nicole", "Lacrosse", "Female", 6, 7, 10, 5, 4));
		test1.addPlayer(new Players("Janet", "Golf", "Female", 7, 8, 12, 7, 3));
		test1.addPlayer(new Players("Dan", "Tennis", "Male", 5, 6, 10, 5, 4));
		
		test2 = new Team("Test 2");
		test2.addPlayer(new Players("Emma", "Basketball", "Female", 3, 4, 8, 1, 2));
		test2.addPlayer(new Players("Kelli", "Soccer", "Female", 5, 6, 10, 3, 3));
		test2.addPlayer(new Players("Nicole", "Lacrosse", "Female", 3, 4, 8, 1, 2));
		test2.addPlayer(new Players("Janet", "Golf", "Female", 5, 6, 10, 3, 3));
		test2.addPlayer(new Players("Dan", "Tennis", "Male", 3, 4, 8, 1, 2));
		
	}
	
	//First Team Wins
	@Test
	public void testsFirstTwoTeams() {
		testStrategy = new FirstTeamWinsStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(0), testTeams.get(1));
		assertEquals(testTeams.get(0), winningTestTeam);
	}
	
	@Test
	public void testsLastTwoTeams() {
		testStrategy = new FirstTeamWinsStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(2), testTeams.get(3));
		assertEquals(testTeams.get(2), winningTestTeam);
	}
	
	@Test
	public void testsFirstandLastTeams() {
		testStrategy = new FirstTeamWinsStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(0), testTeams.get(3));
		assertEquals(testTeams.get(0), winningTestTeam);
	}
	
	@Test
	public void testsMiddleTwoTeams() {
		testStrategy = new FirstTeamWinsStrategy();
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(1), testTeams.get(2));
		assertEquals(testTeams.get(1), winningTestTeam);
	}
	
	
	//ByClassYearStrategy
	@Test
	public void testClassYearStrategy() {
		testStrategy = new ByClassYearStrategy();
		Team winningTestTeam = testStrategy.determineWinner(test1, test2);
		assertEquals(test1, winningTestTeam);
	}
	
	//ByGamesLostStrategy
	@Test
	public void testGamesLostStrategy() {
		testStrategy = new ByGamesLostStrategy();
		Team winningTestTeam = testStrategy.determineWinner(test1, test2);
		assertEquals(test1, winningTestTeam);
	}
	
	//ByGamesPlayedStrategy
	@Test
	public void testGamesPlayedStrategy() {
		testStrategy = new ByGamesPlayedStrategy();
		Team winningTestTeam = testStrategy.determineWinner(test1, test2);
		assertEquals(test1, winningTestTeam);
	}
	
	//ByGamesWonStrategy
	@Test
	public void testGamesWinStrategy() {
		testStrategy = new ByGamesWonStrategy();
		Team winningTestTeam = testStrategy.determineWinner(test1, test2);
		assertEquals(test1, winningTestTeam);
	}
	
	//ByHeightStrategy
	@Test
	public void testHeightStrategy() {
		testStrategy = new ByHeightStrategy();
		Team winningTestTeam = testStrategy.determineWinner(test1, test2);
		assertEquals(test1, winningTestTeam);
	}

}
