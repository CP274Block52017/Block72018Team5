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

public class GUICreateNewTournamentWindow {

	private static JFrame frame;
	private static boolean hasBeenClicked;
	private ActionListener submitListener;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private static String tournamentName;
	private static String participantNumber;
	private static String strategy;
	private static JTextField textField;
	private static Choice choice;
	private static Choice choice_1;
	


	/**
	 * Create the application.
	 */
	public GUICreateNewTournamentWindow() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateANew = new JLabel("Create a New Tournament!");
		lblCreateANew.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblCreateANew.setForeground(Color.ORANGE);
		lblCreateANew.setBounds(443, 95, 595, 44);
		frame.getContentPane().add(lblCreateANew);
		
		JLabel lblWhatWouldYou = new JLabel("What would you like to name your tournament?");
		lblWhatWouldYou.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblWhatWouldYou.setForeground(Color.ORANGE);
		lblWhatWouldYou.setBackground(Color.ORANGE);
		lblWhatWouldYou.setBounds(329, 198, 798, 36);
		frame.getContentPane().add(lblWhatWouldYou);
		
		textField = new JTextField();
		textField.setBounds(619, 270, 224, 51);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblHowManyParticipants = new JLabel("How many participants do you want in the tournament?");
		lblHowManyParticipants.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblHowManyParticipants.setForeground(Color.ORANGE);
		lblHowManyParticipants.setBounds(266, 345, 959, 51);
		frame.getContentPane().add(lblHowManyParticipants);
		
		JLabel lblWhatStrategyDo = new JLabel("What strategy do you want to use to determine the winners?");
		lblWhatStrategyDo.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblWhatStrategyDo.setForeground(Color.ORANGE);
		lblWhatStrategyDo.setBounds(238, 485, 1027, 44);
		frame.getContentPane().add(lblWhatStrategyDo);
		
		JLabel lblIfTheInformation = new JLabel("If the information above is correct, click submit below.");
		lblIfTheInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfTheInformation.setForeground(Color.ORANGE);
		lblIfTheInformation.setBounds(280, 626, 931, 36);
		frame.getContentPane().add(lblIfTheInformation);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		submitListener = new SubmitButton();
		btnSubmit.addActionListener(submitListener);
		btnSubmit.setBounds(658, 692, 144, 51);
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
		choice.setBounds(619, 561, 216, 36);
		frame.getContentPane().add(choice);
		
		choice_1 = new Choice();
		choice_1.setForeground(Color.BLACK);
		choice_1.setBackground(Color.ORANGE);
		choice_1.add("2");
		choice_1.add("4");
		choice_1.add("8");
		choice_1.add("16");
		choice_1.setBounds(619, 424, 224, 36);
		frame.getContentPane().add(choice_1);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
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
						tournamentName = textField.getText();
						participantNumber = choice_1.getSelectedItem();
						strategy = choice.getSelectedItem();
						GUIShowTournamentInformation window = new GUIShowTournamentInformation();
						window.getFrame().setVisible(true);
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
