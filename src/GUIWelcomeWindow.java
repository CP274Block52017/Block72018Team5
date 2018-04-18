<<<<<<< HEAD
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
	
	public class GUIWelcomeWindow extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JFrame frame;
		private boolean hasBeenClicked;
		private ActionListener yesListener;
		private ActionListener noListener;
		private static final int FRAME_WIDTH = 1500;
		private static final int FRAME_HEIGHT = 1500;
		
		public GUIWelcomeWindow() throws IOException {
			initialize();
			setSize(FRAME_WIDTH, FRAME_HEIGHT);	
			openGUIWindow();
		}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() throws IOException {
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Tournament Generator");
		lblWelcomeToThe.setFont(new Font("Al Bayan", Font.PLAIN, 50));
		lblWelcomeToThe.setForeground(Color.ORANGE);
		lblWelcomeToThe.setBounds(277, 178, 930, 52);
		frame.getContentPane().add(lblWelcomeToThe);
		
		JLabel lblCreatedByNicole = new JLabel("Created by: Nicole Woch, Kelli Sullivan, and Emma Blair");
		lblCreatedByNicole.setFont(new Font("Al Nile", Font.ITALIC, 25));
		lblCreatedByNicole.setForeground(Color.ORANGE);
		lblCreatedByNicole.setBounds(400, 266, 668, 35);
		frame.getContentPane().add(lblCreatedByNicole);
		
		JLabel lblWouldYouLike = new JLabel("Would you like to create a tournament?");
		lblWouldYouLike.setFont(new Font("Al Nile", Font.PLAIN, 30));
		lblWouldYouLike.setForeground(Color.ORANGE);
		lblWouldYouLike.setBackground(Color.ORANGE);
		lblWouldYouLike.setBounds(435, 600, 563, 52);
		frame.getContentPane().add(lblWouldYouLike);
		
		JButton btnYes = new JButton("Yes");
		yesListener = new YesButton();
		btnYes.addActionListener(yesListener);
		btnYes.setBounds(517, 666, 142, 52);
		frame.getContentPane().add(btnYes);
		
		JButton btnNo = new JButton("No");
		noListener = new NoButton();
		btnNo.addActionListener(noListener);
		btnNo.setBounds(747, 666, 142, 52);
		frame.getContentPane().add(btnNo);
		
		JLabel lblChooseATournament = new JLabel("Choose a Tournament Master to create a tournament that includes");
		lblChooseATournament.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblChooseATournament.setForeground(Color.WHITE);
		lblChooseATournament.setBounds(313, 364, 811, 35);
		frame.getContentPane().add(lblChooseATournament);
		
		JLabel lblHowToPlay = new JLabel("How To Play:");
		lblHowToPlay.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblHowToPlay.setForeground(Color.WHITE);
		lblHowToPlay.setBounds(624, 311, 171, 41);
		frame.getContentPane().add(lblHowToPlay);
		
		JLabel label = new JLabel("2, 4, or 8 friends to be the participants in the tournament");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label.setForeground(Color.WHITE);
		label.setBounds(343, 411, 756, 28);
		frame.getContentPane().add(label);
		
		JLabel lblAndEachCreate = new JLabel("and each create a customized team of Colorado College athletes");
		lblAndEachCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblAndEachCreate.setForeground(Color.WHITE);
		lblAndEachCreate.setBounds(323, 451, 782, 35);
		frame.getContentPane().add(lblAndEachCreate);
		
		JLabel lblToCompeteAgainst = new JLabel("based on their statistics to compete against each other. The");
		lblToCompeteAgainst.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblToCompeteAgainst.setForeground(Color.WHITE);
		lblToCompeteAgainst.setBounds(332, 498, 736, 29);
		frame.getContentPane().add(lblToCompeteAgainst);
		
		JLabel lblWillDecideThe = new JLabel("Tournament Master will decide the strategy used to determine the winner.");
		lblWillDecideThe.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblWillDecideThe.setForeground(Color.WHITE);
		lblWillDecideThe.setBounds(252, 539, 903, 28);
		frame.getContentPane().add(lblWillDecideThe);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(24, 583, 205, 194);
		frame.getContentPane().add(lblNewLabel);
		
		String logoFile = "Logo.jpg";
	    File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(25, 155, 300, 1200);
	    frame.getContentPane().add(graphic);
	    
	    String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	}
		
	/**
	 * Opens GUI window
	 */
	private void openGUIWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	private class YesButton extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;

		public YesButton() {
			hasBeenClicked = false;
		}
	
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTournamentWindow createTournamentWindow = new GUICreateNewTournamentWindow();
						createTournamentWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
			hasBeenClicked = true;
		}
	}
	
	private class NoButton extends JFrame implements ActionListener {
	
		private static final long serialVersionUID = 1L;

		public NoButton() {
			hasBeenClicked = false;
		}
	
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
			hasBeenClicked = false;
		}
	}

}



