package test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Arrays;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import main.Game;

public class GameTest {
	private Game game;
	
	@Before
		public void setup() {
		game = new Game();
	}
	
	@Test
	public void shouldReturnAnInstanceOfGame() {
		Assert.assertNotNull(game);
	}
	
	@Test
	public void shouldPrintWelcomeMessage() {
		String expected = "Welcome to Rock Paper Scissors!";
		Assert.assertEquals(expected, game.welcomeMessage());
	}
	
	@Test
	public void shouldPromptForUserInput() {
		String expected = "Enter 0 for Rock, 1 for Paper, 2 for Scissors.";
		Assert.assertEquals(expected, game.userInputPrompt());
	}
	
	@Test
	public void validInputShouldProduceValidOutput() {
		String userInput = String.format("1");
		ByteArrayInputStream bais = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais);
		
		String expected = "1 - Paper";
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		PrintStream printStream = new PrintStream(baos);
		System.setOut(printStream);
		
		game.getUserInput();
		
		String[] lines = baos.toString().split(System.lineSeparator());
		String actual = lines[0];
		Assert.assertEquals(expected, actual);
	}
	/*
	@Test(expected = IllegalArgumentException.class)
	public void invalidInputShouldProduceErrorMessage() {
		String userInput = String.format("4");
		ByteArrayInputStream bais2 = new ByteArrayInputStream(userInput.getBytes());
		System.setIn(bais2);

		game.getUserInput();
	}
	*/
	
	@Test
	public void computerShouldMakeAChoice() {
		Integer possibleValues[] = {0, 1, 2,};
		game.computerChooses();
		boolean test = Arrays.asList(possibleValues).contains(game.computerChoice);
		Assert.assertTrue(test);
	}
	
	@Test
	public void displayWhoWonTheRound() {
		game.userChoice = 1;
		game.computerChoice = 2;
		String expected = "You played Paper, Computer played Scissors. Computer wins this round.";
		String result = game.outputOfRound();
		Assert.assertEquals(expected, result);
	}
	
	
	@Test
	public void displayTieRound() {
		game.userChoice = 1;
		game.computerChoice = 1;
		String expected = "You both played Paper.  Tie round.";
		String result = game.outputOfRound();
		Assert.assertEquals(expected, result);
	}
	
	@Test
	public void shouldCalculateTheNumberOfRoundsPlayed() {
		game.userChoice = 1;
		game.computerChoice = 2;
		game.outputOfRound();
		Assert.assertEquals(1, game.roundCounter);
		game.userChoice = 0;
		game.computerChoice = 1;
		game.outputOfRound();
		Assert.assertEquals(2, game.roundCounter);
		}
	
	@Test
	public void shouldPromptForNextRoundIfAvailable() {
		game.userChoice = 1;
		game.computerChoice = 2;
		game.outputOfRound();
		Assert.assertEquals("Enter 0 for Rock, 1 for Paper, 2 for Scissors.", game.nextRoundCheck());
		game.userChoice = 1;
		game.computerChoice = 2;
		game.outputOfRound();
		Assert.assertEquals("Enter 0 for Rock, 1 for Paper, 2 for Scissors.", game.nextRoundCheck());
		game.userChoice = 1;
		game.computerChoice = 2;
		game.outputOfRound();
		Assert.assertEquals("No turns remaining.", game.nextRoundCheck());
	}
	
	@Test
	public void shouldShowUserWinsGame() {
		game.userChoice = 0;
		game.computerChoice = 2;
		game.outputOfRound();
		Assert.assertEquals("Enter 0 for Rock, 1 for Paper, 2 for Scissors.", game.nextRoundCheck());
		game.userChoice = 2;
		game.computerChoice = 1;
		game.outputOfRound();
		Assert.assertEquals("Enter 0 for Rock, 1 for Paper, 2 for Scissors.", game.nextRoundCheck());
		game.userChoice = 1;
		game.computerChoice = 0;
		game.outputOfRound();
		Assert.assertEquals("You won - best 3 out of 3", game.declareWinner());
	}
	
	@Test
	public void shouldShowComputerWinsGame() {
		game.userChoice = 0;
		game.computerChoice = 1;
		game.outputOfRound();
		Assert.assertEquals("Enter 0 for Rock, 1 for Paper, 2 for Scissors.", game.nextRoundCheck());
		game.userChoice = 1;
		game.computerChoice = 2;
		game.outputOfRound();
		Assert.assertEquals("Enter 0 for Rock, 1 for Paper, 2 for Scissors.", game.nextRoundCheck());
		game.userChoice = 2;
		game.computerChoice = 0;
		game.outputOfRound();
		Assert.assertEquals("Computer won - best 3 out of 3", game.declareWinner());
	}
	
	@Test
	public void shouldNotIncrementRoundCounterIfRoundIsATie() {
		game.userChoice = 0;
		game.computerChoice = 0;
		game.outputOfRound();
		Assert.assertEquals(0, game.roundCounter);
	}
}
