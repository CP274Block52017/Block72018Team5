import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;



public class GetTournamentName extends JFrame{
	
	private JPanel controlPanel;

	public GetTournamentName(){
		setTitle("Tournament Info");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 422);
		controlPanel = new JPanel();
		controlPanel.setBackground(new Color(0, 0, 0));
		controlPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		controlPanel.setLayout(new BorderLayout(0, 0));
		controlPanel.setLayout(new BorderLayout());
		controlPanel.add(createLabel(), BorderLayout.NORTH);
		controlPanel.add(createTextField(), BorderLayout.CENTER);
		controlPanel.add(createButton(), BorderLayout.SOUTH);
		setContentPane(controlPanel);
	}
	

	public JLabel createLabel() {
		JLabel label = new JLabel("What would you like to name your tournament?");
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setPreferredSize(new Dimension(445, 100));
		label.setBackground(Color.BLACK);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}

	
	public JTextField createTextField() {
		JTextField textField = new JTextField();
		textField.setPreferredSize(new Dimension(445, 60));
		textField.setMaximumSize(new Dimension(445, 60));
		textField.setFont(new Font("Verdana", Font.PLAIN, 20));
		textField.setBackground(Color.BLACK);
		textField.setForeground(Color.WHITE);
		textField.setAlignmentX(Component.CENTER_ALIGNMENT);
		return textField;
	}
	public JButton createButton() {
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				NumberofParticipants frame = new NumberofParticipants();
				frame.setVisible(true);
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		button.setBackground(SystemColor.desktop);
		button.setForeground(Color.WHITE);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setPreferredSize(new Dimension(50, 35));
		return button;
	}	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GetTournamentName frame = new GetTournamentName();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
