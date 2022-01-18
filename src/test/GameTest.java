package test;

import org.junit.Assert;
import org.junit.Test;

import main.Game;

public class GameTest {
	@Test
	public void shouldReturnAnInstanceOfGame() {
		Game game = new Game();
		Assert.assertNotNull(game);
	}
	
	@Test
	public void shouldPrintWelcomeMessage() {
		Game game = new Game();
		String expected = "Welcome to Rock Paper Scissors!";
		Assert.assertEquals(expected, game.welcomeMessage());
	}
}
