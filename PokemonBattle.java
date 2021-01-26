/**
 * @(#)PokemonBattle.java
 *
 *
 * @author 
 * @version 1.00 2020/5/4
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class PokemonBattle extends JFrame {
	
	JPanel movesPanel;
	
	JLabel playerHPLabel;
	JLabel enemyHPLabel;
	
	JPanel enemyHPPanel;
	JPanel playerHPPanel;
	
	double enemyHP;
	double enemyDamage;
	double playerHP;
	double playerDamage;
	int Turns;
	
    public PokemonBattle() {
    	
    	setTitle("Battle!");
    	setLayout(new BorderLayout());
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	setSize(1600,1000);
    	
    	enemyHPPanel = new JPanel();
    	playerHPPanel = new JPanel();
    	
    	add(playerHPPanel, BorderLayout.EAST);
    	add(enemyHPPanel, BorderLayout.NORTH);
    	
    	setVisible(true);
    }
    public JPanel getPanel(){
    	movesPanel = new JPanel();
    	return movesPanel;
    }
    
    public void getHP(double eHP, double pHP) {
    	enemyHP = eHP;
    	playerHP = pHP; // PHP sucks
    	
    	playerHPLabel = new JLabel("Your HP: " + playerHP);
    	enemyHPLabel = new JLabel("Enemy HP: " + enemyHP);
    	enemyHPPanel.add(enemyHPLabel);
    	playerHPPanel.add(playerHPLabel);
    }
    
    public void playTurn(double D, double enemyD) {
    	playerDamage = D;
    	enemyDamage = enemyD;
    	
    	enemyHP = enemyHP - playerDamage;
    	
    	playerHP = playerHP - enemyDamage;
    	
    	playerHPLabel.setText("Your HP: " + playerHP);
    	enemyHPLabel.setText("Enemy HP: " + enemyHP);
    	
    	if(playerHP <= 0){
    		JOptionPane.showMessageDialog(null, "You Lost!");
    		System.exit(0);
    	}
    	if(enemyHP <= 0){
    		JOptionPane.showMessageDialog(null, "You Won!");
    		System.exit(0);
    	}
    }
    
}