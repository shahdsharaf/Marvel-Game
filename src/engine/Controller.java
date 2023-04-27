package engine;

import javax.swing.JButton;
import javax.swing.JFrame;

import model.abilities.Ability;
import model.world.Champion;
import model.world.Cover;
import model.world.Direction;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Point;
public class Controller  implements ActionListener {
    Game game;
    View view;
    int c=0;
	boolean move=false;
	boolean attack=false;
	boolean ability=false;
	Ability a;
    public Controller() {
    	view = new View();
    	view.submit.addActionListener(this);
    
    }
	public void actionPerformed(ActionEvent e) {
		JButton buttonPressed = (JButton) e.getSource();
		if (buttonPressed.getActionCommand().equals("Submit")) {
			try{ 
				Player p1= new Player(view.t1.getText());
			Player p2= new Player(view.t2.getText());
			game = new Game(p1,p2);
			Game.loadAbilities("Abilities.csv");
			Game.loadChampions("Champions.csv");
			view.displayChamps(Game.getAvailableChampions());
			initiateButtons();
		    view.gameInstructions();
		    initiateOkButton();
			}
			catch (Exception ex){ 
				System.out.println("missing files");
			}
			view.submit.setEnabled(false);
		}
		if (buttonPressed.getActionCommand().equals("Select")) {
			view.beforewestart.dispose();
		}
	   if (buttonPressed.getActionCommand().equals("ChooseChampion")) {
		   int i= view.getChooseChampion().indexOf(buttonPressed);
		   Champion curr= Game.getAvailableChampions().get(i);
		   if (c<3) {
			   game.getFirstPlayer().getTeam().add(curr);
			   if (c==0)
				   game.getFirstPlayer().setLeader(curr);
		   }
		   else if( c>=3 && c<6) {
			   game.getSecondPlayer().getTeam().add(curr);
			   if (c==3)
				   game.getSecondPlayer().setLeader(curr);
		   }
		   c++;
		   if (c==6) {
			   view.window.dispose();
				view.window2.setVisible(true);
				game.placeChampions();
				view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());   //should call after every action
				view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName(), game.isFirstLeaderAbilityUsed());
				initiateFpButtons();
				view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName(), game.isSecondLeaderAbilityUsed());
				initiateSpButtons();
				game.prepareChampionTurns();       //should call again after endturn
				view.setUpLeft(game.getTurnOrder());  //should call after every action
				initiateAbilityButton();
				initiateEffectsButton();
				initiateActionButtons();
				initiateDirectionButtons();
				//initiateLeaderAbility();
				}
		   JButton boop= view.getChooseChampion().get(i);
	       boop.setEnabled(false);
		   }
	   if (buttonPressed.getActionCommand().equals("FirstPlayerTeam")) {
		   int i= view.getFirstTeam().indexOf(buttonPressed);
		   Champion curr= game.getFirstPlayer().getTeam().get(i);
		   boolean b= view.isLeader(curr, game);
		   view.displaySingleFTChamp(curr, b);
	   }
	   if (buttonPressed.getActionCommand().equals("SecondPlayerTeam")) {
		   int i= view.getSecondTeam().indexOf(buttonPressed);
		   Champion curr= game.getSecondPlayer().getTeam().get(i);
		   boolean b= view.isLeader(curr, game);
		   view.displaySingleSTChamp(curr, b);
	   }
	   if (buttonPressed.getActionCommand().equals("ViewAbilities")) {
		   Champion c= game.getCurrentChampion();
		   view.popUpAbilities(c); 
	   }
	   if (buttonPressed.getActionCommand().equals("ViewAppliedEffects")) {
		   Champion c= game.getCurrentChampion();
		   view.popUpEffects(c);
	   }
	   if (buttonPressed.getActionCommand().equals("Attack")) {
		   move=false;
		   ability=false;
		   attack=true;
		   view.window5.setVisible(true);
	   }
	   if (buttonPressed.getActionCommand().equals("Move")) {
		   ability=false;
		   attack=false;
		   move=true;          //so we know the combo action + direction, move is instantiated when move is true and direction is picked
		   view.window5.setVisible(true);
	   }
	  if (buttonPressed.getActionCommand().equals("Direction") && move==true) {
		  System.out.println("ok");
		  String s= buttonPressed.getText();
		  Direction d= Direction.valueOf(s);
		  try {
			  game.move(d);
			 
		  }
		  catch (Exception ex) {
			  view.catchException(ex.getMessage());
			  System.out.print("noooooo");
		  }
		  move=false;         //resetting again to false for next move
		  System.out.print("yay");
		  view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());
		  view.setUpLeft(game.getTurnOrder());
		  initiateAbilityButton();
		  initiateEffectsButton();
		  Player p = game.checkGameOver();
		  if (p!= null)
			  view.farewell(p);
		  System.out.print("yay2");
		  view.window5.dispose();
	  }
	  if (buttonPressed.getActionCommand().equals("Direction") && attack==true) {
		  System.out.println("ok2");
		  String s= buttonPressed.getText();
		  Direction d= Direction.valueOf(s);
		  try {
			  game.attack(d);
		  }
		  catch (Exception ex) {
			  view.catchException(ex.getMessage());
			  System.out.println("you idiot");
		  }
		  attack=false;         //resetting again to false for next attack
		  System.out.print("yay2");
		  view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());
		  view.setUpLeft(game.getTurnOrder());
		  initiateAbilityButton();
		  initiateEffectsButton();
		 /* view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName());
		  view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName());
		  initiateFpButtons();
			initiateSpButtons();*/
		  System.out.print("yay22");
		  Player p = game.checkGameOver();
		  if (p!= null)
			  view.farewell(p);
		  view.window5.dispose();
	  }
	  if (buttonPressed.getActionCommand().equals("Endturn")) {
		  game.endTurn();
		  //Champion c= game.getCurrentChampion();
		  view.setUpLeft(game.getTurnOrder());
		  initiateAbilityButton();
		  initiateEffectsButton();
		  view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName(), game.isFirstLeaderAbilityUsed());
		  view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName(), game.isSecondLeaderAbilityUsed());
		  initiateFpButtons();
			initiateSpButtons();
	  }
      if (buttonPressed.getActionCommand().equals("LeaderAbility")) {
		  try {
			  game.useLeaderAbility();
		  }
		  catch(Exception ex) {
			  view.catchException(ex.getMessage());
		  }
		  view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());
		  view.setUpLeft(game.getTurnOrder());
		  initiateAbilityButton();
		  initiateEffectsButton();
		  view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName(), game.isFirstLeaderAbilityUsed());
		  view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName(), game.isSecondLeaderAbilityUsed());
		  initiateFpButtons();
			initiateSpButtons();
		  Player p = game.checkGameOver();
		  if (p!= null)
			  view.farewell(p);
	  }
	  if (buttonPressed.getActionCommand().equals("Ability")) {
		  attack=false;
		  move=false;
		  ability= true;
		 Champion curr= game.getCurrentChampion();
		 view.chooseAbility(curr);
		 initiateChooseAbilityButtons();
	   }
	  if (buttonPressed.getActionCommand().equals("SINGLETARGET") && ability==true) {
		  view.window6.dispose();
		  System.out.println("safe");
		  String s=buttonPressed.getText();
		  a= Game.findAbilityByName(s);
		  System.out.println(a.getName());
		  view.singleTarget(game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam(), game.getCurrentChampion(), game.getCovers());
		  initiateTargetOptionButtons();
		  Player p = game.checkGameOver();
		  if (p!= null)
			  view.farewell(p);
		 // view.window6.dispose();
		
	  }
	  if (buttonPressed.getActionCommand().equals("ChosenSingleTarget")) {
		  view.singleTarget.dispose();
		  Champion curr=null;
		  Cover c=null;
		  Point location=null;
		  if (view.t1Buttons.contains(buttonPressed)) {
			 int i= view.t1Buttons.indexOf(buttonPressed);
		      curr= (Champion) game.getFirstPlayer().getTeam().get(i);
		       location= curr.getLocation();
		  }
		  else if (view.t2Buttons.contains(buttonPressed)){
			int j= view.t2Buttons.indexOf(buttonPressed);
			 curr= (Champion) game.getSecondPlayer().getTeam().get(j);
			  location= curr.getLocation();
			  }
		  else {
			  int z= view.t3Buttons.indexOf(buttonPressed);
			  c= game.getCovers().get(z);
			   location= c.getLocation();
		  }
		  
		  int x= (int) location.getX();
		  int y= (int) location .getY();
		  System.out.println(x);
		  System.out.println(y);
		  try {
			  game.castAbility(a, x, y);
		  }
		  catch (Exception ex) {
			  view.catchException(ex.getMessage());
		  }
		  a=null;
		  ability=false;
		  view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());
		  view.setUpLeft(game.getTurnOrder());
		  initiateAbilityButton();
		  initiateEffectsButton();
		 // view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName());
		  //view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName());
		 // initiateFpButtons();
			//initiateSpButtons();
		  Player p = game.checkGameOver();
		  if (p!= null)
			  view.farewell(p);
		  view.singleTarget.dispose();
	  }
	  if (buttonPressed.getActionCommand().equals("DIRECTIONAL") && ability==true) {
		  String s=buttonPressed.getText();
		  a= Game.findAbilityByName(s);
		  view.window5.setVisible(true);
	  }
	  if (buttonPressed.getActionCommand().equals("Direction") && ability==true) {
		  String s= buttonPressed.getText();
		  Direction d= Direction.valueOf(s);
		  try {
			  game.castAbility(a, d);
		  }
		  catch (Exception ex) {
			  view.catchException(ex.getMessage());
		  }
		  a=null;
		  ability=false;
		  view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());
		  view.setUpLeft(game.getTurnOrder());
		  initiateAbilityButton();
		  initiateEffectsButton(); 
		  //view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName());
		 // view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName());
		  //initiateFpButtons();
			//initiateSpButtons();
		  Player p = game.checkGameOver();
		  if (p!= null)
			  view.farewell(p);
		  view.window5.dispose();
	  }
	  if( (buttonPressed.getActionCommand().equals("TEAMTARGET") ||buttonPressed.getActionCommand().equals("SELFTARGET")|| 
			  buttonPressed.getActionCommand().equals("SURROUND")) && ability==true ) {
		  String s=buttonPressed.getText();
		  a= Game.findAbilityByName(s);
		  try {
			  game.castAbility(a);
		  }
		  catch(Exception ex){
			  view.catchException(ex.getMessage());
		  }
	  a=null;
	  ability=false;
	  view.paint(game.getBoard(), game.getFirstPlayer().getTeam(), game.getSecondPlayer().getTeam());
	  view.setUpLeft(game.getTurnOrder());
	  initiateAbilityButton();
	  initiateEffectsButton();
	  //view.firstPlayerSetUp(game.getFirstPlayer().getTeam(), game.getFirstPlayer().getName());
	  //view.secondPlayerSetUp(game.getSecondPlayer().getTeam(), game.getSecondPlayer().getName());
	  //initiateFpButtons();
		//initiateSpButtons();
	  Player p = game.checkGameOver();
	  if (p!= null)
		  view.farewell(p);
	  view.window6.dispose();
	  }
	}   
	
	   
	public void initiateFpButtons() {
		for (int i=0;i<view.getFirstTeam().size(); i++) {
			JButton boooop= view.getFirstTeam().get(i);
			boooop.addActionListener(this);
		}
	}
	public void initiateSpButtons() {
		for (int i=0;i<view.getSecondTeam().size(); i++) {
			JButton toot= view.getSecondTeam().get(i);
			toot.addActionListener(this);
		}
	}
	
	public void initiateButtons() {
		for (int i=0; i<view.getChooseChampion().size(); i++) {
    		JButton j= view.getChooseChampion().get(i);
    		j.addActionListener(this);
    	}
	}
	public void initiateActionButtons() {
		view.ability.addActionListener(this);
		view.attack.addActionListener(this);
		view.move.addActionListener(this);
		view.endturn.addActionListener(this);
		view.leaderAbility.addActionListener(this);
	}

	public void initiateDirectionButtons() {
		view.up.addActionListener(this);
		view.down.addActionListener(this);
		view.left.addActionListener(this);
		view.right.addActionListener(this);
	}
	public void initiateAbilityButton() {
		view.champAbilities.addActionListener(this);
	}
	public void initiateEffectsButton() {
		view.appliedEffects.addActionListener(this);
	}

	public void initiateChooseAbilityButtons() {
		 for (int i=0; i<view.chooseAbility.size();i++) {
			  JButton j= view.chooseAbility.get(i);
			  j.addActionListener(this);
		  }
	}
	public void initiateTargetOptionButtons() {
		for (int i=0; i<view.t1Buttons.size();i++) {
			JButton j= view.t1Buttons.get(i);
			j.addActionListener(this);
		}
		for (int i=0; i<view.t2Buttons.size();i++) {
			JButton j= view.t2Buttons.get(i);
			j.addActionListener(this);
		}
		for (int i= 0; i<view.t3Buttons.size();i++) {
			JButton j= view.t3Buttons.get(i);
			j.addActionListener(this);
		}
	}
	public void initiateOkButton() {
		view.ok.addActionListener(this);
	}
	public static void main ( String[]args) {
		new Controller();
	}
}
