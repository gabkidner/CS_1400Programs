public class Tests {
	static CoinFlipper student = new CoinFlipper();
	private static int testCount = 0;
	private static int passed = 0;


	public static void main(String[] args){
		testFlipper1();
		testFlipper2();
		System.out.println("Passed "+passed+" out of "+testCount+" tests.");
		System.exit((passed == testCount) ? 0 : 1);
	}

	static public void testFlipper1(){
    int result = student.flipper(10,0);
	int[] correct = {3,7};
	compare("testFlipper1", result, correct);
  }
	static public void testFlipper2(){
		int result = student.flipper(500,14);
		int[] correct = {255,245};
		compare("testFlipper2", result, correct);
  }

  //setup methods
	public static void compare(String name, int result, int[] correct){
		String message = Diff.compare(name, result, correct);
		System.out.println(message);
		testCount++;
		if(message.indexOf("Passed") != -1){
			passed++;
		}
	}

}
