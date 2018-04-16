import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class DisplayTeam {

	private static JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DisplayTeam window = new DisplayTeam();
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
	public DisplayTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(null);
		
		JLabel lblDisplayTeam = new JLabel("Display Teams");
		lblDisplayTeam.setForeground(Color.WHITE);
		lblDisplayTeam.setBounds(179, 25, 97, 16);
		frame.getContentPane().add(lblDisplayTeam);
		
		JLabel lblFirstTeam = new JLabel("First Team:");
		lblFirstTeam.setForeground(Color.ORANGE);
		lblFirstTeam.setBackground(Color.ORANGE);
		lblFirstTeam.setBounds(28, 66, 76, 16);
		frame.getContentPane().add(lblFirstTeam);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				lblNewLabel.setText(CreateTeam.getTeamName());
			}
		});
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(107, 66, 61, 16);
		frame.getContentPane().add(lblNewLabel);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static JFrame getFrame() {
		return frame;
	}

}
