import java.util.Scanner;

public class AuthoringAssistant {
  public static char printMenu(Scanner scan){
    char use = 'b';
    do{
      System.out.println("\nMENU\nc - Number of non-whitespace characters");
      System.out.println("w - Number of words");
      System.out.println("f - Find text");
      System.out.println("r - Replace all !\'s");
      System.out.println("s - Shorten spaces");
      System.out.println("q - Quit");
      System.out.println("\nChoose an option:");
      use = scan.nextLine().charAt(0);
    }while(use!= 'w'&&use!='f'&&use!='r'&&use!='s'&&use!='q'&&use!='c');
    return use;
  }
  public static int getNumOfNonWSCharacters(String text){
      int numChar;
      int numWhite = 0;
      for(int i=0; i<text.length(); i++){
        char ch = text.charAt(i);
        boolean right = Character.isWhitespace(ch);
        if(right){
          numWhite++;
        }
      }
      numChar=text.length()-numWhite;
      return numChar;
  }
  public static int getNumOfWords(String text){
    int numWord = 1;
    if(text.charAt(0)==' '){
      numWord = 0;
    }
    int length = text.length()-1;
    for(int i=0; i<length; i++){
      char ch = text.charAt(i);
      char ch1 = text.charAt(i+1);
      boolean right = Character.isWhitespace(ch);
      boolean wrong = Character.isLetter(ch1);
      if(right&&wrong){
        numWord++;
      }
    }
    return numWord;
  }
  public static int findText(String find, String text){
    int instances = 0;
    int isThere = text.indexOf(find);
      while(isThere != -1){
        isThere = text.indexOf(find,isThere+1);
        instances++;
    }
    return instances;
  }
  public static String replaceExclamation(String text){
    for(int i=0; i<text.length(); i++){
      char ch = text.charAt(i);
      if(ch == '!'){
          text = text.replace('!', '.');
      }
    }
    return text;
  }
  public static String shortenSpace(String text){
    for(int i=0; i<text.length(); i++){
      if(Character.isWhitespace(text.charAt(0))){
        String text2 = text.substring(1,text.length());
        text = text2;
      }
    }
    for(int i=0; i<text.length(); i++){
      while(Character.isWhitespace(text.charAt(i))&&Character.isWhitespace(text.charAt(i+1))){
        text = text.replace("  ", " ");
      }
    }
    return text;
  }
  public static void main(String[] args) {
    /* Type your code here. */
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter a sample text:");
    String text = scan.nextLine();
    System.out.println("\nYou entered: " + text);
    boolean using = true;
    char user;
    String find;
    while(using){
      user = printMenu(scan);
      if(user == 'q'){
        using = false;
      }
      else if(user == 'c'){
        System.out.println("Number of non-whitespace characters: "+getNumOfNonWSCharacters(text));
      }
      else if(user == 'w'){
        System.out.println("Number of words: "+getNumOfWords(text));
      }
      else if(user == 'f'){
        System.out.println("Enter a word or phrase to be found:");
        find = scan.nextLine();
        System.out.println("\""+find+"\" instances: "+findText(find, text));
      }
      else if(user == 'r'){
        System.out.println("Edited text: "+replaceExclamation(text));
        text = replaceExclamation(text);
      }
      else if(user == 's'){
        System.out.println("Edited text: "+shortenSpace(text));
        text = shortenSpace(text);
      }
   }
 }
}
