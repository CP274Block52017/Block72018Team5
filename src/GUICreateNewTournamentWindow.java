import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Choice;

public class GUICreateNewTournamentWindow {

	private static JFrame frame;
	private static boolean hasBeenClicked;
	private ActionListener submitListener;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private static String tournamentName;
	private static String teamTournament;
	private static String participantNumber;
	private static String strategy;
	private static Object[] values;
	private static JComboBox combobox;
	
	private static JTextField textField;
	private static Choice choice;
	private static Choice choice_1;
	


	/**
	 * Create the application.
	 */
	public GUICreateNewTournamentWindow() {
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
		submitListener = new SubmitButton();
		btnSubmit.addActionListener(submitListener);
		btnSubmit.setBounds(395, 585, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		choice = new Choice();
		choice.setForeground(Color.BLACK);
		choice.setBackground(Color.ORANGE);
		choice.add("1: Random Winner");
		choice.add("2: By Greatest Average Height");
		choice.add("3: By Greatest Average Games Played");
		choice.add("4: By Greatest Average Games Won");
		choice.add("5: By Greatest Average Games Lost");
		choice.add("6: By Greatest Average Class Year");
		choice.setBounds(415, 422, 100, 500);
		frame.getContentPane().add(choice);
		
		choice_1 = new Choice();
		choice_1.setForeground(Color.BLACK);
		choice_1.setBackground(Color.ORANGE);
		choice_1.add("2");
		choice_1.add("4");
		choice_1.add("8");
		choice_1.add("16");
		choice_1.setBounds(425, 296, 100, 100);
		frame.getContentPane().add(choice_1);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static String getTournamentName() {
		return teamTournament;
	}
	
	public static String getParticipantNumber() {
		return participantNumber;
	}
	
	public static String getStrategy() {
		return strategy;
	}
	
	class SubmitButton extends JFrame implements ActionListener {
		
		public SubmitButton() {
			hasBeenClicked = false;
		}
		
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						String text = textField.getText();
						
						int item = Integer.parseInt(choice.getSelectedItem());
						String item1 = choice_1.getSelectedItem();
						System.out.println(text+ " " + item + " " + item1);
						
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}

	}
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//	EventQueue.invokeLater(new Runnable() {
//		public void run() {
//			try {
//				GUICreateNewTournament window = new GUICreateNewTournament();
//				window.frame.setVisible(true);
//			} catch (Exception e) {
//				e.printStackTrace();
//			}
//		}
//	});
//}


}
