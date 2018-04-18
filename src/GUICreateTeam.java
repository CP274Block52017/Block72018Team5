import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Choice;
import java.awt.Font;
import java.util.ArrayList;

public class GUICreateTeam {

	private static JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private static Choice athleteChoice1;
	private static Choice athleteChoice2;
	private static Choice athleteChoice3;
	private static Choice athleteChoice4;
	private static Choice athleteChoice5;
	private static ArrayList<Player> playerChoices; 
	private static boolean hasBeenClicked;
	public static int counter;
	public static ArrayList<String> currentTeam;
	private static JTextField textField;
	private static String teamName;
	private static String firstAthlete;
	private static String secondAthlete;
	private static String thirdAthlete;
	private static String fourthAthlete;
	private static String fifthAthlete;
	private static ActionListener enterListener;
	private static ArrayList<String> teamNames;
	
	/**
	 * Create the application.
	 */
	public GUICreateTeam() throws IOException {
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
		lblCreateTeam.setBounds(583, 128, 289, 36);
		frame.getContentPane().add(lblCreateTeam);
		
		JLabel lblAthlete = new JLabel("Athlete 1:");
		lblAthlete.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete.setForeground(Color.ORANGE);
		lblAthlete.setBounds(58, 343, 223, 54);
		frame.getContentPane().add(lblAthlete);
		
		JLabel lblAthlete_2 = new JLabel("Athlete 2:");
		lblAthlete_2.setForeground(Color.ORANGE);
		lblAthlete_2.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_2.setBounds(514, 343, 223, 54);
		frame.getContentPane().add(lblAthlete_2);
		
		JLabel lblAthlete_1 = new JLabel("Athlete 3:");
		lblAthlete_1.setForeground(Color.ORANGE);
		lblAthlete_1.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_1.setBounds(952, 343, 223, 54);
		frame.getContentPane().add(lblAthlete_1);
		
		JLabel lblAthlete_4 = new JLabel("Athlete 4:");
		lblAthlete_4.setForeground(Color.ORANGE);
		lblAthlete_4.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_4.setBounds(279, 478, 223, 54);
		frame.getContentPane().add(lblAthlete_4);
		
		JLabel lblAthlete_3 = new JLabel("Athlete 5:");
		lblAthlete_3.setForeground(Color.ORANGE);
		lblAthlete_3.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_3.setBounds(758, 478, 223, 54);
		frame.getContentPane().add(lblAthlete_3);
		
		athleteChoice1 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice1.add(playerChoices.get(i).getName());
		}
		athleteChoice1.setForeground(Color.BLACK);
		athleteChoice1.setBackground(Color.ORANGE);
		athleteChoice1.setBounds(514, 478, 203, 42);
		frame.getContentPane().add(athleteChoice1);
		
		athleteChoice2 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice2.add(playerChoices.get(i).getName());
		}
		athleteChoice2.setBackground(Color.ORANGE);
		athleteChoice2.setForeground(Color.BLACK);
		athleteChoice2.setBounds(743, 343, 203, 42);
		frame.getContentPane().add(athleteChoice2);
		
		athleteChoice3 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice3.add(playerChoices.get(i).getName());
		}
		athleteChoice3.setForeground(Color.BLACK);
		athleteChoice3.setBackground(Color.ORANGE);
		athleteChoice3.setBounds(984, 478, 203, 42);
		frame.getContentPane().add(athleteChoice3);
		
		athleteChoice4 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice4.add(playerChoices.get(i).getName());
		}
		athleteChoice4.setForeground(Color.BLACK);
		athleteChoice4.setBackground(Color.ORANGE);
		athleteChoice4.setBounds(1181, 343, 203, 42);
		frame.getContentPane().add(athleteChoice4);
		
		athleteChoice5 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice5.add(playerChoices.get(i).getName());
		}
		athleteChoice5.setBackground(Color.ORANGE);
		athleteChoice5.setForeground(Color.BLACK);
		athleteChoice5.setBounds(290, 343, 203, 42);
		frame.getContentPane().add(athleteChoice5);
		
		JLabel lblPressEnterTo = new JLabel("Press Enter to submit these athletes to your team!");
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
	    
	    textField = new JTextField();
	    textField.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    textField.setBounds(812, 239, 289, 36);
	    frame.getContentPane().add(textField);
	    textField.setColumns(10);
		
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static ArrayList<String> getTeam() {
		return currentTeam;
	}
	
	public static String getTeamName() {
		return teamName;
	}
	
	public static String getFirstAthlete() {
		return firstAthlete;
	}
	
	public static String getSecondAthlete() {
		return secondAthlete;
	}
	
	public static String getThirdAthlete() {
		return thirdAthlete;
	}
	
	public static String getFourthAthlete() {
		return fourthAthlete;
	}
	
	public static String getFifthAthlete() {
		return fifthAthlete;
	}
	
	public static ArrayList<String> getTeamNames() {
		return teamNames;
	}
	
	class EnterButton extends JFrame implements ActionListener {
		
		public EnterButton() {
			hasBeenClicked = false;
		}
		
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						teamName = textField.getText();
						firstAthlete = athleteChoice1.getSelectedItem();
						secondAthlete = athleteChoice2.getSelectedItem();
						thirdAthlete = athleteChoice3.getSelectedItem();
						fourthAthlete = athleteChoice4.getSelectedItem();
						fifthAthlete = athleteChoice5.getSelectedItem();
//						teamNames.add(teamName);
//						currentTeam.add(firstAthlete);
//						currentTeam.add(secondAthlete);
//						currentTeam.add(thirdAthlete);
//						currentTeam.add(fourthAthlete);
//						currentTeam.add(fifthAthlete);
						GUIDisplayTeam window = new GUIDisplayTeam();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			frame.setVisible(false);
			hasBeenClicked = true;
		}
	}
}
