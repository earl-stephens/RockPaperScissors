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
}
