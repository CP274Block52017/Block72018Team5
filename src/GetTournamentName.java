import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GetTournamentName extends JFrame{


	private JLabel startLabel;
	private JTextField nameTextField;
	private JButton continueButton;
	private JLabel label;
	private ActionListener buttonListener;
	private ActionListener textListener;
	private ActionListener choiceListener;
	private String prompt;
	private boolean hasBeenClicked;
	private JComboBox participantsComboBox;
	
	private static final int START_FRAME_WIDTH = 500;
	private static final int START_FRAME_HEIGHT = 500;
	
	private static final int TEXT_FIELD_WIDTH = 10;
	
	
	public GetTournamentName(String prompt){
		this.prompt = prompt;
		
		choiceListener = new ChoiceListener();
		textListener = new TextListener();
		buttonListener = new ContinueListener();
		
		JPanel comboPanel = createComboBox();
		JPanel namePanel = createTournamentTextField();
		createContinueButton();
		createPanel();
		
		setSize(START_FRAME_WIDTH, START_FRAME_HEIGHT);	
	}
	

	public JPanel createComboBox() {
		startLabel = new JLabel("How many participants do you want?");
		participantsComboBox = new JComboBox();
		participantsComboBox.addItem(2);
		participantsComboBox.addItem(4);
		participantsComboBox.addItem(8);
		participantsComboBox.addItem(16);
		participantsComboBox.addActionListener(choiceListener);
		JPanel panel = new JPanel();
		panel.add(startLabel);
		panel.add(participantsComboBox);
		return panel;
	}
	
	public JPanel createTournamentTextField() {
		startLabel = new JLabel("What is the name of the tournament?");
		nameTextField = new JTextField(TEXT_FIELD_WIDTH);
		JPanel panel = new JPanel();
		panel.add(startLabel);
		panel.add(nameTextField);
		return panel;
	}
	public void createContinueButton() {
		continueButton = new JButton("Next");
		buttonListener = new ContinueListener();
		continueButton.addActionListener(buttonListener);
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

class ContinueListener extends JFrame implements ActionListener {
		
		
		public ContinueListener() {
			hasBeenClicked = false;
		}

		public void actionPerformed(ActionEvent e) {
			System.out.println("Continue button pressed");
		}
	}


class TextListener extends JFrame implements ActionListener{
	
	public TextListener() {
		hasBeenClicked = false;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println();
	}
}

class ChoiceListener extends JFrame implements ActionListener {
	
	
	public ChoiceListener() {
		hasBeenClicked = false;
	}

	public void actionPerformed(ActionEvent e) {
		System.out.println("Choice picked");
	}
}
	
}
