/**
 * @(#)PokemonMain.java
 *
 *
 * @author 
 * @version 1.00 2020/3/24
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PokemonMain extends JFrame {


	private PokemonFight Fight;
	private PokemonChoice Choose;
	private JPanel buttonPanel;
	private JButton calcButton;
	private JButton exitButton;
	//private final int WINDOW_HEIGHT = 1080;
	//private final int WINDOW_WIDTH = 1920;



	public PokemonMain() {
		
		//setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		
		setTitle("Pokemon Battle Simulator");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setLayout(new GridLayout(2,3));
		setLayout(new BorderLayout());
		
		
		
		
		Choose = new PokemonChoice();
		Fight = new PokemonFight();
		
		buildButtonPanel();
		
		//add(Choose, BorderLayout.WEST);
		add(Fight, BorderLayout.CENTER);
		
		pack();
		
		setVisible(true);
		
		
		
	}
	
	public void buildButtonPanel() {
		buttonPanel = new JPanel();
		
		calcButton = new JButton("Fight Calculation");
		exitButton = new JButton("Run");
		
		calcButton.addActionListener(new CalcButtonListener());
		exitButton.addActionListener(new ExitButtonListener());
		
		//add(calcButton);
		//add(exitButton);
		
	}
	
	public class CalcButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			int rando = 1+1;
		}
		
		
	}
	
	public class ExitButtonListener implements ActionListener {
		public void actionPerformed(ActionEvent e){
			System.exit(0);
		}
	}
	
	
    public static void main(String [] args) {
    	new PokemonMain();
		
    }
    

}