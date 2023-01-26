import java.util.Scanner;

public class TextMsgExpander {
   public static void main(String[] args) {
      /* Type your code here. */
      Scanner scan = new Scanner(System.in);
      System.out.println("Enter text:");
      String user = scan.nextLine();
      System.out.println("You entered: "+user+"\n");
      if(user.indexOf("BFF")>-1){
        System.out.println("Replaced \"BFF\" with \"best friend forever\".");
      }
      if(user.indexOf("IDK")>-1){
        System.out.println("Replaced \"IDK\" with \"I don\'t know\".");
      }
      if(user.indexOf("JK")>-1){
        System.out.println("Replaced \"JK\" with \"just kidding\".");
      }
       if(user.indexOf("TMI")>-1){
        System.out.println("Replaced \"TMI\" with \"too much information\".");
      }
      if(user.indexOf("TTYL")>-1){
        System.out.println("Replaced \"TTYL\" with \"talk to you later\".");
      }
      String idk = user.replace("IDK","I don't know");
      String jk = idk.replace("JK","just kidding");
      String tmi = jk.replace("TMI","too much information");
      String ttyl = tmi.replace("TTYL","talk to you later");
      String bff = ttyl.replace("BFF","best friend forever");
      System.out.println("\nExpanded: "+bff);
   }
}
