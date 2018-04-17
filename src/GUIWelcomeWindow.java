

	import javax.swing.JFrame;
	import javax.swing.JButton;
	import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
	import java.awt.event.ActionEvent;
	import javax.swing.JLabel;
	import java.awt.Font;
	
	public class GUIWelcomeWindow extends JFrame {
	
		private static final long serialVersionUID = 1L;
		private static JFrame frame;
		private static boolean hasBeenClicked;
		private ActionListener yesListener;
		private ActionListener noListener;
		private static final int FRAME_WIDTH = 1500;
		private static final int FRAME_HEIGHT = 1500;
		
		public GUIWelcomeWindow() {
			initialize();
			setSize(FRAME_WIDTH, FRAME_HEIGHT);	
		}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
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
		
		JLabel label = new JLabel("2, 4, 8, or 16 friends to be the participants in the tournament");
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
		}
		
		public static boolean getClick() {
			return hasBeenClicked;
		}
		
		public JFrame getFrame() {
			return frame;
		}
	
	class YesButton extends JFrame implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public YesButton() {
			hasBeenClicked = false;
		}
	
		public void actionPerformed(ActionEvent e) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						GUICreateNewTournamentWindow window = new GUICreateNewTournamentWindow();
						window.getFrame().setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});

			hasBeenClicked = true;
		}
	}
	
	class NoButton extends JFrame implements ActionListener {
		
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		public NoButton() {
			hasBeenClicked = false;
		}
	
		public void actionPerformed(ActionEvent e) {
			System.exit(1);
			hasBeenClicked = false;
		}
	}
	
	public static void main(String[] args) {
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				GUIWelcomeWindow window = new GUIWelcomeWindow();
				window.frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}


}



