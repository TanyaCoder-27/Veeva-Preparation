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
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://automationexercise.com/login");
        System.out.println("opened browser and navigated to login page");
    }
    @Test
    public void loginTest() {
        driver.findElement(By.name("email")).sendKeys("tanyakonapala@gmail.com");
        driver.findElement(By.name("password")).sendKeys("test123");
        driver.findElement(By.xpath("//button[text()='Login']")).click();
        System.out.println("login test passed");
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
PASSED: TestNGAnnotations.TestNGAnnotations.loginTest

===============================================
    Default test
    Tests run: 1, Failures: 0, Skips: 0
===============================================


===============================================
Default suite
Total tests run: 1, Passes: 1, Failures: 0, Skips: 0

*/