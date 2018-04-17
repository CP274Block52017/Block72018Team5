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
	private static String participantNumber;
	private static String strategyNumber;
	private static Object[] values;
	private static JComboBox combobox;
	
	private static JTextField textField;
	private static Choice strategyChoice;
	private static Choice participantsChoice;
	


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
		
		strategyChoice = new Choice();
		strategyChoice.setForeground(Color.BLACK);
		strategyChoice.setBackground(Color.ORANGE);
		strategyChoice.add("1: Random Winner");
		strategyChoice.add("2: By Greatest Average Height");
		strategyChoice.add("3: By Greatest Average Games Played");
		strategyChoice.add("4: By Greatest Average Games Won");
		strategyChoice.add("5: By Greatest Average Games Lost");
		strategyChoice.add("6: By Greatest Average Class Year");
		strategyChoice.setBounds(415, 422, 100, 500);
		frame.getContentPane().add(strategyChoice);
		
		participantsChoice = new Choice();
		participantsChoice.setForeground(Color.BLACK);
		participantsChoice.setBackground(Color.ORANGE);
		participantsChoice.add("2");
		participantsChoice.add("4");
		participantsChoice.add("8");
		participantsChoice.add("16");
		participantsChoice.setBounds(425, 296, 100, 100);
		frame.getContentPane().add(participantsChoice);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static String getTournamentName() {
		return tournamentName;
	}
	
	public static String getParticipantNumber() {
		return participantNumber;
	}
	
	public static String getStrategy() {
		return strategyNumber;
	}
	
	class SubmitButton extends JFrame implements ActionListener {
		
		

		public SubmitButton() {
			hasBeenClicked = false;
		}
		
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						tournamentName = textField.getText();
						participantNumber = participantsChoice.getSelectedItem();
						//participantNumber = Integer.parseInt(participantsChoice.getSelectedItem());
						//strategyNumber = Character.getNumericValue((strategyChoice.getSelectedItem().charAt(0)));
						
						String text = textField.getText();
						int item = Character.getNumericValue((strategyChoice.getSelectedItem().charAt(0)));
						int item1 = Integer.parseInt(participantsChoice.getSelectedItem());
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
