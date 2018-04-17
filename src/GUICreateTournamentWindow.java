import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import java.awt.BorderLayout;
import java.awt.TextField;
import java.awt.event.ActionListener;
import java.awt.Label;
import java.awt.Choice;
import javax.swing.JButton;
import java.awt.event.ActionEvent;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import javax.swing.JComboBox;

public class GUICreateTournamentWindow extends JFrame {

	private static JFrame frame;
	private static boolean hasBeenClicked;
	private ActionListener submitListener;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1500;
	private static String tournamentName;
	private static String teamName;
	private static String participantNumber;
	private static String strategy;
	private static Object[] values;
	private static JComboBox combobox;
	
	public static JFrame getFrame() {
		return frame;
	}

	/**
	 * Create the application.
	 */
	public GUICreateTournamentWindow() {
		initialize();
	}
	
	void initComboBox() {
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to name your tournament?");
		lblWhatWouldYou.setForeground(Color.WHITE);
		lblWhatWouldYou.setBounds(73, 6, 300, 16);
		frame.getContentPane().add(lblWhatWouldYou);
		
		TextField textField = new TextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teamName = textField.getText();
			}
		});
		textField.setBounds(129, 41, 199, 22);
		frame.getContentPane().add(textField);
		
		JLabel lblChooseANumber = new JLabel("Choose a number of participants for the tournament.");
		lblChooseANumber.setForeground(Color.WHITE);
		lblChooseANumber.setBounds(59, 79, 342, 16);
		frame.getContentPane().add(lblChooseANumber);
		
		JButton btnSubmit = new JButton("Submit ");
		submitListener = new SubmitButton();
		btnSubmit.addActionListener(submitListener);
		btnSubmit.setBounds(161, 243, 117, 29);
		frame.getContentPane().add(btnSubmit);
		
		JLabel lblChooseAStrategy = new JLabel("Choose a strategy to determine the winner.");
		lblChooseAStrategy.setForeground(Color.WHITE);
		lblChooseAStrategy.setBounds(83, 162, 276, 16);
		frame.getContentPane().add(lblChooseAStrategy);
		
		Choice choice = new Choice();
		choice.add("2");
		choice.add("4");
		choice.add("8");
		choice.add("16");
		choice.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				 participantNumber = choice.getSelectedItem();
			}
		});
		choice.setBackground(Color.ORANGE);
		choice.setForeground(Color.BLACK);
		choice.setBounds(147, 115, 146, 27);
		frame.getContentPane().add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.add("1: Random Selection");
		choice_1.add("2: Athletes' Height");
		choice_1.add("3: Athletes' Games Played");
		choice_1.add("4: Athletes' Games Won");
		choice_1.add("5: Athletes' Games Lost");
		choice_1.add("6: Athletes' Class Year");
		choice_1.setBackground(Color.ORANGE);
		choice_1.setForeground(Color.BLACK);
		choice_1.setBounds(147, 199, 146, 27);
		choice_1.addComponentListener(new ComponentAdapter() {
			public void componentShown(ComponentEvent e) {
				strategy = choice.getSelectedItem();
			}
		});
		frame.getContentPane().add(choice_1);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static String getTeamName() {
		return teamName;
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
						GUIDisplayTournamentInformation window = new GUIDisplayTournamentInformation();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
}
