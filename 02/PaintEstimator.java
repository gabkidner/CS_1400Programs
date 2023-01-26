import java.util.Scanner;
import java.lang.Math;     // Note: Needed for math functions in part (3)

public class PaintEstimator {
   public static void main(String[] args) {
      Scanner scnr = new Scanner(System.in);
      double wallHeight;
      double wallWidth;
      double wallArea;
      double gallons;
      int cans;
      System.out.println("Enter wall height (feet):");
      wallHeight = scnr.nextDouble();

      // FIXME (1): Prompt user to input wall's width
      System.out.println("Enter wall width (feet):");
      wallWidth = scnr.nextDouble();
      // Calculate and output wall
      // FIXME (1): Calculate the wall's area
      wallArea = wallHeight * wallWidth;
      // FIXME (1): Finish the output statement
      System.out.println("Wall area: " + wallArea + " square feet");
      // FIXME (2): Calculate and output the amount of paint in gallons needed to paint the wall
      gallons = wallArea / 350;
      System.out.println("Paint needed: " + gallons + " gallons");
      // FIXME (3): Calculate and output the number of 1 gallon cans needed to paint the wall, rounded up to nearest integer
      cans = (int)Math.ceil(wallArea / 350);
      System.out.println("Cans needed: " + cans + " can(s)");
   }
}
