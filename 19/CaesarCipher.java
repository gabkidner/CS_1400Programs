import java.util.InputMismatchException;
import java.util.Scanner;
import java.io.File;
import java.io.PrintWriter;

public class CaesarCipher{
	public static void main(String[] args){
	Scanner in = new Scanner(System.in);
	System.out.println("Welcome to the Caesar Cipher!\nThis utility will let you encrypt and decrypt a message"
				+ " from a file you provide.");
		int userChoice = -1;
		int cipher = 0;
		String file;
		String again = "yes";
		String message = "";
		String menu = "\n"
				+ "Short messages\n"
				+ "Option 1: Encrypt a Message\n"
				+ "Option 2: Decrypt a Message\n"
				+ "Long messages\n"
				+ "Option 3: Encrypt a Text File\n"
				+ "Option 4: Decrypt a Text File\n"
				+ "Other Functions\n"
				+ "Option 5: Letter Distribution Analysis\n"
				+ "Option 0: Exit Program\n";


		while (userChoice == 0) {
			if(again.equalsIgnoreCase("yes")||again.equalsIgnoreCase("y")){
				System.out.print(menu);
			}
			System.out.print("What is your choice?: ");
			try {
				userChoice = in.nextInt();
				in.nextLine();
			}
			catch (InputMismatchException e) {
				System.out.println("Input was not a number.");
				in.nextLine();
				userChoice = -1;
			}
			//make a switch case for the menu
				//encrypt message
				System.out.println("Enter your short message: ");
				message = in.nextLine();
				cipher = get_num(in);
				System.out.println(Support.encrypt(message,cipher));

				//decrypt message
				System.out.println("Enter your short message: ");
				message = in.nextLine();
				cipher = get_num(in);
				System.out.println(Support.decrypt(message, cipher));

				//encrypt text file
				file = get_name(in);
				if(file.equals("n")){
					break;
				}
				else{
					cipher = get_num(in);
					message = ReadWrite.read(ReadWrite.openFile(file,in));
					ReadWrite.write("Encrypted.txt", Support.encrypt(message, cipher));
					System.out.println("Encrypted message saved to Encrypted.txt");
				}
				//decrypt text file
				file = get_name(in);
				if(file.equals("n")){
					break;
				}
				else{
					cipher = get_num(in);
					message = ReadWrite.read(ReadWrite.openFile(file,in));
					ReadWrite.write("Decrypted.txt", Support.decrypt(message, cipher));
					System.out.println("Decrypted message saved to Decrypted.txt");
				}

				//letter distribution
				String temp = "a";
				while(!temp.equalsIgnoreCase("y") && !temp.equalsIgnoreCase("n")){
					System.out.print("Is the message in a file (y/n)?: ");
					temp = in.nextLine();
				if(temp.equalsIgnoreCase("n")){
					System.out.println("Enter your encrypted message: ");
					message = in.nextLine();
				}
					//end enter message
				else{
					file = get_name(in);
					if(file.equals("n")){
						break;
					}
					else{
						message = ReadWrite.read(ReadWrite.openFile(file,in));
					}
				}
				//end file message
				Support.printDistr(Support.letterDistr(message));

				//exit message
					System.out.println("Thank you for using the utility and goodbye~");

				//invalid input
					System.out.println("That wasn't a valid menu option.");
				}
			//end switch
			if (userChoice != 0){
				System.out.print("Would you like to see the menu again?: ");
				again = in.nextLine();
			}
		}
		//end while loop menu
		in.close();
	}//end main method

	public static int get_num(Scanner in){
		int num = 0;
		while (num < 2 || num > 26){
			try{
				System.out.print("What is the cipher?: ");
				num = in.nextInt();
				in.nextLine();
				if(num < 2 || num > 26){
					System.out.println("Cipher must be between 2 and 26 inclusive.");
				}
			}
			catch (InputMismatchException e) {
				System.out.println("You need to use a number for the cipher. Try again.");
			}
		}
		return num;
	}//end get_num method

	public static String get_name(Scanner in){
		String file;
		String temp="blah";
		String response;
		System.out.print("Enter the name of the text file: ");
		file = in.nextLine();
		String ext = file.substring(file.length()-4);
		boolean txt = ext.equals(".txt");
		if (!txt){
			temp = file+".txt";
			System.out.print("Entered file name doesn't end with \'.txt\' "
					+"attempting to ammend file extension.\n"
					+"New File name: "+temp+"\n"
					+"Is this correct? ");
			response = in.nextLine();
			if(response.equalsIgnoreCase("yes")||response.equalsIgnoreCase("y")){
				return temp;
			}
			else{
				System.out.println("Program can only use txt files. Try again.");
				return "n";
			}
		}
		return temp;	//file;
	}//end get_name method
}//end Main
