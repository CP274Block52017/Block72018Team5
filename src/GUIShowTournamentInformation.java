import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
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
	 */
	public GUIShowTournamentInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTournamentInformation = new JLabel("Tournament Information!");
		lblTournamentInformation.setForeground(Color.ORANGE);
		lblTournamentInformation.setBounds(898, 25, 175, 36);
		frame.getContentPane().add(lblTournamentInformation);
		
		JLabel lblTournamentName = new JLabel("Tournament Name:");
		lblTournamentName.setForeground(Color.ORANGE);
		lblTournamentName.setBounds(898, 111, 133, 16);
		frame.getContentPane().add(lblTournamentName);
		
		JLabel lblNumberOfParticipants = new JLabel("Number of Participants:");
		lblNumberOfParticipants.setForeground(Color.ORANGE);
		lblNumberOfParticipants.setBounds(901, 196, 172, 16);
		frame.getContentPane().add(lblNumberOfParticipants);
		
		JLabel lblStrategyToDetermine = new JLabel("Strategy to Determine Winner:");
		lblStrategyToDetermine.setForeground(Color.ORANGE);
		lblStrategyToDetermine.setBounds(898, 284, 206, 16);
		frame.getContentPane().add(lblStrategyToDetermine);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setText(GUICreateNewTournament.getTournamentName());
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(1138, 284, 317, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(GUICreateNewTournament.getParticipantNumber());
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(1088, 111, 292, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel("");
		label.setText(GUICreateNewTournament.getStrategy());
		label.setForeground(Color.WHITE);
		label.setBounds(1088, 196, 292, 16);
		frame.getContentPane().add(label);
		
		JLabel lblIfTheInformation = new JLabel("If the information is correct, press next, if you want to edit the information, press back!");
		lblIfTheInformation.setForeground(Color.ORANGE);
		lblIfTheInformation.setBounds(873, 388, 582, 16);
		frame.getContentPane().add(lblIfTheInformation);
		
		JButton btnNext = new JButton("Next");
		nextListener = new NextButton();
		btnNext.addActionListener(nextListener);
		btnNext.setBounds(914, 472, 117, 29);
		frame.getContentPane().add(btnNext);
		
		JButton btnBack = new JButton("Back");
		backListener = new BackButton();
		btnBack.addActionListener(backListener);
		btnBack.setBounds(1137, 472, 117, 29);
		frame.getContentPane().add(btnBack);
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
						GUICreateNewTournament window = new GUICreateNewTournament();
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
