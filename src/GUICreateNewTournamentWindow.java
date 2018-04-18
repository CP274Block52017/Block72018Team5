import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Choice;

public class GUICreateNewTournamentWindow {

	private JFrame frame;
	private ActionListener submitListener;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private JTextField tournamentNameChoice;
	private Choice strategyChoiceString;
	private Choice numParticipantsChoice;

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
		
		tournamentNameChoice = new JTextField();
		tournamentNameChoice.setBounds(619, 270, 224, 51);
		frame.getContentPane().add(tournamentNameChoice);
		tournamentNameChoice.setColumns(10);
		
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
		
		strategyChoiceString = new Choice();
		strategyChoiceString.setForeground(Color.BLACK);
		strategyChoiceString.setBackground(Color.ORANGE);
		strategyChoiceString.add("1: Random Winner");
		strategyChoiceString.add("2: By Greatest Average Height");
		strategyChoiceString.add("3: By Greatest Average Games Played");
		strategyChoiceString.add("4: By Greatest Average Games Won");
		strategyChoiceString.add("5: By Greatest Average Games Lost");
		strategyChoiceString.add("6: By Greatest Average Class Year");
		strategyChoiceString.setBounds(619, 561, 216, 36);
		frame.getContentPane().add(strategyChoiceString);
		
		numParticipantsChoice = new Choice();
		numParticipantsChoice.setForeground(Color.BLACK);
		numParticipantsChoice.setBackground(Color.ORANGE);
		numParticipantsChoice.add("2");
		numParticipantsChoice.add("4");
		numParticipantsChoice.add("8");
		numParticipantsChoice.setBounds(619, 424, 224, 36);
		frame.getContentPane().add(numParticipantsChoice);
		
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
	
	public JFrame getFrame() {
		return frame;
	}
	
	class SubmitButton extends JFrame implements ActionListener {
	
		private static final long serialVersionUID = 1L;

		public SubmitButton() {
		}
		
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			String tournamentName = tournamentNameChoice.getText();
			Character firstCharStrategyString = strategyChoiceString.getSelectedItem().charAt(0);
			int strategyChoiceString = Character.getNumericValue(firstCharStrategyString);
			int numParticipants = Integer.parseInt(numParticipantsChoice.getSelectedItem());
			
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUIDisplayTournamentInfoWindow showTournamentInfoWindow = new GUIDisplayTournamentInfoWindow(tournamentName, strategyChoiceString, numParticipants);
						showTournamentInfoWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}

	}

}

