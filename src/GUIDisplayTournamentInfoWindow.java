import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 * This GUI is going to display all the information of the
 * tournament that the user just inputed and check if this is
 * the information they want.
 * @author Kelli
 * @author Emma
 * @author Kelli
 *
 */
public class GUIDisplayTournamentInfoWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener nextListener;
	private ActionListener backListener;
	private boolean hasBeenClicked;
	
	private String tournamentName;
	private TournamentWinnerStrategy strategy;
	private int numParticipants;

	/**
	 * Constructor is going to take in tournament name, strategy choice and number of 
	 * participants that the last GUI got from the user so that it can be displayed
	 * and checked in this class.
	 * Initializes all that information it takes in and calls for the frame to be initalized
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 */
	public GUIDisplayTournamentInfoWindow(String tournamentName, int strategyChoice, int numParticipants) throws IOException {
		this.tournamentName = tournamentName;
		this.strategy = WinnerStrategyFactory.getWinnerStrategy(strategyChoice);
		this.numParticipants = numParticipants;
		initialize();
	}

	/**
	 * Initialize the contents of the frame that displays the
	 * name of the tournament, number of participants and the strategy
	 * the user needs to check about their tournament
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 */
	private void initialize() throws IOException {
		//creates initial basic JFrame
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//lets the user know we are displaying the tournament information
		JLabel lblTournamentInformation = new JLabel("Tournament Information!");
		lblTournamentInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblTournamentInformation.setForeground(Color.ORANGE);
		lblTournamentInformation.setBounds(475, 112, 506, 36);
		frame.getContentPane().add(lblTournamentInformation);
		
		//states the tournament name
		JLabel lblTournamentName = new JLabel("Tournament Name:");
		lblTournamentName.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblTournamentName.setForeground(Color.ORANGE);
		lblTournamentName.setBounds(271, 176, 335, 36);
		frame.getContentPane().add(lblTournamentName);
		
		//states the number of participants
		JLabel lblNumberOfParticipants = new JLabel("Number of Participants:");
		lblNumberOfParticipants.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNumberOfParticipants.setForeground(Color.ORANGE);
		lblNumberOfParticipants.setBounds(271, 301, 405, 43);
		frame.getContentPane().add(lblNumberOfParticipants);
		
		//states the strategy
		JLabel lblStrategyToDetermine = new JLabel("Strategy to Determine Winner:");
		lblStrategyToDetermine.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblStrategyToDetermine.setForeground(Color.ORANGE);
		lblStrategyToDetermine.setBounds(271, 430, 515, 43);
		frame.getContentPane().add(lblStrategyToDetermine);
		
		//prints the strategy the user choice to use
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setText(getStrategyDisplayName(strategy));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(790, 430, 723, 43);
		frame.getContentPane().add(lblNewLabel);
		
		//gets the name of the tournament the user wanted 
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel_1.setText(tournamentName);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(618, 176, 768, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		//gets the number of participants the user inputed
		JLabel label = new JLabel("");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		label.setText(Integer.toString(numParticipants));
		label.setForeground(Color.WHITE);
		label.setBounds(688, 301, 603, 36);
		frame.getContentPane().add(label);
		
		//directs the user toward a button
		JLabel lblIfTheInformation = new JLabel("If the information is correct, click Next. ");
		lblIfTheInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfTheInformation.setForeground(Color.ORANGE);
		lblIfTheInformation.setBounds(271, 558, 710, 36);
		frame.getContentPane().add(lblIfTheInformation);
		
		//next button to confirm the information
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		nextListener = new NextButton();
		btnNext.addActionListener(nextListener);
		btnNext.setBounds(1115, 551, 154, 43);
		frame.getContentPane().add(btnNext);
		
		//button to let the user go back and edit
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		backListener = new BackButton();
		btnBack.addActionListener(backListener);
		btnBack.setBounds(1115, 599, 154, 43);
		frame.getContentPane().add(btnBack);
		
		//informs the user on how to go back and edit info
		JLabel lblIfYouWant = new JLabel("If you want to edit the information, click Back.");
		lblIfYouWant.setForeground(Color.ORANGE);
		lblIfYouWant.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfYouWant.setBounds(271, 606, 793, 36);
		frame.getContentPane().add(lblIfYouWant);
		
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
	
	/**
	 * returns the JFrame that is being built in this class
	 * @return frame - current JFrame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Takes in the strategy that has been chosen and produces the string
	 * that makes it clear for user which strategy they picked
	 * @param strategy - strategy the user picked
	 * @return the display name string that describes the strategy to users
	 */
	private String getStrategyDisplayName(TournamentWinnerStrategy strategy) {
		String strategyDisplayName = "";
		if (strategy.getName().equals("Random Winner")) {
			strategyDisplayName = strategy.getName();
		}
		else {
			strategyDisplayName = "Greatest " + strategy.getName();
		}
		return strategyDisplayName;
	}
	
	/**
 	 * This method is used to create a tournament given the information the user has entered
 	 * @return tournament - new tournament that has been created
 	 */
 	private Tournament createTournament() {
 			Tournament newTournament = new Tournament(tournamentName, numParticipants, strategy);
 			return newTournament;
 	}
	
 	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "Next" is pressed
	 * in our verify the tournament information JFrame
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
	class NextButton extends JFrame implements ActionListener {
		
		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
		public NextButton() {
			hasBeenClicked = false;
		}
		
		/**
		 * When a user presses the next button then this method will
		 * make this frame no longer visible and create a new GUI frame
		 *  to start creating the teams we want in the tournament
		 */
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Tournament tournament = createTournament();
			
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTeamWindow createNewTeamWindow = new GUICreateNewTeamWindow(tournament);
						createNewTeamWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
	
	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "Back" is pressed
	 * in our verify the tournament information JFrame
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
	class BackButton extends JFrame implements ActionListener {
		
		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
		public BackButton() {
			hasBeenClicked = false;
		}

		/**
		 * When the user clicks the back button this method will take the
		 * user back to the previous window to re-input the information
		 * the want for their tournament.
		 */
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			//go back to create-a-tournament window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTournamentWindow window = new GUICreateNewTournamentWindow();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}

}