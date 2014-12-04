/*David Fickes
CS 110
*/

import java.util.ArrayList;

/**Any stack of cards, with no restrictions on pile size.
Contains all appropriate constructors, getters, and setters. Holds cards in an array.
*/
public class CardPile
{
   /**Contains any number of Card objects*/
   private ArrayList<Card> pile = new ArrayList<Card>();
   
   /**default constructor creates an empty card pile*/
   public CardPile()
   {
   
   }
   
   /**Constructor that adds each card in an array of cards to the card pile.
   @param cardArray An array of Card objects to add to the card pile.
   @param arraySize The number of elements in the array.*/
   public CardPile(Card[] cardArray, int arraySize)
   {
      for (int i = 0; i < arraySize; i++)
      {
         pile.add(cardArray[i]);
      }
   }
   
   /**Adds a single Card object to the pile.
   @param newCard The card to be added.*/
   public void add(Card newCard)
   {
      pile.add(newCard);
   }
   
    /**Adds each card in an array of cards to the card pile.
   @param cardArray An array of Card objects to add to the card pile.*/

   public void add(ArrayList<Card> cardArray)
   {
      for (int i = 0; i < cardArray.size(); i++)
      {
         add(cardArray.get(i));
      }
   }
   
   /**Removes a card from the pile by its index.
   @param i The index of the card to remove*/
   public void remove(int i)
   {
      pile.remove(i);
   }
      
   /**Returns the top card of the pile and then deletes it, simulating a draw.*/
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
   
   /**Checks if the pile is empty and returns true or false.*/ 
   public boolean isEmpty()
   {
      return pile.isEmpty();
   }
   
   /**Returns the number of elements in the pile.*/   
   public int size()
   {
      return pile.size();
   }
   
   /**Gets the value of a card at an index.
   @param i The index of the card to get.*/
   public Card get(int i)
   {
      return pile.get(i);
   }
   
   

   
   

}