import java.util.Scanner;

public class ParseStrings {
   public static void main(String[] args) {
      /* Type your code here. */
      String[] words = new String[2];
      Scanner scan = new Scanner(System.in);
      String user;
      boolean cont=true;
      int uses = 0;
      while(cont){
        if(uses > 0){
          System.out.println();
        }
        System.out.println("Enter input string:");
        user = scan.nextLine();
        char chara = user.charAt(0);
        if(chara=='q'){
          cont = false;
        }
        if(user.indexOf(',')==-1&&cont==true){
          System.out.println("Error: No comma in string.\n");
        }
        if(user.indexOf(',')>-1&&cont == true){
          words = user.split(",");
          System.out.print("First word: "+words[0].trim()+"\nSecond word: "+words[1].trim()+"\n");
        uses ++;
        }
      }
   }
}
