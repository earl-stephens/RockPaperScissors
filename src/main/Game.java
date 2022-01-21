package main;

import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	public int userChoice;
	public int computerChoice;
	private Random randomNumber = new Random();
	public int roundCounter = 0;
	public int playerWins = 0;
	public int computerWins = 0;
	
	public void run() {
		System.out.println(welcomeMessage());
		System.out.println(userInputPrompt());
		getUserInput();
		computerChooses();
		System.out.println(outputOfRound());
		nextRoundCheck();
		keepPlaying();
	}
	
	public String welcomeMessage() {
		return "Welcome to Rock Paper Scissors!";
	}
	
	public String userInputPrompt() {
		return "Enter 0 for Rock, 1 for Paper, 2 for Scissors.";
	}
	
	public void close() {
		scanner.close();
	}
	
	public void getUserInput() {
		String userInput = scanner.nextLine();
		int userChoice = 0;
		
		if(userInput.equals("")) {
			System.out.println("Invalid Input.");
			System.out.println("Enter 0 for Rock, 1 for Paper, 2 for Scissors.");
			getUserInput();
		} else {
			userChoice = Integer.parseInt(userInput);
		}
		
		int[] options = {0, 1, 2};
		boolean checkFlag = false;
		for(int check: options) {
			if(check == userChoice) {
				checkFlag = true;
			}
		}
		
		if(checkFlag == false) {
			System.out.println("That is not a valid option");
			getUserInput();
		}
		
		switch(userInput) {
		case "0": 
			System.out.printf("%d - Rock\n", userChoice);
			break;
		case "1":
			System.out.printf("%d - Paper\n", userChoice);
			break;
		case "2":
			System.out.printf("%d - Scissors\n", userChoice);
			break;
		}
	}
	
	public int computerChooses() {
		computerChoice = randomNumber.nextInt(3);
		return computerChoice;
	}
	
	public String outputOfRound() {
		String outputPhrase = null;
		switch(userChoice) {
		case 0:
			if(computerChoice == 1) {
				outputPhrase = "You played Rock, Computer played Paper.  Computer wins this round.";
				computerWins++;
				roundCounter++;
			} else if(computerChoice == 2) {
				outputPhrase = "You played Rock, Computer played Scissors.  You win this round.";
				playerWins++;
				roundCounter++;
			} else {
				outputPhrase = "You both played Rock.  Tie round.";
			}
			break;
		case 1:
			if(computerChoice == 0) {
				outputPhrase = "You played Paper, Computer played Rock.  You win this round.";
				playerWins++;
				roundCounter++;
			} else if(computerChoice == 2) {
				outputPhrase = "You played Paper, Computer played Scissors. Computer wins this round.";
				computerWins++;
				roundCounter++;
			} else {
				outputPhrase = "You both played Paper.  Tie round.";
			}
			break;
		case 2:
			if(computerChoice == 0) {
				outputPhrase = "You played Scissors, Computer played Rock.  Computer wins this round.";
				computerWins++;
				roundCounter++;
			} else if(computerChoice == 1) {
				outputPhrase = "You played Scissors, Computer played Paper.  You win this round.";
				playerWins++;
				roundCounter++;
			} else {
				outputPhrase = "You both played Scissors.  Tie round.";
			}
			break;
		}
		//roundCounter++;
		return outputPhrase;
	}
	
	public String nextRoundCheck() {
		System.out.println("That was round " + roundCounter);
		if(roundCounter < 3) {
			System.out.println("Enter 0 for Rock, 1 for Paper, 2 for Scissors.");
			return "Enter 0 for Rock, 1 for Paper, 2 for Scissors.";
		} else {
			System.out.println("No turns remaining.");
			return "No turns remaining.";
		}
	}
	
	public void keepPlaying() {
		if(roundCounter < 3) {
			getUserInput();
			computerChooses();
			System.out.println(outputOfRound());
			nextRoundCheck();
			keepPlaying();
		} else {
			declareWinner();
		}
	}
	
	public String declareWinner() {
		if(computerWins > playerWins) {
			String compWin = "Computer won - best " + computerWins + " out of 3";
			System.out.println(compWin);
			return compWin;
		} else {
			String playWin = "You won - best " + playerWins + " out of 3";
			System.out.println(playWin);
			return playWin;
		}
	}
}
