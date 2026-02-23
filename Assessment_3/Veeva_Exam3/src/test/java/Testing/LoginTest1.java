package Testing;
//Q1) Write a script to login 
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest1 {

	public static void main(String[] args) {

		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();

		try {

			driver.get("https://tutorialsninja.com/demo/");

			driver.manage().window().maximize();

			driver.manage().timeouts().implicitlyWait(java.time.Duration.ofSeconds(10));

			// go to login page
			driver.findElement(By.xpath("//span[text()='My Account']")).click();
			driver.findElement(By.xpath("//a[text()='Login']")).click();

			// login with existing creds : email -> tanyacoder3@gmail.com and pswd :
			// pwdtesting

			driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys("tanyacoder3@gmail.com");
			driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys("pwdtesting");
			driver.findElement(By.xpath("//input[@value='Login']")).click();
			String expected_title = "My Account";
			String actual_title = driver.findElement(By.xpath("//h2[text()='My Account']")).getText();

			if (expected_title.equals(actual_title)) {
				System.out.println("successfully logged in.");
			} else {
				System.out.println("login failed.");
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {

			driver.quit();
		}
	}
}

//console output: successfully logged in.
