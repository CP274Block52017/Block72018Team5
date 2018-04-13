import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.Before;
import java.util.ArrayList;

public class WinnerStrategyTest {
	
	TournamentWinnerStrategy winner;
	ArrayList<Team> teams;
	Team team1;
	Team team2;

	@Before
	public void setUp() {
		teams = new ArrayList<Team>();
		team1 = new Team("Test Team 1");
		team2 = new Team("Test Team 2");
		team1.addPlayer("player1");
		team1.addPlayer("player2");
		team1.addPlayer("player3");
		team1.addPlayer("player4");
		team1.addPlayer("player5");
		
		team2.addPlayer("player1");
		team2.addPlayer("player2");
		team2.addPlayer("player3");
		team2.addPlayer("player4");
		team2.addPlayer("player5");
	}
	
	@Test
	public void testRandomWinnerStrategy() {
		teams.add(team1);
		winner = new RandomWinnerStrategy();
		assertEquals(teams.get(0), winner.determineWinner(teams));
	}

}
