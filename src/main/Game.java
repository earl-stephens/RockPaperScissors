package main;

import java.util.Random;
import java.util.Scanner;

public class Game {
	Scanner scanner = new Scanner(System.in);
	private int userChoice;
	public int computerChoice;
	private Random randomNumber = new Random();
	
	public void run() {
		System.out.println(welcomeMessage());
		System.out.println(userInputPrompt());
		
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
}
