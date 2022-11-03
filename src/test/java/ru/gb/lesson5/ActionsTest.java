package ru.gb.lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;

public class ActionsTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;

    @BeforeAll
    static void registerDriver(){
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void setupBrowser() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
    }
     @Test
     void highlightTextTest () throws InterruptedException {
       driver.get("https://translate.google.com/?sl=ru&tl=en&text=test&op=translate");
       webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//textarea[@aria-label='Source text']/following-sibling::div/span")));
        // Thread.sleep(5000);
       actions.moveToElement(driver.findElement(By.xpath("//textarea[@aria-label='Source text']/following-sibling::div/span")), -20, 0)
               .clickAndHold()
               .moveByOffset(30, 0)
               .perform();
       Thread.sleep(5000);
     }
     @Test
     void yetNewExamplesTest () throws InterruptedException {
        driver.get("https://google.com");
         ((JavascriptExecutor)driver).executeScript("alert('sdfdsf')");
         Thread.sleep(5000);
         driver.switchTo().alert().accept();
         Thread.sleep(5000);

         //to open new tab in browser
         driver.switchTo().newWindow(WindowType.TAB);
         Thread.sleep(5000);

         //to switch to the new tab opened
         ArrayList<String> tabs = new ArrayList<>(driver.getWindowHandles());
         driver.switchTo().window(tabs.get(1));
         driver.get("https://www.youtube.com/watch?app=desktop&v=bxdbtpnY8b4&fbclid=IwAR2qesSpKUCFhRJOnhF1miiFvwtNlfZzYz960C9p9TE4HlnknKOjg3XD-aw&ab_channel=MsPtiprince");
         Thread.sleep(2000);
         driver.switchTo().window(tabs.get(0));
         driver.close();
     }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
