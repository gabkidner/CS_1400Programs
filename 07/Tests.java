import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static DrawHalfArrow student = new DrawHalfArrow();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1();
		test2();
		test3a();
		test3b();
		test4();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1(){
		String correct = "Enter arrow base height:\nEnter arrow base width:\nEnter arrow head width:\n";
		correct += "\n**\n**\n**\n**\n**\n";
		String input = "5 2 4";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1", result, correct);
	}
	static public void test2(){
		String correct = "Enter arrow base height:\nEnter arrow base width:\nEnter arrow head width:\n";
		correct += "\n***\n***\n";
		String input = "2 3 4";
		String result = getOutput(input).substring(0,correct.length());
		compare("test2", result, correct);
	}
	static public void test3a(){
		String correct = "Enter arrow base height:\nEnter arrow base width:\nEnter arrow head width:\n";
		correct += "\n***\n***\n***\n*******\n******\n*****\n****\n***\n**\n*\n";
		String input = "3 3 7";
		String result = getOutput(input);
		compare("test3a", result, correct);
	}
	static public void test3b(){
		String correct = "Enter arrow base height:\nEnter arrow base width:\nEnter arrow head width:\n";
		correct += "\n*\n*\n*\n*\n*\n***\n**\n*\n";
		String input = "5 1 3";
		String result = getOutput(input);
		compare("test3b", result, correct);
	}
	static public void test4(){
		String correct = "Enter arrow base height:\nEnter arrow base width:\nEnter arrow head width:\nEnter arrow head width:\nEnter arrow head width:\n";
		correct += "\n****\n****\n********\n*******\n******\n*****\n****\n***\n**\n*\n";
		String input = "2 4 3 4 8";
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

