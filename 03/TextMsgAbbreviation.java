import java.util.Scanner;

public class TextMsgAbbreviation {
   public static void main(String[] args) {
      /* Type your code here. */
      String user;
      Scanner scan = new Scanner(System.in);
      System.out.println("Input an abbreviation:");
      user = scan.next();
      if(user.equals("LOL")){
        System.out.println("laughing out loud");
      }
      else if(user.equals("IDK")){
        System.out.println("I don't know");
      }
      else if(user.equals("BFF")){
        System.out.println("best friends forever");
      }
      else if(user.equals("IMHO")){
        System.out.println("in my humble opinion");
      }
      else if(user.equals("TMI")){
        System.out.println("too much information");
      }
      else{
        System.out.println("Unknown");
      }
   }
}
