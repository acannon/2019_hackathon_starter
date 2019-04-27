
import java.util.Random;

public class AI {
	int wins = 0;
	int losses = 0;
	
	public AI() {
		
	}
	
	String play(){
		Random rand = new Random();
		int choice;
		String wordedchoice ="";
		//R = 0, P = 1, S = 2
		
		choice = rand.nextInt(3);
		
		switch(choice) {
		case 0:
			wordedchoice = "Rock";
			break;
		case 1:
			wordedchoice = "Paper";
			break;
		case 2:
			wordedchoice = "Scissors";
			break;
		default:
			System.out.println("ERROR with Random.");
		}
		return wordedchoice ;
	}
	
	
}
