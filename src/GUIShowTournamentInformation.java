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

public class GUIShowTournamentInformation {

	private static JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener nextListener;
	private ActionListener backListener;
	private static boolean hasBeenClicked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIShowTournamentInformation window = new GUIShowTournamentInformation();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws IOException 
	 */
	public GUIShowTournamentInformation() throws IOException {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * @throws IOException 
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
		lblTournamentInformation.setBounds(475, 63, 506, 36);
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
		lblNewLabel.setText(GUICreateNewTournamentWindow.getStrategy());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(790, 430, 723, 43);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel_1.setText(GUICreateNewTournamentWindow.getTournamentName());
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(618, 176, 768, 36);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		label.setText(GUICreateNewTournamentWindow.getParticipantNumber());
		label.setForeground(Color.WHITE);
		label.setBounds(688, 301, 603, 36);
		frame.getContentPane().add(label);
		
		JLabel lblIfTheInformation = new JLabel("If the information is correct, press Next. ");
		lblIfTheInformation.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfTheInformation.setForeground(Color.ORANGE);
		lblIfTheInformation.setBounds(271, 595, 710, 36);
		frame.getContentPane().add(lblIfTheInformation);
		
		JButton btnNext = new JButton("Next");
		btnNext.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		nextListener = new NextButton();
		btnNext.addActionListener(nextListener);
		btnNext.setBounds(1115, 588, 154, 43);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		btnBack.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		backListener = new BackButton();
		btnBack.addActionListener(backListener);
		btnBack.setBounds(1115, 661, 154, 43);
		frame.getContentPane().add(btnBack);
		
		JLabel lblIfYouWant = new JLabel("If you want to edit the information, press Back.");
		lblIfYouWant.setForeground(Color.ORANGE);
		lblIfYouWant.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblIfYouWant.setBounds(271, 668, 793, 36);
		frame.getContentPane().add(lblIfYouWant);
		
		String logoFile = "Logo.jpg";
	    File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(25, 125, 300, 1200);
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
	
class NextButton extends JFrame implements ActionListener {
		
		public NextButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {

			hasBeenClicked = true;
		}
	}
	
	class BackButton extends JFrame implements ActionListener {
		
		public BackButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
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
			hasBeenClicked = false;
		}
	}

}
