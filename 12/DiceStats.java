import java.util.Scanner;
import java.util.Random;

public class DiceStats{
  public static int[] dice(int numRolls, Random randGen){
        int[] results = new int[11];
      // Roll dice numRoll times
      for(int i = 0; i < numRolls; ++i) {
          int die1 = randGen.nextInt(6) + 1;
          int die2 = randGen.nextInt(6) + 1;
          int rollTotal = die1 + die2;
          results[rollTotal-2]++;
    }
    return results;
  }

  public static String histogram(int[] results){
    String histogramStr = "Dice roll histogram:\n\n";
    for(int b=0; b<11; b++){
      int c = b+2;
      histogramStr+=(c+":\t");
      for(int i=0; i<results[b]; i++){
        histogramStr+=("*");
      }
      histogramStr+=("("+results[b]+")\n");
      }
    return histogramStr;
  }
  public static void main(String[] args) {
	  //Leave this code or your tests won't work
	  Random randGen = (args.length>0) ? new Random(Integer.parseInt(args[0])) : new Random();
	  //Don't delete ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

    Scanner scnr = new Scanner(System.in);
    int[] results;
    int i;          // Loop counter iterates numRolls times
    int numRolls;   // User defined number of rolls
    System.out.println("Enter number of rolls:");
    numRolls = scnr.nextInt();
    if(numRolls >= 1){
         results= dice(numRolls,randGen);
          // Print statistics on dice rolls
          System.out.print(histogram(results)+"\n");
       }
    else{
       System.out.println("Invalid rolls. Try again.");
    }
 }
}
