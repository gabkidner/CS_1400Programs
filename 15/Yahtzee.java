import java.util.Random;
import java.util.Scanner;
import java.util.Arrays;

public class Yahtzee {
  public static String printScore(int[] dice){
    //Check for Yahtzee
    int dup = 0;
    int[] oDice = new int[5];
    for(int i=0; i<5; i++){
      oDice[i]=dice[i];
    }
    Arrays.sort(dice);
    for(int i=0; i<dice.length-1; i++){
      if(dice[i]==dice[i+1]){
        dup++;
      }
    }
    if(dup>=2){
      System.out.print("2");
      if(dice[0]==dice[4]){
        return "Yahtzee";
      }
      else if(dice[0]==dice[3]||dice[1]==dice[4]){
        return "Four of a Kind";
      }
      else if(dice[0]==dice[2]&&dice[3]==dice[4]&&dice[4]!=dice[0]){
        return "Full House";
      }
      else if(dice[0]==dice[1]&&dice[2]==dice[4]&&dice[4]!=dice[0]){
        return "Full House";
      }
      else if(dice[0]==dice[2]||dice[1]==dice[3]||dice[2]==dice[4]){
        return "Three of a Kind";
      }
      else{
        return "You did not score anything noteworthy.";
      }
    }
    else if(dup==1){
      int small = 0;
      for(int i=0; i<4; i++){
        if(dice[i+1]-dice[i]==1){
          small++;
        }
      }
      if(small==3){
        return "Small Straight";
      }
      else{
        return "You did not score anything noteworthy.";
      }
    }
    else if(dup==0){
      if(dice[4]-dice[0]==4){
        return "Large Straight";
      }
      int small = 0;
      for(int i=0; i<4; i++){
        if(dice[i+1]-dice[i]==1){
          small++;
        }
      }
      if(small==3){
        return "Small Straight";
      }
      else{
        return "You did not score anything noteworthy.";
      }
    }
    else{
      return "You did not score anything noteworthy.";
    }
  }
  public static int[] kinds(int[] dice){
    int[] kinds = new int[6];
    for(int i=0; i<dice.length; i++){
      int kind = dice[i]-1;
      kinds[kind]++;
    }
    return kinds;
  }
  public static String printDice(int[] dice){
    String die=dice[0]+" "+dice[1]+" "+dice[2]+" "+dice[3]+" "+dice[4];
    System.out.println(die);
    return die;
  }
  public static int[] rerollDice(int[] dice, Scanner scnr, Random randGen, int hold){
    int reroll = 5-hold;
    for(int i=0; i<reroll; i++){
      System.out.println("Which die would you like to reroll?");
      int die = scnr.nextInt();
      while(die>5){
        System.out.println("Which die would you like to reroll?");
        die = scnr.nextInt();
      }
      die --;
      dice[die] = randGen.nextInt(6)+1;
    }
    System.out.println(Arrays.toString(dice));
    return dice;
  }
  public static int holding(Scanner scnr){
    System.out.println("How many dice would you like to hold?");
    int hold = scnr.nextInt();
    while(hold>5){
      System.out.println("How many dice would you like to hold?");
      hold = scnr.nextInt();
    }
    return hold;
  }
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    Random randGen = new Random();
    int[] dice = new int[5];
    int[] kinds = new int[6];
    int hold = 0;//number of dice not being rerolled
    int rounds = 2;//number of rerolls allowed


    //generate the initial dice roll - save it in an int[5]
    //for(int i=0; i<5; i++){
      //dice[i]=randGen.nextInt(6)+1;
    //}
    dice[0]=4;
    dice[1]=5;
    dice[2]=6;
    dice[3]=3;
    dice[4]=2;
    System.out.println(Arrays.toString(dice));
    System.out.println("The dice fall:");
    printDice(dice);

    //determine which dice to hold holding(scnr)
    hold = holding(scnr);
    System.out.println("You chose to reroll "+(5-hold)+" dice.");
    while(hold<5&&rounds>0){
      rounds--;
      dice = rerollDice(dice, scnr, randGen, hold);
		//ask and reroll some of the dice rerollDice(dice,x` scnr, randGen, hold)

      if(rounds>0){//only ask if there are rerolls left
        System.out.println("The dice fall:");
        printDice(dice);
	   //printDice(dice)
 		//determine which dice to hold holding(scnr)
        System.out.println();//newline
      }
    }//end re-roll loop
    kinds = kinds(dice);

    //final dice display
    System.out.println("The final dice are:");
    printDice(dice);
    //print(printDice(dice))

    //Display score
    System.out.println("Score:");
    //print(printScore(dice))
    System.out.println(printScore(dice));
    scnr.close();

   }//end main method

//int holding(Scanner scnr)
  /*This method asks how many of the 5 dice the palyer would like to keep (ie, not reroll)
  After getting the input, check to see if it was a valid number of dice and ask the player again if they did not put in a valid number of dice.
  Return the number of dice the player is holding.
  */

//int[] rerollDice(int[] dice, Scanner scnr, Random randGen, int hold)
  /*for the number of dice the player is not holding ask which die they would like to reroll and validate that is is a usable die number (1-5, dice there are 5 dice). generate a new random number for the selected die. Return the new dice array.*/


//String printDice(int[] dice)
   /*This methos creates a string representation of the dice array seperated by " "
   ie. rep = "1 2 3...", full credit will be given with or without a trailing " "
   */

//int[] kinds(int[] dice) method
   /*this method counts the number of unique values and stores them in an int array
   ie. dice of {1, 3, 3, 4, 6} yields [1,0,2,1,0,1] which is read as (one 1, zero 2s, two 3s, one 4, zero 5s, one 6)
   */

//String printScore(int[]dice) method
   /*this methiod returns a string representation of the different winning values. The test for this method is worth 7 points.
   possible return values
	      rep = "Yahtzee"; all dice the same value
	      rep = "Large Straight"; all dice in sequential order
	      rep = "Small Straight"; 4 dice in sequential order
	      rep = "Four of a Kind"; 4 dice with the same value
	      rep = "Full House"; 3 dice with the same value and another 2 dice with the same value
	      rep = "Three of a Kind"; 3 dice with the same value
	      rep = "You did not score anything noteworthy."; anything else
   */

}//end class Main
