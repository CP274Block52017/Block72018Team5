import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateTournamentGUI extends JFrame {
	private JLabel rateLabel;
	private JTextField rateField;
	private JButton button;
	private JButton continueButton;
	private JButton noButton;
	private JLabel label;
	private ActionListener yesListener;
	private ActionListener noListener;
	private String prompt;
	private static boolean hasBeenClicked;
	
	private static final int FRAME_WIDTH = 1000;
	private static final int FRAME_HEIGHT = 1500;
	
	private static final int FIELD_WIDTH = 310;
	private static final int FIELD_HEIGHT = 10;
	
	
	public CreateTournamentGUI(String prompt){
		this.prompt = prompt;
		createComponenets();
		setSize(FRAME_WIDTH, FRAME_HEIGHT);	
	}
	
	private void createComponenets() {
		continueButton = new JButton("Continue");
		yesListener = new ContinueButton();
		continueButton.addActionListener(yesListener);
		label = new JLabel(prompt);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(label);
		panel.add(continueButton, BorderLayout.SOUTH);
		add(panel);
	}
	
	public static boolean getClick() {
		return hasBeenClicked;
	}
	
	

class ContinueButton extends JFrame implements ActionListener {
		
		
		public ContinueButton() {
			hasBeenClicked = false;
			
		}

		public void actionPerformed(ActionEvent e) {
			
			hasBeenClicked = true;
		}
}
}
