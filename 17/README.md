(1) Prompt the user for a title for data. Output the title.
```
Enter a title for the data:
Number of Novels Authored
You entered: Number of Novels Authored
```
(2) Prompt the user for the headers of two columns of a table. Output the column headers.
```
Enter the column 1 header:
Author name
You entered: Author name

Enter the column 2 header:
Number of novels
You entered: Number of novels
```
(3) Prompt the user for data points. Data points must be in this format: *string, int*. Store the information before the comma into a string variable and the information after the comma into an integer. The user will enter `-1` when they have finished entering data points. Output the data points. Store the string components of the data points in an ArrayList of strings. Store the integer components of the data points in a second ArrayList of integers.
```
Enter a data point (-1 to stop input):
Jane Austen, 6
Data string: Jane Austen
Data integer: 6
```
(4) Perform error checking for the data point entries. If any of the following errors occurs, output the appropriate error message and prompt again for a valid data point.

- If entry has no comma
   - Output: `Error: No comma in string.`
- If entry has more than one comma
   - Output: `Error: Too many commas in input.`
- If entry after the comma is not an integer
   - Output: `Error: Comma not followed by an integer.`
```
Enter a data point (-1 to stop input):
Ernest Hemingway 9
Error: No comma in string.

Enter a data point (-1 to stop input):
Ernest, Hemingway, 9
Error: Too many commas in input.

Enter a data point (-1 to stop input):
Ernest Hemingway, nine
Error: Comma not followed by an integer.

Enter a data point (-1 to stop input):
Ernest Hemingway, 9
Data string: Ernest Hemingway
Data integer: 9
```
(5) Output the information in a formatted table. The title is right justified with a minimum of 33 characters. Column 1 is left justified with a minimum of 20 characters. Column 2 is right justified with a minimum of 23 characters.
```
        Number of Novels Authored
Author name         |       Number of novels
--------------------------------------------
Jane Austen         |                      6
Charles Dickens     |                     20
Ernest Hemingway    |                      9
Jack Kerouac        |                     22
F. Scott Fitzgerald |                      8
Mary Shelley        |                      7
Charlotte Bronte    |                      5
Mark Twain          |                     11
Agatha Christie     |                     73
Ian Fleming        |                     14
J.K. Rowling        |                     14
Stephen King        |                     54
Oscar Wilde         |                      1
```
(6) Output the information as a formatted histogram. Each name is right justified with a minimum of 20 characters.
```
         Jane Austen ******
     Charles Dickens ********************
    Ernest Hemingway *********
        Jack Kerouac **********************
 F. Scott Fitzgerald ********
        Mary Shelley *******
    Charlotte Bronte *****
          Mark Twain ***********
     Agatha Christie *************************************************************************
        Ian Fleming **************
        J.K. Rowling **************
        Stephen King ******************************************************
         Oscar Wilde *
```
