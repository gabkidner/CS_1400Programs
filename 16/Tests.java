import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static ParseStrings student = new ParseStrings();
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
		test4();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1(){
		String correct = "Enter input string:\n";
		String input = "John, Simonsen\nq\n";
		String result = getOutput(input);
		result = result.substring(0, correct.length());
		compare("test1", result, correct);
	}
	static public void test2(){
		String correct = "Enter input string:\nError: No comma in string.\n\nEnter input string:\nError: No comma in string.\n\nEnter input string:\nError: No comma in string.\n\nEnter input string:\n";
		String input = "John Simonsen\nJohnSimonsen\nJohn  Simonsen\nq\n";
		String result = getOutput(input);
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "Enter input string:\nFirst word: John\nSecond word: Simonsen\n";
		String input = "John, Simonsen\nq\n";
		String result = getOutput(input);
		result = result.substring(0, correct.length());
		compare("test3", result, correct);
	}
	static public void test4(){
		String correct = "Enter input string:\nFirst word: John\nSecond word: Simonsen\n\n";
		correct += "Enter input string:\nFirst word: Luke\nSecond word: Skywalker\n\n";
		correct += "Enter input string:\nFirst word: Layton\nSecond word: UT\n\n";
		correct += "Enter input string:\n";
		String input = "John, Simonsen\nLuke , Skywalker\nLayton,UT\nq\n";
		String result = getOutput(input);
		compare("test4", result, correct);
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
