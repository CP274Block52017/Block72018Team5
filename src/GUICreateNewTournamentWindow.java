import java.awt.EventQueue;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Choice;

public class GUICreateNewTournamentWindow {

	private JFrame frame;
	private boolean hasBeenClicked;
	private ActionListener submitListener;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private String tournamentName;
	private String numParticipants;
	private int strategy;
	private Object[] values;
	private JComboBox combobox;
	
	private JTextField tournamentNameChoice;
	private Choice strategyChoiceString;
	private Choice numParticipantsChoice;

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
		
		tournamentNameChoice = new JTextField();
		tournamentNameChoice.setBounds(372, 188, 130, 26);
		frame.getContentPane().add(tournamentNameChoice);
		tournamentNameChoice.setColumns(10);
		
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
		
		strategyChoiceString = new Choice();
		strategyChoiceString.setForeground(Color.BLACK);
		strategyChoiceString.setBackground(Color.ORANGE);
		strategyChoiceString.add("1: Random Winner");
		strategyChoiceString.add("2: By Greatest Average Height");
		strategyChoiceString.add("3: By Greatest Average Games Played");
		strategyChoiceString.add("4: By Greatest Average Games Won");
		strategyChoiceString.add("5: By Greatest Average Games Lost");
		strategyChoiceString.add("6: By Greatest Average Class Year");
		strategyChoiceString.setBounds(415, 422, 100, 500);
		frame.getContentPane().add(strategyChoiceString);
		
		numParticipantsChoice = new Choice();
		numParticipantsChoice.setForeground(Color.BLACK);
		numParticipantsChoice.setBackground(Color.ORANGE);
		numParticipantsChoice.add("2");
		numParticipantsChoice.add("4");
		numParticipantsChoice.add("8");
		numParticipantsChoice.add("16");
		numParticipantsChoice.setBounds(425, 296, 100, 100);
		frame.getContentPane().add(numParticipantsChoice);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public JFrame getFrame() {
		return frame;
	}
	
	class SubmitButton extends JFrame implements ActionListener {
	
		private static final long serialVersionUID = 1L;

		public SubmitButton() {
			hasBeenClicked = false;
		}
		
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			String tournamentName = tournamentNameChoice.getText();
			Character firstCharStrategyString = strategyChoiceString.getSelectedItem().charAt(0);
			int strategyChoice = Character.getNumericValue(firstCharStrategyString);
			int numParticipants = Integer.parseInt(numParticipantsChoice.getSelectedItem());
			
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUIShowTournamentInfoWindow showTournamentInfoWindow = new GUIShowTournamentInfoWindow(tournamentName, strategyChoice, numParticipants);
						showTournamentInfoWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}

	}

}

