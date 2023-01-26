import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests{
	static HelloWorld student = new HelloWorld();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}
  
	public static void test1(){
		String correct = "Hello World!\n";
		String result = getOutput("");
		compare("test1", result, correct);
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
