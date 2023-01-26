import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static DrawRightTriangle student = new DrawRightTriangle();
	static private ByteArrayOutputStream TOut;
	static private ByteArrayInputStream TIn;
	static private final PrintStream SOut = System.out;
	static private final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1();
		test2();
		test3();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1(){
		String correct = "Enter a character:\nEnter triangle height:\n";
		correct += "\n@ \n@ @ \n@ @ @ \n";
		String input = "@ 3";
		String result = getOutput(input);
		compare("test1", result, correct);
	}
	static public void test2(){
		String correct = "Enter a character:\nEnter triangle height:\n";
		correct += "\n% \n% % \n% % % \n% % % % \n% % % % % \n";
		String input = "% 5";
		String result = getOutput(input);
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "Enter a character:\nEnter triangle height:\n";
		correct += "\nm \nm m \nm m m \nm m m m \n";
		String input = "m 4";
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
	static public void setOutput(){
		TOut = new ByteArrayOutputStream();
		System.setOut(new PrintStream(TOut));
	}
	static private void setInput(String data){
		TIn = new ByteArrayInputStream(data.getBytes());
		System.setIn(TIn);
	}
	static private String getOutput(String input){
		setOutput();
		setInput(input);
		student.main(null);
		String result = TOut.toString();
		restoreSystem();
		return result;
	}
	static public void restoreSystem(){
		System.setOut(SOut);
		System.setIn(SIn);
	}
}
