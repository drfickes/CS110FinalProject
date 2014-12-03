import java.util.ArrayList;
import java.util.Random;

public class WarObj
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

   public WarObj() 
   {    
      deal();
   }
  
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
  
  public int getPileSize1()
  {
     return player1.size();
  }
  
  public int getPileSize2()
  {
     return player2.size();
     
  }
  
  //returns a 0 if game is over, a 1 if player 1 wins, a 2 if player 2 wins, or a 3 if it's a war
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
         int warResult = war();
         
         if (warResult == 0)
         {
            return 0;
         }
         
         else if(warResult == 1)
         {
            return 1;
         }
         
         else if(warResult ==2)
         {
            return 2;
         }
         
         else
         {
            return 3;
         }

      }         
   }
   
   catch(NullPointerException e)
   {
      determineWinner();
      winner = true;
      return 0;
   }

  
  }
  
  public int war()
  {
         try{
         
         warPile.add(card1);
         warPile.add(card2);
         
         System.out.println("It's a war!");
            
            card1 = player1.draw();
            card2 = player2.draw();
            warPile.add(card1);
            warPile.add(card2);
            
                       
            card1 = player1.draw();
            System.out.println("Player 1 draws a " + card1.toString());
            card2 = player2.draw();
            System.out.println("Player 2 draws a " + card2.toString());
            
                  
            if((card1.getRank()) > (card2.getRank()))
            {
               System.out.println("Player 1 wins the war!");
               player1.add(warPile);
               addCards(player1, card1, card2);
               warPile.clear();
               return 1;
            }
               
            else if((card1.getRank()) < (card2.getRank()))
            {
               System.out.println("Player 2 wins the war!");
               player2.add(warPile);
               addCards(player2, card1, card2);
               warPile.clear();
               return 2;
                     
            }
                  
            else
            {
               System.out.println("The war continues...");
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
  
  public int getRound()
  {
      return roundNum;
  }


}