package engine;
import javax.swing.*;
import javax.swing.border.Border;

import model.abilities.Ability;
import model.abilities.CrowdControlAbility;
import model.abilities.DamagingAbility;
import model.abilities.HealingAbility;
import model.effects.Effect;
import model.world.Champion;
import model.world.Cover;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;
import java.util.ArrayList;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Component;
public class View extends JFrame   {
	 Border border = BorderFactory.createLineBorder(Color.BLACK);
     JFrame window;
     JFrame window2;
     JFrame window3;
     JFrame window4;
     JFrame window5;
     JFrame window6;
     JFrame beforewestart;
     JFrame gameover;
     JPanel farewell;
     JPanel instructions;
     JButton ok;
     JFrame singleTarget;
     JPanel s1;
     JPanel s2;
     JPanel s3;
     JPanel panel1;
     JPanel panel2;
     JPanel panel3;
     JPanel currDisplay;
     JPanel panel4;
     JPanel panel45;
     JPanel panel5;
     JPanel panel55;
     JPanel panel56;
     JPanel panel6;
     JPanel panel7;
     JPanel panel75;
     JPanel panel76;
     JPanel panel8;
     JPanel panel85;
     JPanel panel86;
     JPanel panel87;
     JPanel panel88;
     JPanel panel9;
     JPanel panel10;
     JPanel panel105;
     JPanel panel106;
     JPanel panelstart;
     JPanel popup;
     JPanel popup12;
     JPanel popup2;

