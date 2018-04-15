import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class StartMenuAttempt extends JFrame{
	
	private JPanel controlPanel;
	private String prompt;
	
	public StartMenuAttempt(){
		setTitle("Begin");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 422);
		controlPanel = new JPanel();
		controlPanel.setBackground(new Color(0, 0, 0));
		controlPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		controlPanel.setLayout(new BorderLayout(0, 0));
		controlPanel.add(createLabel(), BorderLayout.NORTH);
		controlPanel.add(createYesButton(), BorderLayout.WEST);
		controlPanel.add(createNoButton(), BorderLayout.EAST);
		setContentPane(controlPanel);
	}
	
	public JLabel createLabel(){
		JLabel label = new JLabel("Would you like to start a new tournament?");
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setPreferredSize(new Dimension(445, 60));
		label.setMinimumSize(new Dimension(445, 60));
		label.setMaximumSize(new Dimension(445, 60));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}
	
	public JButton createYesButton() {
		JButton button = new JButton("Yes");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				GetTournamentName frame = new GetTournamentName();
				frame.setVisible(true);
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setPreferredSize(new Dimension(100, 35));
		return button;
	}
	
	public JButton createNoButton() {
		JButton button = new JButton("No");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PickStrategy frame = new PickStrategy();
				frame.setVisible(true);
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setPreferredSize(new Dimension(100, 35));
		return button;
	}	
}
