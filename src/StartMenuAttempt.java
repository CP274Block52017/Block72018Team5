import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class StartMenuAttempt extends JFrame{
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JButton yesButton;
	private JButton noButton;
	private JLabel label;
	private ActionListener yesListener;
	private String prompt;
	private boolean hasBeenClicked;
	
	private static final int FRAME_WIDTH = 500;
	private static final int FRAME_HEIGHT = 500;
	
	private static final int FIELD_WIDTH = 310;
	private static final int FIELD_HEIGHT = 10;
	
	
	public StartMenuAttempt(String prompt){
		this.prompt = prompt;
		createComponenets();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);	
	}
	
	private void createComponenets() {
		yesButton = new JButton("Yes!");
		yesListener = new YesButton();
		yesButton.addActionListener(yesListener);
		noButton = new JButton("No!");
		label = new JLabel(prompt);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(label);
		panel.add(yesButton, BorderLayout.WEST);
		panel.add(noButton, BorderLayout.EAST);
		add(panel);
	}

class YesButton extends JFrame implements ActionListener {
		
		
		public YesButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			JFrame frame = new GetTournamentInfo("What would you like the name of your tournament to be?");
			frame.setBackground(Color.black);
			frame.setTitle("Start Menu");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}
	
}
