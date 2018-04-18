import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class GUIDisplayTournamentInfoWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener nextListener;
	private ActionListener backListener;
	private boolean hasBeenClicked;
	
	private String tournamentName;
	private TournamentWinnerStrategy strategy;
	private int numParticipants;

	/**
	 * Create the application.
	 */
	public GUIDisplayTournamentInfoWindow(String tournamentName, int strategyChoice, int numParticipants) throws IOException {
		this.tournamentName = tournamentName;
		this.strategy = WinnerStrategyFactory.getWinnerStrategy(strategyChoice);
		this.numParticipants = numParticipants;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTournamentInformation = new JLabel("Tournament Information!");
		lblTournamentInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
		lblTournamentInformation.setForeground(Color.ORANGE);
		lblTournamentInformation.setBounds(475, 112, 506, 36);
		frame.getContentPane().add(lblTournamentInformation);
		
		JLabel lblTournamentName = new JLabel("Tournament Name:");
		lblTournamentName.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblTournamentName.setForeground(Color.ORANGE);
		lblTournamentName.setBounds(271, 176, 335, 36);
		frame.getContentPane().add(lblTournamentName);
		
		JLabel lblNumberOfParticipants = new JLabel("Number of Participants:");
		lblNumberOfParticipants.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNumberOfParticipants.setForeground(Color.ORANGE);
		lblNumberOfParticipants.setBounds(271, 301, 405, 43);
		frame.getContentPane().add(lblNumberOfParticipants);
		
		JLabel lblStrategyToDetermine = new JLabel("Strategy to Determine Winner:");
		lblStrategyToDetermine.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblStrategyToDetermine.setForeground(Color.ORANGE);
		lblStrategyToDetermine.setBounds(271, 430, 515, 43);
		frame.getContentPane().add(lblStrategyToDetermine);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblNewLabel.setText(getStrategyDisplayName(strategy));
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(790, 430, 723, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel_1.setText(tournamentName);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(618, 176, 768, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		label.setText(Integer.toString(numParticipants));
		label.setForeground(Color.WHITE);
		label.setBounds(688, 301, 603, 36);
		frame.getContentPane().add(label);
		
		JLabel lblIfTheInformation = new JLabel("If the information is correct, click Next. ");
		lblIfTheInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfTheInformation.setForeground(Color.ORANGE);
		lblIfTheInformation.setBounds(271, 558, 710, 36);
		frame.getContentPane().add(lblIfTheInformation);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		nextListener = new NextButton();
		btnNext.addActionListener(nextListener);
		btnNext.setBounds(1115, 551, 154, 43);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		backListener = new BackButton();
		btnBack.addActionListener(backListener);
		btnBack.setBounds(1115, 599, 154, 43);
		frame.getContentPane().add(btnBack);
		
		JLabel lblIfYouWant = new JLabel("If you want to edit the information, click Back.");
		lblIfYouWant.setForeground(Color.ORANGE);
		lblIfYouWant.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfYouWant.setBounds(271, 606, 793, 36);
		frame.getContentPane().add(lblIfYouWant);
		
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
	
	private String getStrategyDisplayName(TournamentWinnerStrategy strategy) {
		String strategyDisplayName = "";
		if (strategy.getName().equals("Random Winner")) {
			strategyDisplayName = strategy.getName();
		}
		else {
			strategyDisplayName = "Greatest " + strategy.getName();
		}
		return strategyDisplayName;
	}
	
	/**
 	 * This method is used to create a tournament given the information the user has entered
 	 * @param
 	 * @return
 	 */
 	private Tournament createTournament() {
 			Tournament newTournament = new Tournament(tournamentName, numParticipants, strategy);
 			return newTournament;
 	}
	
	class NextButton extends JFrame implements ActionListener {
		
		public NextButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			Tournament tournament = createTournament();
			
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTeamWindow createNewTeamWindow = new GUICreateNewTeamWindow(tournament);
						createNewTeamWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
	
	class BackButton extends JFrame implements ActionListener {
		
		public BackButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			//go back to create-a-tournament window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTournamentWindow window = new GUICreateNewTournamentWindow();
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