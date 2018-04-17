import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

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

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICreateTeam window = new GUICreateTeam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUICreateTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateTeam = new JLabel("Create Team!");
		lblCreateTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblCreateTeam.setForeground(Color.ORANGE);
		lblCreateTeam.setBounds(596, 40, 257, 36);
		frame.getContentPane().add(lblCreateTeam);
		
		JLabel lblAthlete = new JLabel("Athlete 1:");
		lblAthlete.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete.setForeground(Color.ORANGE);
		lblAthlete.setBounds(50, 170, 223, 54);
		frame.getContentPane().add(lblAthlete);
		
		JLabel lblAthlete_2 = new JLabel("Athlete 2:");
		lblAthlete_2.setForeground(Color.ORANGE);
		lblAthlete_2.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_2.setBounds(520, 170, 223, 54);
		frame.getContentPane().add(lblAthlete_2);
		
		JLabel lblAthlete_1 = new JLabel("Athlete 3:");
		lblAthlete_1.setForeground(Color.ORANGE);
		lblAthlete_1.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_1.setBounds(972, 170, 223, 54);
		frame.getContentPane().add(lblAthlete_1);
		
		JLabel lblAthlete_4 = new JLabel("Athlete 4:");
		lblAthlete_4.setForeground(Color.ORANGE);
		lblAthlete_4.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_4.setBounds(280, 338, 223, 54);
		frame.getContentPane().add(lblAthlete_4);
		
		JLabel lblAthlete_3 = new JLabel("Athlete 5:");
		lblAthlete_3.setForeground(Color.ORANGE);
		lblAthlete_3.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblAthlete_3.setBounds(755, 338, 223, 54);
		frame.getContentPane().add(lblAthlete_3);
		
		athleteChoice1 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice1.add(playerChoices.get(i).getName() + ", " + playerChoices.get(i).getSport());
		}
		athleteChoice1.setForeground(Color.BLACK);
		athleteChoice1.setBackground(Color.ORANGE);
		athleteChoice1.setBounds(509, 350, 203, 42);
		frame.getContentPane().add(athleteChoice1);
		
		athleteChoice2 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice2.add(playerChoices.get(i).getName() + ", " + playerChoices.get(i).getSport());
		}
		athleteChoice2.setBackground(Color.ORANGE);
		athleteChoice2.setForeground(Color.BLACK);
		athleteChoice2.setBounds(749, 182, 203, 42);
		frame.getContentPane().add(athleteChoice2);
		
		athleteChoice3 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice3.add(playerChoices.get(i).getName() + ", " + playerChoices.get(i).getSport());
		}
		athleteChoice3.setForeground(Color.BLACK);
		athleteChoice3.setBackground(Color.ORANGE);
		athleteChoice3.setBounds(972, 350, 203, 42);
		frame.getContentPane().add(athleteChoice3);
		
		athleteChoice4 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice4.add(playerChoices.get(i).getName() + ", " + playerChoices.get(i).getSport());
		}
		athleteChoice4.setForeground(Color.BLACK);
		athleteChoice4.setBackground(Color.ORANGE);
		athleteChoice4.setBounds(1200, 182, 203, 42);
		frame.getContentPane().add(athleteChoice4);
		
		athleteChoice5 = new Choice();
		playerChoices = PlayerDatabase.getPlayersList();
		for(int i = 0; i < playerChoices.size(); i++) {
			athleteChoice5.add(playerChoices.get(i).getName() + ", " + playerChoices.get(i).getSport());
		}
		athleteChoice5.setBackground(Color.ORANGE);
		athleteChoice5.setForeground(Color.BLACK);
		athleteChoice5.setBounds(279, 182, 203, 42);
		frame.getContentPane().add(athleteChoice5);
		
		JLabel lblPressEnterTo = new JLabel("Press Enter to submit these athletes to your team!");
		lblPressEnterTo.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblPressEnterTo.setForeground(Color.ORANGE);
		lblPressEnterTo.setBounds(260, 529, 1001, 36);
		frame.getContentPane().add(lblPressEnterTo);
		
		JButton btnNewButton = new JButton("Enter");
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		btnNewButton.setBounds(640, 651, 189, 54);
		frame.getContentPane().add(btnNewButton);
		
	}
	
	public static JFrame getFrame() {
		return frame;
	}

}
