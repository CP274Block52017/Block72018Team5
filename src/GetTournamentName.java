import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


public class GetTournamentName extends JFrame{


	private JLabel startLabel;
	private JTextField nameTextField;
	private JButton continueButton;
	private JLabel label;
	private ActionListener nameListener;
	private String prompt;
	private boolean hasBeenClicked;
	
	private static final int START_FRAME_WIDTH = 500;
	private static final int START_FRAME_HEIGHT = 500;
	
	private static final int START_FIELD_WIDTH = 10;
	
	
	public GetTournamentName(String prompt){
		this.prompt = prompt;
		
		createTextField();
		createButton();
		createPanel();
		
		setSize(START_FRAME_WIDTH, START_FRAME_HEIGHT);	
	}
	
	public void createTextField() {
		startLabel = new JLabel("Who is creating a tournament today?");
		nameTextField = new JTextField(START_FIELD_WIDTH);
	}
	public void createButton() {
		continueButton = new JButton("Next");
		nameListener = new StartButton();
		continueButton.addActionListener(nameListener);
	}

	public boolean getClick() {
		return hasBeenClicked;
	}
	
	private void createPanel() {
		label = new JLabel(prompt);
		JPanel panel = new JPanel();
		panel.setLayout(new BorderLayout());
		panel.add(label, BorderLayout.BEFORE_FIRST_LINE);
		panel.add(nameTextField, BorderLayout.CENTER);
		panel.add(continueButton, BorderLayout.SOUTH);
		add(panel);
	}

class StartButton extends JFrame implements ActionListener {
		
		
		public StartButton() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			JFrame frame = new ParticipantChooser();
			frame.setBackground(Color.black);
			frame.setTitle("Start Menu");
			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.setVisible(true);
		}
	}
	
}
