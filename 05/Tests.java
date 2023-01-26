import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static TextMsgExpander student = new TextMsgExpander();
	static private ByteArrayOutputStream TOut;
	static private ByteArrayInputStream TIn;
	static private final PrintStream SOut = System.out;
	static private final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		testRepeating();
		testExpand1();
		testExpand2();
		testExpand3();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void testRepeating(){
		String correct = "Enter text:\nYou entered: IDK how that happened. TTYL.\n";
		String input = "IDK how that happened. TTYL.";
		String result = getOutput(input).substring(0,correct.length());
		compare("testRepeating", result, correct);
	}
	static public void testExpand1(){
		String correct = "Enter text:\nYou entered: IDK how that happened. TTYL.\n";
		correct += "\nReplaced \"IDK\" with \"I don't know\".\nReplaced \"TTYL\" with \"talk to you later\".\n";
		correct += "\nExpanded: I don't know how that happened. talk to you later.\n";
		String input = "IDK how that happened. TTYL.";
		String result = getOutput(input);
		compare("testExpand1", result, correct);
	}
	static public void testExpand2(){
		String correct = "Enter text:\nYou entered: I'll fix it. JK, you know IDK how.\n";
		correct += "\nReplaced \"IDK\" with \"I don't know\".\nReplaced \"JK\" with \"just kidding\".\n";
		correct += "\nExpanded: I'll fix it. just kidding, you know I don't know how.\n";
		String input = "I'll fix it. JK, you know IDK how.";
		String result = getOutput(input);
		compare("testExpand2", result, correct);
	}
	static public void testExpand3(){
		String correct = "Enter text:\nYou entered: Your bff, my BFF, and her BFF are all there.\n";
		correct += "\nReplaced \"BFF\" with \"best friend forever\".\n";
		correct += "\nExpanded: Your bff, my best friend forever, and her best friend forever are all there.\n";
		String input = "Your bff, my BFF, and her BFF are all there.";
		String result = getOutput(input);
		compare("testExpand3", result, correct);
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
