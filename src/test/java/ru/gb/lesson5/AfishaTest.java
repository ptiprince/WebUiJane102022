package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AfishaTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get("https://afisha.ru");
    }

    @Test
    void goToOkkoTest() throws InterruptedException {
        ((JavascriptExecutor) driver).executeScript("let element = document.evaluate(\"//div[@data-test='HONEY-AD AD-ad_1']\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null)\n " +
                "element.singleNodeValue.remove()");
         /* div[@data-test='HONEY-AD AD-ad_1'] => xPath
          need to find how to delete element, for ex in Stackoverflow */

        actions.scrollToElement(driver.findElement(By.xpath("//button[.='Подписаться']")))
                .perform();
        Thread.sleep(5000);
        // //button[.='Подписаться']
        actions.moveToElement(driver.findElement(By.xpath("//a[.='КИНО']")))
                .perform();
        driver.findElement(By.xpath("//div[@data-test='HEADER-MENU']//a[.='Скоро онлайн в Okko']")).click();
        // //a[.='КИНО']
        // //div[@data-test='HEADER-MENU']//a[.='Скоро онлайн в Okko']
        Assertions.assertTrue(driver.getCurrentUrl().contains("okko"));
        Thread.sleep(5000);
    }

    @Test
    void authTest() throws InterruptedException {
        driver.findElement(By.xpath("//button[.='Войти']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[contains(@src, 'login')]")));
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.id("login")));
        driver.findElement(By.id("login")).sendKeys("spartalex1993");
        driver.findElement(By.id("password")).sendKeys("Test4test");
        Thread.sleep(20000); // for captcha which should be clicked manually
        webDriverWait.until(d -> d.findElement(By.id("login")).getAttribute("value").contains("@rambler.ru"));
        driver.findElement(By.xpath("//button[.='Войти']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header//a//div[contains(., 'Избранное') and preceding-sibling::span]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//header//a//div[contains(., 'Избранное') and preceding-sibling::span]")).isDisplayed());
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
