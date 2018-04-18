
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
/**
 * This method produces the frame that asks the user to check the 
 * team they have just created. If they like the information they
 * can move on. If not they have a chance to go back and edit it
 * their entries.
 * @author Kelli
 * @author Emma
 * @author Nicole
 */
public class GUIDisplayTeamWindow extends JFrame {

	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener backListener;
	private ActionListener nextListener;
	
	private Tournament tournament;
	private String teamName;
	private ArrayList<String> chosenPlayers;

	/**
	 * Constructor sets the tournament, team name and array list of our players to the 
	 * corresponding classes instances. Then calls in the method to initialize the GUI
	 * window.
	 * @throws IOException - make sure the user has the correct
	 *graphics stored in their project file
	 * @param tournament - tournament we are currently working on
	 * @param teamName - team name of this team
	 * @param chosenPlayers - chosen players of this team
	 */
	public GUIDisplayTeamWindow(Tournament tournament, String teamName, ArrayList<String> chosenPlayers) throws IOException {
		this.tournament = tournament;
		this.teamName = teamName;
		this.chosenPlayers = chosenPlayers;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String logoFile = "Logo.jpg";
	    File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(6, 153, 300, 1200);
	    frame.getContentPane().add(graphic);
	    
	    String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	    
	    JLabel lblDoubleCheckYou = new JLabel("Double check your team!");
	    lblDoubleCheckYou.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblDoubleCheckYou.setForeground(Color.ORANGE);
	    lblDoubleCheckYou.setBounds(503, 142, 560, 62);
	    frame.getContentPane().add(lblDoubleCheckYou);
	    
	    JLabel lblTeamName = new JLabel("Team Name:");
	    lblTeamName.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblTeamName.setForeground(Color.ORANGE);
	    lblTeamName.setBounds(100, 250, 293, 54);
	    frame.getContentPane().add(lblTeamName);
	    
	    JLabel label = new JLabel("");
	    label.setText(teamName);
	    label.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
	    label.setForeground(Color.WHITE);
	    label.setBounds(392, 257, 560, 48);
	    frame.getContentPane().add(label);
	    
	    JLabel lblAthletesInTeam = new JLabel("Athletes in team:");
	    lblAthletesInTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblAthletesInTeam.setForeground(Color.ORANGE);
	    lblAthletesInTeam.setBounds(100, 366, 371, 48);
	    frame.getContentPane().add(lblAthletesInTeam);
	    
	    JLabel label_1 = new JLabel("");
	    label_1.setText(chosenPlayers.get(0));
	    label_1.setForeground(Color.WHITE);
	    label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_1.setBounds(503, 366, 432, 48);
	    frame.getContentPane().add(label_1);
	    
	    JLabel label_2 = new JLabel("");
	    label_2.setText(chosenPlayers.get(1));
	    label_2.setForeground(Color.WHITE);
	    label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_2.setBounds(986, 366, 432, 48);
	    frame.getContentPane().add(label_2);
	    
	    JLabel label_3 = new JLabel("");
	    label_3.setText(chosenPlayers.get(2));
	    label_3.setForeground(Color.WHITE);
	    label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_3.setBounds(100, 480, 432, 48);
	    frame.getContentPane().add(label_3);
	    
	    JLabel label_4 = new JLabel("");
	    label_4.setText(chosenPlayers.get(3));
	    label_4.setForeground(Color.WHITE);
	    label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_4.setBounds(558, 480, 432, 48);
	    frame.getContentPane().add(label_4);
	    
	    JLabel label_5 = new JLabel("");
	    label_5.setText(chosenPlayers.get(4));
	    label_5.setForeground(Color.WHITE);
	    label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_5.setBounds(1012, 480, 432, 48);
	    frame.getContentPane().add(label_5);
	    
	    JLabel lblClickBackTo = new JLabel("Click Back to edit team, click Next to continue!");
	    lblClickBackTo.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblClickBackTo.setForeground(Color.ORANGE);
	    lblClickBackTo.setBounds(265, 599, 1076, 54);
	    frame.getContentPane().add(lblClickBackTo);
	    
	    JButton btnBack = new JButton("Back");
	    backListener = new BackButton();
	    btnBack.addActionListener(backListener);
	    btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    btnBack.setBounds(518, 690, 160, 54);
	    frame.getContentPane().add(btnBack);
	    
	    JButton btnNext = new JButton("Next");
	    nextListener = new NextButton();
	    btnNext.addActionListener(nextListener);
	    btnNext.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    btnNext.setBounds(882, 690, 160, 54);
	    frame.getContentPane().add(btnNext);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	private Team createTeam() {
		Team newTeam = new Team(teamName);
		for (String playerName : chosenPlayers) {
			Player chosenPlayer = PlayerDatabase.findPlayer(playerName);
			newTeam.addPlayer(chosenPlayer);
		}
		return newTeam;
	}
	
	class NextButton extends JFrame implements ActionListener {
			
		private static final long serialVersionUID = 1L;

			public NextButton() {
			}
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				Team team = createTeam();
				
				//add team to tournament
				tournament.addTeam(team);
				
				//open next window
				//if below max number of teams, go back to make a new team
				//otherwise, advance to confirmation window
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							if (tournament.getNumTeams() < tournament.getMaxNumTeams()) {
								GUICreateNewTeamWindow createNewTeamWindow = new GUICreateNewTeamWindow(tournament);
								createNewTeamWindow.getFrame().setVisible(true);
							}
							else {
								GUIDisplayTournamentTeamsWindow displayTeamsWindow = new GUIDisplayTournamentTeamsWindow(tournament);
								displayTeamsWindow.getFrame().setVisible(true);
							}
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
	}

	class BackButton extends JFrame implements ActionListener {
	
		private static final long serialVersionUID = 1L;

		public BackButton() {
		}
		
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			
			//go back to create-a-tournament window
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
		}
	}
}

