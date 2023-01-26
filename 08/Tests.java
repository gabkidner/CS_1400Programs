import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static PeopleWeights student = new PeopleWeights();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1a();
		testArray1();
		test1b();
		testArray2();
		test2();
		test3();
		test4a();
		test4b();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1a(){
		String correct = "Enter weight 1:\nEnter weight 2:\nEnter weight 3:\nEnter weight 4:\nEnter weight 5:\n";
		correct += "You entered: 236.0 89.5 142.0 166.3 93.0 \n";
		String input = "236.0 89.5 142.0 166.3 93.0";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1a", result, correct);
	}
	static public void testArray1(){
		double[] correct = {236,89.5,142.0,166.3,93};
		String input = "236.0 89.5 142.0 166.3 93.0";
		getOutput(input);
		double[] result = student.userWeights;
		compare("testArray1", result, correct);
	}
	static public void test1b(){
		String correct = "Enter weight 1:\nEnter weight 2:\nEnter weight 3:\nEnter weight 4:\nEnter weight 5:\n";
		correct += "You entered: 123.4 56.0 98.0 174.0 215.8 \n";
		String input = "123.4 56.0 98.0 174.0 215.8";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1b", result, correct);
	}
	static public void testArray2(){
		double[] correct = {123.4,56,98,174,215.8};
		String input = "123.4 56.0 98.0 174.0 215.8";
		getOutput(input);
		double[] result = student.userWeights;
		compare("testArray2", result, correct);
	}
	static public void test2(){
		String correct = "Enter weight 1:\nEnter weight 2:\nEnter weight 3:\nEnter weight 4:\nEnter weight 5:\n";
		correct += "You entered: 236.0 89.5 142.0 166.3 93.0 \n";
		correct += "\nTotal weight: 726.8\n";
		String input = "236.0 89.5 142.0 166.3 93.0";
		String result = getOutput(input).substring(0,correct.length());
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "Enter weight 1:\nEnter weight 2:\nEnter weight 3:\nEnter weight 4:\nEnter weight 5:\n";
		correct += "You entered: 236.0 89.5 142.0 166.3 93.0 \n";
		correct += "\nTotal weight: 726.8\n";
		correct += "Average weight: 145.35999999999999\n";
		String input = "236.0 89.5 142.0 166.3 93.0";
		String result = getOutput(input).substring(0,correct.length());
		compare("test3", result, correct);
	}
	static public void test4a(){
		String correct = "Enter weight 1:\nEnter weight 2:\nEnter weight 3:\nEnter weight 4:\nEnter weight 5:\n";
		correct += "You entered: 236.0 89.5 142.0 166.3 93.0 \n";
		correct += "\nTotal weight: 726.8\n";
		correct += "Average weight: 145.35999999999999\n";
		correct += "Max weight: 236.0\n";
		String input = "236.0 89.5 142.0 166.3 93.0";
		String result = getOutput(input);
		compare("test4a", result, correct);
	}
	static public void test4b(){
		String correct = "Enter weight 1:\nEnter weight 2:\nEnter weight 3:\nEnter weight 4:\nEnter weight 5:\n";
		correct += "You entered: 123.4 56.0 98.0 174.0 215.8 \n";
		correct += "\nTotal weight: 667.2\n";
		correct += "Average weight: 133.44\n";
		correct += "Max weight: 215.8\n";
		String input = "123.4 56.0 98.0 174.0 215.8";
		String result = getOutput(input);
		compare("test4b", result, correct);
	}

	//setup methods
	public static void compare(String name, String result, String correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
	public static void compare(String name, double[] result, double[] correct){
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
		setOutput();
		setInput(input);
		student.main(null);
		String result = TOut.toString();
		restoreSystem();
		return result;
	}
	public static void restoreSystem(){
		System.setOut(SOut);
		System.setIn(SIn);
	}
}
