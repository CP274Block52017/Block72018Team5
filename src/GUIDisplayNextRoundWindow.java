
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;

/**
 * This class creates a GUI that represents the 
 * points and winner of a round of the tournament.
 * @author Nicole
 * @author Kelli
 * @author Emma
 *
 */
public class GUIDisplayNextRoundWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private boolean hasBeenClicked;
	private ActionListener nextListener;
	
	private Tournament tournament;
	private Team finalWinningTeam;
	private ArrayList<Team> thisRoundTeams;
	private ArrayList<Team> nextRoundTeams;

	
	/**
	 * Constructor for the class initiates the creating of the window..
	 */
	public GUIDisplayNextRoundWindow(Tournament tournament, ArrayList<Team> thisRoundTeams) throws IOException {
		this.tournament = tournament;
		this.thisRoundTeams = thisRoundTeams;
		determineRoundWinners(tournament.getWinnerStrategy());
		initialize();
	}

	/**
	 * Initialize the contents of the frame, elements of the window.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//tournament bracket label
		JLabel lblNewLabel = new JLabel("Tournament Bracket Rounds!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(409, 118, 646, 54);
		frame.getContentPane().add(lblNewLabel);
		
		//name of first team
		JLabel lblNewLabel_1 = new JLabel((String) null);
		lblNewLabel_1.setText(thisRoundTeams.get(0).getName());
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(150, 298, 327, 48);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//border image across the top
		String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	    
	    //Competeting teams text
	    JLabel lblNameYourTeam = new JLabel("Competing Teams:");
	    lblNameYourTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
	    lblNameYourTeam.setForeground(Color.ORANGE);
	    lblNameYourTeam.setBounds(531, 173, 373, 54);
	    frame.getContentPane().add(lblNameYourTeam);
	    
	    //VS. text
	    JLabel lblVs = new JLabel("VS.");
	    lblVs.setForeground(Color.ORANGE);
	    lblVs.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblVs.setBounds(288, 382, 67, 48);
	    frame.getContentPane().add(lblVs);
	    
	    //name of the second team
	    JLabel label = new JLabel((String) null);
	    label.setText(thisRoundTeams.get(1).getName());
	    label.setForeground(Color.WHITE);
	    label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label.setBounds(150, 455, 327, 48);
	    frame.getContentPane().add(label);
	    
	    //top left round first team points
	    JLabel lblPoints = new JLabel("Points:");
	    lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblPoints.setForeground(Color.ORANGE);
	    lblPoints.setBounds(504, 301, 117, 42);
	    frame.getContentPane().add(lblPoints);
	    
	    //top left round second team points
	    JLabel label_10 = new JLabel("Points:");
	    label_10.setForeground(Color.ORANGE);
	    label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_10.setBounds(504, 461, 117, 42);
	    frame.getContentPane().add(label_10);
	    
	    //top left round winner
	    JLabel lblWinner = new JLabel("Winner: ");
	    lblWinner.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    lblWinner.setForeground(Color.ORANGE);
	    lblWinner.setBounds(504, 382, 129, 42);
	    frame.getContentPane().add(lblWinner);
	    
	    //top left top points blank
	    JLabel label_22 = new JLabel(Double.toString(thisRoundTeams.get(0).getLastRoundAverage()));
	    label_22.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_22.setForeground(Color.WHITE);
	    label_22.setBounds(633, 298, 117, 40);
	    frame.getContentPane().add(label_22);
	    
	    //top left win blank
	    JLabel label_32 = new JLabel(nextRoundTeams.get(0).getName());
	    label_32.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_32.setForeground(Color.WHITE);
	    label_32.setBounds(633, 372, 195, 40);
	    frame.getContentPane().add(label_32);
	    
	    //top left bottom point blank
	    JLabel label_42 = new JLabel(Double.toString(thisRoundTeams.get(1).getLastRoundAverage()));
	    label_42.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_42.setForeground(Color.WHITE);
	    label_42.setBounds(633, 455, 117, 40);
	    frame.getContentPane().add(label_42);
	    
	    //if the number of teams in the round is greater than two
	    if (thisRoundTeams.size() > 2) {
	    		//third team in the tournament
	    		JLabel label_1 = new JLabel((String) null);
	 	    label_1.setText(thisRoundTeams.get(2).getName());
	 	    label_1.setForeground(Color.WHITE);
	 	    label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_1.setBounds(150, 569, 327, 48);
	 	    frame.getContentPane().add(label_1);
	 	    
	 	    //VS. test
	 	    JLabel label_3 = new JLabel("VS.");
		    label_3.setForeground(Color.ORANGE);
		    label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_3.setBounds(288, 635, 67, 48);
		    frame.getContentPane().add(label_3);
	 	    
		    //fourth team in tournament
	 	    JLabel label_2 = new JLabel((String) null);
	 	    label_2.setText(thisRoundTeams.get(3).getName());
	 	    label_2.setForeground(Color.WHITE);
	 	    label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_2.setBounds(150, 695, 327, 48);
	 	    frame.getContentPane().add(label_2);
	 	    
	 	    //bottom left round first team points
		    JLabel label_16 = new JLabel("Points:");
		    label_16.setForeground(Color.ORANGE);
		    label_16.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_16.setBounds(504, 569, 117, 42);
		    frame.getContentPane().add(label_16);
		    
		    //bottom left round second team points
		    JLabel label_17 = new JLabel("Points:");
		    label_17.setForeground(Color.ORANGE);
		    label_17.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_17.setBounds(504, 701, 117, 42);
		    frame.getContentPane().add(label_17);
		    
		    //bottom right round winner
		    JLabel label_18 = new JLabel("Winner: ");
		    label_18.setForeground(Color.ORANGE);
		    label_18.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    label_18.setBounds(504, 635, 129, 42);
		    frame.getContentPane().add(label_18);
		    
		    //bottom left first team points blank
		    JLabel label_21 = new JLabel(Double.toString(thisRoundTeams.get(2).getLastRoundAverage()));
		    label_21.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_21.setForeground(Color.WHITE);
		    label_21.setBounds(633, 577, 117, 40);
		    frame.getContentPane().add(label_21);
		    
		    //bottom left winner blank
		    JLabel label_23 = new JLabel(nextRoundTeams.get(1).getName());
		    label_23.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    label_23.setForeground(Color.WHITE);
		    label_23.setBounds(633, 635, 171, 40);
		    frame.getContentPane().add(label_23);
		    
		    //bottom left second team points blank
		    JLabel label_24 = new JLabel(Double.toString(thisRoundTeams.get(3).getLastRoundAverage()));
		    label_24.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_24.setForeground(Color.WHITE);
		    label_24.setBounds(633, 703, 117, 40);
		    frame.getContentPane().add(label_24);
	    }
	    
	    //if the number of team in the round is greater than 4
	    if (thisRoundTeams.size() > 4) { 
	    		//fifth team name
	    		JLabel label_4 = new JLabel((String) null);
	 	    label_4.setText(thisRoundTeams.get(4).getName());
	 	    label_4.setForeground(Color.WHITE);
	 	    label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_4.setBounds(783, 298, 327, 48);
	 	    frame.getContentPane().add(label_4);
	 	    
	 	    //VS. text
	 	    JLabel label_8 = new JLabel("VS.");
		    label_8.setForeground(Color.ORANGE);
		    label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_8.setBounds(922, 635, 67, 48);
		    frame.getContentPane().add(label_8);
	 	    
		    //name of the sixth team
	 	    JLabel label_5 = new JLabel((String) null);
	 	    label_5.setText(thisRoundTeams.get(5).getName());
	 	    label_5.setForeground(Color.WHITE);
	 	    label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_5.setBounds(783, 455, 327, 48);
	 	    frame.getContentPane().add(label_5);
	 	    
	 	    //top right round first team points
		    JLabel label_11 = new JLabel("Points:");
		    label_11.setForeground(Color.ORANGE);
		    label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_11.setBounds(1120, 298, 117, 42);
		    frame.getContentPane().add(label_11);
		    
		    //top right round second team points
		    JLabel label_13 = new JLabel("Points:");
		    label_13.setForeground(Color.ORANGE);
		    label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_13.setBounds(1120, 455, 117, 42);
		    frame.getContentPane().add(label_13);
		    
		    //top right round winner
		    JLabel label_19 = new JLabel("Winner: ");
		    label_19.setForeground(Color.ORANGE);
		    label_19.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    label_19.setBounds(1120, 372, 129, 42);
		    frame.getContentPane().add(label_19);
		    
		    //top right second team points blank
		    JLabel label_28 = new JLabel(Double.toString(thisRoundTeams.get(5).getLastRoundAverage()));
		    label_28.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_28.setForeground(Color.WHITE);
		    label_28.setBounds(1259, 455, 117, 40);
		    frame.getContentPane().add(label_28);
		    
		    //top right winner blank
		    JLabel label_29 = new JLabel(nextRoundTeams.get(2).getName());
		    label_29.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    label_29.setForeground(Color.WHITE);
		    label_29.setBounds(1261, 372, 171, 40);
		    frame.getContentPane().add(label_29);
		    
		    //top right first team points blank
		    JLabel label_30 = new JLabel(Double.toString(thisRoundTeams.get(4).getLastRoundAverage()));
		    label_30.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_30.setForeground(Color.WHITE);
		    label_30.setBounds(1259, 298, 117, 40);
		    frame.getContentPane().add(label_30);
	    }
	   
	    //if the number of names in the tournament is greater than 6
	    if (thisRoundTeams.size() > 6) { 
	    		//name of the seventh team
	    		JLabel label_6 = new JLabel((String) null);
		    label_6.setText(thisRoundTeams.get(6).getName());
		    label_6.setForeground(Color.WHITE);
		    label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_6.setBounds(783, 552, 327, 48);
		    frame.getContentPane().add(label_6);
		    
		    //name of the eight team
		    JLabel label_7 = new JLabel((String) null);
		    label_7.setText(thisRoundTeams.get(7).getName());
		    label_7.setForeground(Color.WHITE);
		    label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_7.setBounds(783, 695, 327, 48);
		    frame.getContentPane().add(label_7);
		    
		    //VS text
		    JLabel label_9 = new JLabel("VS.");
		    label_9.setForeground(Color.ORANGE);
		    label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_9.setBounds(922, 382, 67, 48);
		    frame.getContentPane().add(label_9);
		    
		    //bottom right first team points blank
		    JLabel label_25 = new JLabel(Double.toString(thisRoundTeams.get(6).getLastRoundAverage()));
		    label_25.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_25.setForeground(Color.WHITE);
		    label_25.setBounds(1259, 552, 117, 40);
		    frame.getContentPane().add(label_25);
		    
		    //bottom right winner blank
		    JLabel label_26 = new JLabel(nextRoundTeams.get(3).getName());
		    label_26.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    label_26.setForeground(Color.WHITE);
		    label_26.setBounds(1244, 622, 171, 40);
		    frame.getContentPane().add(label_26);
		    
		    //bottom right second team points blank
		    JLabel label_27 = new JLabel(Double.toString(thisRoundTeams.get(7).getLastRoundAverage()));
		    label_27.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_27.setForeground(Color.WHITE);
		    label_27.setBounds(1259, 703, 117, 40);
		    frame.getContentPane().add(label_27);
		    
		    //bottom left round winner
		    JLabel label_20 = new JLabel("Winner: ");
		    label_20.setForeground(Color.ORANGE);
		    label_20.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		    label_20.setBounds(1120, 622, 129, 42);
		    frame.getContentPane().add(label_20);
		    
		    //bottom right first team points 
		    JLabel label_14 = new JLabel("Points:");
		    label_14.setForeground(Color.ORANGE);
		    label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_14.setBounds(1122, 552, 117, 42);
		    frame.getContentPane().add(label_14);
		    
		    //bottom right second team points
		    JLabel label_15 = new JLabel("Points:");
		    label_15.setForeground(Color.ORANGE);
		    label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_15.setBounds(1120, 695, 117, 42);
		    frame.getContentPane().add(label_15);
		 }
	    
	    //button that takes you to the next round
	    JButton btnNextRound = new JButton("Next Round");
	    nextListener = new NextButton();
	    btnNextRound.addActionListener(nextListener);
	    btnNextRound.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	    btnNextRound.setBounds(643, 239, 135, 47);
	    frame.getContentPane().add(btnNextRound);
	}
	
	/**
	 * Gets the frame for the window.
	 * @return JFrame - window frame.
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
 	 * This method determines the winner of each round and uses recursion to do
 	 * this method again and again until the tournament is complete
 	 * @param strategy to determine winner
 	 * @param teams that are playing in the tournament
 	 */
 	private void determineRoundWinners(TournamentWinnerStrategy strategy) {
 		nextRoundTeams = new ArrayList<Team>();
 		Team winningTeam = null;
 		
 		//determines winners for each matchup in current round, adds winners to list of teams advancing to next round
 		for (int i = 0; i < thisRoundTeams.size(); i += 2) {
 			winningTeam = strategy.determineWinner(thisRoundTeams.get(i), thisRoundTeams.get(i + 1));
 			nextRoundTeams.add(winningTeam);
 		}
 	}
 	
 	/**
 	 * This class allows for actions to be completed when the
 	 * next button is clicked.
 	 *  @author Nicole
 	 * @author Kelli
 	 * @author Emma
 	 *
 	 */
	class NextButton extends JFrame implements ActionListener {
		
		/**
		 * Constructor is empty.
		 */
		public NextButton() {
			
		}
		
		/**
		 * Performs the actions for the button
		 * @param ActionEvent - event that causes the action.
		 */
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUINextRoundMatchupsWindow displayNextRoundWindow = new GUINextRoundMatchupsWindow(tournament, nextRoundTeams);
						displayNextRoundWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
	
}

