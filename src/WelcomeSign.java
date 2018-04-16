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
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;


public class WelcomeSign extends JFrame{


	private JPanel contentPanel;
	private String prompt;
	
	public WelcomeSign(String prompt){
		this.prompt = prompt;
		setTitle("Start Menu");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 422);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(createLabel(), BorderLayout.NORTH);
		contentPanel.add(createButton(), BorderLayout.CENTER);
		setContentPane(contentPanel);
	}

	public JButton createButton() {
		JButton button = new JButton("Start");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				StartMenuAttempt frame = new StartMenuAttempt();
				frame.setVisible(true);
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		button.setBackground(Color.BLACK);
		button.setForeground(Color.WHITE);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setPreferredSize(new Dimension(50, 35));
		return button;
	}
	
	public JLabel createLabel(){
		JLabel label = new JLabel(prompt);
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setPreferredSize(new Dimension(445, 60));
		label.setMinimumSize(new Dimension(445, 60));
		label.setMaximumSize(new Dimension(445, 60));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}	
}
