Yahtzee is a game played with five 6-sided dice. The player rolls all dice and has 2 rerolls where they can choose any or all of the 5 dice to reroll to attempt to improve their score. The different scores explained as part of the printScores() method comments. To simplify this program, we'll code only 1 round with 1 player.

For this assignment, you'll be finishing this Yahtzee program. The main method is incomplete read the comments and infer what need to be completed. You'll also need to make 5 methods: method "holding" that takes a scanner object and returns an int, method "rerollDice" that takes an int array, scanner object, random object and int then returns an int array, method "kinds" that takes and returns an int array, method printDice() that takes an int array and returns a string, and method printScores() that takes an int array and returns a string. There are more details in the template provided, so be sure to **READ ALL THE COMMENTS**.

You may want to sort the array before scoring it. (My solution doesn't require sorting, but yours might.)
```
import java.util.Arrays;
Arrays.sort(array_name);
```
If you want to print out a string version of your array (for debugging purposes) here's how you do it
```
import java.util.Arrays;
System.out.println(Arrays.toString(array_name));
```
