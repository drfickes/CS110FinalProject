/*
David Fickes
CS 110
*/

/**
Holds basic information of a card. Contains relevant 
getters and setters.
*/

public class Card
{
   //assign each suit to an integer
   /**A constant that represents an integer value for the suit*/
   public static int SPADES = 1;
   /**A constant that represents an integer value for the suit*/
   public static int CLUBS = 2;
   /**A constant that represents an integer value for the suit*/
   public static int HEARTS = 3;
   /**A constant that represents an integer value for the suit*/
   public static int DIAMONDS = 4;
   //assign the face cards a numerical value
   /**A constant that represents an integer value for the rank*/
   public static int ACE = 1;
   /**A constant that represents an integer value for the rank*/
   public static int JACK = 11;
   /**A constant that represents an integer value for the rank*/
   public static int QUEEN = 12;
   /**A constant that represents an integer value for the rank*/
   public static int KING = 13;
   /**A constant that represents an integer value for the rank*/
   
   //the rank and suit for the particular card being created
   /**stores the card's suit*/
   private int suit;
   /**stores the card's rank*/
   private int rank;
   
   /**
   Creates a card with a suit and a rank.
   @param cardSuit a suit numbered 1-4, corresponding to Spades, clubs, hearts, and diamonds.
   @param cardRank a rank numbered 1-13, corresponding to ace, 1-10, Jack, Queen, and King.
   */
   public Card(int cardSuit, int cardRank)
   {
      //assign a suit and rank to the card upon creation
      suit = cardSuit;
      rank = cardRank;
   }
   
   /**returns card's suit as an integer*/
   public int getSuit()
   {
      return suit;
   }
   /**returns the card's rank as an integer*/
   public int getRank()
   {
      return rank;
   }
   /** returns the card's name as a string in the form RANK OF SUIT*/
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
   
   
   
   
   
   /** Compares toString method of two card objects to see if they are equal
   @param otherCard A second card object to compare to.*/
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
   
   /**gets the card name as a file name in the form cardPics/RANKSUIT.jpg*/
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
      return ("cardPics/" + rankName + suitName + ".jpg");
   }
}