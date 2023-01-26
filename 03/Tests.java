import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static TextMsgAbbreviation student = new TextMsgAbbreviation();
	static private ByteArrayOutputStream TOut;
	static private ByteArrayInputStream TIn;
	static private final PrintStream SOut = System.out;
	static private final InputStream SIn = System.in;
	static private int testCount = 0;
	static private int passed = 0;

	public static void main(String[] args){
		testLOL();
		testIDK();
		testUnknown();
		testBFF();
		testIMH();
		testIMHO();
		testTMI();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	public static void testLOL(){
		String correct = "Input an abbreviation:\nlaughing out loud\n";
		String input = "LOL";
		String result = getOutput(input);
		compare("testLOL", result, correct);
	}
	public static void testIDK(){
		String correct = "Input an abbreviation:\nI don't know\n";
		String input = "IDK";
		String result = getOutput(input);
		compare("testIDK", result, correct);
	}
	public static void testUnknown(){
		String correct = "Input an abbreviation:\nUnknown\n";
		String input = "XYZ";
		String result = getOutput(input);
		compare("testUnknown", result, correct);
	}
	public static void testBFF(){
		String correct = "Input an abbreviation:\nbest friends forever\n";
		String input = "BFF";
		String result = getOutput(input);
		compare("testBFF", result, correct);
	}
	public static void testIMH(){
		String correct = "Input an abbreviation:\nUnknown\n";
		String input = "IMH";
		String result = getOutput(input);
		compare("testIMH", result, correct);
	}
	public static void testIMHO(){
		String correct = "Input an abbreviation:\nin my humble opinion\n";
		String input = "IMHO";
		String result = getOutput(input);
		compare("testIMHO", result, correct);
	}
	public static void testTMI(){
		String correct = "Input an abbreviation:\ntoo much information\n";
		String input = "TMI";
		String result = getOutput(input);
		compare("testTMI", result, correct);
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
