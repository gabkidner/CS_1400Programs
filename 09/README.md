This program will store roster and rating information for a basketball team. Coaches rate players during tryouts to ensure a balanced team.

(1) Prompt the user to input five pairs of numbers: A player's jersey number and the player's rating. Store the jersey numbers and ratings in a 2D int array. Output the array in the format shown below (i.e., output the roster). *Note: the 2D array must be declared as <code>public static int[][] players;</code> outside of main for the tests to work.*

Ex:
```
Enter player 1's jersey number:
84
Enter player 1's rating:


Enter player 2's jersey number:
23
Enter player 2's rating:
4

Enter player 3's jersey number:
4
Enter player 3's rating:
5

Enter player 4's jersey number:
30
Enter player 4's rating:
2

Enter player 5's jersey number:
66
Enter player 5's rating:
9

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9
```
(2) Implement a menu of options for a user to modify the roster. Each option is represented by a single character. The program initially outputs the menu, and outputs the menu after a user chooses an option. The program ends when the user chooses the option to Quit. For this step, the other options do nothing.

Ex:
```
Enter player 1's jersey number:
84
Enter player 1's rating:
7

Enter player 2's jersey number:
23
Enter player 2's rating:
4

Enter player 3's jersey number:
4
Enter player 3's rating:
5

Enter player 4's jersey number:
30
Enter player 4's rating:
2

Enter player 5's jersey number:
66
Enter player 5's rating:
9

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
q
```
(3) Implement the "Output roster" menu option.

Ex:
```
Enter player 1's jersey number:
84
Enter player 1's rating:
7

Enter player 2's jersey number:
23
Enter player 2's rating:
4

Enter player 3's jersey number:
4
Enter player 3's rating:
5

Enter player 4's jersey number:
30
Enter player 4's rating:
2

Enter player 5's jersey number:
66
Enter player 5's rating:
9

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
o

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
q
```
(4) Implement the "Update player rating" menu option. Prompt the user for a player's jersey number. Prompt again for a new rating for the player. If the player exists, change that player's rating. If the player does not exist, go back to the main menu.

Ex:
```
Enter player 1's jersey number:
84
Enter player 1's rating:
7

Enter player 2's jersey number:
23
Enter player 2's rating:
4

Enter player 3's jersey number:
4
Enter player 3's rating:
5

Enter player 4's jersey number:
30
Enter player 4's rating:
2

Enter player 5's jersey number:
66
Enter player 5's rating:
9

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
u
Enter a jersey number:
4
Enter a new rating for player:
6

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
o

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 6
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
q
```
(5) Implement the "Output players above a rating" menu option. Prompt the user for a rating. Print the jersey number and rating for all players with ratings above the entered value. If there are no players above the rating, still print the ABOVE statement. The player number should match the roster.

Ex:
```
Enter player 1's jersey number:
84
Enter player 1's rating:
7

Enter player 2's jersey number:
23
Enter player 2's rating:
4

Enter player 3's jersey number:
4
Enter player 3's rating:
5

Enter player 4's jersey number:
30
Enter player 4's rating:
2

Enter player 5's jersey number:
66
Enter player 5's rating:
9

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
a
Enter a rating:
4

ABOVE 4
Player 1 -- Jersey number: 84, Rating: 7
Player 3 -- Jersey number: 4, Rating: 5
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
q
```
(6) Implement the "Replace player" menu option. Prompt the user for the jersey number of the player to replace. **If** the player is in the roster, **then** prompt again for a new jersey number and rating. Update the replaced player's jersey number and rating. If the player is not in the roster, go back to the main menu.

Ex:
```
Enter player 1's jersey number:
84
Enter player 1's rating:
7

Enter player 2's jersey number:
23
Enter player 2's rating:
4

Enter player 3's jersey number:
4
Enter player 3's rating:
5

Enter player 4's jersey number:
30
Enter player 4's rating:
2

Enter player 5's jersey number:
66
Enter player 5's rating:
9

ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 66, Rating: 9

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
r
Enter a jersey number:
10

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
o
ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 4, Rating: 5
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 15, Rating: 6

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
r
Enter a jersey number:
4
Enter a new jersey number:
14
Enter a rating for the new player:
1

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
o
ROSTER
Player 1 -- Jersey number: 84, Rating: 7
Player 2 -- Jersey number: 23, Rating: 4
Player 3 -- Jersey number: 14, Rating: 1
Player 4 -- Jersey number: 30, Rating: 2
Player 5 -- Jersey number: 15, Rating: 6

MENU
u - Update player rating
a - Output players above a rating
r - Replace player
o - Output roster
q - Quit

Choose an option:
q
```
