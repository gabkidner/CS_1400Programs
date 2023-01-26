import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static TextAnalyzer student = new TextAnalyzer();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;
	
	public static void main(String[] args){
		test1();
		test2a();
		test2b();
		test3();
		test4a();
		test4b();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1(){
		String correct = "Enter a sentence or phrase:\n\nYou entered: The only thing we have to fear is fear itself.\n";
		String input = "The only thing we have to fear is fear itself.\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1", result, correct);
	}
	static public void test2a(){
		int correct = 36;
		String input = "The only thing we have to fear is fear itself.";
		int result = student.getNumOfCharacters(input);
		compare("test2a", result, correct);
	}
	static public void test2b(){
		int correct = 35;
		String input = "The rain in Spain stays mainly in the plain.";
		int result = student.getNumOfCharacters(input);
		compare("test2b", result, correct);
	}
	static public void test3(){
		String correct = "Enter a sentence or phrase:\n\nYou entered: The only thing we have to fear is fear itself.\n";
		correct += "\nNumber of characters: 36\n";
		String input = "The only thing we have to fear is fear itself.\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test3", result, correct);
	}
	static public void test4a(){
		String correct = "Enter a sentence or phrase:\n\nYou entered: The only thing we have to fear is fear itself.\n";
		correct += "\nNumber of characters: 36\n";
		correct += "String with no whitespace: Theonlythingwehavetofearisfearitself.\n";
		String input = "The only thing we have to fear is fear itself.\n";
		String result = getOutput(input);
		compare("test4a", result, correct);
	}
	static public void test4b(){
		String correct = "Enter a sentence or phrase:\n\nYou entered: The rain in Spain stays mainly in the plain.\n";
		correct += "\nNumber of characters: 35\n";
		correct += "String with no whitespace: TheraininSpainstaysmainlyintheplain.\n";
		String input = "The rain in Spain stays mainly in the plain.\n";
		String result = getOutput(input);
		compare("test4b", result, correct);
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
	public static void compare(String name, int result, int correct){
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
