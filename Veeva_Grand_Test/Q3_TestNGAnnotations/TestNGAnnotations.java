package TestNGAnnotations;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

public class TestNGAnnotations {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        System.out.println("opened browser and navigated to login page");
    }

    @Test(priority = 1)
    public void loginTest() {
        driver.findElement(By.name("email")).sendKeys("tanyakonapala@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        System.out.println("login test passed");
    }

    @Test(priority = 2)
    public void pageTitleTest() {
        String title = driver.getTitle();
        System.out.println("Page title is: " + title);
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
        System.out.println("closed browser");
    }
}


/*
opened browser and navigated to login page
login test passed
closed browser
Mar 18, 2026 9:48:31 AM org.openqa.selenium.devtools.CdpVersionFinder findNearestMatch
WARNING: Unable to find CDP implementation matching 146
Mar 18, 2026 9:48:31 AM org.openqa.selenium.chromium.ChromiumDriver lambda$new$5
WARNING: Unable to find version of CDP to use for 146.0.7680.80. You may need to include a dependency on a specific version of the CDP using something similar to `org.seleniumhq.selenium:selenium-devtools-v86:4.18.1` where the version ("v86") matches the version of the chromium-based browser you're using and the version number of the artifact is the same as Selenium's.
opened browser and navigated to login page
Page title is: Automation Exercise - Signup / Login
closed browser
PASSED: TestNGAnnotations.TestNGAnnotations.pageTitleTest
PASSED: TestNGAnnotations.TestNGAnnotations.loginTest

===============================================
    Default test
    Tests run: 2, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 2, Passes: 2, Failures: 0, Skips: 0
===============================================

*/
