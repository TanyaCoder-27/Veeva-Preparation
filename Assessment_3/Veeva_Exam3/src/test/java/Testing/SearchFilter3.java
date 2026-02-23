package Testing;
//Q3) Search the filter listbox and select the option based on user text.
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchFilter3 {

	public static void main(String[] args) {

		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

		String filterText = "an"; // user text
		String targetOption = "Angola"; // option to select

		// enter text in search box
		WebElement searchBox = driver.findElement(By.id("autocomplete"));
		searchBox.sendKeys(filterText);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("ui-id-1"))); // class -> ui-menu-item-wrapper

		// all filter options
		List<WebElement> options = driver.findElements(By.cssSelector("#ui-id-1 li.ui-menu-item div"));

		// select specific option
		boolean found = false;

		for (WebElement option : options) {
			String text = option.getText();
			if (text.equalsIgnoreCase(targetOption)) {
				option.click();
				found = true;
				break;
			}
		}

		if (found) {
			System.out.println("Selected: " + targetOption);
		} else {
			System.out.println("Option not found: " + targetOption);
		}

		driver.quit();
	}
}