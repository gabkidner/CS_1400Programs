import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Random;

public class Tests {
	static DiceStats student = new DiceStats();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		testDice1();
		testDice2();
		testHistogram1();
		testHistogram2();
		testAll1();
		testAll2();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}
	static public void testDice1(){
		int[] correct = {0,1,0,0,1,1,1,3,1,1,2};
		int[] result = student.dice(11,new Random(0));
		compare("testDice1", result, correct);
	}
	static public void testDice2(){
		int[] correct = {2,4,6,1,4,7,8,6,5,5,2};
		int[] result = student.dice(50,new Random(14));
		compare("testDice2", result, correct);
	}
	static public void testHistogram1(){
		String correct = "Dice roll histogram:\n\n";
		String star = "****(4)\n";
		for(int i=2; i<13; i++){
			correct += i+":\t"+star;
		}
		int[] input = {4,4,4,4,4,4,4,4,4,4,4};
		String result = student.histogram(input);
		compare("testHistogram1", result, correct);
	}
	static public void testHistogram2(){
		String correct = "Dice roll histogram:\n\n";
		correct += "2:\t**(2)\n"+"3:\t***(3)\n"+"4:\t*****(5)\n"+"5:\t***(3)\n";
		correct += "6:\t***(3)\n"+"7:\t***(3)\n"+"8:\t*****(5)\n"+"9:\t********(8)\n";
		correct += "10:\t****(4)\n"+"11:\t*(1)\n"+"12:\t***(3)\n";
		int[] input = {2,3,5,3,3,3,5,8,4,1,3};
		String result = student.histogram(input);
		compare("testHistogram2", result, correct);
	}
	static public void testAll1(){
		String correct = "Enter number of rolls:\nDice roll histogram:\n\n";
		correct += "2:\t**(2)\n3:\t****(4)\n4:\t******(6)\n5:\t*(1)\n6:\t****(4)\n";
		correct += "7:\t*******(7)\n8:\t********(8)\n9:\t******(6)\n10:\t*****(5)\n";
		correct += "11:\t*****(5)\n12:\t**(2)\n\n";
		String input = "50";
		String result = getOutput(input, 14);
		compare("testAll1", result, correct);
	}
	static public void testAll2(){
		String correct = "Enter number of rolls:\n";
		correct += "Invalid rolls. Try again.\n";
		String input = "0";
		String result = getOutput(input);
		compare("testAll2", result, correct);
	}

	public static void compare(String name, String result, String correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
	public static void compare(String name, int[] result, int[] correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
	public static void setOutput(){
		TOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(TOut));
	}
	private static void setInput(String data){
		TIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(TIn);
	}
	private static String getOutput(String input){
		String[] args = {};
		setOutput();
		setInput(input);
		student.main(args);
		String result = TOut.toString();
		restoreSystem();
		return result;
	}
	private static String getOutput(String input, int seed){
		String[] args = {""+seed};
		setOutput();
		setInput(input);
		student.main(args);
		String result = TOut.toString();
		restoreSystem();
		return result;
	}
	public static void restoreSystem(){
		System.setOut(SOut);
		System.setIn(SIn);
	}
}