=======
import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.io.File;
import java.io.IOException;
import java.awt.Font;
	/**
	 * This method produces our first frame of our tournament 
	 * It welcomes the user to the game and asks if they would like to start
	 * a new tournament if they do they get to start the tournament.
	 * If they choose to not create a new tournaemnt it exists the window
	 * @author Kelli
	 * @author Emma
	 * @author Nicole
	 *
	 */
	public class GUIWelcomeWindow extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private JFrame frame;
		private ActionListener yesListener;
		private ActionListener noListener;
		private static final int FRAME_WIDTH = 1500;
		private static final int FRAME_HEIGHT = 1500;
		
		/**
		 * Constructor that calls the method to initialize
		 * the GUI and then sets the frame size and opens the starting GUI window
		 * @throws IOException - in case the file isn't stored properly it will
		 * let the user know they need the correct files to run the database and 
		 * correct JFrame images
		 */
		public GUIWelcomeWindow() throws IOException {
			initialize();
			setSize(FRAME_WIDTH, FRAME_HEIGHT);	
			openGUIWindow();
		}
	
	/**
	 * Initialize the contents of the frame.
	 * Consists of both of our images and all the text information
	 * in regards to the tournament and allows for two buttons.
	 * One to continue on into the tournament game and the other to 
	 * exit the the software program.
	 * @throws IOException - allows user to know if the file they want
	 * read in isn't working this shouldn't be an issue since we aren't
	 * getting user input for this
	 */
	private void initialize() throws IOException {
		//sets up frame
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.WHITE);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.setBounds(100, 100, 1500, 1000);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//label that welcomes the user
		JLabel lblWelcomeToThe = new JLabel("Welcome to the Tournament Generator");
		lblWelcomeToThe.setFont(new Font("Al Bayan", Font.PLAIN, 50));
		lblWelcomeToThe.setForeground(Color.ORANGE);
		lblWelcomeToThe.setBounds(277, 178, 930, 52);
		frame.getContentPane().add(lblWelcomeToThe);
		
		//label that states the creaters
		JLabel lblCreatedByNicole = new JLabel("Created by: Nicole Woch, Kelli Sullivan, and Emma Blair");
		lblCreatedByNicole.setFont(new Font("Al Nile", Font.ITALIC, 25));
		lblCreatedByNicole.setForeground(Color.ORANGE);
		lblCreatedByNicole.setBounds(400, 266, 668, 35);
		frame.getContentPane().add(lblCreatedByNicole);
		
		//asks if the user wants to create a tournament
		JLabel lblWouldYouLike = new JLabel("Would you like to create a tournament?");
		lblWouldYouLike.setFont(new Font("Al Nile", Font.PLAIN, 30));
		lblWouldYouLike.setForeground(Color.ORANGE);
		lblWouldYouLike.setBackground(Color.ORANGE);
		lblWouldYouLike.setBounds(435, 600, 563, 52);
		frame.getContentPane().add(lblWouldYouLike);
		
		//yes button
		JButton btnYes = new JButton("Yes");
		yesListener = new YesButton();
		btnYes.addActionListener(yesListener);
		btnYes.setBounds(517, 666, 142, 52);
		frame.getContentPane().add(btnYes);
		
		//no button
		JButton btnNo = new JButton("No");
		noListener = new NoButton();
		btnNo.addActionListener(noListener);
		btnNo.setBounds(747, 666, 142, 52);
		frame.getContentPane().add(btnNo);
		
		//information about how to create tournament
		JLabel lblChooseATournament = new JLabel("Choose a Tournament Master to create a tournament that includes");
		lblChooseATournament.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblChooseATournament.setForeground(Color.WHITE);
		lblChooseATournament.setBounds(313, 364, 811, 35);
		frame.getContentPane().add(lblChooseATournament);
		
		//information about how to create tournament
		JLabel lblHowToPlay = new JLabel("How To Play:");
		lblHowToPlay.setFont(new Font("Lucida Grande", Font.PLAIN, 27));
		lblHowToPlay.setForeground(Color.WHITE);
		lblHowToPlay.setBounds(624, 311, 171, 41);
		frame.getContentPane().add(lblHowToPlay);
		
		//information about how to create tournament
		JLabel label = new JLabel("2, 4, or 8 friends to be the participants in the tournament");
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		label.setForeground(Color.WHITE);
		label.setBounds(343, 411, 756, 28);
		frame.getContentPane().add(label);
		
		//information about how to create tournament
		JLabel lblAndEachCreate = new JLabel("and each create a customized team of Colorado College athletes");
		lblAndEachCreate.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblAndEachCreate.setForeground(Color.WHITE);
		lblAndEachCreate.setBounds(323, 451, 782, 35);
		frame.getContentPane().add(lblAndEachCreate);
		
		//information about how to create tournament
		JLabel lblToCompeteAgainst = new JLabel("based on their statistics to compete against each other. The");
		lblToCompeteAgainst.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblToCompeteAgainst.setForeground(Color.WHITE);
		lblToCompeteAgainst.setBounds(332, 498, 736, 29);
		
		frame.getContentPane().add(lblToCompeteAgainst);
		//information about how to create tournament
		JLabel lblWillDecideThe = new JLabel("Tournament Master will decide the strategy used to determine the winner.");
		lblWillDecideThe.setFont(new Font("Lucida Grande", Font.PLAIN, 25));
		lblWillDecideThe.setForeground(Color.WHITE);
		lblWillDecideThe.setBounds(252, 539, 903, 28);
		frame.getContentPane().add(lblWillDecideThe);
		
		//produces the CC logo for the bottom left corner of the frame
		String logoFile = "Logo.jpg";
	    File logo_file = new File(logoFile);
	    BufferedImage CC_logo = ImageIO.read(logo_file);
	    JLabel graphic = new JLabel(new ImageIcon(CC_logo));
	    graphic.setBounds(25, 155, 300, 1200);
	    frame.getContentPane().add(graphic);
	    
	    //produces the top bar graphic for the frame
	    String topBar = "TopLine.jpg";
	    File topbar_file = new File(topBar);
	    BufferedImage top_bar = ImageIO.read(topbar_file);
	    JLabel top_graphic = new JLabel(new ImageIcon(top_bar));
	    top_graphic.setBounds(100, 0, 1200, 100);
	    frame.getContentPane().add(top_graphic);
	}
		
	/**
	 * Opens GUI window by setting the frame we created to
	 * be visible
	 */
	private void openGUIWindow() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "Yes" is pressed
	 * in our Welcome Window JFrame
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
	private class YesButton extends JFrame implements ActionListener {
		
		private static final long serialVersionUID = 1L;
		
		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
		public YesButton() {
		}
		
		/**
		 * If the yes button is clicked then this method uses that action
		 * to try and create a new tournament window and set it visible
		 * so that the user can now see the next visible. In addition
		 * this will close out the previous frame as it is no longer in use.
		 */
		public void actionPerformed(ActionEvent e) {
			frame.setVisible(false);
			//open next window
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTournamentWindow createTournamentWindow = new GUICreateNewTournamentWindow();
						createTournamentWindow.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}
	/**
	 * Class that extends JFrame and implements the ActionListener
	 * to produce actions when the JButton denoting "No" is pressed
	 * in our Welcome Window JFrame
	 *@author Kelli
	 *@author Emma
	 *@author Nicole
	 */
	private class NoButton extends JFrame implements ActionListener {
	
		private static final long serialVersionUID = 1L;

		/**
		 * Constructor that stores the boolean
		 * that the button has not been clicked
		 */
		public NoButton() {
		}
	
		/**
		 * If the no button is clicked then this method
		 * will exit the program
		 */
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
		}
	}

}
>>>>>>> refs/remotes/origin/Kelli's_Branch
