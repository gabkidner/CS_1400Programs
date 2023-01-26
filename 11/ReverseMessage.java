import java.util.Scanner;

//class
public class ReverseMessage{
	//main
	public static void main(String[] args) {
    //get message
    Scanner scan = new Scanner(System.in);
    String message = scan.nextLine();
    //call reverse
		String finalMesg = reverse(message);
    //print reversed
		System.out.println(finalMesg);
  }
	// reversing method called 'reverse'
  public static String reverse(String message){
		int x = 1;
		int y = message.length();
		String reversed = "";
		String reverse = "";
   	//do the reversing
		do{
			String letter = message.substring(message.length()-x, y);
			reverse += reversed.concat(letter);
			x++;
			y--;
		}while(x <= message.length());
		return reverse;
	}
}
