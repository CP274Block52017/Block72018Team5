import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Label;
import java.awt.Font;

public class GUI {

	private static JFrame frame;
	
	private static boolean isYes;
	
	private static Tournament newTournament;
	private static TournamentWinnerStrategy chosenStrategy;
	private static ArrayList<Players> allPlayers = CreatePlayerDatabase.getPlayers();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static boolean getIsYes() {
		return isYes;
	}

	/**
	 * Create the application.
	 */
	public GUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Tournament Generator");
		lblWelcomeToThe.setFont(new Font("Al Bayan", Font.PLAIN, 50));
		lblWelcomeToThe.setForeground(Color.ORANGE);
		lblWelcomeToThe.setBounds(247, 196, 930, 52);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCreatedByNicole = new JLabel("Created by: Nicole Woch, Kelli Sullivan, and Emma Blair");
		lblCreatedByNicole.setFont(new Font("Al Nile", Font.ITALIC, 25));
		lblCreatedByNicole.setForeground(Color.ORANGE);
		lblCreatedByNicole.setBounds(351, 272, 668, 35);
		frame.getContentPane().add(lblCreatedByNicole);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to create a tournament?");
		lblWouldYouLike.setFont(new Font("Al Nile", Font.PLAIN, 20));
		lblWouldYouLike.setForeground(Color.ORANGE);
		lblWouldYouLike.setBackground(Color.ORANGE);
		lblWouldYouLike.setBounds(647, 577, 372, 28);
		frame.getContentPane().add(lblWouldYouLike);
		
		JButton btnYes = new JButton("Yes");
		btnYes.setBounds(647, 648, 117, 29);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		btnNo.setBounds(888, 648, 117, 29);
		frame.getContentPane().add(btnNo);
		
		JLabel lblChooseATournament = new JLabel("Choose a Tournament Master to create a tournament that includes");
		lblChooseATournament.setForeground(Color.WHITE);
		lblChooseATournament.setBounds(638, 378, 417, 16);
		frame.getContentPane().add(lblChooseATournament);
		
		JLabel lblHowToPlay = new JLabel("How To Play:");
		lblHowToPlay.setForeground(Color.WHITE);
		lblHowToPlay.setBounds(793, 350, 81, 16);
		frame.getContentPane().add(lblHowToPlay);
		
		JLabel label = new JLabel("2, 4, 8, or 16 friends to be the participants in the tournament");
		label.setForeground(Color.WHITE);
		label.setBounds(659, 406, 385, 16);
		frame.getContentPane().add(label);
		
		JLabel lblAndEachCreate = new JLabel("and each create a customized team of Colorado College athletes");
		lblAndEachCreate.setForeground(Color.WHITE);
		lblAndEachCreate.setBounds(647, 434, 404, 16);
		frame.getContentPane().add(lblAndEachCreate);
		
		JLabel lblToCompeteAgainst = new JLabel("based on their statistics to compete against each other. The Tournament master");
		lblToCompeteAgainst.setForeground(Color.WHITE);
		lblToCompeteAgainst.setBounds(601, 462, 505, 16);
		frame.getContentPane().add(lblToCompeteAgainst);
		
		JLabel lblWillDecideThe = new JLabel("will decide the strategy used to determine the winner.");
		lblWillDecideThe.setForeground(Color.WHITE);
		lblWillDecideThe.setBounds(667, 490, 338, 16);
		frame.getContentPane().add(lblWillDecideThe);
	}
}


