package WorkWithFrames;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WorkWithFrames {

    public static void main(String[] args) {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://ui.vision/demo/webtest/frames/");
        driver.manage().window().maximize();

        // using index
        driver.switchTo().frame(0);
        System.out.println("switched using index");

        driver.findElement(By.name("mytext1")).sendKeys("Index Frame");

        driver.switchTo().defaultContent();

        // using name (no name for any frame))
        WebElement frame2 = driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
        driver.switchTo().frame(frame2);
        System.out.println("switched using name - frame 2");

        driver.findElement(By.name("mytext2")).sendKeys("Frame 2");

        driver.switchTo().defaultContent();

        // using WebElement
        WebElement frame3 = driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
        driver.switchTo().frame(frame3);
        System.out.println("switched using webelement - frame 3");

        driver.findElement(By.name("mytext3")).sendKeys("Frame 3");

        driver.switchTo().defaultContent();

        driver.quit();
    }
}



/*
switched using index
switched using name - frame 2
switched using webelement - frame 3

*/