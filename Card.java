/*
David Fickes
CS 110
the Card class creates a card with both a numerical value and a suit.
Also contains the methods getSuit, getRank, toString, and equals(otherCard:Card).
*/

public class Card
{
   //assign each suit to an integer
   public static int SPADES = 1;
   public static int CLUBS = 2;
   public static int HEARTS = 3;
   public static int DIAMONDS = 4;
   //assign the face cards a numerical value
   public static int ACE = 1;
   public static int JACK = 11;
   public static int QUEEN = 12;
   public static int KING = 13;
   
   //the rank and suit for the particular card being created
   private int suit;
   private int rank;
   
   public Card(int cardSuit, int cardRank)
   {
      //assign a suit and rank to the card upon creation
      suit = cardSuit;
      rank = cardRank;
   }
   
   //getSuit returns the corresponding suit integer
   public int getSuit()
   {
      return suit;
   }
   //getRank returns the card's rank
   public int getRank()
   {
      return rank;
   }
   //to string returns the card's name as a string
   public String toString()
   {
      String suitName;
      //converts the suit number to a string
      if (suit == 1)
      {
         suitName = "Spades";
      }
      else if (suit == 2)
      {
         suitName = "Clubs";
      }
      else if (suit == 3)
      {
         suitName = "Hearts";
      }
      else
      {
         suitName = "Diamonds";
      } 
   
      String rankName;
      //converts the rank to a face value if applicable
      if (rank == 1)
      {
         rankName = "Ace";
      }
      
      else if (rank == 11)
      {
         rankName = "Jack";
      }
   
      else if (rank == 12)
      {
         rankName = "Queen";
      }
      
      else if (rank == 13)
      {
         rankName = "King";
      }
      
      else
      {
         //if not a face value, convert numerical rank to a string
         rankName = Integer.toString(rank);
      }
      
      //return the name as a string
      return (rankName + " of " + suitName);
   }
   
   
   
   
   
   //equals checks to see if two card objects are equal
   public boolean equals(Card otherCard)
   {
      if (this.toString().equals(otherCard.toString()))
      {
         return true;
      }
      else
      {
         return false;
      }
   }
   
   public String getImage()
   {
      String suitName;
      //converts the suit number to a string
      if (suit == 1)
      {
         suitName = "s";
      }
      else if (suit == 2)
      {
         suitName = "c";
      }
      else if (suit == 3)
      {
         suitName = "h";
      }
      else
      {
         suitName = "d";
      } 
   
      String rankName;
      //converts the rank to a face value if applicable
      if (rank == 1)
      {
         rankName = "ace";
      }
      
      else if (rank == 11)
      {
         rankName = "jack";
      }
   
      else if (rank == 12)
      {
         rankName = "queen";
      }
      
      else if (rank == 13)
      {
         rankName = "king";
      }
      
      else
      {
         //if not a face value, convert numerical rank to a string
         rankName = Integer.toString(rank);
      }
      
      //return the name as a string
      return (suitName + rankName);
   }
}