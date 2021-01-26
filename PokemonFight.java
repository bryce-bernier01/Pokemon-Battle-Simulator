/**
 * @(#)PokemonFight.java
 *
 *
 * @author 
 * @version 1.00 2020/3/24
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import javax.swing.ImageIcon;

public class PokemonFight extends JPanel{
	
	ImageIcon bulbaBack = new ImageIcon("bulbaBack.png");
	ImageIcon bulbaFront = new ImageIcon("bulbaFront.png");
	ImageIcon charmBack = new ImageIcon("charmBack.png");
	ImageIcon charmFront = new ImageIcon("charmFront.png");
	ImageIcon squirtleBack = new ImageIcon("squirtleBack.png");
	ImageIcon squirtleFront = new ImageIcon("squirtleFront.png");
	
	JPanel playerPanel;
	JPanel enemyPanel;
	
	JLabel playerLabel;
	JLabel enemyLabel;
	
	private PokemonChoice choice;
	private PokemonBattle Battle;
	
	Random rand = new Random();
	
	int playerPokemon, enemyPokemon;
	int[] playerPokeStats;
	int[] enemyPokeStats;
	
	private JButton move1;
	private JButton move2;
	private JButton move3;
	private JButton move4;
	
	private JPanel movesPanel;
	
	private JButton builderButton;
	private JPanel builderPanel;
	
	String[] CharmMoves = {"Fire Blast", "Dragon Pulse", "Thunder Punch", "Dig"};
	String[] BulbaMoves = {"Seed Bomb", "Giga Drain", "Sludge Bomb", "Poison Powder"};
	String[] SquirtleMoves = {"Hydro Pump", "Ice Punch", "Facade", "Brick Break"};
	
	private int statusEffect = 0;
	
	//Moves For Charmander
	int fireBlastPower = 110;
	int dragonPulsePower = 85;
	int thunderPunchPower = 75;
	int digPower = 80;
	
	//Moves For Bulbasaur
	int seedBombPower = 80;
	int gigaDrainPower = 75;
	int sludgeBombPower = 90;
	int poisonPowderPower = 0;
	
	//Moves for Squirtle
	int hydroPumpPower = 120;
	int icePunchPower = 75;
	int facadePower = (70 * (++statusEffect));
	int brickBreakPower = 75;
	
	int move1Power;
	int move2Power;
	int move3Power;
	int move4Power;
	
	int enemyMove1Power;
	int enemyMove2Power;
	int enemyMove3Power;
	int enemyMove4Power;
	
	//String[] playerType;
	//String[] enemyType;
	String moveType;
	
	double damage;
	double enemyDamage;
	double modifier;
	int Targets = 1;
	int Weather = 1;
	// 1 / 16
	double Critical;
	int random = 1;
	double STAB;
	double Type;
	int randWatch;
	
	
	
    public PokemonFight() {
    	
    	choice = new PokemonChoice();
    	
    	add(choice);
    	builderButtonPanel();
    	
    
    	
    }
    
    public void builderButtonPanel() {
    	//builderPanel = new JPanel();
    	
    	builderButton = new JButton("Build");
    	
    	builderButton.addActionListener(new builderButtonListener());
    	
    	add(builderButton);
    }
    
    public class builderButtonListener implements ActionListener {
    	
    	public void actionPerformed(ActionEvent e) {
    		playerPokemon = choice.getPlayerPokemon();
    		enemyPokemon = choice.getEnemyPokemon();
    		
    		
    		
    		
    		buildStats();
    		buildMoves();
    	}
    }
    
    
    private void buildStats() {
    	//Building Players Stats
    	//{HP, Attack, Defense, Special Attack, Special Defense, Speed}
    	if(playerPokemon == 0){
    		//Charmander
    		playerPokeStats = new int[]{188, 109, 91, 125, 105, 135};
    		
    	}else if(playerPokemon == 1){
    		//Bulbasaur
    		playerPokeStats = new int[]{200, 103, 103, 135, 135, 95};
    		
    	}else if(playerPokemon == 2){
    		//Squirtle
    		playerPokeStats = new int[]{198, 101, 135, 105, 133, 91};
    		
    	}else
    		playerPokeStats = new int[]{1, 1, 1, 1, 1, 1};
    		
    	System.out.println(playerPokeStats[1]);
    		
    	//Building Enemies Stats
    	if(enemyPokemon == 0){
    		enemyPokeStats = new int[]{188, 109, 91, 125, 105, 135};
    	}
    	if(enemyPokemon == 1){
    		enemyPokeStats = new int[]{200, 103, 103, 135, 135, 95};
    	}
    	if(enemyPokemon == 2){
    		enemyPokeStats = new int[]{198, 101, 135, 105, 133, 91};	
    	}
    		//this else statement breaks everything ;-;
    		//else
    		//enemyPokeStats = new int[]{1, 1, 1, 1, 1, 1};
    		
    	System.out.println(enemyPokeStats[1]);
    }
    
    private void buildMoves() {
    	//Charmanders Moves
    	if(playerPokemon == 0){
    		move1 = new JButton(CharmMoves[0]);
    		move1Power = fireBlastPower;
    		move2 = new JButton(CharmMoves[1]);
    		move2Power = dragonPulsePower;
    		move3 = new JButton(CharmMoves[2]);
    		move3Power = thunderPunchPower;
    		move4 = new JButton(CharmMoves[3]);
    		move4Power = digPower;
    		
    	}else if(playerPokemon == 1){
    		move1 = new JButton(BulbaMoves[0]);
    		move1Power = seedBombPower;
    		move2 = new JButton(BulbaMoves[1]);
    		move2Power = gigaDrainPower;
    		move3 = new JButton(BulbaMoves[2]);
    		move3Power = sludgeBombPower;
    		move4 = new JButton(BulbaMoves[3]);
    		move4Power = poisonPowderPower;
    		
    	}else if(playerPokemon == 2){
    		move1 = new JButton(SquirtleMoves[0]);
    		move1Power = hydroPumpPower;
    		move2 = new JButton(SquirtleMoves[1]);
    		move2Power = icePunchPower;
    		move3 = new JButton(SquirtleMoves[2]);
    		move3Power = facadePower;
    		move4 = new JButton(SquirtleMoves[3]);
    		move4Power = brickBreakPower;
    	}else {
    		move1 = new JButton("null");
    		move2 = new JButton("null");
    		move3 = new JButton("null");
    		move4 = new JButton("null");
    		
    	}
    	move1.addActionListener(new moveButton1());
    	move2.addActionListener(new moveButton2());
    	move3.addActionListener(new moveButton3());
    	move4.addActionListener(new moveButton4());
    	
    	if(enemyPokemon == 0){
    		enemyMove1Power = fireBlastPower;
    		enemyMove2Power = dragonPulsePower;
    		enemyMove3Power = thunderPunchPower;
    		enemyMove4Power = digPower;
    	}else if(enemyPokemon == 1){
    		enemyMove1Power = seedBombPower;
    		enemyMove2Power = gigaDrainPower;
    		enemyMove3Power = sludgeBombPower;
    		enemyMove4Power = poisonPowderPower;
    	}else if(enemyPokemon == 2){
    		enemyMove1Power = hydroPumpPower;
    		enemyMove2Power = icePunchPower;
    		enemyMove3Power = facadePower;
    		enemyMove4Power = brickBreakPower;
    	}
    	
    	Battle = new PokemonBattle();
    	movesPanel = Battle.getPanel();
    	playerPanel = new JPanel();
    	enemyPanel = new JPanel();
    	
    	Battle.add(movesPanel, BorderLayout.SOUTH);
    	Battle.add(playerPanel, BorderLayout.WEST);
    	Battle.add(enemyPanel, BorderLayout.CENTER);
    	
    	if(playerPokemon == 0){
    		playerLabel = new JLabel(charmBack);
    	}else if(playerPokemon == 1){
    		playerLabel = new JLabel(bulbaBack);
    	}else if(playerPokemon == 2){
    		playerLabel = new JLabel(squirtleBack);
    	}
    	
    	if(enemyPokemon == 0){
    		enemyLabel = new JLabel(charmFront);
    	}else if(enemyPokemon == 1){
    		enemyLabel = new JLabel(bulbaFront);
    	}else if(enemyPokemon ==2){
    		enemyLabel = new JLabel(squirtleFront);
    	}
    	
    	playerPanel.add(playerLabel);
    	enemyPanel.add(enemyLabel);
    	
    	movesPanel.add(move1);
    	movesPanel.add(move2);
    	movesPanel.add(move3);
    	movesPanel.add(move4);
    	//send HP values to Battle
    	Battle.getHP(enemyPokeStats[0], playerPokeStats[0]);
    	
    }
    public class moveButton1 implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		//Checking for critical hits
    		randWatch = rand.nextInt(16);
    		randWatch++;
    		if(randWatch == 1){
    			Critical = 1.5;
    		}else {
    			Critical = 1;
    		}
   			
    		if(playerPokemon == 0){
    			moveType = "Fire";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move1Power * (playerPokeStats[3] / enemyPokeStats[4])) / 50) * modifier;
    		}
    		
    		if(playerPokemon == 1){
    			moveType = "Grass";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move1Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		if(playerPokemon == 2){
    			moveType = "Water";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move1Power * (playerPokeStats[3] / enemyPokeStats[4])) / 50) * modifier;
    		}
    		//make enemy moves
    		if(enemyPokemon == 0){
    			moveType = "Fire";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[3] / playerPokeStats[4])) / 50);
    		}
    		if(enemyPokemon == 1){
    			moveType = "Grass";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		if(enemyPokemon == 2){
    			moveType = "Water";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[3] / playerPokeStats[4])) / 50);
    		}
    		
    		Battle.playTurn(damage, enemyDamage);
    		
    	}
    }
	public class moveButton2 implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		randWatch = rand.nextInt(16);
    		randWatch++;
    		if(randWatch == 1){
    			Critical = 1.5;
    		}else {
    			Critical = 1;
    		}
    		
    		if(playerPokemon == 0){
    			moveType = "Dragon";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move2Power * (playerPokeStats[3] / enemyPokeStats[4])) / 50);
    			System.out.println("Damage: " + damage);
    			System.out.println(Type);
    			System.out.println(modifier);
    			System.out.println(move2Power);
    			System.out.println(playerPokeStats[3]);
    			System.out.println(enemyPokeStats[4]);
    		}
    		if(playerPokemon == 1){
    			moveType = "Grass";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move2Power * (playerPokeStats[3] / enemyPokeStats[4])) / 50) * modifier;
    		}
    		if(playerPokemon == 2){
    			moveType = "Ice";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move2Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		
    		//calculate Enemy's moves and damage
    		if(enemyPokemon == 0){
    			moveType = "Dragon";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[3] / playerPokeStats[4])) / 50);
    		}
    		if(enemyPokemon == 1){
    			moveType = "Grass";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[3] / playerPokeStats[4])) / 50);
    		}
    		if(enemyPokemon == 2){
    			moveType = "Ice";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		
    		Battle.playTurn(damage, enemyDamage);
    	}
    }
    public class moveButton3 implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		randWatch = rand.nextInt(16);
    		randWatch++;
    		if(randWatch == 1){
    			Critical = 1.5;
    		}else {
    			Critical = 1;
    		} 
    			
    		if(playerPokemon == 0){
    			moveType = "Electric";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move3Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		if(playerPokemon == 1){
    			moveType = "Poison";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move3Power * (playerPokeStats[3] / enemyPokeStats[4])) / 50) * modifier;
    		}
    		if(playerPokemon == 2){
    			moveType = "Normal";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move3Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		
    		if(enemyPokemon == 0){
    			moveType = "Electric";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		if(enemyPokemon == 1){
    			moveType = "Poison";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[3] / playerPokeStats[4])) / 50);
    		}
    		if(enemyPokemon == 2){
    			moveType = "Normal";
    			Type = PlayerCheckTypes();
    			STAB = 1.5;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		
    		Battle.playTurn(damage, enemyDamage);
    		
    	}
    }
    public class moveButton4 implements ActionListener {
    	public void actionPerformed(ActionEvent e){
    		
    		randWatch = rand.nextInt(16);
    		randWatch++;
    		if(randWatch == 1){
    			Critical = 1.5;
    		}else {
    			Critical = 1;
    		}
    		
    		if(playerPokemon == 0){
    			moveType = "Ground";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move4Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		if(playerPokemon == 1){
    			moveType = "Poison";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move4Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		if(playerPokemon == 2){
    			moveType = "Fighting";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			damage = (((((2 * 100)/5) + 2) * move4Power * (playerPokeStats[1] / enemyPokeStats[2])) / 50) * modifier;
    		}
    		
    		if(enemyPokemon == 0){
    			moveType = "Ground";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		if(enemyPokemon == 1){
    			moveType = "Poison";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		if(enemyPokemon == 2){
    			moveType = "Fighting";
    			Type = PlayerCheckTypes();
    			STAB = 1;
    			
    			modifier = Targets * Weather * Critical * random * STAB * Type;
    			enemyDamage = (((((2 * 100)/5) + 2) * enemyMove2Power * (enemyPokeStats[1] / playerPokeStats[2])) / 50);
    		}
    		
    		Battle.playTurn(damage, enemyDamage);
    	}
    }
    
    public double PlayerCheckTypes(){
    	if(moveType == "Fire"){
    		if(enemyPokemon == 0){
    			return 0.5;
    		}else if(enemyPokemon == 1){
    			return 2;
    		}else if(enemyPokemon == 2){
    			return 0.5;
    		}else{
    			return 1.0;
    		}
    	}
    	
    	if(moveType == "Dragon"){
    		return 1.0;
    	}
    	
    	if(moveType == "Electric"){
    		if(enemyPokemon == 2){
    			return 2.0;
    		}else if(enemyPokemon == 1){
    			return 0.5;
    		}else{
    			return 1.0;
    		}
    	}
    	
    	if(moveType == "Ground"){
    		if(enemyPokemon == 0){
    			return 2.0;
    		}else{
    			return 1.0;
    		}
    	}
    	
    	if(moveType =="Grass"){
    		if(enemyPokemon == 0){
    			return 0.5;
    		}else if(enemyPokemon == 2){
    			return 2;
    		}else if(enemyPokemon == 1){
    			return 0.25;
    		}else{
    			return 1;
    		}
    	}
    	
    	if(moveType == "Posion"){
    		return 1;
    	}
    	
    	if(moveType == "Water"){
    		if(enemyPokemon == 0){
    			return 2.0;
    		}else if(enemyPokemon == 2 || enemyPokemon == 1){
    			return 0.5;
    		}else{
    			return 1;
    		}
    	}
    	
    	if(moveType == "Ice"){
    		if(enemyPokemon == 0 || enemyPokemon == 2){
    			return 0.5;
    		}else if(enemyPokemon == 1){
    			return 2.0;
    		}else{
    			return 1.0;
    		}
    	}
    	
    	if(moveType == "Normal"){
    		return 1.0;
    	}
    	if(moveType == "Fighting"){
    		if(enemyPokemon == 1 || enemyPokemon == 2){
    			return 0.5;
    		}else{
    			return 1.0;
    		}
    	}
    	else{
    		return 0.0;
    	}
    }
}