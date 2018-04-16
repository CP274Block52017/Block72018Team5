import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Scrollbar;
import java.awt.Choice;
import java.awt.Button;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreateTeam {

	private JFrame frame;
	private JTextField textField;
	private static String teamName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateTeam window = new CreateTeam();
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
	public CreateTeam() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBackground(Color.BLACK);
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateTeam = new JLabel("Create Team");
		lblCreateTeam.setForeground(Color.WHITE);
		lblCreateTeam.setBounds(182, 16, 87, 16);
		frame.getContentPane().add(lblCreateTeam);
		
		JLabel lblMember = new JLabel("Athlete 1:");
		lblMember.setForeground(Color.ORANGE);
		lblMember.setBounds(49, 76, 61, 16);
		frame.getContentPane().add(lblMember);
		
		JLabel lblMember_1 = new JLabel("Athlete 2:");
		lblMember_1.setForeground(Color.ORANGE);
		lblMember_1.setBounds(49, 140, 70, 16);
		frame.getContentPane().add(lblMember_1);
		
		JLabel lblMember_2 = new JLabel("Athlete 3:");
		lblMember_2.setForeground(Color.ORANGE);
		lblMember_2.setBounds(49, 211, 70, 16);
		frame.getContentPane().add(lblMember_2);
		
		JLabel lblAthlete = new JLabel("Athlete 4:");
		lblAthlete.setForeground(Color.ORANGE);
		lblAthlete.setBounds(244, 107, 70, 16);
		frame.getContentPane().add(lblAthlete);
		
		JLabel lblAthlete_1 = new JLabel("Athlete 5:");
		lblAthlete_1.setForeground(Color.ORANGE);
		lblAthlete_1.setBounds(244, 177, 61, 16);
		frame.getContentPane().add(lblAthlete_1);
		
		Choice choice = new Choice();
		choice.setBounds(116, 76, 115, 27);
		frame.getContentPane().add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.setBounds(125, 140, 106, 27);
		frame.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.setBounds(119, 211, 112, 27);
		frame.getContentPane().add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.setBounds(312, 107, 106, 27);
		frame.getContentPane().add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.setBounds(311, 177, 106, 27);
		frame.getContentPane().add(choice_4);
		
		Button button = new Button("Submit Team");
		button.setBounds(312, 239, 117, 29);
		frame.getContentPane().add(button);
		
		JLabel lblTeamName = new JLabel("Team name:");
		lblTeamName.setForeground(Color.ORANGE);
		lblTeamName.setBounds(116, 44, 87, 16);
		frame.getContentPane().add(lblTeamName);
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teamName = textField.getText();
			}
		});
		textField.setBounds(216, 39, 130, 26);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
	
	public static String getTeamName() {
		return teamName;
	}
	
}
