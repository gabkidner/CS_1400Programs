Analyzing dice rolls is a common example in understanding probability and statistics. The following (DiceStats.java) calculates the number of times the sum of two dice (randomly rolled) equals six or seven.


Modify the program according to the following:

1. Create a method called "dice" that takes two parameters, an integer and an instance of class Random, and returns an integer array. The method should calculate the number of times the sum of the randomly rolled 2d6 equals each possible value from 2 to 12. Store the totals in an array where index 0 refers to the lowest sum (value 2).
2. Create a string method called "histogram" that takes has a single parameter of an integer array. This method should create a histogram string in which displays the the count of each sum  by having a * character that number of times, followed by the actual count, as shown below._Note: there is a tab character between the colon and the stars._

example:
```
Dice roll histogram:

2:  ******(6)
3:  ****(4)
4:  ***(3)
5:  ********(8)
6:  *******************(19)
7:  *************(13)
8:  *************(13)
9:  **************(14)
10: ***********(11)
11: *****(5)
12: ****(4)
```
3. Alter the code in main so that dice() and histogram() are called if a valid number of rolls were entered. 
