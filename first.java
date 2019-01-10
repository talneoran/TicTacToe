package tictactoe;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.Timer;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.ButtonGroup;

//TicTacToe Version 1.0 by Tal Neoran
public class first {

	private JFrame frmTictactoe;
	private JButton[][] boxes;
	public ActionListener taskPerformer;
	private int winLose; // -1 = AI wins, 1 = User wins, 0 = draw, 2 = game in progress
	private Position aI;
	private AIplayer aiplayer; 
	private final ButtonGroup buttonGroup = new ButtonGroup();
	private Position lastMove  = new Position(0, 0);
	private int difficulty = 100; 
	private boolean isPressable = true;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					first window = new first();
					window.frmTictactoe.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application
	 */
	public first() {
		initialize();
	}
	
	public void changeTextUser(JButton button){ // Changes parameter button text to "X"
		button.setText("X");
		button.setFocusable(false);
	}

	public void changeTextAI(JButton button){ // Changes parameter button text to "O"
		button.setText("O");
	}
	public void endMessage(int WinLose){ // Shows pop up message on game end
		
		switch (WinLose){
		case 1: JOptionPane.showMessageDialog(null,"You Win!","End Game Message",JOptionPane.PLAIN_MESSAGE);break;
		case 0: JOptionPane.showMessageDialog(null,"Draw!","End Game Message",JOptionPane.PLAIN_MESSAGE);break;
		case -1: JOptionPane.showMessageDialog(null,"You Lose!","End Game Message",JOptionPane.PLAIN_MESSAGE);break;
		}
	}
	public void doMove(JButton button, int i, int j){ // Applies user move and initializes AI's move
		if (button.getText() != "" || isPressable == false)
			return;
		aiplayer.updateStatus(i, j, aiplayer.x);
		changeTextUser(button);
		lastMove.setI(i);
		lastMove.setJ(j);
		aI = new Position(-1, -1);
		winLose = doMoveAI(i, j, aI);
		isPressable = false; // Prevention of clicking before AI move bug
		Timer timer = new Timer(1200, taskPerformer); // 
		timer.setRepeats(false);					  // Wait for AI's move GUI draw
		timer.start(); 								  //	
		
		
	}

	public int doMoveAI(int i, int j, Position ai){ // Applies AI's move chosen by the AIplayer MoveChooser
		return aiplayer.play(ai, difficulty);
	}
	public void changeColor(Color color){ // Applies background change to parameer color
		for(int i = 0; i < 3; i++)
		{
			for(int j = 0; j < 3; j++)
			{
				boxes[i][j].setBackground(color);
			}
		}
	}
	
