package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HwLesson5Test {
    WebDriver driver;
    WebDriverWait webDriverWait;
   // Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        // actions = new Actions(driver);
        driver.get("https://www.riproad.com");
    }

    private static final String privacyPolicyButtonXpathLocator = "//div/h2[.='Privacy Policy']";

    @Test
    void goToPrivacyTest() {
        driver.findElement(By.xpath("//a[.='Privacy']")).click();
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(privacyPolicyButtonXpathLocator)));
        Assertions.assertTrue(driver.findElement(By.xpath(privacyPolicyButtonXpathLocator)).isDisplayed());
    }

    @Test
    void goToTrackerTest() {
        driver.findElement(By.xpath("//a[.='TRACKRR']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(., 'Our tracking software')]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div/h1[contains(., 'Our tracking software')]")).isDisplayed());
    }

    @Test
    void contactUsTest() throws InterruptedException {
        driver.findElement(By.xpath("//div[@class='standard-header-links-wrapper']//a[.='CONTACT']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@data-name='firstName']")));
        driver.findElement(By.xpath("//input[@data-name='firstName']")).sendKeys("Brad");
        driver.findElement(By.xpath("//input[@data-name='lastName']")).sendKeys("Pitt");
        driver.findElement(By.xpath("//input[@data-name='email']")).sendKeys("Pittttt@gmail.com");
        driver.findElement(By.xpath("//textarea[@data-name='notes']")).sendKeys("Hello World!!");
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        Thread.sleep(5000);
        /* webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div//div[.='Thank you! Your submission has been received!']")));
        I added Thread.sleep because test did not work with webDriverWait.  */
        Assertions.assertTrue(driver.findElement(By.xpath("//div//div[.='Thank you! Your submission has been received!']")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
