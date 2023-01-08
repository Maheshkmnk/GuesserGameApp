import java.util.*;


class GuessingNumberGenerator{
	int GNumber;
	
	int gNinput() {
		
		//System.out.println("Called >> GuessingNumberGenerator");
		Scanner sc = new Scanner(System.in);
		GNumber = sc.nextInt();
		return GNumber;
	}
}

class Players{
	int Gplayer;
	
	int playerInput() {
		//System.out.println("Called >> Players");
		Scanner sc = new Scanner(System.in);
		Gplayer = sc.nextInt();
		return Gplayer;
	}
}


class Empire{
	int GuessableNumber;
	
	int[] GuessedNumbers;
	
	void collectNumberFromGenerator() {
		
		System.out.print("Guessable Number: ");
		GuessingNumberGenerator gNG = new GuessingNumberGenerator();
		//gNG.gNinput();
		GuessableNumber = gNG.gNinput();
	}
	
	
	void collectNumberFromPlayer(int numberOfPlayesr) {		
		
		GuessedNumbers = new int[numberOfPlayesr];
		Players plrs = new Players();
		
		for(int i=0;i<numberOfPlayesr;i++)
		{
			System.out.print("Player "+ (i+1)+": ");
			GuessedNumbers[i] = plrs.playerInput();
		}	
	}
	
	void compare(int numberOfPlayesr) {
		
		ArrayList<Integer> wonPlayers = new ArrayList<>();
		for(int i=0;i<numberOfPlayesr;i++) {
			if(GuessableNumber == GuessedNumbers[i]) {
				wonPlayers.add(i+1);
			}
		}
		
		if(wonPlayers.size()>0) {
			
			String s= wonPlayers.size()==1? "Player":"Players";
			System.out.print(s);
			for(int i = 0; i < wonPlayers.size(); i++) {
				if(wonPlayers.size()>1 && wonPlayers.size()-1==i) {
					System.out.print(" and " + wonPlayers.get(i));
					continue;
				}
				System.out.print(" "+wonPlayers.get(i));
			}
			System.out.print(" Won the Match");
		}	
		else {
			System.out.println("All players Lost the match");
		}
		
	}
}



public class GuesserGame {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter Number Of Players: ");
		int numberOfPlayesr = sc.nextInt();
		
		
		Empire ep = new Empire();
		
		ep.collectNumberFromGenerator();
		ep.collectNumberFromPlayer(numberOfPlayesr);
		ep.compare(numberOfPlayesr);
	}

}
