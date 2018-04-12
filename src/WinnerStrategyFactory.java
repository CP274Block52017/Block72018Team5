
public class WinnerStrategyFactory {
	
	public WinnerStrategyFactory()  {
		
	}
	
	public static TournamentWinnerStrategy getWinnerStrategy(int chosenStrategy) {
		switch(chosenStrategy) {
		case 1: 
			return new RandomWinner();
		default:
			System.out.println("Please enter a valid option between 1 and 1.");
			System.out.println();
		}
		return null;
	}

}