     JPanel popup3;
     JButton button; 
     JButton champAbilities;
     JButton appliedEffects;
     JButton boop;
     JButton submit;
     JButton fpt;
     JButton spt;
     JButton move;
     JButton attack;
     JButton ability;
     JButton endturn;
     JButton leaderAbility;
     JButton up;
     JButton down;
     JButton left;
     JButton right;
     JTextField t1;
     JTextField t2;
     JTextArea text;
     JOptionPane error;
     JLabel t;
     JButton start;
      public ArrayList<JButton>chooseChampionButton;
     public ArrayList<JButton> firstTeam;
     public ArrayList<JButton> secondTeam;
      public ArrayList<JButton> chooseChampion;
      public ArrayList<JButton> chooseAbility;
      public ArrayList<JButton> t1Buttons;
      public ArrayList<JButton> t2Buttons;
      public ArrayList<JButton> t3Buttons;
      public View() {
    	  gameover= new JFrame("GAMEOVER");
    	  gameover.setSize(500,160);
    	  gameover.setResizable(false);
    	  gameover.setLocationRelativeTo(null);
    	  gameover.setDefaultCloseOperation(EXIT_ON_CLOSE);
    	  gameover.setVisible(false);
    	  farewell= new JPanel();
    	  beforewestart= new JFrame("Before we start...");
    	  beforewestart.setSize(500,160);
    	  beforewestart.setResizable(false);
    	  beforewestart.setLocationRelativeTo(null);
    	  beforewestart.setVisible(false);
    	  instructions= new JPanel();
    	  instructions.setLayout(new BorderLayout());
    	  singleTarget =new JFrame("Choose Your Target");
    	  singleTarget.setLayout(new BorderLayout());
    	  singleTarget.setSize(700,160);
    	  singleTarget.setResizable(false);
    	  singleTarget.setLocationRelativeTo(null);
    	  singleTarget.setVisible(false);
    	   s1= new JPanel();
    	  s2= new JPanel();
    	  s3= new JPanel();
    	  window3 =new JFrame("Champion's Abilities");
    	  window3.setLayout(new BorderLayout());
    	  window3.setSize(600,240);
    	  window3.setLocationRelativeTo(null);
    	  window3.setVisible(false);
    	  window4 =new JFrame("Champion's Applied Effect");
    	  window4.setSize(600,220);
    	  window4.setLocationRelativeTo(null);
    	  window4.setVisible(false);
    	  window5 =new JFrame("Direction");
    	  window5.setSize(300,220);
    	  window5.setLocationRelativeTo(null);
    	  
    	  window5.setVisible(false);
    	  window6 =new JFrame("Champion's Abilities");
    	  window6.setLayout(new BorderLayout());
    	  window6.setSize(300,130);
    	  window6.setLocationRelativeTo(null);
    	  window6.setVisible(false);
    	  window2 =new JFrame();
    	  window2.setSize(1363,763);
    	  window2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  window2.setLayout(new BorderLayout());
    	  window2.setVisible(false);
    	  window= new JFrame();
    	  window.setSize(1363,763);
    	  window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    	  window.setLayout(new BorderLayout());
    	   panel1= new JPanel();
    	  panel1.setPreferredSize(new Dimension(100,100));
    	  panel1.setBackground(Color.BLACK);
    	  JLabel l1= new JLabel();
    	  l1.setText("MARVEL ULTIMATE WAR");
    	  l1.setFont(new Font("Mv Boli", Font.PLAIN, 40));
    	  l1.setForeground(Color.WHITE);
    	  panel1.add(l1);
    	  window.add(panel1,BorderLayout.NORTH);
    	   panel2 = new JPanel();
    	  panel2.setLayout(new GridLayout(5,6));
    	  panel2.setPreferredSize(new Dimension(200,200));
    	  chooseChampion= new ArrayList<>();

    	   submit= new JButton("Submit");
    	   submit.setFont(new Font("Mv Boli", Font.PLAIN, 20 ));
    	   submit.setActionCommand("Submit");
    	  
    	   t1= new JTextField("Player 1");
    	   t2= new JTextField("Player 2");
    	  t1.setPreferredSize(new Dimension(100,40));
    	  t2.setPreferredSize(new Dimension(100,40));
    	   panel3= new JPanel();
    	   panel3.setPreferredSize(new Dimension(100,100));
    	   panel3.setBackground(Color.BLACK);
    	  panel3.add(t1);
    	  panel3.add(t2);
    	  panel3.add(submit, BorderLayout.SOUTH);
    	  panelstart= new JPanel();
    	  panelstart.setPreferredSize(new Dimension (100,130));
    	  panelstart.setBackground(Color.BLACK);
   
    	  panel4= new JPanel();
    	  text= new JTextArea();
    	  text.setLineWrap(true);
    	  text.setPreferredSize(new Dimension(300,600));
    	  panel4.add(text);
    	  panel5= new JPanel();
    	  panel5.setPreferredSize(new Dimension(300,200));
    	  panel5.setBorder(border);
    	  panel55= new JPanel();
    	  panel55.setPreferredSize(new Dimension(300,200));
    	  //panel55.setBackground(Color.BLACK);
    	  panel5.setLayout(new BorderLayout());
    	  panel56= new JPanel();
    	  panel56.setPreferredSize(new Dimension(300,200));
    	  panel56.setBackground(Color.BLACK);
    	  panel5.add(panel55, BorderLayout.CENTER);
    	  panel5.add(panel56, BorderLayout.SOUTH);
    	  panel6= new JPanel();
    	  panel6.setLayout(new GridLayout(5,5));
    	  
    	  panel7= new JPanel();
    	  panel7.setPreferredSize(new Dimension(100,130));
    	  panel7.setLayout(new BorderLayout());
    	  //panel7.setBackground(Color.BLUE);
    	  panel75=new JPanel();
    	  panel75.setLayout(new FlowLayout());
    	  panel75.setBackground(Color.RED);
    	  panel76= new JPanel();
    	  panel76.setLayout(new BorderLayout());
    	  panel8= new JPanel();
    	  panel8.setPreferredSize(new Dimension(100,130));
    	  panel8.setLayout(new BorderLayout());
    	  //panel8.setBackground(Color.RED);
    	  panel85=new JPanel();
    	  panel85.setLayout(new FlowLayout());
    	  panel85.setBackground(Color.BLUE);
    	  panel86= new JPanel();
    	  panel86.setLayout(new BorderLayout());
    	  panel10= new JPanel();
    	  panel10.setPreferredSize(new Dimension(300,200));
    	  
    	  panel10.setLayout(new BorderLayout());
    	  panel10.setBorder(border);
    	  panel106= new JPanel();
    	  panel106.setBackground(Color.BLACK);
    	  panel105= new JPanel();
    	  panel105.setBackground(Color.BLACK);
    	  currDisplay= new JPanel();
    	  currDisplay.setBackground(Color.BLACK);
    	  panel10.setBackground(Color.red);
    	  window2.add(panel10, BorderLayout.WEST);
    	  window2.add(panel5, BorderLayout.EAST);
    	  window.add(panel3, BorderLayout.WEST); 
    	 window.setVisible(true);
    	 
    	  popup3= new JPanel();
    	  popup3.setPreferredSize(new Dimension (170,170));
    	  popup3.setLayout(new BorderLayout());
    	  up= new JButton("UP");
    	  up.setActionCommand("Direction");
    	  down=new JButton("DOWN");
    	  down.setActionCommand("Direction");
    	  left=new JButton("LEFT");
    	  left.setActionCommand("Direction");
    	  right=new JButton("RIGHT");
    	  right.setActionCommand("Direction");
    	  popup3.add(up, BorderLayout.NORTH);
    	  popup3.add(down, BorderLayout.SOUTH);
    	  popup3.add(left, BorderLayout.WEST);
    	  popup3.add(right, BorderLayout.EAST);
    	 
    	  window5.add(popup3);
    	  
    	  move = new JButton("MOVE");
    	  move.setActionCommand("Move");
    	  move.setBorder(border);
    	  //move.setPreferredSize(new Dimension (20,50));
    	  attack= new JButton("ATTACK");
    	  attack.setActionCommand("Attack");
    	  attack.setBorder(border);
    	  //attack.setBackground(Color.BLACK);
    	  attack.setPreferredSize(new Dimension(75,50));
    	  ability= new JButton("ABILITY");
    	  ability.setActionCommand("Ability");
    	  ability.setBorder(border);
    	  ability.setPreferredSize(new Dimension(75,50));
    	  endturn= new JButton("END TURN");
    	  endturn.setActionCommand("Endturn");
    	  endturn.setBorder(border);
    	  endturn.setPreferredSize(new Dimension (20,50));
    	  leaderAbility= new JButton("LEADER ABILITY");
    	  leaderAbility.setActionCommand("LeaderAbility");
    	  leaderAbility.setBorder(border);
    	  leaderAbility.setPreferredSize(new Dimension(30,50));
    	  panel55.setLayout(new BorderLayout());
    	  panel55.add(move, BorderLayout.CENTER);
    	  panel55.add(leaderAbility, BorderLayout.NORTH);
    	  panel55.add(attack, BorderLayout.WEST);
    	  panel55.add(ability, BorderLayout.EAST);
    	  panel55.add(endturn, BorderLayout.SOUTH);
    	  
    	  popup= new JPanel();
    	  popup.setLayout(new FlowLayout());
    	  popup.setPreferredSize(new Dimension(500, 170));
    	  
    	  popup2=new JPanel();
    	  popup2.setLayout(new FlowLayout());
    	  
    	  popup12= new JPanel();
    	  popup12.setLayout(new FlowLayout());
    	  popup12.setPreferredSize(new Dimension(500, 30));
      }
      public void gameInstructions() {
    	  instructions.removeAll();
    	  instructions.revalidate();
    	  instructions.repaint();
    	  beforewestart.remove(instructions);
    	  beforewestart.revalidate();
    	  beforewestart.repaint();
    	  JTextArea t= new JTextArea();
    	    ok= new JButton("Select");
    	  ok.setActionCommand("Select");
    	  //ok.setPreferredSize(new Dimension(20,10));
    	  String s= "Both players should choose 3 champions." + "\n" + "Player 1 should begin." +"\n" + "The first champion chosen by each team "
    	  		+ "should be the leader." + "\n";
    	  t.setPreferredSize(new Dimension(600, 160));
    	  t.setText(s);
    	 
    	  instructions.add(t, BorderLayout.CENTER);
    	  instructions.add(ok, BorderLayout.SOUTH);
    	  beforewestart.add(instructions);
    	  beforewestart.setVisible(true);
      }
      public void displayChamps(ArrayList<Champion> c) {
    	  int j=0;
    	  for (int i=0; i< 30;i=i+2) {
    		 JButton button= new JButton();
    		 button.setText(c.get(j).getName());
    		  button.setActionCommand("ChooseChampion");
    		  button.setBorder(border);
    		  chooseChampion.add(button);
    	      panel2.add(button);
    	      //j++;
        	  Champion curr= c.get(j);
              String s="Type: " + curr.getClass().getSimpleName() + "\n" + "Speed: " + curr.getSpeed() + "\n" + "Attack Damage: " + curr.getAttackDamage()
               + "  Attack Range: " + curr.getAttackRange() + "\n" + "Health Points: " + curr.getMaxHP() + "  Mana: " +curr.getMana() + "\n" + "Abilities: "; 
              for (int z=0;z<curr.getAbilities().size();z++) {
                 s=  s+ curr.getAbilities().get(z).getName() +"\n ";
            	  }
            JTextArea text= new JTextArea(s);
            Border border = BorderFactory.createLineBorder(Color.BLACK);
            text.setBorder(border);
            text.setLineWrap(true);
             panel2.add(text);
        	  j++;
    	  }
    	  
    	  window.add(panel2, BorderLayout.CENTER);
    	  window.setVisible(true);
    	  
      }
      public void paint(Object [][] board, ArrayList<Champion> p1,ArrayList<Champion> p2 ) {
    	// panel6=new JPanel(new GridLayout(5,5));
    	 panel6.removeAll();
    	 panel6.revalidate();
    	 panel6.repaint();
    	  Border border = BorderFactory.createLineBorder(Color.BLACK);
    	  for (int i=4; i>=0;i--) {
    		  for (int j=0; j<5; j++) {
    			  Object o = board[i][j];
    			  JLabel t= new JLabel();
    			  if (o instanceof Champion) {
    				  Champion c= (Champion) o;
    				  String s= c.getName() +" " + "HP:" + c.getCurrentHP();
    				  t.setText(s);
    				  if (p1.contains(c)) {
    					  t.setForeground(Color.BLUE);
    				  }
    				  else {
    					  t.setForeground(Color.RED);
    				  }
    			  }
    			  else if (o instanceof Cover) {
    				  Cover poo= (Cover)o;
    				  int h= poo.getCurrentHP();
    				  String m= "V  " +"HP: " +  h;
    				  t.setText(m);
    			  }
    			  else if (o==null)
    			  { t.setText(null);}
    			  
    			  t.setBorder(border);
    			  panel6.add(t);
    			  panel6.setVisible(true);
    		  }  
    	  }
    	  window2.add(panel6, BorderLayout.CENTER);
    	 window2.revalidate();
    	  window2.repaint();
      }
      public void firstPlayerSetUp(ArrayList<Champion> c, String s, boolean u) {
    	  firstTeam= new ArrayList<JButton>();
    	  window2.remove(panel8);
    	  window2.revalidate();
    	  window2.repaint();
    	  panel85.removeAll();
    	  panel85.revalidate();
    	  panel85.repaint();
    	  panel86.removeAll();
    	  panel86.revalidate();
    	  panel86.repaint();
    	  JTextArea t= new JTextArea();
    	  t.setText(s);
    	  JTextArea t1= new JTextArea();
    	  if (u)
    		  t1.setText("LeaderAbility Used");
    	  else 
    		  t1.setText("Leader Ability Hasn't Been Used");
    	  panel85.add(t);
    	  for (int i=0;i< c.size();i++) {
    		  JButton fpt= new JButton();
    		  fpt.setText(c.get(i).getName());
    		  fpt.setActionCommand("FirstPlayerTeam");
    		  panel85.add(fpt);
    		 firstTeam.add(fpt);
    	  }
    	  panel85.add(t1);
    	  panel8.add(panel85, BorderLayout.CENTER);
    	  window2.add(panel8, BorderLayout.SOUTH);
    	  window2.setVisible(true);
      }
      public boolean isLeader(Champion c, Game g) {
    	  if (g.getFirstPlayer().getLeader()==c || g.getSecondPlayer().getLeader()==c)
    	      return true;
    	  return false;
      }
      public void displaySingleFTChamp(Champion curr, boolean isLeader) {
    	  window2.remove(panel8);
    	  window2.revalidate();
    	  window2.repaint();
    	  panel86.removeAll();
    	  panel86.revalidate();
    	  panel86.repaint();
    	  String s= "Champion: " + curr.getName() + "\n" + "Speed: " + curr.getSpeed() + "\n" + "Attack Damage: " + curr.getAttackDamage()
          + "\n" + "Attack Range: " + curr.getAttackRange() + "\n" + "Health Points: " + curr.getCurrentHP() +"\n" + "Mana: " +curr.getMana() + "\n"; 
 
          JTextArea j=new JTextArea();
        
          j.setPreferredSize(new Dimension(200, 150));
       
          j.setLineWrap(true);
          j.setText(s);
          j.setFont(new Font ("Mv Boli", Font.BOLD, 12));
          String s2;
           s2= "Type: " + curr.getClass().getSimpleName() + "\n";
           if (isLeader==true)
     		  s2+= "LEADER" + "\n" + "Applied Effects:" + "\n";
     	  else 
     		  s2+="NOT LEADER" + "\n" + "Applied Effects:" + "\n";
           String s3=null;
          for (int i=0; i< curr.getAppliedEffects().size(); i++) {
        	  Effect e= curr.getAppliedEffects().get(i);
        	  if (i< 3)
        	     s2+=  e.getName() + "  " + "Duration: " + e.getDuration() + "\n";
        	  else 
        		  s3+=  e.getName() + "  " + "Duration: " + e.getDuration() + "\n"; 
          }
          JTextArea j2=new JTextArea();
          j2.setPreferredSize(new Dimension(150, 150));
          j2.setLineWrap(true);
          j2.setText(s2);
          j2.setFont(new Font ("Mv Boli", Font.BOLD, 12));
          JTextArea j3=new JTextArea();
          j3.setPreferredSize(new Dimension(150, 150));
          j3.setLineWrap(true);
          j3.setText(s3);
          j3.setFont(new Font ("Mv Boli", Font.BOLD, 12));
          panel86.add(j2, BorderLayout.CENTER);
          panel86.add(j3, BorderLayout.EAST);
          panel86.add(j, BorderLayout.WEST);
          panel8.add(panel86, BorderLayout.WEST);
          window2.add(panel8,BorderLayout.SOUTH);
          window2.setVisible(true);
          
      }
      public void secondPlayerSetUp(ArrayList<Champion> c, String s, boolean u) {
    	  secondTeam= new ArrayList<JButton>();
    	  window2.remove(panel7);
    	  window2.revalidate();
    	  window2.repaint();
    	  panel75.removeAll();
    	  panel75.revalidate();
    	  panel75.repaint();
    	  panel76.removeAll();
    	  panel76.revalidate();
    	  panel76.repaint();
    	  JTextArea t= new JTextArea();
    	  t.setText(s);
    	  panel75.add(t);
    	  JTextArea t1= new JTextArea();
    	  if (u)
    		  t1.setText("LeaderAbility Used");
    	  else 
    		  t1.setText("Leader Ability Hasn't Been Used");
    	  for (int i=0;i< c.size();i++) {
    		  JButton spt= new JButton();
    		  spt.setText(c.get(i).getName());
    		  spt.setActionCommand("SecondPlayerTeam");
    		  panel75.add(spt);
    		 secondTeam.add(spt);
    	  }
    	  panel75.add(t1);
    	  panel7.add(panel75, BorderLayout.CENTER);
    	  window2.add(panel7, BorderLayout.NORTH);
    	  window2.setVisible(true);
      }
      public void displaySingleSTChamp(Champion curr, boolean isLeader) {
    	  window2.remove(panel7);
    	  window2.revalidate();
    	  window2.repaint();
    	  panel76.removeAll();
    	  panel76.revalidate();
    	  panel76.repaint();
    	  String s= "Champion: " + curr.getName() + "\n" + "Speed: " + curr.getSpeed() + "\n" + "Attack Damage: " + curr.getAttackDamage()
          + "\n" + "Attack Range: " + curr.getAttackRange() + "\n" + "Health Points: " + curr.getCurrentHP() +"\n" + "Mana: " +curr.getMana() +"\n" ; 
          JTextArea j=new JTextArea();
          j.setPreferredSize(new Dimension(200, 150));
          j.setLineWrap(true);
          j.setText(s);
          j.setFont(new Font ("Mv Boli", Font.BOLD, 12));
          String s2;
          String s3= null;
          s2= "Type: " + curr.getClass().getSimpleName() + "\n";
          if (isLeader==true)
     		  s2+= "LEADER" +"\n"+ "Applied Effects:" + "\n";
     	  else 
     		  s2+="NOT LEADER" +"\n" + "Applied Effects:" + "\n";
          for (int i=0; i< curr.getAppliedEffects().size(); i++) {
        	  Effect e= curr.getAppliedEffects().get(i);
        	  if (i<3)
        	    s2+= e.getName() + "  " + "Duration: " + e.getDuration() + "\n";
        	  else
        		  s3+= e.getName() + "  " + "Duration: " + e.getDuration() + "\n";
          }
          JTextArea j2=new JTextArea();
          j2.setPreferredSize(new Dimension(150, 150));
          j2.setLineWrap(true);
          j2.setText(s2);
          j2.setFont(new Font ("Mv Boli", Font.BOLD, 12));
          JTextArea j3=new JTextArea();
          j3.setPreferredSize(new Dimension(150, 150));
          j3.setLineWrap(true);
          j3.setText(s3);
          j3.setFont(new Font ("Mv Boli", Font.BOLD, 12));
          panel76.add(j2, BorderLayout.CENTER);
          panel76.add(j, BorderLayout.WEST);
          panel76.add(j3, BorderLayout.EAST);
          panel7.add(panel76, BorderLayout.WEST);
          window2.add(panel7,BorderLayout.NORTH);
          window2.setVisible(true);
          
      }
      public void setUpLeft(PriorityQueue turns) {
    	  Champion curr= (Champion) turns.peekMin();
    	  window2.remove(panel10);
    	  window2.revalidate();
    	  window2.repaint();
    	  panel10.removeAll();
    	  panel10.revalidate();
    	  panel10.repaint();
    	  panel106.removeAll();
    	  panel106.revalidate();
    	  panel106.repaint();
    	  panel105.removeAll();
    	  panel105.revalidate();
    	  panel105.repaint();
    	  currDisplay.removeAll();
    	  currDisplay.revalidate();
    	  currDisplay.repaint();
    	  PriorityQueue temp= new PriorityQueue(turns.size());
    	  JTextArea t= new JTextArea();
    	  String s= "TURN ORDER: " + "\n";
    	  while( (!turns.isEmpty())) {
    		 Champion c= (Champion) turns.remove() ;
    		 s+= c.getName() + "\n";
    		 temp.insert(c);
    	  }
    	  while (!temp.isEmpty())
    		  turns.insert(temp.remove());
    	  t.setPreferredSize(new Dimension (130, 160));
    	  t.setText(s);
    	  t.setFont(new Font ("Mv Boli", Font.BOLD, 14));
    	  t.setBorder(border);
    	  JTextArea t2= new JTextArea();
    	  panel105.add(t, BorderLayout.CENTER);
    	  
    	  String s2= "CURRENT CHAMP: " + curr.getName() + "\n"+ "Type: " + curr.getClass().getSimpleName() +"\n" +"Health Points: " + curr.getCurrentHP() +
    	 "\n" + "Mana: " +curr.getMana() +"\n"+"Speed: " + curr.getSpeed() + "\n" + "Attack Damage: " + curr.getAttackDamage()+ "\n" + "Attack Range: " + 
    	   curr.getAttackRange() + "\n" +"Action Points:" + curr.getCurrentActionPoints();  
    	  t2.setText(s2);
    	  t2.setFont(new Font ("Mv Boli", Font.BOLD, 14));
    	  t2.setBorder(border);
    	  t2.setPreferredSize(new Dimension(280, 220));
    	  champAbilities= new JButton();
    	  champAbilities.setText("Abilities");
    	  champAbilities.setActionCommand("ViewAbilities");
    	  champAbilities.setPreferredSize(new Dimension(100,30));
    	  appliedEffects= new JButton();
    	  appliedEffects.setText("Applied Effects");
    	  appliedEffects.setActionCommand("ViewAppliedEffects");
    	  appliedEffects.setPreferredSize(new Dimension(130,30));
    	  panel106.add(t2, BorderLayout.CENTER);
    	  panel106.setVisible(true);
    	  currDisplay.add(champAbilities);
    	  currDisplay.add(appliedEffects);
    	  panel10.add(currDisplay, BorderLayout.CENTER);
    	  panel10.add(panel106, BorderLayout.NORTH);
    	  panel10.add(panel105, BorderLayout.SOUTH);
    	  window2.add(panel10, BorderLayout.WEST);
    	 // window2.revalidate();
    	  //window2.repaint();
    	  window2.setVisible(true);
      }
      public void popUpAbilities(Champion c) {
    	  /*popup= new JPanel();
    	  popup.setLayout(new FlowLayout());
    	  popup.setPreferredSize(new Dimension(500, 170));*/
    	  window3.remove(popup);
    	  window3.revalidate();
    	  window3.repaint();
    	  popup.removeAll();
    	  popup.revalidate();
    	  popup.repaint();
    	  for (int i=0; i<c.getAbilities().size();i++) {
    		  Ability now= c.getAbilities().get(i);
    		  JTextArea a= new JTextArea();
    		  String s= "Ability: " + now.getName() + "\n" + "Area of Effect: " + now.getCastArea() +"\n" + "Cast Range: " + now.getCastRange() +"\n" + "Mana Cost: " + now.getManaCost() +"\n" + "Action Costs: " + now.getRequiredActionPoints() +"\n" +
    			"Current Cooldown: " + now.getCurrentCooldown()+ "\n" + "Base Cooldown: " + now.getBaseCooldown() + "\n" + "Type: " + now.getClass().getSimpleName() + "\n";
    		  if (now instanceof HealingAbility) {
    			  HealingAbility h= (HealingAbility) now;
    			  s+= "Heal Amount: " + h.getHealAmount();
    		  }
    		  else if (now instanceof DamagingAbility) {
    			  DamagingAbility d= (DamagingAbility) now;
    			  s+= "Damage Amount: " + d.getDamageAmount();
    		  }
    		  else {
    			  CrowdControlAbility cc= (CrowdControlAbility) now;
    			  s+= "Effect Name: " + cc.getEffect().getName() +"\n" + "Effect Duration: "+ cc.getEffect().getDuration();
    		  }
    		  a.setText(s);
    		  a.setPreferredSize(new Dimension (170, 170));
    		  a.setBorder(border);
    		  popup.add(a);
    	  }
    	  window3.add(popup, BorderLayout.CENTER);
    	 
    	  window3.revalidate();
    	 window3.repaint();
    	  window3.setVisible(true);
    	  
      }
      public void popUpEffects(Champion curr) {
    	  //window3.remove(popup);                          //reuse the same frame (efficiency mish aktar)
    	  /*popup2=new JPanel();
    	  popup2.setLayout(new FlowLayout());*/
    	  window4.remove(popup2);
    	  window4.revalidate();
    	  window4.repaint();
    	  popup2.removeAll();
    	  popup2.revalidate();
    	  popup2.repaint();
    	  for (int i=0; i<curr.getAppliedEffects().size();i++) {
    		  Effect e= curr.getAppliedEffects().get(i);
    		  JTextArea a= new JTextArea();
    		  String s= "Effect:  " + e.getName()+ "\n" + "Duration: " + e.getDuration();
    		  a.setText(s);
    		  a.setPreferredSize(new Dimension (170, 170));
    		  a.setBorder(border);
    		  popup2.add(a);
    	  }
    	  window4.add(popup2);
    	  window4.revalidate();
    	  window4.repaint();
    	  window4.setVisible(true);
      }
      public void catchException(String s) {
    	  JOptionPane.showMessageDialog(null, s, "Error", JOptionPane.ERROR_MESSAGE);
      }
      public void chooseAbility(Champion curr) {
    	  chooseAbility= new ArrayList<JButton>();
     	  window6.remove(popup2);
    	  window6.revalidate();
    	  window6.repaint();
    	  popup12.removeAll();
    	  popup12.revalidate();
    	  popup12.repaint();
    	  for (int i=0; i<curr.getAbilities().size(); i++) {
    		  JButton b = new JButton(curr.getAbilities().get(i).getName());
    		  chooseAbility.add(b);
    		  String s= curr.getAbilities().get(i).getCastArea().toString();
    		  System.out.print(s);
    		  b.setActionCommand(s);
    		  b.setPreferredSize(new Dimension(150, 20));
    		  b.setBorder(border);
    		  popup12.add(b);
    	  }
    	  window6.add(popup12);
    	  window6.setVisible(true);
      }
     public void singleTarget(ArrayList<Champion> t1, ArrayList<Champion> t2, Champion curr, ArrayList<Cover> covers) {
    	 t1Buttons= new ArrayList<JButton>();
    	 t2Buttons= new ArrayList<JButton>();
    	 t3Buttons= new ArrayList<JButton>();
    	 s1.removeAll();
         s1.revalidate();
         s1.repaint();
         s3.removeAll();
         s3.revalidate();
         s3.repaint();
         s2.removeAll();
         s2.revalidate();
         s2.repaint();
         singleTarget.remove(s1);
         singleTarget.remove(s2);
         singleTarget.revalidate();
         singleTarget.repaint(); 
         
         JLabel l1= new JLabel();
         JLabel l2= new JLabel();
         if (t1.contains(curr)) {
        	 l1.setText("YOUR TEAM: ");
        	 l2.setText("OPPONENT'S TEAM:");
         }
         else {
        	 l2.setText("YOUR TEAM: ");
        	 l1.setText("OPPONENT'S TEAM: ");
         }
         s1.add(l1);
         s2.add(l2);
         JLabel l3= new JLabel("COVER: ");
         s3.add(l3);
    	 for (int i=0; i<t1.size();i++) {
    		 Champion c= t1.get(i);
    		 JButton poo= new JButton();
    		 poo.setText(c.getName());
    		 poo.setActionCommand("ChosenSingleTarget");
    		 t1Buttons.add(poo);
    		 s1.add(poo);
    	 }
    	 System.out.println("trace2");
    	 for (int i=0; i<t2.size();i++) {
    		 Champion c= t2.get(i);
    		 JButton poo= new JButton();
    		 poo.setText(c.getName());
    		 poo.setActionCommand("ChosenSingleTarget");
    		 t2Buttons.add(poo);
    		 s2.add(poo);
    	 }
    	 for (int i=0; i< covers.size();i++) {
    		 Cover o= covers.get(i);
    		 String s = "Cover HP:" + o.getCurrentHP();
    		 JButton lol= new JButton(s);
    		 lol.setActionCommand("ChosenSingleTarget");
    		 t3Buttons.add(lol);
    		 s3.add(lol);
    	 }
    	 System.out.println("trace3");
    	 singleTarget.add(s3, BorderLayout.NORTH);
    	 singleTarget.add(s1, BorderLayout.CENTER);
    	 singleTarget.add(s2, BorderLayout.SOUTH);
    	// singleTarget.revalidate();
         //singleTarget.repaint();
    	 singleTarget.setVisible(true);
    	 
     }

     public void farewell(Player p) {
    	 String s= "Game Over" + "\n" + "Congratulations " + p.getName() + "\n" + "YOU WON!!!!!!";
    	 JLabel bye= new JLabel(s);
    	 farewell.add(bye);
    	 gameover.add(farewell);
    	 gameover.setVisible(true);
     }
      
      public ArrayList<JButton> getChooseChampion() {
		return chooseChampion;
	}
      public ArrayList<JButton> getFirstTeam() {
  		return firstTeam;
  	}
	
      public ArrayList<JButton> getSecondTeam() {
    		return secondTeam;
    	}
	public JTextField getT1() {
		return t1;
	}
	
	public JTextField getT2() {
		return t2;
	}
	
	public JButton getSubmit() {
		return submit;
	}
	
}
