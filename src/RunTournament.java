import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class contains the prompts for user input and uses it to 
 * provide input to create the tournament. 
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class RunTournament {
	
	private static final int MAX_PARTICIPANTS = 16;
	private static final int MAX_TEAM_SIZE = 5;
	private static final int NUMBER_STRATEGIES = 6;
	
	private static final int RANDOM_STRATEGY = 1;
	private static final int BY_HEIGHT_STRATEGY = 2;
	private static final int BY_GAMESPLAYED_STRATEGY = 3;
	private static final int BY_GAMESWON_STRATEGY = 4;
	private static final int BY_GAMESLOST_STRATEGY = 5;
	private static final int BY_CLASSYEAR_STRATEGY = 6;
	
	private static Tournament newTournament;
	private static TournamentWinnerStrategy chosenStrategy;
	private static Team finalWinningTeam;
	
	private static GUIWelcomeWindow welcomeWindow;
	
	/**
	 * This method gets user input on whether or not they would like to
	 * create a new tournament.
	 * @param prompt - the prompt to ask the user a question.
	 * @param scan - the input from the user.
	 * @return boolean - returns true or false depending on the user's answer.
	 */
	private static boolean askYesNo(String prompt, Scanner scan) {
		boolean isYes = false;
		boolean validAnswer = false;
		while (!validAnswer) {
			System.out.print(prompt);
			String answer = scan.nextLine();
			if (answer.equalsIgnoreCase("Yes")) {
				isYes = true;
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
	
	/**
	 * This method prompts the user by asking if they would like to create a team, 
	 * allowing the user to input the team's name and add players from the athlete database to the team.
	 * @param scan - user input.
	 * @return Team - an instance of team.
	 */
	private static Team createTeam(Scanner scan) {
		Boolean confirmTeam = false;
		Boolean existingPlayer;
		Team newTeam = null;
		
		//outer loop so that user can go back and edit/make new team if unhappy with initial entries
		while (!confirmTeam) {
			String teamName = askName("\nWhat do you want to name your team?", scan);
			newTeam = new Team(teamName);
	 		int teamSize = 0;
	 		
	 		//inner loop adds players to team until team is full
	 		while (teamSize < MAX_TEAM_SIZE) {
	 			existingPlayer = false;
	 			System.out.println("\n");
	 			for (Player player : PlayerDatabase.getPlayersList()) {
	 				System.out.println(player.getName() + ", " + player.getSport());
	 			}
	 			
	 			//this loop checks to make sure the player name entered by the user actually corresponds to a player in the database, 
	 			//and if it does not, gives user a chance to correct the input
	 			while (!existingPlayer) {
	 				String playerName = askName("\nWhich player do you want to add to your team?", scan);
		 			Player chosenPlayer = PlayerDatabase.findPlayer(playerName);
		 			if (chosenPlayer == null) {
		 				System.out.println("Chosen player does not exist in athlete database. Please enter a valid player name.");
		 			}
		 			else {
		 				newTeam.addPlayer(chosenPlayer);
			 			System.out.println(playerName + " was added to Team " + teamName);
			 			teamSize++;
			 			existingPlayer = true;
		 			}
	 			}
	 		}
	 		
	 		//checks if user is happy with team; if not, go back and edit
	 		if (teamSize == MAX_TEAM_SIZE) {
	 			System.out.println("\nTeam " + teamName + " is full!");
	 			System.out.println("\nTeam Name: " + teamName);
	 	 		System.out.println("\nTeam members:");
	 	 		System.out.println(newTeam);
	 	 		Boolean isCorrect = askYesNo("Is this the correct information for your team?\n", scan);
	 			if (!isCorrect) {
	 				System.out.println("\nPlease edit your team information.");
	 			}
	 			else {
	 				confirmTeam = true;
	 			}
	 		}
	 		else {
	 			System.out.println((MAX_TEAM_SIZE - teamSize) + " more player(s) needed to make a complete team. Please add another player:");
	 		}
		}
 		return newTeam;
 	}


	
	/**
	 * This method gets the names entered by the user.
	 * @param prompt - the prompt to ask the user for a question.
	 * @param scan - user input.
	 * @return String - the name inputed by the user.
	 */
	private static String askName(String prompt, Scanner scan) {
 		System.out.println(prompt);
 	 	//String name = scan.nextLine();
 	 	String name = GUICreateTournamentWindow.getTeamName();
 	 	System.out.println(name);
 	 	return name;
 	 }
 	 	
 	/**
 	 * This method asks the user for the number of teams they would like 
 	 * to create for the tournament.
 	 * @param scan - user input.
 	 * @return int - number of teams to create.
 	 */
 	private static int askNumberOfTeams(Scanner scan) {
 		//int numParticipants = 0;
 		//Boolean validAnswer = false;
 		//while (!validAnswer) {
	 		//try {
	 			//System.out.println("\nHow many participants do you want in your tournament? (2, 4, 8, or 16) ");
	 	 		//numParticipants = scan.nextInt();
	 	 		//scan.nextLine();
	 	 		//if ((numParticipants == 2) || (numParticipants == 4) || (numParticipants == 8) || (numParticipants == MAX_PARTICIPANTS)) {
	 	 			//validAnswer = true;
	 	 		//}
	 		//}
	 		//catch(InputMismatchException ex) {
				//scan.nextLine();
			//}
			//if (!validAnswer) {
				//System.out.println("Invalid selection -- enter 2, 4, 8, or 16.");
			//}
	 	//}
 		return GUICreateTournamentWindow.getParticipantNumber();
	}
		
 	/**
 	 * This method prompts the user for the strategy they would like 
 	 * to use to determine the winner of the tournament.
 	 * @param scan - user input.
 	 * @return int - number correlating to the desired strategy.
 	 */
 	private static int askStrategy(Scanner scan) {
 		//int chosenStrategy = 0;
 		//Boolean validAnswer = false;
 		//while(!validAnswer) {
 			//System.out.println("Choose a strategy to determine the winner of the tournament from the following options: ");
 			//System.out.println("1: Random Winner");
 			//System.out.println("2: By Greatest Average Height");
 			//System.out.println("3: By Greatest Average Games Played");
 		//	System.out.println("4: By Greatest Average Games Won");
 			//System.out.println("5: By Greatest Average Games Lost");
 			//System.out.println("6: By Greatest Average Class Year");
 			//System.out.print("> ");
 			//try {
 				//chosenStrategy = scan.nextInt();
 				//scan.nextLine();
 				
 				//switch (chosenStrategy) {
 				//case RANDOM_STRATEGY:
 					//chosenStrategy = RANDOM_STRATEGY;
 					//validAnswer = true;
 					//break;
 				//case BY_HEIGHT_STRATEGY: 
 					//chosenStrategy = BY_HEIGHT_STRATEGY;
 					//validAnswer = true;
 					//break;
 				//case BY_GAMESPLAYED_STRATEGY: 
 					//chosenStrategy = BY_GAMESPLAYED_STRATEGY;
 					//validAnswer = true;
 					//break;
 				//case BY_GAMESWON_STRATEGY: 
 					//chosenStrategy = BY_GAMESWON_STRATEGY;
 					//validAnswer = true;
 					//break;
 				//case BY_GAMESLOST_STRATEGY: 
 					//chosenStrategy = BY_GAMESLOST_STRATEGY;
 					//validAnswer = true;
 					//break;
 				//case BY_CLASSYEAR_STRATEGY: 
 					//chosenStrategy = BY_CLASSYEAR_STRATEGY;
 					//validAnswer = true;
 					//break;
 				//default: 
 					//System.out.println("Invalid selection -- enter a number between 1 and " + NUMBER_STRATEGIES);
 				//}
 			//}
 			//catch (InputMismatchException ex) {
 				//scan.nextLine();
 				//System.out.println("Invalid selection -- enter a number between 1 and " + NUMBER_STRATEGIES);
 			//}
 		//}
 		return GUICreateTournamentWindow.getStrategy();
	 }
	 	
	 	
 	/**
 	 * This method is used to create a tournament given the 
 	 * information the user has inputed. 
 	 * @param scan - user input.
 	 */
 	private static void createTournament(Scanner scan) {
 		Boolean confirmTournament = false;
 		while(!confirmTournament) {
 			String tournamentName = askName("\nWhat do you want to name your tournament?", scan);
 			int numParticipants = askNumberOfTeams(scan);
 			int strategyChoice = askStrategy(scan);
 			chosenStrategy = WinnerStrategyFactory.getWinnerStrategy(strategyChoice);
 			System.out.println("\nTournament Name: " + tournamentName);
 			System.out.println("Number of Teams/Participants: " + numParticipants);
 			if (chosenStrategy.getName().equals("Random Winner")) {
 				System.out.println("Strategy to determine winner: " + chosenStrategy.getName());
 			}
 			else {
 				System.out.println("Strategy to determine winner: Greatest " + chosenStrategy.getName());
 			}
 			Boolean isCorrect = askYesNo("Is this the correct information for your tournament?\n", scan);
 			if (!isCorrect) {
 				System.out.println("Please edit your tournament information.");
 			}
 			else {
 				newTournament = new Tournament(tournamentName, numParticipants, chosenStrategy);
 				confirmTournament = true;
 			}
 		}
 	}

 	/**
 	 * This method determines the winner of each round and uses recursion to do
 	 * this method again and again until the tournament is complete
 	 * @param strategy to determine winner
 	 * @param teams that are playing in the tournament
 	 * @param new scan to get user input
 	 * @return the team that won
 	 */
 	private static Team determineRoundWinners(TournamentWinnerStrategy strategy, ArrayList<Team> teams, Scanner scan) {
 		ArrayList<Team> nextRoundTeams = new ArrayList<Team>();
 		Team winningTeam = null;
 		Team losingTeam = null;
 		Boolean isFinalRound = true;
 		
 		//determines winners for each matchup in current round, adds winners to list of teams advancing to next round
 		for (int i = 0; i < teams.size(); i += 2) {
 			System.out.println("\nTeam Matchup: " + teams.get(i).getName() + " vs. " + teams.get(i + 1).getName());
 			winningTeam = strategy.determineWinner(teams.get(i), teams.get(i + 1));
 			if (teams.get(i).getName().equals(winningTeam.getName())) {
 				losingTeam = teams.get(i + 1);
 			}
 			else {
 				losingTeam = teams.get(i);
 			}
 			System.out.println("Team " + winningTeam.getName() + " has won the matchup!");
 			if (!chosenStrategy.getName().equals("Random Winner")) {
 				System.out.println("Team " + winningTeam.getName() + " had a " + chosenStrategy.getName() + " of " + winningTeam.getLastRoundAverage() + " vs. the losing team's " + chosenStrategy.getName() + " of " + losingTeam.getLastRoundAverage());
 			}
 			nextRoundTeams.add(winningTeam);
 		}
 		
 		//recursive method calls itself if there is more than one team left in the tournament
 		if (nextRoundTeams.size() != 1) {
 			isFinalRound = false;
 			System.out.println("\nNext round's matchups: ");
 	 		for (int i = 0; i < nextRoundTeams.size(); i += 2) {
 	 			System.out.println(nextRoundTeams.get(i).getName() + " vs. " + nextRoundTeams.get(i + 1).getName());
 	 		}
 	 		Boolean yesContinue = askYesNo("\nWould you like to continue to the next round?\n", scan);
 			if (yesContinue) {
 				determineRoundWinners(strategy, nextRoundTeams, scan);
 			}
 			else {
 				System.out.println("Tournament terminated!");
 			}
 		}
 		if (isFinalRound) {
 	 		finalWinningTeam = winningTeam;
 	 	}
 		return finalWinningTeam;
 	}
 	
 	/**
 	 * This method determines the winner of each an individual matchup between two teams.
 	 * It is used by the strategies which determine the winner based on different player attributes.
 	 * @param firstTeam - first team in matchup
 	 * @return secondTeam - second team in matchup
 	 */
 	public static Team determineWinningAverage(Team firstTeam, Team secondTeam) {
 		if (firstTeam.getLastRoundAverage() > secondTeam.getLastRoundAverage()) {
			return firstTeam;
		}
		else if (firstTeam.getLastRoundAverage() < secondTeam.getLastRoundAverage()) {
			return secondTeam;
		}
		else { // if teams are tied, pick a random winner
			RandomWinnerStrategy randomWinner = new RandomWinnerStrategy();
			return randomWinner.determineWinner(firstTeam, secondTeam);
		}
 	}


	/**
	 * This is the main method that runs the tournament.
	 * @param args
	 */
	public static void main(String[] args) {
		PlayerDatabase.generateDatabase();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					welcomeWindow = new GUIWelcomeWindow();
					welcomeWindow.getFrame().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	
		Boolean exitTournamentGenerator = false;
		System.out.println("Welcome to the tournament game!");
		Scanner scan = new Scanner(System.in);
		Boolean yesCreate = askYesNo("\nWould you like to create a new tournament?\n", scan);
		
		//loop continues while tournament master wants to create a new tournament
 		while(!exitTournamentGenerator) {
			if (yesCreate) {
				createTournament(scan);
			}
			else {
				break;
			}
			
			int numTeams = 0;
			System.out.println("\nNeed to add " + (newTournament.getNumTeams() - numTeams) + " more team(s) to run tournament. Please add another team:");
			
			//loop continues while teams still need to be added to the tournament to match number of participants (teams) entered by tournament master
			while (numTeams < newTournament.getNumTeams()) {
				Team newTeam = createTeam(scan);
				newTournament.addTeam(newTeam);
				System.out.println("\nTeam " + newTeam.getName() + " added to tournament.");
				System.out.println("\nTournament Teams:");
				for (Team team: newTournament.getTeams()) {
					System.out.println("\nTeam " + team.getName() + ":");
					System.out.println(team);
				}
				numTeams++;
				if (numTeams == newTournament.getNumTeams()) {
					System.out.println("\nTournament is ready to start!");
				}
				else {
					System.out.println("\nNeed to add " + (newTournament.getNumTeams() - numTeams) + " more teams to run tournament. Please add another team:");
				}
			}
			
			//Determine winners for each round of tournament, including final winner
			Team tournamentWinner = determineRoundWinners(chosenStrategy, newTournament.getTeams(), scan);
			newTournament.setWinner(tournamentWinner);
			System.out.println("Team " + tournamentWinner.getName() + " has won the tournament!");
			
			//Ask tournament master whether to start new tournament
			Boolean startAgain = askYesNo("\nWould you like to start a new tournament?\n", scan);
			if(!startAgain) {
				exitTournamentGenerator = true;
			}
		}
 		System.out.println("\nThanks for playing! Come back soon!");
	}
}


