import java.util.Random;
import java.util.Scanner;
public class CoinFlipper{
   public static void main(String[] args){
      Scanner scnr = new Scanner(System.in);
      int flips;
      int heads;
      //greet user
      System.out.println("Welcome to the Coin Flip Simulator!");
      System.out.print("How many times should I flip the coin: ");
      flips = scnr.nextInt();
      System.out.println();
      //flip the coin flips times, get back the number of heads
      heads = flipper(flips, 0);
      System.out.println("The coin has been flipped "+flips+" times.");
      System.out.println("There were "+heads+" heads and "+(flips-heads)+" tails.");
   }//end main

   public static int flipper(int flips, int seed){
     //don't mess with these lines
      int heads = 0;
      Random randGen = new Random(seed);
      // Write your code here
      int x = 0;
      do{
        if(randGen.nextInt(2) == 0){
            heads++;
        }
        x++;
      }while(x != flips);

      return heads;
   }//end flipper
}//end class
