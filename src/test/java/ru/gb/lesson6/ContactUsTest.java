package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class ContactUsTest {
    WebDriver driver;
    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        driver.get("https://www.riproad.com");
    }

    @Test
    void contactUsTest() throws InterruptedException {
        new MainPage(driver).clickContactButton();
        new ContactPage(driver).contactUs("Brad", "Pitt", "baddddd@gmail.com", "Hello World!");
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
