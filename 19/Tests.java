import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Tests {
	static CaesarCipher student = new CaesarCipher();
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		testLetterCount();
		testEncrypt();
		testDecrypt();
		testOpenFile();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void testLetterCount(){
		int[] correct = {3,1,0,0,2,0,1,2,3,0,0,2,1,2,1,0,0,2,4,5,0,0,0,0,1,0};	
		String input = "Holy letters Batman, this is a string.";
		int[] result = Support.letterDistr(input);
		compare("testLetterCount", result, correct);
	}
	static public void testEncrypt(){
		String correct = "Hvwg wg am asggous.";
		String input = "This is my message.";
		String result = Support.encrypt(input, 14);
		compare("testEcrypt", result, correct);
	}
	static public void testDecrypt(){
		String correct = "This is my message."; 
		String input = "Hvwg wg am asggous.";
		String result = Support.decrypt(input, 14);
		compare("testDecrypt", result, correct);
	}
	static public void testOpenFile(){
		Scanner rinput = ReadWrite.openFile("secret.txt",new Scanner("abc"));
		String correct = "testOpenFile() in Test20 had an error.";
		try{
			Scanner cinput = new Scanner(new File("secret.txt"));
			correct = cinput.nextLine();
		}
		catch (FileNotFoundException e){
			System.out.println(e);
		}
		String result = rinput.nextLine();
		compare("testOpenFile", result, correct);
	}

  //setup methods
	public static void compare(String name, String result, String correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
	public static void compare(String name, int[] result, int[] correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
}
