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
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class CreateTeam {

	private static JFrame frame;
	private JTextField textField;
	private static String teamName;
	private static String firstAthlete;
	private static String secondAthlete;
	private static String thirdAthlete;
	private static String fourthAthlete;
	private static String fifthAthlete;

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
		choice.add("1");
		choice.add("2");
		choice.add("3");
		choice.add("4");
		choice.add("5");
		choice.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				firstAthlete = choice.getSelectedItem();
			}
		});
		choice.setBounds(116, 76, 115, 27);
		frame.getContentPane().add(choice);
		
		Choice choice_1 = new Choice();
		choice_1.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				secondAthlete = choice_1.getSelectedItem();
			}
		});
		choice_1.add("1");
		choice_1.add("2");
		choice_1.add("3");
		choice_1.add("4");
		choice_1.add("5");
		choice_1.setBounds(125, 140, 106, 27);
		frame.getContentPane().add(choice_1);
		
		Choice choice_2 = new Choice();
		choice_2.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				thirdAthlete = choice_2.getSelectedItem();
			}
		});
		choice_2.add("1");
		choice_2.add("2");
		choice_2.add("3");
		choice_2.add("4");
		choice_2.add("5");
		choice_2.setBounds(119, 211, 112, 27);
		frame.getContentPane().add(choice_2);
		
		Choice choice_3 = new Choice();
		choice_3.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fourthAthlete = choice_3.getSelectedItem();
			}
		});
		choice_3.add("1");
		choice_3.add("2");
		choice_3.add("3");
		choice_3.add("4");
		choice_3.add("5");
		choice_3.setBounds(312, 107, 106, 27);
		frame.getContentPane().add(choice_3);
		
		Choice choice_4 = new Choice();
		choice_4.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentShown(ComponentEvent e) {
				fifthAthlete = choice_4.getSelectedItem();
			}
		});
		choice_4.add("1");
		choice_4.add("2");
		choice_4.add("3");
		choice_4.add("4");
		choice_4.add("5");
		choice_4.setBounds(311, 177, 106, 27);
		frame.getContentPane().add(choice_4);
		
		Button button = new Button("Submit Team");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							DisplayTeam window = new DisplayTeam();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
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
	
	public static JFrame getFrame() {
		return frame;
	}
	
	public static String getFirstAthlete() {
		return firstAthlete;
	}
	
	public static String getSecondAthlete() {
		return secondAthlete;
	}
	
	public static String getThirdAthlete() {
		return thirdAthlete;
	}
	
	public static String getFourthAthlete() {
		return fourthAthlete;
	}
	
	public static String getFifthAthlete() {
		return fifthAthlete;
	}
	
}
