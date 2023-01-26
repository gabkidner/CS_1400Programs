import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.ArrayList;

public class Tests {
	static ShoppingCartManager student = new ShoppingCartManager();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1a();
		test1b();
		test2a();
		test2b();
		test3();
		test4();
		test5();
		test6();
		test7();
		test8a();
		test8b();
		test9a();
		test9b();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1a(){
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("Name: Bottled Water");
		correct.add("Description: Fiji, 12 oz.");
		correct.add("Price: 1");
		correct.add("Quantity: 10");

		ItemToPurchase item = new ItemToPurchase("Bottled Water", "Fiji, 12 oz.", 1, 10);
		ArrayList<String> result = new ArrayList<String>();
		result.add("Name: "+item.getName());
		result.add("Description: "+item.getDescription());
		result.add("Price: "+item.getPrice());
		result.add("Quantity: "+item.getQuantity());

		compare("test1a", result, correct);
	}
	static public void test1b(){
		String correct = "Volt color, Weightlifting shoes";

		ItemToPurchase item = new ItemToPurchase();
		item.setDescription("Volt color, Weightlifting shoes");
		String result = item.getDescription();

		compare("test1b", result, correct);
	}
	static public void test2a(){
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("Name: none");
		correct.add("Date: January 1, 2016");

		ShoppingCart cart = new ShoppingCart();
		ArrayList<String> result = new ArrayList<String>();
		result.add("Name: "+cart.getCustomerName());
		result.add("Date: "+cart.getDate());

		compare("test2a", result, correct);
	}
	static public void test2b(){
		ArrayList<String> correct = new ArrayList<String>();
		correct.add("Name: John Doe");
		correct.add("Date: August 17, 2019");

		ShoppingCart cart = new ShoppingCart("John Doe", "August 17, 2019");
		ArrayList<String> result = new ArrayList<String>();
		result.add("Name: "+cart.getCustomerName());
		result.add("Date: "+cart.getDate());

		compare("test2b", result, correct);
	}
	static public void test2c(){
		int correct = 6;

		ShoppingCart cart = new ShoppingCart();
		ItemToPurchase item = new ItemToPurchase();
		for(int i=0; i<6;i++){
			item = new ItemToPurchase();
			item.setQuantity(1);
			cart.addItem(item);
		}
		int result = cart.getNumItemsInCart();

		compare("test2c", result, correct);
	}
	static public void test2d(){
		int correct = 9;

		ShoppingCart cart = new ShoppingCart();
		ItemToPurchase item1 = new ItemToPurchase();
		ItemToPurchase item2 = new ItemToPurchase();
		item1.setPrice(2);
		item1.setQuantity(4);
		cart.addItem(item1);
		item2.setPrice(1);
		item2.setQuantity(1);
		cart.addItem(item2);
		int result = cart.getCostOfCart();

		compare("test2d", result, correct);
	}
	static public void test3(){
		String correct = "Enter Customer's Name:\nEnter Today's Date:\n\nCustomer Name: John Doe\nToday's Date: February 1, 2016\n\n";
		String input = "John Doe\nFebruary 1, 2016\nq\n";
		String result = getOutput(input).substring(0,correct.length());
		compare("test3", result, correct);
	}
	static public void test4(){
		String correct = "Enter Customer's Name:\nEnter Today's Date:\n\nCustomer Name: John Doe\nToday's Date: February 1, 2016\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\nChoose an option:\nChoose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\nf\ns\nq\n";
		String result = getOutput(input);
		compare("test4", result, correct);
	}
	static public void test5(){
		String correct = "Enter Customer's Name:\nEnter Today's Date:\n\nCustomer Name: John Doe\nToday's Date: February 1, 2016\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "OUTPUT SHOPPING CART\nJohn Doe's Shopping Cart - February 1, 2016\nNumber of Items: 0\n\nSHOPPING CART IS EMPTY\n\nTotal: $0\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\no\nq\n";
		String result = getOutput(input);
		compare("test5", result, correct);
	}
	static public void test6(){
		String correct = "OUTPUT ITEMS' DESCRIPTIONS\nJohn Doe's Shopping Cart - February 1, 2016\n\nItem Descriptions\nNike Romaleos: Volt color, Weightlifting shoes\nChocolate Chips: Semi-sweet\nPowerbeats 2 Headphones: Bluetooth headphones\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\na\nNike Romaleos\nVolt color, Weightlifting shoes\n189\n2\na\nChocolate Chips\nSemi-sweet\n3\n5\na\nPowerbeats 2 Headphones\nBluetooth headphones\n128\n1\ni\nq\n";
		String result = getOutput(input);
		result = result.substring(result.length()-correct.length(),result.length());
		compare("test6", result, correct);
	}
	static public void test7(){
		String correct = "Enter Customer's Name:\nEnter Today's Date:\n\nCustomer Name: John Doe\nToday's Date: February 1, 2016\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "ADD ITEM TO CART\nEnter the item name:\nEnter the item description:\nEnter the item price:\nEnter the item quantity:\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "OUTPUT SHOPPING CART\nJohn Doe's Shopping Cart - February 1, 2016\nNumber of Items: 2\n\nNike Romaleos 2 @ $189 = $378\n\nTotal: $378\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\na\nNike Romaleos\nVolt color, Weightlifting shoes\n189\n2\no\nq\n";
		String result = getOutput(input);
		compare("test7", result, correct);
	}
	static public void test8a(){
		String correct = "Enter Customer's Name:\nEnter Today's Date:\n\nCustomer Name: John Doe\nToday's Date: February 1, 2016\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "ADD ITEM TO CART\nEnter the item name:\nEnter the item description:\nEnter the item price:\nEnter the item quantity:\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "REMOVE ITEM FROM CART\nEnter name of item to remove:\nItem not found in cart. Nothing removed.\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\na\nNike Romaleos\nVolt color, Weightlifting shoes\n189\n2\nd\nSpectre DVD\nq\n";
		String result = getOutput(input);
		compare("test8a", result, correct);
	}
	static public void test8b(){
		String correct = "Enter Customer's Name:\nEnter Today's Date:\n\nCustomer Name: John Doe\nToday's Date: February 1, 2016\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "ADD ITEM TO CART\nEnter the item name:\nEnter the item description:\nEnter the item price:\nEnter the item quantity:\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "ADD ITEM TO CART\nEnter the item name:\nEnter the item description:\nEnter the item price:\nEnter the item quantity:\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "ADD ITEM TO CART\nEnter the item name:\nEnter the item description:\nEnter the item price:\nEnter the item quantity:\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "REMOVE ITEM FROM CART\nEnter name of item to remove:\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		correct += "OUTPUT SHOPPING CART\nJohn Doe's Shopping Cart - February 1, 2016\nNumber of Items: 3\n\nNike Romaleos 2 @ $189 = $378\nPowerbeats 2 Headphones 1 @ $128 = $128\n\nTotal: $506\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\na\nNike Romaleos\nVolt color, Weightlifting shoes\n189\n2\na\nChocolate Chips\nSemi-sweet\n3\n5\na\nPowerbeats 2 Headphones\nBluetooth headphones\n128\n1\nd\nChocolate Chips\no\nq\n";
		String result = getOutput(input);
		compare("test8b", result, correct);
	}
	static public void test9a(){
		String correct = "CHANGE ITEM QUANTITY\nEnter the item name:\nEnter the new quantity:\nItem not found in cart. Nothing modified.\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\na\nNike Romaleos\nVolt color, Weightlifting shoes\n189\n2\na\nChocolate Chips\nSemi-sweet\n3\n5\na\nPowerbeats 2 Headphones\nBluetooth headphones\n128\n1\nc\nThermos Stainless Steel King\n5\nq\n";
		String result = getOutput(input);
		result = result.substring(result.length()-correct.length(),result.length());
		compare("test9a", result, correct);
	}
	static public void test9b(){
		String correct = "OUTPUT SHOPPING CART\nJohn Doe's Shopping Cart - February 1, 2016\nNumber of Items: 9\n\nNike Romaleos 3 @ $189 = $567\nChocolate Chips 5 @ $3 = $15\nPowerbeats 2 Headphones 1 @ $128 = $128\n\nTotal: $710\n\n";
		correct += "MENU\na - Add item to cart\nd - Remove item from cart\nc - Change item quantity\ni - Output items' descriptions\no - Output shopping cart\nq - Quit\n\n";
		correct += "Choose an option:\n";
		String input = "John Doe\nFebruary 1, 2016\na\nNike Romaleos\nVolt color, Weightlifting shoes\n189\n2\na\nChocolate Chips\nSemi-sweet\n3\n5\na\nPowerbeats 2 Headphones\nBluetooth headphones\n128\n1\nc\nNike Romaleos\n3\no\nq\n";
		String result = getOutput(input);
		result = result.substring(result.length()-correct.length(),result.length());
		compare("test9b", result, correct);
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
	public static void compare(String name, ArrayList<String> result, ArrayList<String> correct){
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
