import java.io.*;

public class main {
	static BufferedReader in = 
			new BufferedReader (new InputStreamReader(System.in));
	
	public static void main(String[] args) {
		AI AI = new AI();
		String userchoice = "";
		String AIchoice = AI.play();
		int wins = 0;
		int losses = 0;
		int ties = 0;
		
		// TODO Auto-generated method stub
		
			//print current score
			System.out.println("Score: AI wins " + AI.wins + ". AI losses: " + AI.losses);
			System.out.println("Score: Your wins " + wins + ". Your losses: " + losses);
			System.out.println("Ties: " + ties);
			
			
			try {
				System.out.println("CHOOSE YOUR WEAPON (Rock, Paper, Scissors): ");
				userchoice = in.readLine();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("You must enter: 'Paper' 'Rock' or 'Scissors' ");
			}
			
			switch (userchoice) {
			case "Rock":
				if (AIchoice == "Paper") {
					System.out.println("AI Chose: " + AIchoice + " YOU LOSE.");
					losses--;
					AI.wins++;
					
				}
				else if (AIchoice == "Rock"){
					System.out.println("AI also chose: " + AIchoice + " IT'S A TIE.");
					ties++;
				}
				else {
					System.out.println("AI chose: " + AIchoice + " YOU WIN!");
					AI.losses++;
					wins++;
				}
				break;
			case "Scissors":
				if (AIchoice == "Rock") {
					System.out.println("AI Chose: " + AIchoice + " YOU LOSE.");
					losses--;
					AI.wins++;
				}
				else if (AIchoice == "Scissors"){
					System.out.println("AI also chose: " + AIchoice + " IT'S A TIE.");
					ties++;
				}
				else {
					AI.losses++;
					wins++;
				}
				break;
			case "Paper":
				if (AIchoice == "Scissors") {
					System.out.println("AI Chose: " + AIchoice + " YOU LOSE.");
					losses--;
					AI.wins++;
				}
				else if (AIchoice == "Paper"){
					System.out.println("AI also chose: " + AIchoice + " IT'S A TIE.");
					ties++;
				}
				else {
					AI.losses++;
					wins++;
				}
				break;
			}
			
		
		
	}

}
