/**
 * @(#)PokemonChoice.java
 *
 *
 * @author 
 * @version 1.00 2020/3/30
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; 

//added 3:58

public class PokemonChoice extends JPanel{
	
	private JLabel playerChoice;
	private JLabel enemyChoice;
	private JComboBox starter;
	private JComboBox enemy;
		
	private JTextField starterText;
	private JTextField enemyText;
	
	private String[] starterPoke = {"Charmander", "Bulbasaur", "Squirtle"};
	private String[] enemyPoke = {"Charmander", "Bulbasaur", "Squirtle"};
	
	public int[] starterNumber = {0, 1, 2};
	public int[] enemyNumber = {0, 1, 2};
	
	private int pickedStarter = 0;
	private int pickedEnemy = 0;
	
    public PokemonChoice() {
    	
    	setLayout(new GridLayout(3,3));
    		
    	playerChoice = new JLabel("Pick your starter Pokemon!");
    	enemyChoice = new JLabel("Pick your enemies Pokemon!");
    	starter = new JComboBox(starterPoke);
    	enemy = new JComboBox(enemyPoke);
    	
    	starterText = new JTextField(10);
    	starterText.setText("Charmander");
    	enemyText = new JTextField(10);
    	enemyText.setText("Charmander");
    	
    	starter.addActionListener(new ComboBoxListener());
    	enemy.addActionListener(new ComboBoxListener());
    	
    	
    	add(playerChoice);
    	add(starter);
    	add(enemyChoice);
    	add(enemy);
    	add(starterText);
    	add(enemyText);
    	
    	
    	
    }


    public class ComboBoxListener implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		//int index, enemyIndex;
    		String selectedStarter;
    		String selectedEnemy;
    		
    		final int index = starter.getSelectedIndex();
    		
    		selectedStarter = starterPoke[index];
    		pickedStarter = starterNumber[index];
    		
    		starterText.setText(selectedStarter);
    		
    		final int enemyIndex = enemy.getSelectedIndex();
    		
    		selectedEnemy = enemyPoke[enemyIndex];
    		pickedEnemy = enemyNumber[enemyIndex];
    		
    		enemyText.setText(selectedEnemy);
    		
    		
    	}
    }

    
    public int getPlayerPokemon() {
    	return pickedStarter;
    	
    
    	
    }
    public int getEnemyPokemon() {
    	
    	System.out.println(pickedEnemy);
    	return pickedEnemy;
    }
}