public class Tests{
	static ReverseMessage student = new ReverseMessage();
	private static int testCount = 0;
	private static int passed = 0;

	public static void main(String[] args){
		test1();
		test2();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void test1(){
		String correct = ".egassem a si sihT";
		String input = "This is a message.";
		String result = student.reverse(input);
		compare("test1", result, correct);
	}
	static public void test2(){
		String correct = "?uoy t'nod ,nohtyP ssim uoY";
		String input = "You miss Python, don't you?";
		String result = student.reverse(input);
		compare("test2", result, correct);
	}

	public static void compare(String name, String result, String correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}

}
