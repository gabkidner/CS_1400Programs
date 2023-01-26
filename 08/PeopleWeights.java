import java.util.Scanner;
public class PeopleWeights {
  public static double[] userWeights = new double[5];
  public static void main(String[] args) {
    /* Type your code here. */
    double maxWeight = 3.4;
    Scanner scnr = new Scanner(System.in);
    for(int i=0; i<userWeights.length; i++){
      int x = i+1;
      System.out.println("Enter weight "+x+":");
      userWeights[i] = scnr.nextDouble();
    }
    System.out.println("You entered: "+userWeights[0]+" "+userWeights[1]+" "+userWeights[2]+" "+userWeights[3]+" "+userWeights[4]+" ");
    double tWeight= userWeights[0]+userWeights[1]+userWeights[2]+userWeights[3]+userWeights[4];
    System.out.println("\nTotal weight: "+tWeight);
    double avgWeight = tWeight/5;
    System.out.println("Average weight: "+avgWeight);
    		//testng for membership
	  for(double item : userWeights){
		 if(item >= userWeights[0]&&item >=userWeights[1]&&item >= userWeights[2]&&item>=userWeights[3]&&item>=userWeights[4]){
        maxWeight = item;
      }
    }
    System.out.println("Max weight: " + maxWeight);
  }
}
