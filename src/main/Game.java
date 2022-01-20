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
		userChoice = Integer.parseInt(userInput);
		
		switch(userInput) {
		case "0": 
			System.out.printf("%d - Rock", userChoice);
			break;
		case "1":
			System.out.printf("%d - Paper", userChoice);
			break;
		case "2":
			System.out.printf("%d - Scissors", userChoice);
			break;
		default: 
			//System.out.println("Invalid option");
			throw new IllegalArgumentException("Invalid Option");
			//break;
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
			} else if(computerChoice == 2) {
				outputPhrase = "You played Rock, Computer played Scissors.  You win this round.";
				playerWins++;
			} else {
				outputPhrase = "You both played Rock.  Tie round.";
			}
			break;
		case 1:
			if(computerChoice == 0) {
				outputPhrase = "You played Paper, Computer played Rock.  You win this round.";
				playerWins++;
			} else if(computerChoice == 2) {
				outputPhrase = "You played Paper, Computer played Scissors. Computer wins this round.";
				computerWins++;
			} else {
				outputPhrase = "You both played Paper.  Tie round.";
			}
			break;
		case 2:
			if(computerChoice == 0) {
				outputPhrase = "You played Scissors, Computer played Rock.  Computer wins this round.";
				computerWins++;
			} else if(computerChoice == 1) {
				outputPhrase = "You played Scissors, Computer played Paper.  You win this round.";
				playerWins++;
			} else {
				outputPhrase = "You both played Scissors.  Tie round.";
			}
			break;
		}
		roundCounter++;
		return outputPhrase;
	}
	
	public String nextRoundCheck() {
		if(roundCounter < 3) {
			return userInputPrompt();
		} else {
			return "No turns remaining.";
		}
	}
	
	public void keepPlaying() {
		if(roundCounter < 3) {
			getUserInput();
			computerChooses();
			outputOfRound();
			nextRoundCheck();
			keepPlaying();
		} else {
			declareWinner();
		}
	}
	
	public String declareWinner() {
		if(computerWins > playerWins) {
			String compWin = "Computer won - best " + computerWins + " out of 3";
			return compWin;
		} else {
			String playWin = "You won - best " + playerWins + " out of 3";
			return playWin;
		}
	}
}
