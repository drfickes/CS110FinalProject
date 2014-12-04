/*David Fickes
CS 110*/

import java.util.ArrayList;
import java.util.Random;

/**Creates an object containing all of the functions necessary to play a game of war.*/
public class WarObj
{

   /**Checks if there is currently a winner.*/
   boolean winner = false;
   /**Keeps track of the current round number.*/
   int roundNum = 0;
   /**CardPile object represents player 1's current pile*/
   CardPile player1 = new CardPile(); 
   /**CardPile object represents player 2's current pile*/
   CardPile player2 = new CardPile();
   /**Checks if a war is currently ongoing.*/
   boolean war = false;
   /**Array of Card objects used to store cards in the event of a war and facilitate potentially endless wars.*/
   ArrayList<Card> warPile = new ArrayList<Card>();
   /**Used for generating random numbers*/
   Random rand = new Random();
   /**Holds randomly generated numbers*/
   int randNum;
   /**Used for player 1's draws*/
   Card card1;
   /**Used for player 2's draws*/
   Card card2;
   /**Used to deal cards to both players*/   
   Deck deck = new Deck();

   /**Creates a deck and then deals it to both players, starting each with 26 cards*/
   public WarObj() 
   {    
      deal();
   }
  
  /**Adds cards to the specified player. Adds them randomly in order to ensure an infinite game can't occur.
  @param player The player to receive the cards.
  @param card1 Player 1's card.
  @param card2 Player 2's card.*/
  public void addCards(CardPile player, Card card1, Card card2)
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
  
  /**Checks both players' piles to determine the winner*/
  public int determineWinner()
  {
      if (player1.size() == 0)
      {
         return 2;
      }
      else
      {
         return 1;
      }

  }
  
  /**Alternately deals cards from a deck to both players*/
  public void deal()
  {
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
  }
  
  /**Returns the number of cards Player 1 currently has*/
  public int getPileSize1()
  {
     return player1.size();
  }
  
  /**Returns the number of cards Player 2 currently has*/
  public int getPileSize2()
  {
     return player2.size();
     
  }
  
  /**returns a 0 if game is over, a 1 if player 1 wins, a 2 if player 2 wins, or a 3 if it's a war*/
  public int battle()
  {
   roundNum++;
    
   try
   {
   
   card1 = player1.draw();
   card2 = player2.draw();
   
      if((card1.getRank()) > (card2.getRank()))
      {
         addCards(player1, card1, card2);
         return 1;
      }
      
      else if((card1.getRank()) < (card2.getRank()))
      {
         addCards(player2, card1, card2);
         return 2;
      }
      
      //code for wars
      else
      {
        return 3;
      }         
   }
   
   
   catch(NullPointerException e)
   {
      determineWinner();
      winner = true;
      return 0;
   }

  
  }
  
  /**Used in case of a tie. Each player places one card face down and another face up, and the face up cards are then compared.*/
  public int war()
  {
         try{
         
         warPile.add(card1);
         warPile.add(card2);
            
            card1 = player1.draw();
            System.out.println("Player 1 plays a card facedown.");
            card2 = player2.draw();
            System.out.println("Player 2 plays a card facedown.");
            System.out.println("Player 1 has " + getPileSize1() + " cards left");
            System.out.println("Player 2 has " + getPileSize2() + " cards left");
            warPile.add(card1);
            warPile.add(card2);
            
                       
            card1 = player1.draw();
            System.out.println("Player 1 draws a " + card1.toString());
            card2 = player2.draw();
            System.out.println("Player 2 draws a " + card2.toString());
            
                  
            if((card1.getRank()) > (card2.getRank()))
            {
               player1.add(warPile);
               addCards(player1, card1, card2);
               warPile.clear();
               return 1;
            }
               
            else if((card1.getRank()) < (card2.getRank()))
            {
               player2.add(warPile);
               addCards(player2, card1, card2);
               warPile.clear();
               return 2;
                     
            }
                  
            else
            {
               return 3;
            }
      }      
      catch(NullPointerException e)
      {
      determineWinner();
      winner = true;
      return 0;
      }
      
      
         
  }
  
  /**Returns the current round number*/
  public int getRound()
  {
      return roundNum;
  }
  
  /**Gets Player 1's card as an image name*/
  public String getCard1Img()
  {
   return card1.getImage();
  }
  
  /**Gets Player 2's card as an image name*/
  public String getCard2Img()
  {
   return card2.getImage();
  }


}