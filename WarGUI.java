/*David Fickes
CS 110*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

/**Contains the GUI for the war game.*/
public class WarGUI extends JFrame
{
   private WarObj game = new WarObj(); 
   private String buttonText = "fight!";
   private String title = "A game of war"; 
   private String message = "System Message";
   private String cardBackImg = "cardPics/back.jpg";
   private static final int WIDTH = 900;
   private static final int HEIGHT = 600;
   private String initialMessage = "Fight!";
   private String initialCards = "26";
   int winner;
   boolean war = false;
   
   private JLabel sysMessage;
   private JPanel gameFrame;
   private JLabel pileNum1;
   private JLabel pileNum2;
   private JLabel warPileNum1;
   private JLabel warPileNum2;
   private JLabel faceUp1;
   private JLabel faceUp2;
   private ImageIcon card1Img;
   private ImageIcon card2Img;
   
   /**Contains all basic setup for the GUI*/
   public WarGUI()
   {
      setTitle(title);
      setSize(WIDTH, HEIGHT);
      setVisible(true);
      setDefaultCloseOperation(EXIT_ON_CLOSE);
      setLayout(new GridLayout(3,0));
      
      
      JButton button = new JButton(initialMessage);
      button.addActionListener(new ButtonListener());
      
      sysMessage = new JLabel("Welcome to war!");
      
      ImageIcon cardBack = new ImageIcon(cardBackImg);
      JLabel pile1 = new JLabel(cardBack);
      JLabel pile2 = new JLabel(cardBack); 
      JLabel warPile1 = new JLabel(cardBack);
      JLabel warPile2 = new JLabel(cardBack);
      
      faceUp1 = new JLabel(cardBack);
      faceUp2 = new JLabel(cardBack);
      
      
      pileNum1 = new JLabel(initialCards);
      pileNum2 = new JLabel(initialCards);
      
      warPileNum1 = new JLabel("0");
      warPileNum2 = new JLabel("0");
      
      JLabel p1Label = new JLabel("Player 1");
      JLabel p2Label = new JLabel("Player 2");

      
      gameFrame = new JPanel();     
      gameFrame.setLayout(new GridLayout(2,6));
        
      add(button);  
      add(gameFrame);
      add(sysMessage);
      
      gameFrame.add(pile1);
      gameFrame.add(warPile1);
      gameFrame.add(faceUp1);
      gameFrame.add(faceUp2);
      gameFrame.add(warPile2);
      gameFrame.add(pile2);
      gameFrame.add(pileNum1);
      gameFrame.add(warPileNum1);
      gameFrame.add(p1Label);
      gameFrame.add(p2Label);
      gameFrame.add(warPileNum2);
      gameFrame.add(pileNum2);
      
      pack();
      setVisible(true);
      
      
      

    
   }
   
   /**Waits for the button to be pressed to continue the game of war. Currently does not pause for wars; known issue*/
   private class ButtonListener implements ActionListener
   {
      public void actionPerformed(ActionEvent e)
      {     
         
         
      

         System.out.println("Round No. " + game.getRound());
         winner = game.battle();
         System.out.println(game.getCard1Img());
         card1Img = new ImageIcon(game.getCard1Img());
         faceUp1.setIcon(card1Img);
         card2Img = new ImageIcon(game.getCard2Img());
         faceUp2.setIcon(card2Img);
         if (winner == 0)
         {
            if (game.determineWinner() == 1)
            {
            sysMessage.setText("Player 2 cannot draw another card. Player 1 wins!");
            }
      
      else
      {
         sysMessage.setText("Player 1 cannot draw another card. Player 2 wins!");
      }

         }
         else if (winner == 1)
         {
            sysMessage.setText("Player 1 wins the round!");
            pileNum1.setText(String.valueOf(game.getPileSize1()));
            pileNum2.setText(String.valueOf(game.getPileSize2()));
            
          }
          
          else if (winner == 2)
          {
            sysMessage.setText("Player 2 wins the round!");
            pileNum1.setText(String.valueOf(game.getPileSize1()));
            pileNum2.setText(String.valueOf(game.getPileSize2()));
          }
          
          else
          {
            sysMessage.setText("It's a war!");
            war = true;
            while (war == true)
            {
               winner = game.war();
               if (winner == 0)
               {
                  war = false;
               }
               
               else if (winner == 1)
               {
                  sysMessage.setText("Player 1 wins the war!");
                  pileNum1.setText(String.valueOf(game.getPileSize1()));
                  pileNum2.setText(String.valueOf(game.getPileSize2()));
                  war = false;
               }
           
               
               else if (winner == 2)
               {
               sysMessage.setText("Player 2 wins the war!");
               pileNum1.setText(String.valueOf(game.getPileSize1()));
               pileNum2.setText(String.valueOf(game.getPileSize2()));
               war = false;
               }
               
               else
               {
                  sysMessage.setText("The war continues...");
               }

          }
          

      
      }
      

    }   
      
   }
}