	/**
	 * Initialize the contents of the frame
	 */
	private void initialize() {
		frmTictactoe = new JFrame();
		frmTictactoe.setTitle("TicTacToe");
		frmTictactoe.setBounds(100, 100, 500, 500);
		frmTictactoe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTictactoe.getContentPane().setLayout(new GridLayout(3, 3, 0, 0));
		
		//Button initializing and action setting
		JButton btnNewButton_00 = new JButton("");
		btnNewButton_00.setBackground(Color.WHITE);
		btnNewButton_00.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				doMove(btnNewButton_00, 0, 0);
			}
		});
		btnNewButton_00.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_00);
		
		JButton btnNewButton_01 = new JButton("");
		btnNewButton_01.setBackground(Color.WHITE);
		btnNewButton_01.setFont(new Font("Tahoma", Font.BOLD, 99));
		btnNewButton_01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_01, 0, 1);
			}
		});
		frmTictactoe.getContentPane().add(btnNewButton_01);
		
		JButton btnNewButton_02 = new JButton("");
		btnNewButton_02.setBackground(Color.WHITE);
		btnNewButton_02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_02, 0, 2);
			}
		});
		btnNewButton_02.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_02);
		
		JButton btnNewButton_10 = new JButton("");
		btnNewButton_10.setBackground(Color.WHITE);
		btnNewButton_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_10, 1, 0);
			}
		});
		btnNewButton_10.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("");
		btnNewButton_11.setBackground(Color.WHITE);
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_11, 1, 1);
			}
		});
		btnNewButton_11.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("");
		btnNewButton_12.setBackground(Color.WHITE);
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_12, 1, 2);
			}
		});
		btnNewButton_12.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_12);
		
		JButton btnNewButton_20 = new JButton("");
		btnNewButton_20.setBackground(Color.WHITE);
		btnNewButton_20.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_20, 2, 0);
			}
		});
		btnNewButton_20.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_20);
		
		JButton btnNewButton_21 = new JButton("");
		btnNewButton_21.setBackground(Color.WHITE);
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_21, 2, 1);
			}
		});
		btnNewButton_21.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_21);
		
		JButton btnNewButton_22 = new JButton("");
		btnNewButton_22.setBackground(Color.WHITE);
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				doMove(btnNewButton_22, 2, 2);
			}
		});
		btnNewButton_22.setFont(new Font("Tahoma", Font.BOLD, 99));
		frmTictactoe.getContentPane().add(btnNewButton_22);
		// End of button initializing and action setting
		boxes = new JButton[3][3]; // Initialization of button array
		boxes[0][0] = btnNewButton_00;
		boxes[0][1] = btnNewButton_01;
		boxes[0][2] = btnNewButton_02;
		boxes[1][0] = btnNewButton_10;
		boxes[1][1] = btnNewButton_11;
		boxes[1][2] = btnNewButton_12;
		boxes[2][0] = btnNewButton_20;
		boxes[2][1] = btnNewButton_21;
		boxes[2][2] = btnNewButton_22;
		//Menu buttons configuring
		JMenuBar menuBar = new JMenuBar();
		frmTictactoe.setJMenuBar(menuBar);
		//Menu configuration
		JMenu mnFile = new JMenu("Menu");
		mnFile.setFont(new Font("Segoe UI", Font.BOLD, 12));
		menuBar.add(mnFile);
		//Reset button configuration
		JMenuItem mntmReset = new JMenuItem("Reset");
		mntmReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						aiplayer.updateStatus(i, j, aiplayer.empty);
					}
				}
				for(int i = 0; i < 3; i++)
				{
					for(int j = 0; j < 3; j++)
					{
						boxes[i][j].setText("");
					}
				}
			}
		});
		mnFile.add(mntmReset);
		//Undo button configuration
		JMenuItem mntmUndo = new JMenuItem("Undo");
		mntmUndo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				aiplayer.updateStatus(lastMove.getI(), lastMove.getJ(), aiplayer.empty);
				aiplayer.updateStatus(aiplayer.lastMoveAI.getI(), aiplayer.lastMoveAI.getJ(), aiplayer.empty);
				boxes[lastMove.getI()][lastMove.getJ()].setText("");
				boxes[aiplayer.lastMoveAI.getI()][aiplayer.lastMoveAI.getJ()].setText("");
			}
		});
		mnFile.add(mntmUndo);
		//Difficulty buttons configuration
		JMenu mnDifficulty = new JMenu("Difficulty");
		mnFile.add(mnDifficulty);
		
		JRadioButtonMenuItem rdbtnmntmInsane = new JRadioButtonMenuItem("Insane");
		rdbtnmntmInsane.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				difficulty = 100;
			}
		});
		rdbtnmntmInsane.setSelected(true);
		buttonGroup.add(rdbtnmntmInsane);
		mnDifficulty.add(rdbtnmntmInsane);
		
		JRadioButtonMenuItem rdbtnmntmHard = new JRadioButtonMenuItem("Hard");
		rdbtnmntmHard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 80;
			}
		});
		buttonGroup.add(rdbtnmntmHard);
		mnDifficulty.add(rdbtnmntmHard);
		
		JRadioButtonMenuItem rdbtnmntmMedium = new JRadioButtonMenuItem("Medium");
		rdbtnmntmMedium.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 50;
			}
		});
		buttonGroup.add(rdbtnmntmMedium);
		mnDifficulty.add(rdbtnmntmMedium);
		
		JRadioButtonMenuItem rdbtnmntmEasy = new JRadioButtonMenuItem("Easy");
		rdbtnmntmEasy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 30;
			}
		});
		buttonGroup.add(rdbtnmntmEasy);
		mnDifficulty.add(rdbtnmntmEasy);
		
		JRadioButtonMenuItem rdbtnmntmClueless = new JRadioButtonMenuItem("Clueless");
		rdbtnmntmClueless.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				difficulty = 10;
			}
		});
		buttonGroup.add(rdbtnmntmClueless);
		mnDifficulty.add(rdbtnmntmClueless);
		//Background change buttons configuration
		JMenu mnChangeBackground = new JMenu("Change Background");
		mnFile.add(mnChangeBackground);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("Yellow");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.YELLOW);
			}
		});
		
		JMenuItem mntmDefault = new JMenuItem("Default");
		mntmDefault.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.WHITE);
			}
		});
		mnChangeBackground.add(mntmDefault);
		mnChangeBackground.add(mntmNewMenuItem);
		
		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Green");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.GREEN);
			}
		});
		mnChangeBackground.add(mntmNewMenuItem_1);
		
		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Blue");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.BLUE);
			}
		});
		mnChangeBackground.add(mntmNewMenuItem_2);
		
		JMenuItem mntmRed = new JMenuItem("Red");
		mntmRed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.RED);
			}
		});
		mnChangeBackground.add(mntmRed);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Cyan");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.CYAN);
			}
		});
		mnChangeBackground.add(mntmNewMenuItem_3);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Magenta");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.MAGENTA);
			}
		});
		mnChangeBackground.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Pink");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.PINK);
			}
		});
		mnChangeBackground.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Orange");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				changeColor(Color.ORANGE);
			}
		});
		mnChangeBackground.add(mntmNewMenuItem_6);
		
		JMenuItem mntmAbout = new JMenuItem("About");
		mntmAbout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,"TicTacToe created by Tal Neoran.\nVersion 1.0","About",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		mnFile.add(mntmAbout);
		//End of menu buttons configuring
		taskPerformer = new ActionListener() {
		      public void actionPerformed(ActionEvent evt) { // Draw AI's move and calls end game message in case of a game over
		    	  	if (winLose != aiplayer.userWin){
		    	  		if (aI.getI()<3 && aI.getI()>=0 && aI.getJ()<3 && aI.getJ()>=0)
				  		{
				  			changeTextAI(boxes[aI.getI()][aI.getJ()]);
				  		}
		    	  	}
			  		
			  		if (winLose<=aiplayer.userWin && winLose>=aiplayer.aiWin)
			  		{
			  			endMessage(winLose);
			  			
			  		}
					isPressable = true; // Prevention of clicking before AI move bug
						

		      }
	      
		};
		
		// Start up an artificial intelligence player object
		aiplayer = new AIplayer();
		
		
	}

}
