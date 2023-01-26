import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import java.util.Scanner;
import java.util.Random;

public class Tests {
	static Yahtzee student = new Yahtzee();
	private static ByteArrayOutputStream TOut;
	private static ByteArrayInputStream TIn;
	private static final PrintStream SOut = System.out;
	private static final InputStream SIn = System.in;
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		testHolding1();
		testHolding2();
		testRerollDice1();
		testRerollDice2();
		testPrintDice1();
		testPrintDice2();
		testKinds1();
		testKinds2();
		testPrintScoreYahtzee();
		testPrintScoreLargeStraight();
		testPrintScoreSmallStraight();
		testPrintScore4Kind();
		testPrintScoreFullHouse();
		testPrintScore3Kind();
		testPrintScoreNoScore();

		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}
	static public void testHolding1(){
		int correct = 4;
		Scanner input = new Scanner("30 4");
		setOutput();
		int result = student.holding(input);
		restoreSystem();
		compare("TestHolding1", result, correct);
	}
	static public void testHolding2(){
		int correct = 0;
		Scanner input = new Scanner("0");
		setOutput();
		int result = student.holding(input);
		restoreSystem();
		compare("testHolding", result, correct);
	}
	static public void testRerollDice1(){
		int[] correct = {1,2,3,4,5};
		Scanner input = new Scanner("14 1");
		Random rand = new Random(0);
		int[] start = {1,2,3,4,5};
		setOutput();
		int[] result = student.rerollDice(start,input,rand,4);
		restoreSystem();
		compare("testRerollDice1", result, correct);
	}
	static public void testRerollDice2(){
		int[] correct = {6,2,1,4,6};
		Scanner input = new Scanner(" 14 1 3 5 ");
		Random rand = new Random(25);
		int[] start = {1,2,3,4,5};
		setOutput();
		int[] result = student.rerollDice(start,input,rand,2);
		restoreSystem();
		compare("testRerollDice2", result, correct);
	}
	static public void testPrintDice1() {
		String[] correct = {"1 2 3 4 5 ","1 2 3 4 5"};//w/wo trailing space
		int[] input = {1,2,3,4,5};
		String result = student.printDice(input);
		compare("testPrintDice1", result, correct);
	}
	static public void testPrintDice2(){
		String[] correct = {"5 4 3 2 1 ", "5 4 3 2 1"};//w/wo triling space
		int[] input = {5,4,3,2,1};
		String result = student.printDice(input);
		compare("testPrintDice2", result, correct);
	}
	static public void testKinds1(){
		int[] correct = {2,0,1,0,1,1};
		int[] input = {1,1,3,5,6};
		int[] result = student.kinds(input);
		compare("testKinds1", result, correct);
	}
	static public void testKinds2(){
		int[] correct = {0,1,1,2,0,1};
		int[] input = {2,3,4,4,6};
		int[] result = student.kinds(input);
		compare("testKinds2", result, correct);
	}
	static public void testPrintScoreYahtzee(){
		//6 possible Yahtzees
		int[][] input = {{4,4,4,4,4},{6,6,6,6,6},{5,5,5,5,5},{3,3,3,3,3},{2,2,2,2,2},{1,1,1,1,1}};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "Yahtzee";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScoreYahtzee", result, correct);
	}
	static public void testPrintScoreLargeStraight(){
		//2 possible Large Straights
		int[][] input = {{4,5,6,3,2},{5,2,4,1,3}};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "Large Straight";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScoreLargeStraight", result, correct);
	}
	static public void testPrintScoreSmallStraight(){
		//14 possible Small Straights
		int[][] input = {
		{1,2,3,4,6},{1,2,3,4,1},{1,2,3,4,2},{1,2,3,4,3},{1,2,3,4,4},
		{2,3,4,5,2},{2,3,4,5,3},{2,3,4,5,4},{2,3,4,5,5},
		{3,4,5,6,6},{3,4,5,6,1},{3,4,5,6,3},{3,4,5,6,4},{3,4,5,6,5}
		};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "Small Straight";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScoreSmallStright", result, correct);
	}
	static public void testPrintScore4Kind(){
		//testing 2 of the possible 4 o' Kinds
		int[][] input = {{4,4,3,4,4},{3,3,3,5,3}};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "Four of a Kind";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScore4Kind", result, correct);
	}
	static public void testPrintScoreFullHouse(){
		//testing 3 of the possible full houses
		int[][] input = {{2,2,3,3,3},{4,4,4,6,6},{1,4,1,4,1}};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "Full House";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScoreFullHouse", result, correct);
	}
	static public void testPrintScore3Kind(){
		//testing 2 of the possible 3 o' kinds
		int[][] input = {{4,4,4,1,2},{1,3,5,3,3}};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "Three of a Kind";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScore3Kind", result, correct);
	}
	static public void testPrintScoreNoScore(){
		//testing 2 of the possible no score
		int[][] input = {{1,1,4,5,3},{6,5,3,5,6}};
		String[] correct = new String[input.length];
		for (int i = 0; i<input.length; i++){
			correct[i] = "You did not score anything noteworthy.";
		}
		String[] result = new String[input.length];
		for (int i = 0; i < input.length; i++){
			result[i] = student.printScore(input[i]);
		}
		compare("testPrintScoreNoScore", result, correct);
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
	public static void compare(String name, String[] result, String[] correct){
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
	public static void compare(String name, int[] result, int[] correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}
	public static void compare(String name, String result, String[] correct){
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

	private static String getOutput(String input, int seed){
		String[] args = {""+seed};
		setOutput();
		setInput(input);
		student.main(args);
		String result = TOut.toString();
		restoreSystem();
		return result;
	}
}
