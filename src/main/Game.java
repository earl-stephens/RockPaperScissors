package main;

public class Game {
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
}
