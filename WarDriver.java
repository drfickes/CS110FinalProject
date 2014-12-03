public class WarDriver
{

  public static void main(String[] args) 
  {
      int winner = 99;
      WarObj game = new WarObj();
      boolean war = false;
            
      while (winner != 0)
      {
         System.out.println("Round No. " + game.getRound());
         winner = game.battle();
         
         if (winner == 1)
         {
            System.out.println("Player 1 wins the round!");
            System.out.println("Player 1 has " + game.getPileSize1() + " cards left");
            System.out.println("Player 2 has " + game.getPileSize2() + " cards left");
            
          }
          
          else if (winner == 2)
          {
            System.out.println("Player 2 wins the round!");
            System.out.println("Player 1 has " + game.getPileSize1() + " cards left");
            System.out.println("Player 2 has " + game.getPileSize2() + " cards left");
          }
          
          else
          {
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
                  System.out.println("Player 1 wins the war!");
                  System.out.println("Player 1 has " + game.getPileSize1() + " cards left");
                  System.out.println("Player 2 has " + game.getPileSize2() + " cards left");
                  war = false;
               }
           
               
               else if (winner == 2)
               {
               System.out.println("Player 2 wins the war!");
               System.out.println("Player 1 has " + game.getPileSize1() + " cards left");
               System.out.println("Player 2 has " + game.getPileSize2() + " cards left");
               war = false;
               }
               
               else
               {
               }
          }
          }
      
      
      }
      
      if (game.determineWinner() == 1)
      {
         System.out.println("Player 2 cannot draw another card. Player 1 wins!");
      }
      
      else
      {
         System.out.println("Player 1 cannot draw another card. Player 2 wins!");
      }
      
  
  }
  
  
}