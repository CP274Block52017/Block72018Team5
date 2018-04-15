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

public class PickStrategy extends JFrame {

	private JPanel contentPanel;


	/**
	 * Create the frame.
	 */
	public PickStrategy() {
		setTitle("Tournament Info");
		setBackground(Color.BLACK);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 422);
		contentPanel = new JPanel();
		contentPanel.setBackground(new Color(0, 0, 0));
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		contentPanel.add(createLabel(), BorderLayout.NORTH);
		contentPanel.add(createComboBox(), BorderLayout.CENTER);
		contentPanel.add(createButton(), BorderLayout.SOUTH);
		setContentPane(contentPanel);
	}
	
	public JLabel createLabel(){
		JLabel label = new JLabel("What strategy would you like to use to determine the winner?");
		label.setFont(new Font("Verdana", Font.PLAIN, 20));
		label.setPreferredSize(new Dimension(445, 60));
		label.setMinimumSize(new Dimension(445, 60));
		label.setMaximumSize(new Dimension(445, 60));
		label.setBackground(Color.BLACK);
		label.setForeground(new Color(255, 255, 0));
		label.setAlignmentX(Component.CENTER_ALIGNMENT);
		return label;
	}
	
	public JButton createButton() {
		JButton button = new JButton("Next");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setFont(new Font("Verdana", Font.BOLD | Font.ITALIC, 20));
		button.setBackground(SystemColor.desktop);
		button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setPreferredSize(new Dimension(50, 35));
		return button;
	}


	private JComboBox createComboBox() {
		JComboBox comboBox = new JComboBox();
		comboBox.setPreferredSize(new Dimension(11, 13));
		comboBox.addItem("Random Winner");
		comboBox.addItem("By Height");
		comboBox.addItem("By Age");
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				
			}
		});
		comboBox.setFont(new Font("Verdana", Font.PLAIN, 18));
		comboBox.setForeground(SystemColor.scrollbar);
		comboBox.setBackground(UIManager.getColor("CheckBox.background"));
		return comboBox;
	}


	
}
