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
		
		Choice choice = new Choice();
		ArrayList<Player> players = PlayerDatabase.getPlayersList();
		for(int i = 0; i < players.size(); i++) {
			choice.add(players.get(i).getName() + players.get(i).getSport());
		}
		choice.add(players.get(0).getName());
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.ORANGE);
		choice.setBounds(509, 350, 203, 42);
		frame.getContentPane().add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBackground(Color.ORANGE);
		choice_1.setForeground(Color.BLACK);
		choice_1.setBounds(749, 182, 203, 42);
		frame.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setForeground(Color.BLACK);
		choice_2.setBackground(Color.ORANGE);
		choice_2.setBounds(972, 350, 203, 42);
		frame.getContentPane().add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setForeground(Color.BLACK);
		choice_3.setBackground(Color.ORANGE);
		choice_3.setBounds(1200, 182, 203, 42);
		frame.getContentPane().add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBackground(Color.ORANGE);
		choice_4.setForeground(Color.BLACK);
		choice_4.setBounds(279, 182, 203, 42);
		frame.getContentPane().add(choice_4);
		
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
