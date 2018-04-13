
public class WinnerStrategyFactory {
	
	private static final int RANDOM_STRATEGY = 1;

	public WinnerStrategyFactory()  {
			
	}
	
	public static TournamentWinnerStrategy getWinnerStrategy(int chosenStrategy) {
		switch(chosenStrategy) {
		case RANDOM_STRATEGY: 
			return new RandomWinnerStrategy();
		default:
			return null;
		}
	}
}
