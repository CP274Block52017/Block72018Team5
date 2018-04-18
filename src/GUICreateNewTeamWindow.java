import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Font;
import java.util.ArrayList;

public class GUICreateNewTeamWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private JTextField teamNameChoice;
	private Choice playerChoice1;
	private Choice playerChoice2;
	private Choice playerChoice3;
	private Choice playerChoice4;
	private Choice playerChoice5;
	private ArrayList<Player> playerChoices; 
	private ActionListener enterListener;
	
	private Tournament tournament;

	/**
	 * Create the application.
	 */
	public GUICreateNewTeamWindow(Tournament tournament) throws IOException {
		this.tournament = tournament;
		this.playerChoices = PlayerDatabase.getPlayersList();
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
		
		JLabel lblCreateTeam = new JLabel("Create Team!");
		lblCreateTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblCreateTeam.setForeground(Color.ORANGE);
		lblCreateTeam.setBounds(600, 127, 289, 36);
		frame.getContentPane().add(lblCreateTeam);
		
		JLabel lblplayer = new JLabel("Player 1:");
		lblplayer.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblplayer.setForeground(Color.ORANGE);
		lblplayer.setBounds(58, 343, 223, 54);
		frame.getContentPane().add(lblplayer);
		
		JLabel lblplayer_2 = new JLabel("Player 2:");
		lblplayer_2.setForeground(Color.ORANGE);
		lblplayer_2.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblplayer_2.setBounds(514, 343, 223, 54);
		frame.getContentPane().add(lblplayer_2);
		
		JLabel lblplayer_1 = new JLabel("Player 3:");
		lblplayer_1.setForeground(Color.ORANGE);
		lblplayer_1.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblplayer_1.setBounds(952, 343, 223, 54);
		frame.getContentPane().add(lblplayer_1);
		
		JLabel lblplayer_4 = new JLabel("Player 4:");
		lblplayer_4.setForeground(Color.ORANGE);
		lblplayer_4.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblplayer_4.setBounds(279, 478, 223, 54);
		frame.getContentPane().add(lblplayer_4);
		
		JLabel lblplayer_3 = new JLabel("Player 5:");
		lblplayer_3.setForeground(Color.ORANGE);
		lblplayer_3.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblplayer_3.setBounds(758, 478, 223, 54);
		frame.getContentPane().add(lblplayer_3);
		
		playerChoice1 = new Choice();
		for(int i = 0; i < playerChoices.size(); i++) {
			playerChoice1.add(playerChoices.get(i).getName());
		}
		playerChoice1.setForeground(Color.BLACK);
		playerChoice1.setBackground(Color.ORANGE);
		playerChoice1.setBounds(514, 478, 203, 42);
		frame.getContentPane().add(playerChoice1);
		
		playerChoice2 = new Choice();
		for(int i = 0; i < playerChoices.size(); i++) {
			playerChoice2.add(playerChoices.get(i).getName());
		}
		playerChoice2.setBackground(Color.ORANGE);
		playerChoice2.setForeground(Color.BLACK);
		playerChoice2.setBounds(743, 343, 203, 42);
		frame.getContentPane().add(playerChoice2);
		
		playerChoice3 = new Choice();
		for(int i = 0; i < playerChoices.size(); i++) {
			playerChoice3.add(playerChoices.get(i).getName());
		}
		playerChoice3.setForeground(Color.BLACK);
		playerChoice3.setBackground(Color.ORANGE);
		playerChoice3.setBounds(984, 478, 203, 42);
		frame.getContentPane().add(playerChoice3);
		
		playerChoice4 = new Choice();
		for(int i = 0; i < playerChoices.size(); i++) {
			playerChoice4.add(playerChoices.get(i).getName());
		}
		playerChoice4.setForeground(Color.BLACK);
		playerChoice4.setBackground(Color.ORANGE);
		playerChoice4.setBounds(1181, 343, 203, 42);
		frame.getContentPane().add(playerChoice4);
		
		playerChoice5 = new Choice();
		for(int i = 0; i < playerChoices.size(); i++) {
			playerChoice5.add(playerChoices.get(i).getName());
		}
		playerChoice5.setBackground(Color.ORANGE);
		playerChoice5.setForeground(Color.BLACK);
		playerChoice5.setBounds(290, 343, 203, 42);
		frame.getContentPane().add(playerChoice5);
		
		JLabel lblPressEnterTo = new JLabel("Press Enter to submit these players to your team!");
		lblPressEnterTo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblPressEnterTo.setForeground(Color.ORANGE);
		lblPressEnterTo.setBounds(260, 623, 1001, 36);
		frame.getContentPane().add(lblPressEnterTo);
		
		JButton btnNewButton = new JButton("Enter");
		enterListener = new EnterButton();
		btnNewButton.addActionListener(enterListener);
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(642, 716, 189, 54);
		frame.getContentPane().add(btnNewButton);
		
		String logoFile = "Logo.jpg";
	    File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(25, 155, 300, 1200);
	    frame.getContentPane().add(graphic);
	    
	    String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	    
	    JLabel lblNameYourTeam = new JLabel("Name your team:");
	    lblNameYourTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblNameYourTeam.setForeground(Color.ORANGE);
	    lblNameYourTeam.setBounds(401, 226, 386, 54);
	    frame.getContentPane().add(lblNameYourTeam);
	    
	    teamNameChoice = new JTextField();
	    teamNameChoice.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    teamNameChoice.setBounds(812, 239, 289, 36);
	    frame.getContentPane().add(teamNameChoice);
	    teamNameChoice.setColumns(10);
		
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	class EnterButton extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;

		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
		public EnterButton() {
		}
		
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			String teamName = teamNameChoice.getText();
			ArrayList<String> chosenPlayers = new ArrayList<String>();
			chosenPlayers.add(playerChoice1.getSelectedItem());
			chosenPlayers.add(playerChoice2.getSelectedItem());
			chosenPlayers.add(playerChoice3.getSelectedItem());
			chosenPlayers.add(playerChoice4.getSelectedItem());
			chosenPlayers.add(playerChoice5.getSelectedItem());
			
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUIDisplayTeamWindow displayTeamWindow = new GUIDisplayTeamWindow(tournament, teamName, chosenPlayers);
						displayTeamWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
}