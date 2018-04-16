import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;

import javax.swing.JButton;

public class DisplayTournamentInformation {

	private static JFrame frame;
	private ActionListener yesListener;
	private ActionListener noListener;
	private static boolean hasBeenClicked;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTournamentInformation window = new DisplayTournamentInformation();
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
	public DisplayTournamentInformation() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblTournamentName = new JLabel("Tournament Name:");
		lblTournamentName.setForeground(Color.ORANGE);
		lblTournamentName.setBounds(50, 61, 129, 16);
		frame.getContentPane().add(lblTournamentName);
		
		JLabel lblNumberOfTeams = new JLabel("Number of Teams:");
		lblNumberOfTeams.setForeground(Color.ORANGE);
		lblNumberOfTeams.setBounds(49, 112, 116, 16);
		frame.getContentPane().add(lblNumberOfTeams);
		
		JLabel lblStrategyToDetermine = new JLabel("Strategy to determine winner: ");
		lblStrategyToDetermine.setForeground(Color.ORANGE);
		lblStrategyToDetermine.setBounds(50, 162, 197, 16);
		frame.getContentPane().add(lblStrategyToDetermine);
		
		JLabel lblNewLabel = new JLabel();
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(186, 61, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(177, 112, 61, 16);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel label = new JLabel(SecondWindow.getTeamName());
		label.setForeground(Color.WHITE);
		label.setBounds(250, 162, 61, 16);
		frame.getContentPane().add(label);
		
		JLabel lblNewLabel_2 = new JLabel("Is this the correct information?");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(121, 201, 205, 16);
		frame.getContentPane().add(lblNewLabel_2);
		
		JButton btnYes = new JButton("Yes");
		yesListener = new YesButton();
		btnYes.addActionListener(yesListener);
		btnYes.setBounds(91, 229, 117, 29);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		noListener = new NoButton();
		btnNo.addActionListener(noListener);
		btnNo.setBounds(245, 229, 117, 29);
		frame.getContentPane().add(btnNo);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static boolean getClick() {
		return hasBeenClicked;
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	class YesButton extends JFrame implements ActionListener {
		
		public YesButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						CreateTeam window = new CreateTeam();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
	
	class NoButton extends JFrame implements ActionListener {
		
		public NoButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						SecondWindow window = new SecondWindow();
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
