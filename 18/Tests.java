import java.io.File;
import java.util.Scanner;
import java.io.FileNotFoundException;
public class Tests {
	static BinConverter student = new BinConverter();
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1();
		test2();
		test3();
		test4();
		test5();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1(){
		String correct = "1110";
		int input = 14;
		String result = student.convert(input);
		compare("test1", result, correct);
	}
	static public void test2(){
		String correct = "1111 1111";
		int input = 255;
		String result = student.convert(input);
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "1101 0101";
		int input = 213;
		String result = student.convert(input);
		compare("test3", result, correct);
	}
	static public void test4(){
		String correct = "1011 1011 1000";
		int input = 3000;
		String result = student.convert(input);
		compare("test4", result, correct);
	}
	static public void test5(){
		String correct = "0111 0011";
		int input = 115;
		student.write(student.convert(input));
		String result = "";
		try{
			File f = new File("binary.txt");
			Scanner scnr = new Scanner(f);
			result = scnr.nextLine();
			compare("test5", result, correct);
		}
		catch (FileNotFoundException e){
			testCount++;
			System.out.println("test5 Failed");
			System.out.println("\t"+e);
		}
	}

	public static void compare(String name, String result, String correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
}
