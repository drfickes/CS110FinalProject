/*David Fickes
CS 110
Deck creates a CardPile with one of each standard
52 cards, and then automatically shuffles them.*/

import java.util.Random;

/**A card pile that starts with all standard 52 cards and then shuffles them.*/
public class Deck extends CardPile
{
   /**Creates each unique card in a standard deck and then shuffles them*/
   public Deck()
   {
      for(int i = 1; i<=4; i++)
      {
         for(int j = 1; j <= 13; j++)
         {
           add(new Card(i,j));
         }
      
      }
      
     shuffle();
   
   }
   
   /**Simulates shuffling by moving a random card to the end of the deck.*/
   public void shuffle()
   {
      for (int i = 0; i < 2000; i++)
      {
      Random rand = new Random();
      int randNum = rand.nextInt(52);
      //takes random card and puts it on the end
      add(get(randNum));
      remove(randNum);
      }
   }


}