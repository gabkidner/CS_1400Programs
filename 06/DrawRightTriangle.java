import java.util.Scanner;

public class DrawRightTriangle {
  public static void main(String[] args) {
    Scanner scnr = new Scanner(System.in);
    char triangleChar;
    int triangleHeight;
    int curHeight;
    System.out.println("Enter a character:");
    triangleChar = scnr.next().charAt(0);
    System.out.println("Enter triangle height:");
    triangleHeight = scnr.nextInt();
    for(int i=0; i<=triangleHeight; i++){
      int cHeight = 0;
      while(cHeight < i){
        System.out.print(triangleChar+" ");
        cHeight ++;
      }
      System.out.println();
    }
  }
}
