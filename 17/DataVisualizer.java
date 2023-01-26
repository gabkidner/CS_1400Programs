import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class DataVisualizer {
   public static void main(String[] args) {
      /* Type your code here. */
      ArrayList<Integer> numbs = new ArrayList<Integer>();
      ArrayList<String> author = new ArrayList<String>();
      Scanner scan = new Scanner(System.in);
      int skip = 0;
      int in = 0;
      int good = 0;
      String[] dataValue = new String[2];
      System.out.println("Enter a title for the data:");
      String title = scan.nextLine();
      System.out.println("You entered: "+title+"\n\nEnter the column 1 header:");
      String column1 = scan.nextLine();
      System.out.println("You entered: "+column1+"\n\nEnter the column 2 header:");
      String column2 = scan.nextLine();
      System.out.println("You entered: "+column2);
      boolean dataUse = true;
      int noSplit = 0;
      while(dataUse){
        skip = 0;
        noSplit = 0;
        System.out.println("\nEnter a data point (-1 to stop input):");
        String data = scan.nextLine();
        if(data.charAt(0)=='-'&&data.charAt(1)=='1'){
          skip = 1;
        }
        if(data.indexOf(',') == -1&&skip != 1){
          System.out.println("Error: No comma in string.");
          noSplit = 1;
        }
        if(data.indexOf(',')>=0&&data.lastIndexOf(',')!=data.indexOf(',')){
          System.out.println("Error: Too many commas in input.");
          noSplit = 1;
        }
        if(skip == 0&&noSplit == 0){
          dataValue = data.split(",");
          try{
            in = Integer.parseInt(dataValue[1].trim());
            author.add(dataValue[0]);
            numbs.add(in);
            good = 0;
            System.out.println("Data string: "+dataValue[0].trim()+"\nData integer: "+in);
          }
          catch(Exception excpt){
            System.out.println("Error: Comma not followed by an integer.");
          }
        }
        if(skip == 1){
          dataUse = false;
        }
      }
      int[] nu = new int[author.size()];
      int x = 0;
      for(int i:numbs){
        nu[x] = i;
        x++;
      }
      x=0;
      System.out.printf("\n%33s",title);
      System.out.println("");
      System.out.printf("%-20s",column1);
      System.out.printf("|%23s",column2);
      System.out.println("");
      for(int i=0;i<44;i++){
        System.out.print("-");
      }
      for(String i: author){
          String trimmed = i.trim();
          System.out.printf("\n%-20s",i);
          System.out.printf("|%23s",nu[x]);
          x++;
        }
      x = 0;
      System.out.println();
      for(String i: author){
        System.out.printf("\n%20s",i);
        System.out.print(" ");
        for(int a=0; a<nu[x]; a++){
          System.out.print("*");
        }
        x++;
      }
      System.out.println();
    }
  }
