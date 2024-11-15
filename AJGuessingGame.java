//Abby Jahns, Darren Lagbao, Conner Havlicek
//09.27.24
//CS&145
//Lab 1: Reworking Guessing Game 
//Program runs a game that askes player to guess a number between 1 to 100.  
//Program responds higher or lower until they guess the right number.  
//Game loops until player responds 'no'

import java.util.*;

public class AJGuessingGame{
   public static void main (String[] args){
      //create constant for guessing game size
      int max = 100;
      
      //import random
      Random rand = new Random();
      
      int totalGuesses = 1;
      int gameCounter = 0;
      int bestGame = 9999;
      
      //call instructions method
      instructions(max);

      //do play game, while playAgain is not 'no'
      do {
         int randomNum = 1 + rand.nextInt(max);
         gameCounter++;
         System.out.println(randomNum); //cheat to show guess number
         System.out.println("\nI'm thinking of a number between 1 and "+max+"...");
         
         //resets counter for when game played again
         int guessCounter = 1;
         while (playGame(randomNum, guessCounter)) {   
            guessCounter++;
            totalGuesses++;
         }
         if (bestGame > guessCounter) {
             bestGame = guessCounter;
         } 
      } while (playAgain());    
      overallResults(gameCounter, totalGuesses, bestGame);
   }//end main method
   

   //prints out instruction to explain game
   public static void instructions(int max) {
      System.out.println("This program allows you to play a guessing game.");
      System.out.println("I will think of a number between 1 and");
      System.out.println(max+" and will allow you to guess until");
      System.out.println("you get it. For each guess, I will tell you");
      System.out.println("whether the right answer is higher or lower");
      System.out.println("than your guess.\n");
   }//end instructions method
   
   
   //playes guessing game
   //returns true to repeat loop bc wrong guess
   //return false if guessed right
   public static boolean playGame(int randomNum, int guesses) {
      //create scanner       
      Scanner input = new Scanner(System.in);
      
      System.out.print("Your guess? ");
      int guess = input.nextInt();
         
      if (guess < randomNum) {
         System.out.println("It's higher.");
         return true;
      } else if (guess > randomNum) {
         System.out.println("It's lower.");
         return true;
      } else {
         //for grammar
         if (guesses > 0) {
            System.out.println("You got it right in "+(guesses)+" guesses");
            return false;
         } else {
            System.out.println("You got it right in "+(guesses)+" guess");
            return false;
         }
      }//end higher/lower loop    
   }//end playGame method

   //testes if player wants to play again
   //returns false if 'no' entered
   public static boolean playAgain() {
      //create scanner, again     
      Scanner input = new Scanner(System.in);
      
      System.out.print("Do you want to play again? ");
      String again = input.next();
      again = again.substring(0,1);
      switch (again) {
         case "y":
         case "Y":
            return true;
         case "n":
         case "N":
            return false;
         default:
            System.out.println("This is not a valid input. Game will now quit.");
            return false;
      }
   }//end playAgain method
   

   //prints out results at end of play cycle
   public static void overallResults(double games, double guess, int best) {
      System.out.println("\nOverall results:");
      System.out.printf("\ttotal games = %.0f", games);
      System.out.printf("%n\ttotal guesses = %.0f", guess+(games-1));
      double ave = (guess+(games-1)) / games;
      System.out.printf("%n\tguesses/games = %.1f", ave);
      System.out.printf("%n\tbest game = %d", best);
   }//end overallResults method
   
}//end class
