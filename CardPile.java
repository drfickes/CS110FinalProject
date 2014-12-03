/*David Fickes
CS 110
CardPile is any stack of cards, with no restrictions on pile size.
Contains all appropriate constructors, getters, and setters. Uses an array.
*/
import java.util.ArrayList;


public class CardPile
{
   private ArrayList<Card> pile = new ArrayList<Card>();
   
   //default constructor creates an empty card pile 
   public CardPile()
   {
   
   }
   
   //this constructor adds each card in an array of cards
   //to the card pile.
   public CardPile(Card[] cardArray, int arraySize)
   {
      for (int i = 0; i < arraySize; i++)
      {
         pile.add(cardArray[i]);
      }
   }
   
   public void add(Card newCard)
   {
      pile.add(newCard);
   }
   
   public void add(ArrayList<Card> cardArray)
   {
      for (int i = 0; i < cardArray.size(); i++)
      {
         add(cardArray.get(i));
      }
   }
   public void remove(int i)
   {
      pile.remove(i);
   }
      
   //draw method returns the top card of the pile and then deletes it
   public Card draw()
   {
      try
      {
         Card drawnCard = pile.get(0);
         pile.remove(0);
         return drawnCard;   
      }
      
      catch(IndexOutOfBoundsException e)
      {
         return null;
      }
   }
   
   public boolean isEmpty()
   {
      return pile.isEmpty();
   }
   
      
   public int size()
   {
      return pile.size();
   }
   
   public Card get(int i)
   {
      return pile.get(i);
   }
   
   

   
   

}