import java.util.Scanner;

public class TextMsgDecoder {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter text:");
      String text = scan.nextLine();
      System.out.println("You entered: " + text);
      if (text.indexOf("BFF")>=0){
        System.out.println("BFF: best friend forever");
      }
      if (text.indexOf("IDK")>=0){
        System.out.println("IDK: I don't know");
      }
      if (text.indexOf("JK")>=0){
        System.out.println("JK: just kidding");
      }
      if (text.indexOf("TMI")>=0){
        System.out.println("TMI: too much information");
      }
      if (text.indexOf("TTYL")>=0){
        System.out.println("TTYL: talk to you later");
      }
   }
}
