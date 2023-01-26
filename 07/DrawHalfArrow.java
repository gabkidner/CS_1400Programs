import java.util.Scanner;

public class DrawHalfArrow {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      int arrowBaseHeight;
      int arrowBaseWidth;
      int arrowHeadWidth;
      int cHeight = 0;
      int cWidth;
      System.out.println("Enter arrow base height:");
      arrowBaseHeight = scnr.nextInt();

      System.out.println("Enter arrow base width:");
      arrowBaseWidth = scnr.nextInt();

      System.out.println("Enter arrow head width:");
      arrowHeadWidth = scnr.nextInt();
      while(arrowHeadWidth <= arrowBaseWidth){
        System.out.println("Enter arrow head width:");
        arrowHeadWidth = scnr.nextInt();
      }
      // Draw arrow base (height = 3, width = 2)
      while(cHeight<arrowBaseHeight){
        System.out.println();
        cWidth = 0;
        while(cWidth<arrowBaseWidth){
          System.out.print("*");
          cWidth ++;
        }
        cHeight ++;
      }

      // Draw arrow head (width = 4)
      System.out.println();
      for(int i=0; i<arrowHeadWidth; i++){
        int chHeight = arrowHeadWidth;
        while(chHeight > i){
          System.out.print("*");
          chHeight --;
        }
        System.out.println();
      }
   }
}
