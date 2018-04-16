import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

//import WelcomeSign.StartButton;

public class StartMenuAttempt extends JFrame{
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JButton yesButton;
	private JButton noButton;
	private JLabel label;
	private ActionListener yesListener;
	private ActionListener noListener;
	private String prompt;
	private static boolean hasBeenClicked;
	private static boolean yesHasBeenCLicked;
	
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1500;
	
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
		noListener = new NoButton();
		noButton.addActionListener(noListener);
		label = new JLabel(prompt);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(label);
		panel.add(yesButton, BorderLayout.WEST);
		panel.add(noButton, BorderLayout.EAST);
		add(panel);
	}
	
	public static boolean getClick() {
		return hasBeenClicked;
	}


class YesButton extends JFrame implements ActionListener {
		
		
		public YesButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			JFrame frame = new CreateTournamentGUI("Time to create your team!");
			frame.setBackground(Color.black);
			frame.setTitle("Colorado College Athletes Tournament Generator");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
			hasBeenClicked = true;
		}
}

class NoButton extends JFrame implements ActionListener {
	
	
	public NoButton() {
		hasBeenClicked = false;
	}

	public void actionPerformed(ActionEvent e) {
		JFrame frame = new WelcomeSign("Welcome to the Tournament Generator!");
		frame.setBackground(Color.black);
		frame.setTitle("Colorado College Athletes Tournament Generator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		hasBeenClicked = true;
	}
	
}
}

