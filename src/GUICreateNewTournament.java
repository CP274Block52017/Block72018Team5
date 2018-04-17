import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Choice;

public class GUICreateNewTournament {

	private static JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUICreateNewTournament window = new GUICreateNewTournament();
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
	public GUICreateNewTournament() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create a New Tournament!");
		lblCreateANew.setForeground(Color.ORANGE);
		lblCreateANew.setBounds(335, 55, 262, 16);
		frame.getContentPane().add(lblCreateANew);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to name your tournament?");
		lblWhatWouldYou.setForeground(Color.ORANGE);
		lblWhatWouldYou.setBackground(Color.ORANGE);
		lblWhatWouldYou.setBounds(279, 139, 318, 16);
		frame.getContentPane().add(lblWhatWouldYou);
		
		textField = new JTextField();
		textField.setBounds(372, 188, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHowManyParticipants = new JLabel("How many participants do you want in the tournament?");
		lblHowManyParticipants.setForeground(Color.ORANGE);
		lblHowManyParticipants.setBounds(279, 255, 348, 16);
		frame.getContentPane().add(lblHowManyParticipants);
		
		JLabel lblWhatStrategyDo = new JLabel("What strategy do you want to use to determine the winners?");
		lblWhatStrategyDo.setForeground(Color.ORANGE);
		lblWhatStrategyDo.setBounds(265, 358, 384, 16);
		frame.getContentPane().add(lblWhatStrategyDo);
		
		JLabel lblIfTheInformation = new JLabel("If the information above is correct, click submit below.");
		lblIfTheInformation.setForeground(Color.ORANGE);
		lblIfTheInformation.setBounds(279, 516, 348, 16);
		frame.getContentPane().add(lblIfTheInformation);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(395, 585, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		Choice choice = new Choice();
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.ORANGE);
		choice.add("2");
		choice.add("4");
		choice.add("8");
		choice.setBounds(415, 422, 52, 27);
		frame.getContentPane().add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setForeground(Color.BLACK);
		choice_1.setBackground(Color.ORANGE);
		choice_1.add("1: Random Winner");
		choice_1.add("2: By Greatest Average Height");
		choice_1.add("3: By Greatest Average Games Played");
		choice_1.add("4: By Greatest Average Games Won");
		choice_1.add("5: By Greatest Average Games Lost");
		choice_1.add("6: By Greatest Average Class Year");
		choice_1.setBounds(425, 296, 52, 27);
		frame.getContentPane().add(choice_1);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
}
