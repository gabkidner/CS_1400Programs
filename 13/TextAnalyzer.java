import java.util.Scanner;

public class TextAnalyzer {
   // Method counts the number of characters
   public static int getNumOfCharacters(final String usrStr) {
      /* Type your code here. */
      int numChar = 0;
      for(int i=0; i<usrStr.length(); i++){
        char ch = usrStr.charAt(i);
        boolean right = Character.isLetter(ch);
        if(right){
          numChar++;
        }
      }
      return numChar;
   }
   public static String outputWithoutWhitespace(String usrStr) {
    String noWhite = usrStr.replace(" ", "");
    return noWhite;
   }

   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter a sentence or phrase:");
      String usrStr = scan.nextLine();
      System.out.println("\nYou entered: "+usrStr);
      int numChar = getNumOfCharacters(usrStr);
      System.out.println("\nNumber of characters: "+numChar);
      System.out.println("String with no whitespace: "+outputWithoutWhitespace(usrStr));
   }
}
