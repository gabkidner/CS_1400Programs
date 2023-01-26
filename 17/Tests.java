import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static DataVisualizer student = new DataVisualizer();
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
		test4a();
		test4b();
		test4c();
		test5();
		test6();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}
	
	static public void test1(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n";
		String input = "Number of Novels Authored\nblank\nblank\n-1\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test1", result, correct);
	}
	static public void test2(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n\n";
		correct += "Enter the column 1 header:\nYou entered: Author name\n\n";
		correct += "Enter the column 2 header:\nYou entered: Number of novels\n\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\n-1\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n\n";
		correct += "Enter the column 1 header:\nYou entered: Author name\n\n";
		correct += "Enter the column 2 header:\nYou entered: Number of novels\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Jane Austen\nData integer: 6\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\nJane Austen,6\n-1\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test3", result, correct);
	}
	static public void test4a(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n\n";
		correct += "Enter the column 1 header:\nYou entered: Author name\n\n";
		correct += "Enter the column 2 header:\nYou entered: Number of novels\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: No comma in string.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: No comma in string.\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Ernest Hemingway\nData integer: 9\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\nErnest Hemingway 9\nErnest Hemingway9\nErnest Hemingway,9\n-1\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test4a", result, correct);
	}
	static public void test4b(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n\n";
		correct += "Enter the column 1 header:\nYou entered: Author name\n\n";
		correct += "Enter the column 2 header:\nYou entered: Number of novels\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Too many commas in input.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Too many commas in input.\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: F. Scott Fitzgerald\nData integer: 8\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\nF, Scott Fitzgerald, 8\nF. Scott, Fitzgerald, 8\nF. Scott Fitzgerald, 8\n-1\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test4b", result, correct);
	}
	static public void test4c(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n\n";
		correct += "Enter the column 1 header:\nYou entered: Author name\n\n";
		correct += "Enter the column 2 header:\nYou entered: Number of novels\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Comma not followed by an integer.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Comma not followed by an integer.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Comma not followed by an integer.\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Agatha Christie\nData integer: 73\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\nAgatha Christie,seventythree\nAgatha Christie,seventythree\nAgatha Christie,seventythree\nAgatha Christie,73\n-1\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test4c", result, correct);
	}
	static public void test5(){
		String correct = "Enter a title for the data:\nYou entered: Number of Novels Authored\n\n";
		correct += "Enter the column 1 header:\nYou entered: Author name\n\n";
		correct += "Enter the column 2 header:\nYou entered: Number of novels\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Jane Austen\nData integer: 6\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Charles Dickens\nData integer: 20\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: No comma in string.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: No comma in string.\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Ernest Hemingway\nData integer: 9\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Jack Kerouac\nData integer: 22\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Too many commas in input.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Too many commas in input.\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: F. Scott Fitzgerald\nData integer: 8\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Mary Shelley\nData integer: 7\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Charlotte Bronte\nData integer: 5\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Mark Twain\nData integer: 11\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Comma not followed by an integer.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Comma not followed by an integer.\n\n";
		correct += "Enter a data point (-1 to stop input):\nError: Comma not followed by an integer.\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Agatha Christie\nData integer: 73\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Ian Flemming\nData integer: 14\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: J.K. Rowling\nData integer: 14\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Stephen King\nData integer: 54\n\n";
		correct += "Enter a data point (-1 to stop input):\nData string: Oscar Wilde\nData integer: 1\n\n";
		correct += "Enter a data point (-1 to stop input):\n\n";
		correct += "        Number of Novels Authored\n";
		correct += "Author name         |       Number of novels\n";
		correct += "--------------------------------------------\n";
		correct += "Jane Austen         |                      6\n";
		correct += "Charles Dickens     |                     20\n";
		correct += "Ernest Hemingway    |                      9\n";
		correct += "Jack Kerouac        |                     22\n";
		correct += "F. Scott Fitzgerald |                      8\n";
		correct += "Mary Shelley        |                      7\n";
		correct += "Charlotte Bronte    |                      5\n";
		correct += "Mark Twain          |                     11\n";
		correct += "Agatha Christie     |                     73\n";
		correct += "Ian Flemming        |                     14\n";
		correct += "J.K. Rowling        |                     14\n";
		correct += "Stephen King        |                     54\n";
		correct += "Oscar Wilde         |                      1\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\nJane Austen,6\nCharles Dickens,20\nErnest Hemingway 9\nErnest hemingway9\nErnest Hemingway,9\nJack Kerouac,22\nF, Scott Fitzgerald,8\nF. Scott, Fitzgerald, 8    \nF. Scott Fitzgerald,8\nMary Shelley,7\nCharlotte Bronte,5\nMark Twain,11\nAgatha Christie,seventythree\nAgatha Christie,seventythree\nAgatha Christie,seventythree\nAgatha Christie,73\nIan Flemming,14\nJ.K. Rowling,14\nStephen King,    54\nOscar Wilde,1\n-1\n";
		String result = getOutput(input).substring(0, correct.length());
		compare("test5", result, correct);
	}
	static public void test6(){
		String correct = "        Number of Novels Authored\n";
		correct += "Author name         |       Number of novels\n";
		correct += "--------------------------------------------\n";
		correct += "Jane Austen         |                      6\n";
		correct += "Charles Dickens     |                     20\n";
		correct += "Ernest Hemingway    |                      9\n";
		correct += "Jack Kerouac        |                     22\n";
		correct += "F. Scott Fitzgerald |                      8\n";
		correct += "Mary Shelley        |                      7\n";
		correct += "Charlotte Bronte    |                      5\n";
		correct += "Mark Twain          |                     11\n";
		correct += "Agatha Christie     |                     73\n";
		correct += "Ian Flemming        |                     14\n";
		correct += "J.K. Rowling        |                     14\n";
		correct += "Stephen King        |                     54\n";
		correct += "Oscar Wilde         |                      1\n\n";
		correct += "         Jane Austen ******\n";
		correct += "     Charles Dickens ********************\n";
		correct += "    Ernest Hemingway *********\n";
		correct += "        Jack Kerouac **********************\n";
		correct += " F. Scott Fitzgerald ********\n";
		correct += "        Mary Shelley *******\n";
		correct += "    Charlotte Bronte *****\n";
		correct += "          Mark Twain ***********\n";
		correct += "     Agatha Christie *************************************************************************\n";
		correct += "        Ian Flemming **************\n";
		correct += "        J.K. Rowling **************\n";
		correct += "        Stephen King ******************************************************\n";
		correct += "         Oscar Wilde *\n";
		String input = "Number of Novels Authored\nAuthor name\nNumber of novels\nJane Austen,6\nCharles Dickens,20\nErnest Hemingway 9\nErnest hemingway9\nErnest Hemingway,9\nJack Kerouac,22\nF, Scott Fitzgerald,8\nF. Scott, Fitzgerald, 8    \nF. Scott Fitzgerald,8\nMary Shelley,7\nCharlotte Bronte,5\nMark Twain,11\nAgatha Christie,seventythree\nAgatha Christie,seventythree\nAgatha Christie,seventythree\nAgatha Christie,73\nIan Flemming,14\nJ.K. Rowling,14\nStephen King,    54\nOscar Wilde,1\n-1\n";
		String result = getOutput(input);
		result = result.substring(result.length()-correct.length(),result.length());
		compare("test6", result, correct);
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
