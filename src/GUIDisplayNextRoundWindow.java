import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JButton;
/**
 * This class creates a User Interface in the form of a JFrame
 * that displayed the winners and their points of a round in 
 * the tournament. 
 * @author emmablair
 *
 */
public class GUIDisplayNextRoundWindow {

	private JFrame frame;
	private static final int FRAME_WIDTH = 1500;
	private static final int FRAME_HEIGHT = 1000;
	private boolean hasBeenClicked;
	private ActionListener nextListener;
	private ArrayList<String> teamNames;
	
	private Tournament tournament;

	/**
	 * Constructor initializes the application.
	 */
	public GUIDisplayNextRoundWindow() throws IOException {
		initialize();
	}
	
	/**
	 * Return the frame for this window.
	 * @return JFrame - this window's frame.
	 */
	public JFrame getFrame() {
		return frame;
	}

	/**
	 * Initializes the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tournament Bracket Rounds!");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 45));
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setBounds(409, 118, 646, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setText(tournament.getTeamNames().get(0));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(150, 298, 327, 48);
		frame.getContentPane().add(lblNewLabel_1);
		frame.setBounds(100, 100, FRAME_WIDTH, FRAME_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	    
	    JLabel lblNameYourTeam = new JLabel("Competing Teams:");
	    lblNameYourTeam.setFont(new Font("Lucida Grande", Font.PLAIN, 40));
	    lblNameYourTeam.setForeground(Color.ORANGE);
	    lblNameYourTeam.setBounds(531, 173, 373, 54);
	    frame.getContentPane().add(lblNameYourTeam);
	    
	    JLabel lblVs = new JLabel("VS.");
	    lblVs.setForeground(Color.ORANGE);
	    lblVs.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblVs.setBounds(288, 382, 67, 48);
	    frame.getContentPane().add(lblVs);
	    
	    JLabel label = new JLabel("");
	    label.setText(tournament.getTeamNames().get(1));
	    label.setForeground(Color.WHITE);
	    label.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label.setBounds(150, 455, 327, 48);
	    frame.getContentPane().add(label);
	    
	    //if (tournament.getMaxNumTeams() > 2) {
	    	 JLabel label_1 = new JLabel((String) null);
	 	    label_1.setText(tournament.getTeamNames().get(2));
	 	    label_1.setForeground(Color.WHITE);
	 	    label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_1.setBounds(150, 569, 327, 48);
	 	    frame.getContentPane().add(label_1);
	 	    
	 	    JLabel label_3 = new JLabel("VS.");
		    label_3.setForeground(Color.ORANGE);
		    label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_3.setBounds(288, 635, 67, 48);
		    frame.getContentPane().add(label_3);
	 	    
	 	    JLabel label_2 = new JLabel("");
	 	    label_2.setText(tournament.getTeamNames().get(3));
	 	    label_2.setForeground(Color.WHITE);
	 	    label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_2.setBounds(150, 695, 327, 48);
	 	    frame.getContentPane().add(label_2);
	   // }
	    
	    //if (tournament.getMaxNumTeams() > 4) { 
	    	JLabel label_4 = new JLabel((String) null);
	 	    label_4.setText(tournament.getTeamNames().get(4));
	 	    label_4.setForeground(Color.WHITE);
	 	    label_4.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_4.setBounds(783, 298, 327, 48);
	 	    frame.getContentPane().add(label_4);
	 	    
	 	   JLabel label_8 = new JLabel("VS.");
		    label_8.setForeground(Color.ORANGE);
		    label_8.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_8.setBounds(922, 635, 67, 48);
		    frame.getContentPane().add(label_8);
	 	    
	 	    JLabel label_5 = new JLabel((String) null);
	 	    label_5.setText(tournament.getTeamNames().get(5));
	 	    label_5.setForeground(Color.WHITE);
	 	    label_5.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	 	    label_5.setBounds(783, 455, 327, 48);
	 	    frame.getContentPane().add(label_5);
	   // }
	   
	    //if (tournament.getMaxNumTeams() > 6) { 
	    	JLabel label_6 = new JLabel((String) null);
		    label_6.setText(tournament.getTeamNames().get(6));
		    label_6.setForeground(Color.WHITE);
		    label_6.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_6.setBounds(783, 552, 327, 48);
		    frame.getContentPane().add(label_6);
		    
		    JLabel label_7 = new JLabel((String) null);
		    label_7.setText(tournament.getTeamNames().get(7));
		    label_7.setForeground(Color.WHITE);
		    label_7.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_7.setBounds(783, 695, 327, 48);
		    frame.getContentPane().add(label_7);
		    
		    JLabel label_9 = new JLabel("VS.");
		    label_9.setForeground(Color.ORANGE);
		    label_9.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
		    label_9.setBounds(922, 382, 67, 48);
		    frame.getContentPane().add(label_9);
		    
		    
		    
	   // }
	    //top left round top team points
	    JLabel lblPoints = new JLabel("Points:");
	    lblPoints.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    lblPoints.setForeground(Color.ORANGE);
	    lblPoints.setBounds(504, 301, 117, 42);
	    frame.getContentPane().add(lblPoints);
	    //
	    JLabel label_12 = new JLabel("Points:");
	    label_12.setForeground(Color.ORANGE);
	    label_12.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_12.setBounds(504, 458, 117, 42);
	    frame.getContentPane().add(label_1);
	    //top left round winner
	    JLabel lblWinner = new JLabel("Winner: ");
	    lblWinner.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    lblWinner.setForeground(Color.ORANGE);
	    lblWinner.setBounds(504, 382, 129, 42);
	    frame.getContentPane().add(lblWinner);
	    //top left top points blank
	    JLabel label_22 = new JLabel("");
	    label_22.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_22.setBounds(633, 298, 117, 40);
	    frame.getContentPane().add(label_22);
	    //top left win blank
	    JLabel label_32 = new JLabel("");
	    label_32.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_32.setBounds(633, 372, 195, 40);
	    frame.getContentPane().add(label_32);
	    //top left bottom point blank
	    JLabel label_42 = new JLabel("");
	    label_42.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_42.setBounds(633, 455, 117, 40);
	    frame.getContentPane().add(label_42);
	    //top left round points top team
	    JLabel label_10 = new JLabel("Points:");
	    label_10.setForeground(Color.ORANGE);
	    label_10.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_10.setBounds(504, 461, 117, 42);
	    frame.getContentPane().add(label_10);
	   
	    //top right round points top team
	    JLabel label_11 = new JLabel("Points:");
	    label_11.setForeground(Color.ORANGE);
	    label_11.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_11.setBounds(1120, 298, 117, 42);
	    frame.getContentPane().add(label_11);
	    //top right round bottom team points
	    JLabel label_13 = new JLabel("Points:");
	    label_13.setForeground(Color.ORANGE);
	    label_13.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_13.setBounds(1120, 455, 117, 42);
	    frame.getContentPane().add(label_13);
	    //top right round winner
	    JLabel label_19 = new JLabel("Winner: ");
	    label_19.setForeground(Color.ORANGE);
	    label_19.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_19.setBounds(1120, 372, 129, 42);
	    frame.getContentPane().add(label_19);
	    //top right bottom points blank
	    JLabel label_28 = new JLabel("");
	    label.setForeground(Color.WHITE);
	    label_28.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_28.setBounds(1259, 455, 117, 40);
	    frame.getContentPane().add(label_28);
	    //top right win blank
	    JLabel label_29 = new JLabel("");
	    label_29.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_29.setBounds(1261, 372, 171, 40);
	    frame.getContentPane().add(label_29);
	    //top right top points blank
	    JLabel label_30 = new JLabel("");
	    label_30.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_30.setBounds(1259, 298, 117, 40);
	    frame.getContentPane().add(label_30);
	    
	    //bottom right top team points 
	    JLabel label_14 = new JLabel("Points:");
	    label_14.setForeground(Color.ORANGE);
	    label_14.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_14.setBounds(1122, 552, 117, 42);
	    frame.getContentPane().add(label_14);
	    //bottom right round bottom team points
	    JLabel label_15 = new JLabel("Points:");
	    label_15.setForeground(Color.ORANGE);
	    label_15.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_15.setBounds(1120, 695, 117, 42);
	    frame.getContentPane().add(label_15);
	   
	    //bottom left round top points
	    JLabel label_16 = new JLabel("Points:");
	    label_16.setForeground(Color.ORANGE);
	    label_16.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_16.setBounds(504, 569, 117, 42);
	    frame.getContentPane().add(label_16);
	    //bottom left round bottom points
	    JLabel label_17 = new JLabel("Points:");
	    label_17.setForeground(Color.ORANGE);
	    label_17.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_17.setBounds(504, 701, 117, 42);
	    frame.getContentPane().add(label_17);
	    //bottom left round winner
	    JLabel label_20 = new JLabel("Winner: ");
	    label_20.setForeground(Color.ORANGE);
	    label_20.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_20.setBounds(1120, 622, 129, 42);
	    frame.getContentPane().add(label_20);
	    //bottom left top point blank
	    JLabel label_21 = new JLabel("");
	    label_21.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_21.setBounds(633, 577, 117, 40);
	    frame.getContentPane().add(label_21);
	    //bottom left win blank
	    JLabel label_23 = new JLabel("");
	    label_23.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_23.setBounds(633, 635, 171, 40);
	    frame.getContentPane().add(label_23);
	    //bottom left bottom points blank
	    JLabel label_24 = new JLabel("");
	    label_24.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_24.setBounds(633, 703, 117, 40);
	    frame.getContentPane().add(label_24);
	    
	    //bottom right top points blank
	    JLabel label_25 = new JLabel("");
	    label_25.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_25.setBounds(1259, 552, 117, 40);
	    frame.getContentPane().add(label_25);
	    //bottom right win blank
	    JLabel label_26 = new JLabel("");
	    label_26.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_26.setBounds(1244, 622, 171, 40);
	    frame.getContentPane().add(label_26);
	    //bottom right bottom points blank
	    JLabel label_27 = new JLabel("");
	    label_27.setFont(new Font("Lucida Grande", Font.PLAIN, 35));
	    label_27.setBounds(1259, 703, 117, 40);
	    frame.getContentPane().add(label_27);
	    //bottom right round winner
	    JLabel label_18 = new JLabel("Winner: ");
	    label_18.setForeground(Color.ORANGE);
	    label_18.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
	    label_18.setBounds(504, 635, 129, 42);
	    frame.getContentPane().add(label_18);
	    
	    JButton btnNextRound = new JButton("Next Round");
	    nextListener = new NextButton();
	    btnNextRound.addActionListener(nextListener);
	    btnNextRound.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
	    btnNextRound.setBounds(643, 239, 135, 47);
	    frame.getContentPane().add(btnNextRound);
	}
	
	/**
	 * This class allows for the next button to execute
	 * an action.
	 * @author Nicole
	 * @author Kelli
	 * @author Emma
	 *
	 */
	class NextButton extends JFrame implements ActionListener {
		
		/**
		 * Constructor is empty
		 */
		public NextButton() {
			
		}
		
		/**
		 * This method calls the next window based on if the button
		 * was pressed. It then sets the visibility to false so 
		 * that the window disappears.
		 * @param ActionEvent - the action the button performs.
		 */
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			
			hasBeenClicked = true;
		}
	}

}
