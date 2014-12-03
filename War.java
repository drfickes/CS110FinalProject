/*David Fickes
CS 110
War is the driver for the card game*/

import java.util.ArrayList;
import java.util.Random;

public class War
{

  public static void main(String[] args) 
  {
   boolean winner = false;
   int roundNum = 0;
   CardPile player1 = new CardPile(); 
   CardPile player2 = new CardPile();
   boolean war = false;
   
   ArrayList<Card> warPile = new ArrayList<Card>();
   
   Random rand = new Random();
   int randNum;
   
   Card card1;
   Card card2;
      
   Deck deck = new Deck();
   
   //deals alternating cards to either player
   for (int i = 1; i<=52; i++)
   {
      Card card = deck.draw();
      if (i%2 != 0)
      {
         player1.add(card);
      }
      
      else
      {
         player2.add(card);  
      }
      
      
   
   }
   
   System.out.println("Player 1 has " + player1.size() + " cards left");
   System.out.println("Player 2 has " + player2.size() + " cards left");
   
   while(!winner)
   {
    
   roundNum++;
   System.out.println("Round No. " + roundNum);
   System.out.println("Player 1 has " + player1.size() + " cards left");
   System.out.println("Player 2 has " + player2.size() + " cards left");
   
   
   try
   {
   
   card1 = player1.draw();
   System.out.println("Player 1 draws a " + card1.toString());
   card2 = player2.draw();
   System.out.println("Player 2 draws a " + card2.toString());
   
      if((card1.getRank()) > (card2.getRank()))
      {
         System.out.println("Player 1 wins the round!");
         addCards(player1, card1, card2);
      }
      
      else if((card1.getRank()) < (card2.getRank()))
      {
         System.out.println("Player 2 wins the round!");
         addCards(player2, card1, card2);
      }
      
      //code for wars
      else
      {
         warPile.clear();
         warPile.add(card1);
         warPile.add(card2);
         
         war = true;
         while(war)
         {
            System.out.println("It's a war!");
            card1 = player1.draw();
            System.out.println("Player 1 draws a " + card1.toString());
            card2 = player2.draw();
            System.out.println("Player 2 draws a " + card2.toString());
            
                  
            if((card1.getRank()) > (card2.getRank()))
            {
               System.out.println("Player 1 wins the war!");
               player1.add(warPile);
               addCards(player1, card1, card2);
               war = false;
            }
               
            else if((card1.getRank()) < (card2.getRank()))
            {
               System.out.println("Player 2 wins the war!");
               player2.add(warPile);
               addCards(player2, card1, card2);
               war = false;
                     
            }
                  
            else
            {
               warPile.add(card1);
               warPile.add(card2);
            }
         }
      }         
   }
   
   catch(NullPointerException e)
   {
      if (player1.size() == 0)
      {
         System.out.println("Player 1 is out of cards!");
         winner = true;
      }
      else
      {
         System.out.println("Player 2 is out of cards!");
         winner = true;
      }
   }

   
      
   
   
   }
  
  }
  
  public static void addCards(CardPile player, Card card1, Card card2)
  {
      Random rand = new Random();
      int randNum = rand.nextInt(1);
      if(randNum == 0)
      {
         player.add(card1);
         player.add(card2);
      }
         else
      {
         player.add(card2);
         player.add(card1);
      }
  }
  
  
}
