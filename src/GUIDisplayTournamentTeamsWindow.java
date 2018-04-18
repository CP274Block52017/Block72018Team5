import java.awt.Color;
import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JButton;

/**
 * This GUI is going to display all the information of the
 * teams that the user has inputed and confirm it before 
 * it heads to start the tournament
 * @author Kelli
 * @author Emma
 * @author Kelli
 *
 */
public class GUIDisplayTournamentTeamsWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener startListener;
	private Tournament tournament;

	/**
	 * Constructor takes the current tournament that we are working on 
	 * and then initializes the method that creates the frame
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 */
	public GUIDisplayTournamentTeamsWindow(Tournament tournament) throws IOException {
		this.tournament = tournament;
		initialize();
	}

	/**
	 * Initialize the contents of the frame that shows all the teams
	 * that have been inputed and the name of the athletes that are 
	 * on those teams
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 */
	private void initialize() throws IOException {
		//creates the basic frame
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		//labels the tournament bracket
		JLabel lblNewLabel = new JLabel("Tournament Bracket");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(491, 118, 450, 54);
		frame.getContentPane().add(lblNewLabel);
		
		//display first team name
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(tournament.getTeamNames().get(0));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(150, 298, 327, 48);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	    
//	    String logoFile = "Logo.jpg";
//	    File logo_file = new File(logoFile);
//	    BufferedImage CC_logo = ImageIO.read(logo_file);
//	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
//	    graphic.setBounds(6, 153, 300, 1200);
//	    frame.getContentPane().add(graphic);
	    
	    //displays the competing teams
	    JLabel lblNameYourTeam = new JLabel("Competing Teams:");
	    lblNameYourTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
	    lblNameYourTeam.setForeground(Color.ORANGE);
	    lblNameYourTeam.setBounds(531, 184, 373, 54);
	    frame.getContentPane().add(lblNameYourTeam);
	    
	    //versus
	    JLabel lblVs = new JLabel("VS.");
	    lblVs.setForeground(Color.ORANGE);
	    lblVs.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblVs.setBounds(288, 382, 67, 48);
	    frame.getContentPane().add(lblVs);
	    
	    //display second team name
	    JLabel label = new JLabel("");
	    label.setText(tournament.getTeamNames().get(1));
	    label.setForeground(Color.WHITE);
	    label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label.setBounds(150, 455, 327, 48);
	    frame.getContentPane().add(label);
	    
	    //if there are more than two teams then this if will go through
	    if (tournament.getMaxNumTeams() > 2) {
	    	//display third team name
	    	 JLabel label_1 = new JLabel((String) null);
	 	    label_1.setText(tournament.getTeamNames().get(2));
	 	    label_1.setForeground(Color.WHITE);
	 	    label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_1.setBounds(150, 569, 327, 48);
	 	    frame.getContentPane().add(label_1);
	 	    
	 	    //versus
	 	    JLabel label_3 = new JLabel("VS.");
		    label_3.setForeground(Color.ORANGE);
		    label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_3.setBounds(288, 635, 67, 48);
		    frame.getContentPane().add(label_3);
	 	    
		  //display fourth team name
	 	    JLabel label_2 = new JLabel("");
	 	    label_2.setText(tournament.getTeamNames().get(3));
	 	    label_2.setForeground(Color.WHITE);
	 	    label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_2.setBounds(150, 695, 327, 48);
	 	    frame.getContentPane().add(label_2);
	    }
	    
	  //if there are more than four teams then this if will go through
	    if (tournament.getMaxNumTeams() > 4) { 
	    	//display fifth team name
	    	JLabel label_4 = new JLabel((String) null);
	 	    label_4.setText(tournament.getTeamNames().get(4));
	 	    label_4.setForeground(Color.WHITE);
	 	    label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_4.setBounds(942, 310, 327, 48);
	 	    frame.getContentPane().add(label_4);
	 	    
	 	    //verus
	 	   JLabel label_8 = new JLabel("VS.");
		    label_8.setForeground(Color.ORANGE);
		    label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_8.setBounds(1077, 647, 67, 48);
		    frame.getContentPane().add(label_8);
	 	    
		  //display sixth team name
	 	    JLabel label_5 = new JLabel((String) null);
	 	    label_5.setText(tournament.getTeamNames().get(5));
	 	    label_5.setForeground(Color.WHITE);
	 	    label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_5.setBounds(942, 455, 327, 48);
	 	    frame.getContentPane().add(label_5);
	    }
	  //if there are more than six teams then this if will go through
	    if (tournament.getMaxNumTeams() > 6) { 
	    	//displays seventh team name
	    	JLabel label_6 = new JLabel((String) null);
		    label_6.setText(tournament.getTeamNames().get(6));
		    label_6.setForeground(Color.WHITE);
		    label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_6.setBounds(942, 554, 327, 48);
		    frame.getContentPane().add(label_6);
		    
		    //versus
		    JLabel label_7 = new JLabel((String) null);
		    label_7.setText(tournament.getTeamNames().get(7));
		    label_7.setForeground(Color.WHITE);
		    label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_7.setBounds(942, 695, 327, 48);
		    frame.getContentPane().add(label_7);
		    
		    //display eigth team name
		    JLabel label_9 = new JLabel("VS.");
		    label_9.setForeground(Color.ORANGE);
		    label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_9.setBounds(1077, 395, 67, 48);
		    frame.getContentPane().add(label_9);
		    
	    }
	   
	    //start button to begin tournament
	    JLabel lblNewLabel_2 = new JLabel("Start");
	    lblNewLabel_2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblNewLabel_2.setForeground(Color.ORANGE);
	    lblNewLabel_2.setBounds(673, 331, 87, 48);
	    frame.getContentPane().add(lblNewLabel_2);
	    
	    //get excited about the tournament
	    JLabel lblTournament = new JLabel("Tournament!");
	    lblTournament.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblTournament.setForeground(Color.ORANGE);
	    lblTournament.setBounds(600, 393, 226, 27);
	    frame.getContentPane().add(lblTournament);
	    
	    //start button
	    JButton btnStart = new JButton("Start");
	    startListener = new StartButton();
	    btnStart.addActionListener(startListener);
	    btnStart.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    btnStart.setBounds(643, 458, 142, 48);
	    frame.getContentPane().add(btnStart);
	}
	
	/**
	 * returns the JFrame that is being built in this class
	 * @return frame - current JFrame
	 */
	public JFrame getFrame() {
		return frame;
	}
	
	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "Start" is pressed
	 * in our confirm team information
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
class StartButton extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		/**
		*This constructs a new button that will act as the start button to
		*get results from the tournament
		**/
		public StartButton() {
		}
		/**
		*This method is called when the user pushes the start button and then sets 
		*the current display to no longer visible and then creates then next windown
		*which will diplsay the rounds of the tournamnet
		**/
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						if (tournament.getMaxNumTeams() == 2) {
							GUITournamentWinnerWindow tournamentWinnerWindow = new GUITournamentWinnerWindow(tournament, tournament.getTeams());
							tournamentWinnerWindow.getFrame().setVisible(true);
						}
						else {
							GUIDisplayNextRoundWindow displayNextRoundWindow = new GUIDisplayNextRoundWindow(tournament, tournament.getTeams());
							displayNextRoundWindow.getFrame().setVisible(true);
						}
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
		
	}
}

