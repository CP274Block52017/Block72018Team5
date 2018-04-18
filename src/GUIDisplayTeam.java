import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;

public class GUIDisplayTeam extends JFrame {

	private static JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private static int counter;
	private static boolean hasBeenClicked;
	private ActionListener editListener;
	private ActionListener nextListener;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIDisplayTeam window = new GUIDisplayTeam();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GUIDisplayTeam() throws IOException {
		counter = 0;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		String logoFile = "Logo.jpg";
	    File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(6, 153, 300, 1200);
	    frame.getContentPane().add(graphic);
	    
	    String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	    
	    JLabel lblDoubleCheckYou = new JLabel("Double check your team!");
	    lblDoubleCheckYou.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblDoubleCheckYou.setForeground(Color.ORANGE);
	    lblDoubleCheckYou.setBounds(503, 142, 560, 62);
	    frame.getContentPane().add(lblDoubleCheckYou);
	    
	    JLabel lblTeamName = new JLabel("Team Name:");
	    lblTeamName.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblTeamName.setForeground(Color.ORANGE);
	    lblTeamName.setBounds(100, 250, 293, 54);
	    frame.getContentPane().add(lblTeamName);
	    
	    JLabel label = new JLabel("");
	    label.setText(GUICreateTeam.getTeamName());
	    label.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
	    label.setText(GUICreateTeam.getTeamName());
	    label.setForeground(Color.ORANGE);
	    label.setBounds(392, 257, 560, 48);
	    frame.getContentPane().add(label);
	    
	    JLabel lblAthletesInTeam = new JLabel("Athletes in team:");
	    lblAthletesInTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblAthletesInTeam.setForeground(Color.ORANGE);
	    lblAthletesInTeam.setBounds(100, 366, 371, 48);
	    frame.getContentPane().add(lblAthletesInTeam);
	    
	    JLabel label_1 = new JLabel("");
	    label_1.setText(GUICreateTeam.getFirstAthlete());
	    label_1.setForeground(Color.ORANGE);
	    label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_1.setBounds(503, 366, 432, 48);
	    frame.getContentPane().add(label_1);
	    
	    JLabel label_2 = new JLabel("");
	    label_2.setText(GUICreateTeam.getSecondAthlete());
	    label_2.setForeground(Color.ORANGE);
	    label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_2.setBounds(986, 366, 432, 48);
	    frame.getContentPane().add(label_2);
	    
	    JLabel label_3 = new JLabel("");
	    label_3.setText(GUICreateTeam.getThirdAthlete());
	    label_3.setForeground(Color.ORANGE);
	    label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_3.setBounds(100, 480, 432, 48);
	    frame.getContentPane().add(label_3);
	    
	    JLabel label_4 = new JLabel("");
	    label_4.setText(GUICreateTeam.getFourthAthlete());
	    label_4.setForeground(Color.ORANGE);
	    label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_4.setBounds(558, 480, 432, 48);
	    frame.getContentPane().add(label_4);
	    
	    JLabel label_5 = new JLabel("");
	    label_5.setText(GUICreateTeam.getFifthAthlete());
	    label_5.setForeground(Color.ORANGE);
	    label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_5.setBounds(1012, 480, 432, 48);
	    frame.getContentPane().add(label_5);
	    
	    JLabel lblClickEditTo = new JLabel("Click Edit to change team, click Next to continue");
	    lblClickEditTo.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
	    lblClickEditTo.setForeground(Color.ORANGE);
	    lblClickEditTo.setBounds(265, 599, 1076, 54);
	    frame.getContentPane().add(lblClickEditTo);
	    
	    JButton btnEdit = new JButton("Edit");
	    editListener = new EditButton();
	    btnEdit.addActionListener(editListener);
	    btnEdit.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    btnEdit.setBounds(518, 690, 160, 54);
	    frame.getContentPane().add(btnEdit);
	    
	    JButton btnNext = new JButton("Next");
	    nextListener = new EditButton();
	    btnNext.addActionListener(nextListener);
	    btnNext.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    btnNext.setBounds(882, 690, 160, 54);
	    frame.getContentPane().add(btnNext);
	}
	
	public static JFrame getFrame() {
		return frame;
	}
	
	class NextButton extends JFrame implements ActionListener {
			
			public NextButton() {
				hasBeenClicked = false;
			}
			
			public void actionPerformed(ActionEvent e) {
				counter = 0;
				int participantNumber = Integer.parseInt(GUICreateNewTournamentWindow.getParticipantNumber());
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							while(counter < participantNumber) {
								
								GUICreateTeam window = new GUICreateTeam();
								window.getFrame().setVisible(true);
								counter++;
							}
							GUIShowTournamentTeams window = new GUIShowTournamentTeams();
							window.getFrame().setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				hasBeenClicked = true;
			}
		}

	class EditButton extends JFrame implements ActionListener {
		
		public EditButton() {
			hasBeenClicked = false;
		}
		
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateTeam window = new GUICreateTeam();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
}
