import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static PaintEstimator student = new PaintEstimator();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1();
		test2();
		test3();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	public static void test1(){
		String correct = "Enter wall height (feet):\nEnter wall width (feet):\nWall area: 100.0 square feet\n";
		String input = "10 10 ";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1", result, correct);
	}
	public static void test2(){
		String correct = "Enter wall height (feet):\nEnter wall width (feet):\nWall area: 350.0 square feet\nPaint needed: 1.0 gallons\n";
		String input = "25 14";
		String result = getOutput(input).substring(0,correct.length());
		compare("test2", result, correct);
	}
	public static void test3(){
		String correct = "Enter wall height (feet):\nEnter wall width (feet):\nWall area: 1071.0 square feet\nPaint needed: 3.06 gallons\nCans needed: 4 can(s)\n";
		String input = "25.5 42";
		String result = getOutput(input);
		compare("test3", result, correct);
	}

  //Set up methods
	public static void compare(String name, String result, String correct){
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
