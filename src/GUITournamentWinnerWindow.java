import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class GUITournamentWinnerWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private ActionListener exitListener;
	private ActionListener playListener;
	private boolean hasBeenClicked;

	/**
	 * Create the application.
	 */
	public GUITournamentWinnerWindow() {
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
		
		JLabel lblTheTournamentIs = new JLabel("The Tournament is over!");
		lblTheTournamentIs.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblTheTournamentIs.setForeground(Color.ORANGE);
		lblTheTournamentIs.setBounds(452, 169, 546, 41);
		frame.getContentPane().add(lblTheTournamentIs);
		
		JLabel lblTheWinnerIs = new JLabel("The WINNER is...");
		lblTheWinnerIs.setForeground(Color.ORANGE);
		lblTheWinnerIs.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblTheWinnerIs.setBounds(534, 258, 374, 41);
		frame.getContentPane().add(lblTheWinnerIs);
		
		JLabel label = new JLabel("");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 50));
		label.setForeground(Color.WHITE);
		label.setBounds(415, 340, 607, 59);
		frame.getContentPane().add(label);
		
		JLabel lblCongratulations = new JLabel("Congratulations!");
		lblCongratulations.setForeground(Color.ORANGE);
		lblCongratulations.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblCongratulations.setBounds(534, 450, 374, 54);
		frame.getContentPane().add(lblCongratulations);
		
		JLabel lblIfYouWould = new JLabel("If you would like to create another tournmant, press Play Again!");
		lblIfYouWould.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblIfYouWould.setForeground(Color.ORANGE);
		lblIfYouWould.setBounds(333, 573, 1087, 41);
		frame.getContentPane().add(lblIfYouWould);
		
		JLabel lblPressExitTo = new JLabel("Press Exit to leave the program. Thanks for playing!");
		lblPressExitTo.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblPressExitTo.setForeground(Color.ORANGE);
		lblPressExitTo.setBounds(401, 628, 636, 35);
		frame.getContentPane().add(lblPressExitTo);
		
		JButton btnPlayAgain = new JButton("Play Again!");
		playListener = new PlayButton();
		btnPlayAgain.addActionListener(playListener);
		btnPlayAgain.setBounds(469, 689, 143, 54);
		frame.getContentPane().add(btnPlayAgain);
		
		JButton btnExit = new JButton("Exit");
		exitListener = new ExitButton();
		btnExit.addActionListener(exitListener);
		btnExit.setBounds(825, 689, 143, 54);
		frame.getContentPane().add(btnExit);
	}
	
	class PlayButton extends JFrame implements ActionListener {
		
		public PlayButton() {
			
		}
		
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUIWelcomeWindow welcome = new GUIWelcomeWindow();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = false;
		}
	}
	
	class ExitButton extends JFrame implements ActionListener {
			
			public ExitButton() {
				
			}
			
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				System.exit(1);
				hasBeenClicked = false;
			}
		}
}
