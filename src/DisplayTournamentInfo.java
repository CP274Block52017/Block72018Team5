import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;

public class DisplayTournamentInfo extends JFrame{
	
	private JPanel contentPanel;
	private Object participants;
	
	public DisplayTournamentInfo(Object participants) {
		this.participants = participants;
		setTitle("Tournament Info");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 422);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(createLabel1(), BorderLayout.NORTH);
		contentPanel.add(createLabel2(), BorderLayout.CENTER);
		contentPanel.add(createLabel3(), BorderLayout.SOUTH);
		setContentPane(contentPanel);
	}
	
	public JLabel createLabel1(){
		JLabel label = new JLabel("Name of Tournamet: ");
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setPreferredSize(new Dimension(445, 60));
		label.setMinimumSize(new Dimension(445, 60));
		label.setMaximumSize(new Dimension(445, 60));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}
	public JLabel createLabel2(){
		JLabel label = new JLabel("Number of Participants: " + participants.toString());
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setPreferredSize(new Dimension(445, 60));
		label.setMinimumSize(new Dimension(445, 60));
		label.setMaximumSize(new Dimension(445, 60));
		label.setBackground(Color.BLACK);
		label.setForeground(Color.WHITE);
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}
	public JLabel createLabel3(){
		JLabel label = new JLabel("Tournament Strategy: ");
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
