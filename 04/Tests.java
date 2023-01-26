import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static TextMsgDecoder student = new TextMsgDecoder();
	static private ByteArrayOutputStream TOut;
	static private ByteArrayInputStream TIn;
	static private final PrintStream SOut = System.out;
	static private final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		testShort1();
		testShort2();
		testLong1();
		testLong2();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	public static void testShort1(){
		String correct = "Enter text:\nYou entered: IDK if I'll go. It's my BFF's birthday.\n";
		String input = "IDK if I'll go. It's my BFF's birthday.";
		String result = getOutput(input).substring(0,correct.length());
		compare("testShort1", result, correct);
	}
	public static void testShort2(){
		String correct = "Enter text:\nYou entered: Nice pic, TMI haha JK. TTYL\n";
		String input = "Nice pic, TMI haha JK. TTYL";
		String result = getOutput(input).substring(0,correct.length());
		compare("testShort2", result, correct);
	}
	public static void testLong1(){
		String correct = "Enter text:\nYou entered: IDK if I'll go. It's my BFF's birthday.\n";
		correct += "BFF: best friend forever\nIDK: I don't know\n";
		String input = "IDK if I'll go. It's my BFF's birthday.";
		String result = getOutput(input);
		compare("testLong1", result, correct);
	}
	public static void testLong2(){
		String correct = "Enter text:\nYou entered: Nice pic, TMI haha JK. TTYL\n";
		correct += "JK: just kidding\nTMI: too much information\nTTYL: talk to you later\n";
		String input = "Nice pic, TMI haha JK. TTYL";
		String result = getOutput(input);
		compare("testLong2", result, correct);
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
