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
	 * @return
	 */
	public static TournamentWinnerStrategy getWinnerStrategy(int chosenStrategy) {
		switch(chosenStrategy) {
		case 1: 
			return new RandomWinnerStrategy();
		default:
			return null;
		}
	}

}
