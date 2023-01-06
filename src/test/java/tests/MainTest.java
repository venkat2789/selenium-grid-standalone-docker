package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import config.DriverSetup;

public class MainTest {

	private static WebDriver driver;

	@BeforeMethod
	public static void setupDriver() throws MalformedURLException {
		driver = new DriverSetup().getRemoteDriver();
	}

	@Test
	public static void launchGoogle() {
		driver.get("https://google.com");
		System.out.println(driver.getTitle());
	}

	@Test
	public static void launchFacebook() {
		driver.get("https://facebook.com");
		System.out.println(driver.getTitle());
	}

	@Test
	public static void launchWiki() {
		driver.get("https://wikipedia.org");
		System.out.println(driver.getTitle());
	}

	@AfterMethod
	public static void closeDriver() {
		driver.quit();
	}

}
