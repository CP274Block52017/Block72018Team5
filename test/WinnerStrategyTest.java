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

	@Before
	public void setUp() {
		TournamentWinnerStrategy testStrategy = new FirstTeamWinsStrategy();
		testTeams = new ArrayList<Team>();
		Team testTeam1 = new Team("Test Team 1");
		Team testTeam2 = new Team("Test Team 2");
		Team testTeam3 = new Team("Test Team 3");
		Team testTeam4 = new Team("Test Team 4");
		for (int i = 0; i <= 5; i++) {
			testTeam1.addPlayer("testPlayer" + i);
			testTeam2.addPlayer("testPlayer" + i);
			testTeam3.addPlayer("testPlayer" + i);
			testTeam4.addPlayer("testPlayer" + i);
		}
		testTeams.add(testTeam1);
		testTeams.add(testTeam2);
		testTeams.add(testTeam3);
		testTeams.add(testTeam4);
		Collections.shuffle(testTeams);
	}
	
	@Test
	public void testFirstTwoTeams() {
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(0), testTeams.get(1));
		assertEquals(testTeams.get(0), winningTestTeam);
	}
	
	@Test
	public void testLastTwoTeams() {
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(2), testTeams.get(3));
		assertEquals(testTeams.get(0), winningTestTeam);
	}
	
	@Test
	public void testFirstandLastTeams() {
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(0), testTeams.get(3));
		assertEquals(testTeams.get(0), winningTestTeam);
	}
	
	@Test
	public void testMiddleTwoTeams() {
		Team winningTestTeam = testStrategy.determineWinner(testTeams.get(1), testTeams.get(2));
		assertEquals(testTeams.get(0), winningTestTeam);
	}

}
