import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;
import java.io.FileNotFoundException;

public class BinConverter{
  public static String convert(int userInt){
    int x = 0;
    int zeros = 0;
    int s;
    int y;
    String what = "";
    String result = "";
    String usrBinar="";
    String a = "";
    String userStr = Integer.toBinaryString(userInt);
    //4-userStr.compareTo(a) = amount of 0's and then concat the begining x numbers, concat a space, then do the next 4 numbers.
    for(int i=0; i<userStr.length(); i++){
      x++;
      if(x==4){
        x=0;
        y = i+1;
        a = a.concat(userStr.substring(y-4,y));
      }
    }
    if(userStr.compareTo(a)>0){
      zeros = userStr.compareTo(a);
      s = userStr.length()-a.length();
      a = a.concat(userStr.substring(userStr.length()-s,userStr.length()));
      s = userStr.length()-a.length();
      for(int i =0; i<4-zeros; i++){
        result = result.concat("0");
      }
      //stops working here.
    }
    x = 0;
    for(int i=0; i<a.length(); i++){
      x++;
      if(i==zeros){
        result = result.concat(userStr.substring(0,i));
        result = result.concat(" ");
        x=1;
      }
      else if(x==4){
        y = i+1;
        result = result.concat(userStr.substring(y-4,y));
        result = result.concat(" ");
        x=0;
      }
    }
    return result.trim();
  }
  public static void write(String user){
    try{
      File file = new File("binary.txt");
      PrintWriter writer = new PrintWriter(file);
      writer.println(user);
      writer.close();
    }
    catch(FileNotFoundException e){
      System.out.println("blah");
    }
  }
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int userInt;
    System.out.println("input needed:");
    userInt = scan.nextInt();
    String user = convert(userInt);
    System.out.println(user);
    write(user);
  }
}
