package com_orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

/**
 * Project-2- ProjectName : com-orangehrmlive
 * BaseUrl = https://opensource-demo.orangehrmlive.com/
 * 1. Setup chrome browser.
 * 2. Open URL.
 * 3. Print the title of the page.
 * 4. Print the current url.
 * 5. Print the page source.
 * 6. Click on ‘Forgot your password?’ link.
 * 7. Print the current url.
 * 8. Navigate back to the login page.
 * 9. Refresh the page.
 * 10. Enter the email to email field.
 * 11. Enter the password to password field.
 * 12. Click on Login Button.
 * 13. Close the browser.
 */
public class Project02_comorangehrmlive {
    String baseUrl = "https://opensource-demo.orangehrmlive.com/";
    static String browser = "Chrome";
    static WebDriver driver;

    public static void main(String[] args) {
        Project02_comorangehrmlive obj1 = new Project02_comorangehrmlive();
        // multi browser selection code.
        if (browser.equalsIgnoreCase("Chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equalsIgnoreCase("Firefox")) {
            driver = new FirefoxDriver();
        } else if (browser.equalsIgnoreCase("Edge")) {
            driver = new EdgeDriver();
        } else
            System.out.println("Wrong driver name");

        driver.get(obj1.baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        System.out.println("2- URL opened.");
        System.out.println("3- Title of the page: " + driver.getTitle());
        System.out.println("4- Current URL: " + driver.getCurrentUrl());
        System.out.println("5- Page source: " + driver.getPageSource());
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.findElement(By.className("orangehrm-login-forgot")).click();
        System.out.println("6- Forgot your password? link clicked.");
        System.out.println("7- Printing current URL: " + driver.getCurrentUrl());
        driver.navigate().back();
        System.out.println("8- Navigated back to the login page.");
        driver.navigate().refresh();
        System.out.println("9- Refreshed the page.");
        driver.findElement(By.name("username")).sendKeys("prime123@gmail.com");
        System.out.println("10- Email entered to email field.");
        driver.findElement(By.name("password")).sendKeys("prime123");
        System.out.println("11- Password entered to password field.");
        driver.findElement(By.tagName("button")).click();
        System.out.println("12- User clicked on login button.");
        driver.quit();
        System.out.println("13- User closed the browser.");
    }
}