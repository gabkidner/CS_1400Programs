import java.io.*;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class ReadWrite{
	public static String read(Scanner file){
		//create a string to hold the message
		String message = "";
		//set scanner delimiter to EOF
		//read the whole file
		file.useDelimiter("//Z");
		file.close();
		message.concat(file.next());
		return message /*message string*/;
	}//end read

	public static Scanner openFile(String	file_name, Scanner input) {
		File fil;
		try{
			fil = new File(file_name);
			input = new Scanner(fil);
		}//try
			//create a File object based on file_name
			//change the Scanner input to read from the File object
		catch(FileNotFoundException e){
			System.out.println("Cannot find the file "+file_name);
		}
		//catch if the file isn't found
			//Display appropriate error message
		return input;
	}//end open_file

	public static void write(String file_name, String message){
		try{
			File file = new File(file_name);
			PrintWriter writer = new PrintWriter(file);
			writer.println(message);
			writer.close();
		}
		catch(FileNotFoundException e){
			System.out.println("Cannot find the file "+file_name);
		}
		//try
			//create a PrintWriter object based on file_name
			//print the message to the PrintWriter object
			//close the PrintWriter object
		//catch if the file is not found - eventhough java is making a file, so it doesn't need to be there first --stupid java
			//display appropriate error message
	}//end write method
}// end class File
