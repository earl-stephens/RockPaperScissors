package test;

import org.junit.Assert;
import org.junit.Test;

import main.App;

public class AppTest {

	@Test
	public void shouldReturnAnInstanceOfApp() {
		App app = new App();
		Assert.assertNotNull(app);
	}
}
