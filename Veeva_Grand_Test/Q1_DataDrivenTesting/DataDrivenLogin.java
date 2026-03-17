package DataDrivenTesting;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.time.Duration;

public class DataDrivenLogin {

    public static void main(String[] args) {

        WebDriver driver = null;

        try {
            // read data from Excel
            FileInputStream fis = new FileInputStream("data.xlsx");
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheetAt(0);

            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

            // Data reading loop
            for (int i = 1; i <= sheet.getLastRowNum(); i++) {

                Row row = sheet.getRow(i);

                String email = row.getCell(0).getStringCellValue();
                String pswd = row.getCell(1).getStringCellValue();

                driver.get("https://automationexercise.com/login");

                WebElement emailField = driver.findElement(By.name("email"));
                emailField.clear();
                emailField.sendKeys(email);

                WebElement passwordField = driver.findElement(By.name("password"));
                passwordField.clear();
                passwordField.sendKeys(pswd);

                driver.findElement(By.xpath("//button[text()='Login']")).click();

                //logout if login is successful
                try {
                    WebElement logoutLink = driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
                    logoutLink.click();
                    System.out.println("Login successful for: " + email);
                } catch (Exception ex) {
                    System.out.println("Login failed for: " + email);
                }
            }

            workbook.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (driver != null) {
                driver.quit();
            }
        }
    }
}


/*
Login successful for: tanyakonapala@gmail.com
Login failed for: wrong456@gmail.com
*/