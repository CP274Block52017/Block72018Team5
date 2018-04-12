import java.util.Scanner; 
 
  /** 
  *  
  */ 
 
 
 /** 
  * @author Nicole 
  * 
  */ 
 public class RunTournament { 
	 
	 private static TournamentWinnerStrategy winnerStrategy;
	 private static String tournamentName;
	 private static int numberOfParticipants;
 	 
 	 
 	private static boolean askYesNo(String prompt, Scanner scan) { 
		boolean isYes = false; 
 		boolean validAnswer = false; 
 		while (!validAnswer) { 
 			System.out.print(prompt); 
 			String answer = scan.next(); 
 			if (answer.equalsIgnoreCase("Yes")) {
 				isYes = true; 
 				createTournament();
 				validAnswer = true; 
 			} 
 			else if (answer.equalsIgnoreCase("No")) { 
 				isYes = false; 
 				validAnswer = true; 
 			} 
 			else { 
 				System.out.println("\nInvalid entry. Please enter 'yes' or 'no'."); 
 			} 
 		} 
 		return isYes; 
 	} 
 	
 	public static boolean createTeam(String prompt, Scanner scan) {
 		boolean enoughPlayers = false;
 		while (!enoughPlayers) {
 			System.out.println(prompt);
 			return false;
 		}
 		return false;
 	}
 	
 	public static String getTournamentName() {
 		Scanner scan = new Scanner(System.in);
 		System.out.println("What do you want to name your tournament?");
 		String tournamentName = scan.nextLine();
 		return tournamentName;
 	}
 	
 	public static int getNumberofTeams() {
 		Scanner scan = new Scanner(System.in);
 		System.out.println("How many participants do you want in your tournament?");
 		int numberOfParticipants = scan.nextInt();
 		return numberOfParticipants;
 	}
 	
 	public static void getStrategy() {
 		winnerStrategy = null;
 	}
 	
 	public static void createTournament() {
 		boolean confirmTournament = false;
 		while(!confirmTournament) {
 			tournamentName = getTournamentName();
 			numberOfParticipants = getNumberofTeams();
 			getStrategy();
 			System.out.println("Is this the correct information for your tournament?");
 			System.out.println("Tournament Name: " + tournamentName);
 			System.out.println("Number of Teams: " + numberOfParticipants);
 			System.out.println("Strategy to determine winner: " + "default");
 			Scanner scan = new Scanner(System.in);
 			String answer = scan.next(); 
 			if (answer.equalsIgnoreCase("Yes")) {
 				confirmTournament = true; 
 			} 
 			else if (answer.equalsIgnoreCase("No")) { 
 				confirmTournament = false;
 			} 
 			else { 
 				System.out.println("\nInvalid entry. Please enter 'yes' or 'no'."); 
 			}
 		}
 		
 		Tournament tournament = new Tournament(tournamentName, numberOfParticipants, winnerStrategy);
 		
 	}
 
 
 	/** 
 	 * @param args 
 	 */ 
 	public static void main(String[] args) { 
 		System.out.println("Welcome to the tournament game!"); 
 		
 		Scanner scan = new Scanner(System.in); 
 		System.out.println("IsYes: " + askYesNo("Would you like to create a new tournament? ", scan)); 
 		
 		
 	} 
 
 
 } 
