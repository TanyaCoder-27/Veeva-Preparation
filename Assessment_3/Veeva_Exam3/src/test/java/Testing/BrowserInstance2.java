package Testing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

//Q2) Write a script to create a browser instance based on browser name.

public class BrowserInstance2 {
	WebDriver driver;

	@Parameters("browser")
	@BeforeClass
	public void createBrowserInstance(String br) {

		switch (br.toLowerCase()) {
		case "chrome":
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();

			break;

		case "edge":
			WebDriverManager.edgedriver().setup();
			driver = new ChromeDriver();

			break;

		case "firefox":
			WebDriverManager.firefoxdriver().setup();
			driver = new ChromeDriver();

			break;
		default:
			System.out.println("invalid browser name");
			return;
		}
	}

	@Test
	public void test() {
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		System.out.println("browser instance created successfully");
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

}

/*
 * console output: Google browser instance created successfully
 * 
 * =============================================== Suite Total tests run: 1,
 * Passes: 1, Failures: 0, Skips: 0
 * ===============================================
 */
