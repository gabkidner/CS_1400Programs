import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static PlayerRoster student = new PlayerRoster();
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
		test2();
		test3();
		test4();
		testArray4();
		test5a();
		test5b();
		test6a();
		testArray6();
		test6b();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1a(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n\n";
		correct += "ROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		String input = "84 7 23 4 4 5 30 2 66 9 q";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1a", result, correct);
	}
	static public void testArray1(){
		int[][] correct = {{84,7},{23,4},{4,5},{30,2},{66,9}};
		String input = "84 7 23 4 4 5 30 2 66 9 q";
		getOutput(input);
		int[][] result = student.players;
		compare("testArray1", result, correct);
	}
	static public void test1b(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n\n";
		correct += "ROSTER\nPlayer 1 -- Jersey number: 1, Rating: 4\nPlayer 2 -- Jersey number: 6, Rating: 9\nPlayer 3 -- Jersey number: 21, Rating: 5\nPlayer 4 -- Jersey number: 47, Rating: 8\nPlayer 5 -- Jersey number: 83, Rating: 2\n";
		String input = "1 4 6 9 21 5 47 8 83 2 q";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1b", result, correct);
	}
	static public void test2(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n";
		correct += "\nROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "84 7 23 4 4 5 30 2 66 9 q";
		String result = getOutput(input);
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n";
		correct += "\nROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "ROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "84 7 23 4 4 5 30 2 66 9 o q";
		String result = getOutput(input);
		compare("test3", result, correct);
	}
	static public void test4(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n";
		correct += "\nROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "Enter a jersey number:\nEnter a new rating for player:\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "ROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 6\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "84 7 23 4 4 5 30 2 66 9 u 4 6 o q";
		String result = getOutput(input);
		compare("test4", result, correct);
	}
	static public void testArray4(){
		int[][] correct = {{84,7},{23,4},{4,6},{30,2},{66,9}};
		String input = "84 7 23 4 4 5 30 2 66 9 u 4 6 o q";
		getOutput(input);
		int[][] result = student.players;
		compare("testArray4", result, correct);
	}
	static public void test5a(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n";
		correct += "\nROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "Enter a rating:\n\nABOVE 4\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "84 7 23 4 4 5 30 2 66 9 a 4 q";
		String result = getOutput(input);
		compare("test5a", result, correct);
	}
	static public void test5b(){
		String correct = "Enter a rating:\n\nABOVE 5\nPlayer 1 -- Jersey number: 12, Rating: 7\nPlayer 5 -- Jersey number: 90, Rating: 6\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "12 7 47 2 33 2 19 5 90 6 a 5 q";
		String result = getOutput(input);
		result = result.substring(result.length()-correct.length(),result.length());
		compare("test6a", result, correct);
	}
	static public void test6a(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n";
		correct += "\nROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "Enter a jersey number:\nEnter a new jersey number:\nEnter a rating for the new player:\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "ROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 15, Rating: 6\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "84 7 23 4 4 5 30 2 66 9 r 66 15 6 o q";
		String result = getOutput(input);
		compare("test6a", result, correct);
	}
	static public void testArray6(){
		int[][] correct = {{84,7},{23,4},{4,5},{30,2},{15,6}};
		String input = "84 7 23 4 4 5 30 2 66 9 r 66 15 6 o q";
		getOutput(input);
		int[][] result = student.players;
		compare("testArray6a", result, correct);
	}
	static public void test6b(){
		String correct = "Enter player 1's jersey number:\nEnter player 1's rating:\n\nEnter player 2's jersey number:\nEnter player 2's rating:\n\nEnter player 3's jersey number:\nEnter player 3's rating:\n\nEnter player 4's jersey number:\nEnter player 4's rating:\n\nEnter player 5's jersey number:\nEnter player 5's rating:\n";
		correct += "\nROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "Enter a jersey number:\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		correct += "ROSTER\nPlayer 1 -- Jersey number: 84, Rating: 7\nPlayer 2 -- Jersey number: 23, Rating: 4\nPlayer 3 -- Jersey number: 4, Rating: 5\nPlayer 4 -- Jersey number: 30, Rating: 2\nPlayer 5 -- Jersey number: 66, Rating: 9\n";
		correct += "\nMENU\nu - Update player rating\na - Output players above a rating\nr - Replace player\no - Output roster\nq - Quit\n\nChoose an option:\n";
		String input = "84 7 23 4 4 5 30 2 66 9 r 12 o q";
		String result = getOutput(input);
		compare("test6b", result, correct);
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
	public static void compare(String name, int[][] result, int[][] correct){
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
