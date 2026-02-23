package Testing;
//Q4) Create and execute a script to open google.com and verify that the title is google and also verify it is redirected to google.co.in 
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GoogleTest4 {

	@Test
	public void test() {
		try {
			WebDriverManager.chromedriver().setup();
			WebDriver driver = new ChromeDriver();

			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

			driver.get("https://www.google.co.in/");

			Assert.assertEquals(driver.getTitle(), "Google", "title is not google");
			String url = driver.getCurrentUrl();
			System.out.println("current url:" + url);
			Assert.assertTrue(url.contains("google.co.in"), "not redirected to google.co.in");
			driver.quit();
		} catch (Exception e) {
			System.out.println(e);
		}

	}
}

/*
 * 
 * current url:https://www.google.com/ FAILED: Testing.GoogleTest4.test
 * java.lang.AssertionError: not redirected to google.co.in expected [true] but
 * found [false]
 * 
 */