/*David Fickes
CS 110
Deck creates a CardPile with one of each standard
52 cards, and then automatically shuffles them.*/

import java.util.Random;

public class Deck extends CardPile
{
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