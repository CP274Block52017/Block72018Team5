
/**
 * This class utilizes the factory design pattern to 
 * create an instance of the desired TournamentWinnerStrategy
 * concrete implementation.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class WinnerStrategyFactory {
	
	private static final int RANDOM_STRATEGY = 1;
	private static final int BY_HEIGHT_STRATEGY = 2;
	private static final int BY_GAMESPLAYED_STRATEGY = 3;
	private static final int BY_GAMESWON_STRATEGY = 4;
	private static final int BY_GAMESLOST_STRATEGY = 5;
	private static final int BY_CLASSYEAR_STRATEGY = 6;

	/**
	 * Constructor is empty.
	 */
	public WinnerStrategyFactory()  {
			
	}
	
	/**
	 * This is the factory that creates a concrete instance of a 
	 * TournamentWinnerStrategy determined by the user's choice of
	 * strategy.
	 * @param chosenStrategy
	 * @return the strategy that will be used 
	 */
	public static TournamentWinnerStrategy getWinnerStrategy(int chosenStrategy) {
		switch(chosenStrategy) {
		case RANDOM_STRATEGY: 
			return new RandomWinnerStrategy();
		case BY_HEIGHT_STRATEGY: 
			return new ByHeightStrategy();
		case BY_GAMESPLAYED_STRATEGY: 
			return new ByGamesPlayedStrategy();
		case BY_GAMESWON_STRATEGY: 
			return new ByGamesWonStrategy();
		case BY_GAMESLOST_STRATEGY: 
			return new ByGamesLostStrategy();
		case BY_CLASSYEAR_STRATEGY: 
			return new ByClassYearStrategy();
		default:
			return null;
		}
	}
}

