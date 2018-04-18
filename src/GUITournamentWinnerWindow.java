
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This class is going to build the final window of our tournament generater
 * and display the tournament winner. Then the user will have the choice to play
 * again or exit the program.
 * @author Kelli
 * @author Emma
 * @author Nicole
 */
public class GUITournamentWinnerWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener exitListener;
	private ActionListener playListener;
	
	private Tournament tournament;
	private Team tournamentWinner;

	/**
	 * Constructor is going to call the method it initialize the 
	 * frame that we want to display the tournament winner
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 */
	public GUITournamentWinnerWindow(Tournament tournament, ArrayList<Team> finalTeams) throws IOException {
		this.tournament = tournament;
		determineTournamentWinner(tournament.getWinnerStrategy(), finalTeams);
		initialize();
	}

	/**
	 * This frame is going to get the total set up for the winner
	 * and display the champion of this tournament.
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 */
	private void initialize() throws IOException {
		//set the basic frame
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//let the user know that the tournament is over
		JLabel lblTheTournamentIs = new JLabel("The Tournament is over!");
		lblTheTournamentIs.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblTheTournamentIs.setForeground(Color.ORANGE);
		lblTheTournamentIs.setBounds(452, 169, 546, 41);
		frame.getContentPane().add(lblTheTournamentIs);
		
		//state the winner is
		JLabel lblTheWinnerIs = new JLabel("The WINNER is...");
		lblTheWinnerIs.setForeground(Color.ORANGE);
		lblTheWinnerIs.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblTheWinnerIs.setBounds(534, 258, 374, 41);
		frame.getContentPane().add(lblTheWinnerIs);
		
		//get the winner and display
		JLabel label = new JLabel(tournamentWinner.getName() + " with " + tournamentWinner.getLastRoundAverage() + " points!!!");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		label.setForeground(Color.WHITE);
		label.setBounds(415, 340, 607, 125);
		frame.getContentPane().add(label);
		
		//congratulate the winner
		JLabel lblCongratulations = new JLabel("Congratulations!");
		lblCongratulations.setForeground(Color.ORANGE);
		lblCongratulations.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblCongratulations.setBounds(534, 450, 374, 54);
		frame.getContentPane().add(lblCongratulations);
		
		//let the user know that they can play again if they click the Play Again Button
		JLabel lblIfYouWould = new JLabel("If you would like to create another tournmant, press Play Again!");
		lblIfYouWould.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblIfYouWould.setForeground(Color.ORANGE);
		lblIfYouWould.setBounds(333, 573, 1087, 41);
		frame.getContentPane().add(lblIfYouWould);
		
		//let the user know they can exit the program if they hit the exit button
		JLabel lblPressExitTo = new JLabel("Press Exit to leave the program. Thanks for playing!");
		lblPressExitTo.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblPressExitTo.setForeground(Color.ORANGE);
		lblPressExitTo.setBounds(401, 628, 636, 35);
		frame.getContentPane().add(lblPressExitTo);
		
		//create the play again button
		JButton btnPlayAgain = new JButton("Play Again!");
		playListener = new PlayButton();
		btnPlayAgain.addActionListener(playListener);
		btnPlayAgain.setBounds(469, 689, 143, 54);
		btnPlayAgain.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		frame.getContentPane().add(btnPlayAgain);
		
		//create the exit button
		JButton btnExit = new JButton("Exit");
		exitListener = new ExitButton();
		btnExit.addActionListener(exitListener);
		btnExit.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		frame.getContentPane().add(btnPlayAgain);
		btnExit.setBounds(825, 689, 143, 54);
		frame.getContentPane().add(btnExit);
		
		//produces the CC logo for the bottom left corner of the frame
		String logoFile = "Logo.jpg";
		File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(25, 155, 300, 1200);
		frame.getContentPane().add(graphic);
		
	    //produces the top bar graphic for the frame
	    String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	/**
 	 * This method determines the winner of the tournament
 	 * @param strategy to determine winner
 	 * @param teams that are playing in the tournament
 	 */
 	private void determineTournamentWinner(TournamentWinnerStrategy strategy, ArrayList<Team> finalTeams) {
 		tournamentWinner = strategy.determineWinner(finalTeams.get(0), finalTeams.get(1));
 		tournament.setWinner(tournamentWinner);
 		}

	
	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "Play Again" is pressed
	 * in our end jframe
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
	class PlayButton extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;

		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
		public PlayButton() {
			
		}
		
		/**
		 * When the user presses the button to start a new game
		 * it will create the original welcome winder GUI and start all over again.
		 */
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			
			//go back to start window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						new GUIWelcomeWindow();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	
	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "Play Again" is pressed
	 * in our end jframe
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
	class ExitButton extends JFrame implements ActionListener {
			
		private static final long serialVersionUID = 1L;

		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
			public ExitButton() {
				
			}
			
			/**
			 * When this button is pressed it is going to exit out of 
			 * the window since the user no longer wants to play
			 */
			public void actionPerformed(ActionEvent e) {
				System.exit(1);
			}
	}
	
}

