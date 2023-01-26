import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class Tests {
	static ShoppingCartPrinter student = new ShoppingCartPrinter();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;
	
	public static void main(String[] args){
		test1a();
		test1b();
		test1c();
		test2();
		test3();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1a(){
		String correct = "Chocolate Chips";
		ItemToPurchase item = new ItemToPurchase();
		item.setName("Chocolate Chips");
		String result = item.getName();
		compare("test1a", result, correct);
	}
	static public void test1b(){
		int correct = 3;
		ItemToPurchase item = new ItemToPurchase();
		item.setPrice(3);
		int result = item.getPrice();
		compare("test1b", result, correct);
	}
	static public void test1c(){
		int correct = 4;
		ItemToPurchase item = new ItemToPurchase();
		item.setQuantity(4);
		int result = 4;
		compare("test1c", result, correct);
	}
	static public void test2(){
		String correct = "Item 1\nEnter the item name:\nEnter the item price:\nEnter the item quantity:\n";
		correct += "\nItem 2\nEnter the item name:\nEnter the item price:\nEnter the item quantity:\n";
		String input = "Chocolate Chips\n3\n1\nBottled Water\n1\n10\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test2", result, correct);
	}
	static public void test3(){
		String correct = "Item 1\nEnter the item name:\nEnter the item price:\nEnter the item quantity:\n";
		correct += "\nItem 2\nEnter the item name:\nEnter the item price:\nEnter the item quantity:\n";
		correct += "\nTOTAL COST\nChocolate Chips 1 @ $3 = $3\n";
		correct += "Bottled Water 10 @ $1 = $10\n";
		correct += "\nTotal: $13\n";
		String input = "Chocolate Chips\n3\n1\nBottled Water\n1\n10\n";
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
