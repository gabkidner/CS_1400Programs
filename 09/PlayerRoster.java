import java.util.Scanner;

public class PlayerRoster {
	public static int[][] players;//so I can check your 2D array
	//UPDATE
	public static void update(int upUser, int nRate){
		if(upUser == players[0][0]){
			players[1][1] = nRate;
		}
		else if(upUser == players[1][0]){
			players[1][1] = nRate;
		}
		else if(upUser == players[2][0]){
			players[2][1] = nRate;
		}
		else if(upUser == players[3][0]){
			players[3][1] = nRate;
		}
		else if(upUser == players[4][0]){
			players[4][1] = nRate;
		}
	}
	//OUTPUT above
	public static void outAbove(int rate){
		System.out.println("\nABOVE "+rate);
		for(int i=0;i<players.length;i++){
			if(players[i][1] > rate){
				int pNumber = i+1;
				System.out.println("Player "+pNumber+" -- Jersey number: "+players[i][0]+", Rating: "+players[i][1]);
			}
		}
	}
	//ROSTER
	public static void roster(){
    System.out.println("ROSTER\nPlayer 1 -- Jersey number: "+players[0][0]+", Rating: "+players[0][1]);
    System.out.println("Player 2 -- Jersey number: "+players[1][0]+", Rating: "+players[1][1]);
    System.out.println("Player 3 -- Jersey number: "+players[2][0]+", Rating: "+players[2][1]);
    System.out.println("Player 4 -- Jersey number: "+players[3][0]+", Rating: "+players[3][1]);
    System.out.println("Player 5 -- Jersey number: "+players[4][0]+", Rating: "+players[4][1]);
  }
	//MAIN
	public static void main(String[] args) {
		final int NUM_PLAYERS = 5;
        players = new int[NUM_PLAYERS][2];
		/* Type your code here. */
    Scanner scan = new Scanner(System.in);
    char user;
		int nRate;
		for(int i=0; i<players.length; i++){
			int x = i+1;
			if(x==1){
				System.out.println("Enter player 1\'s jersey number:");
				players[0][0] = scan.nextInt();
				System.out.println("Enter player 1\'s rating:");
				players[0][1] = scan.nextInt();
			}
			else{
			System.out.println("\nEnter player "+x+"\'s jersey number:");
			players[i][0] = scan.nextInt();
			System.out.println("Enter player "+x+"\'s rating:");
			players[i][1] = scan.nextInt();
		}
	}
		System.out.print("\n");
    roster();
		boolean using = true;
		while(using){
			System.out.println("\nMENU");
			System.out.println("u - Update player rating");
			System.out.println("a - Output players above a rating");
			System.out.println("r - Replace player");
			System.out.println("o - Output roster");
			System.out.println("q - Quit");
			System.out.println("\nChoose an option:");
      user = scan.next().charAt(0);
			if(user == 'u'){
				System.out.println("Enter a jersey number:");
				int upUser = scan.nextInt();
				System.out.println("Enter a new rating for player:");
				nRate = scan.nextInt();
				update(upUser, nRate);
			}
			else if(user == 'a'){
				System.out.println("Enter a rating:");
				int rate = scan.nextInt();
				outAbove(rate);
			}
			else if(user == 'r'){
				System.out.println("Enter a jersey number:");
				int oldJersey = scan.nextInt();
				for(int i=0;i<players.length;i++){
					if(oldJersey == players[i][0]){
						System.out.println("Enter a new jersey number:");
						players[i][0] = scan.nextInt();
						System.out.println("Enter a rating for the new player:");
						players[i][1] = scan.nextInt();
					}
				}
			}
			else if(user == 'o'){
				roster();
			}
			if(user == 'q'){
				using = false;
			}
    }
	}
}
