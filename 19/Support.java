import java.util.Scanner;

public class Support{
	public static String decrypt(String message, int cipher) {
		String decrypted = "";
		int bob = 0;
		if(cipher < 0){
			cipher += 26;
		}
		for(int i = 0; i<message.length(); i++){
			int in = message.charAt(i);
			if(in>=65&&in<=90){
				in-=cipher;
				if(in<65){
					bob = 65-in;
					in = 91 - bob;
				}
			}
			else if(in>=97&&in<=122){
				in-=cipher;
				if(in<97){
					bob = 97-in;
					in = 123-bob;
				}
			}
			char cha = (char)in;
			String chad = Character.toString(cha);
			decrypted = decrypted.concat(chad);
		}
		return decrypted/*run the encryption method backwards*/;
	}//end decrypt

	public static String encrypt(String message, int cipher) {
		int bob=0;
		String encrypted = "";
		//create an empty string for the encrypted message
		if(cipher < 0){
			cipher += 26;
		}
		//if cipher < 0
			//cipher += 26
		for(int i = 0; i<message.length();i++){
			int in = message.charAt(i);
			if(in>=65&&in<=90){
				in += cipher;
				if(in>90){
					bob = in-90;
					in= 64+bob;
				}
			}
			else if(in>=97&&in<=122){
				in += cipher;
				if(in>122){
					bob = in-122;
					in = 96+bob;
				}
			}
			char cha = (char)in;
			String chad = Character.toString(cha);
			encrypted = encrypted.concat(chad);
		}
		return encrypted;
		//for each character in the message
			//create an integer representation of the char at the current position
			//if the int represents a capital letter (check ascii chart)
				//add the cipher to the int
				//if the new number is out the range of capital letters, wrap it back, ie. Z+1=A, Z+2=B
			//else if the int represents a lower letter (check ascii chart)
				//add the cipher to the int
				//if the new number is out the range of lower letters, wrap it back, ie. z+1=a, z+2=b
			//add the char represented by the int to the encrypted message string
 // re/*encrypted message*/
	}//end encrypt method

	public static int[] letterDistr(String message) {

		//initialize an int array to hold the number of each letter
		int[] numbers = new int[26];
		for(int i=0; i<26; i++){
			numbers[i]=0;
		}
		message = message.toLowerCase();
		for(int i=0; i<message.length(); i++){
			char cha = message.charAt(i);
			int in = cha;
			if(in>=97&&in<=122){
				in = in -97;
				numbers[in]+=1;
			}
		}
		return numbers;
		//for each character in the message
		//convert the current char to lowercase then to an int
		//if the int represents a lowercase letter (check the ascii chart)
			//subtract 97 from the int
			//add 1 to the int array at that index
		//return the int array
	}//end letter distribution method

	public static void printDistr(int[] distr) {
		for(int i=0; i<distr.length; i++){
			int letterInt = i+97;
			char letter = (char)letterInt;
			int numLetter = distr[i];
			System.out.printf(letter+":%20h",numLetter);
			for(int a=0; a<distr[i]; a++){
				System.out.print("*");
			}
			System.out.println(" ");
		}
		//for each element in the array
			//create a char from the current position (ie. 0=a,1=b,...)
			//System.out.printf(/*theChar:numOfChar|*/);//numOfChar should be formatted to have a width of 4.
			//for the number in the array at the current position
				//print an * on the same line
			//move to the next line
	}//end printDistr

}//end class Caersar
