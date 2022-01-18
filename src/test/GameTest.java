package test;

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
		
	}
}
