Create a file called BinConverter.java. I won't be testing your main method for this assignment, but here's the sudocode for mine:
```
prompt user for an Integer
convert the Integer to a binary String
print the binary
write the binary String to a file
```
1) Create a method called "convert" that takes an Integer and returns a String. It should use Integer.toBinaryString() to do the base conversion and should work with any positive integer.
2) Expand converter to format the binary number in nibbles separated by spaces.
3) Expand converter again so that it adds leading 0s so that the binary number is always a multiple of 4 in length. Example with input 57:
```
0011 1001
```
4) The leading 0s and nibble spaces should work regardless of the length of the binary string. i.e. more than 2 nibbles
5) Create a method called "write" that takes a String and returns nothing. It should create a text file called "binary.txt" and write the binary string to it.
