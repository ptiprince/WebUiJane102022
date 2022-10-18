package ru.gb.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class DiaryExample {
    public static void main(String[] arg) throws InterruptedException {
        WebDriverManager.chromedriver().setup();

        WebDriver driver = new ChromeDriver();
        WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        driver.get("https://diary.ru/user/login");
        driver.findElement(By.id("loginform-username")).sendKeys("spartalex");
        driver.findElement(By.id("loginform-password")).sendKeys("123456");
        Thread.sleep(10000);
        driver.findElement(By.id("login_btn")).click();
        //Thread.sleep(5000); - bad practice of waiting
        webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(By.id("writeThisDiary")));
        driver.findElement(By.id("writeThisDiary")).click();

        String postTitle = "title" + new Random().nextInt(100);
        driver.findElement(By.id("postTitle")).sendKeys(postTitle);

        driver.switchTo().frame(driver.findElement(By.id("message_ifr")));
        driver.findElement(By.id("tinymce")).sendKeys("What a wonderful world!");

        driver.switchTo().parentFrame();
        driver.findElement(By.id("rewrite")).click();

        List<WebElement> titles = driver.findElements(By.xpath("//a[@class='title']"));
        titles.stream().filter(p -> p.getText().equals(postTitle)).findFirst().get().click();

        /*Cookie authCookie = new Cookie("_identity_", "83668234c30812b14c46bac1deda1a240770255504032650b424a75038c00b3aa%3A2%3A%7Bi%3A0%3Bs%3A10%3A%22_identity_%22%3Bi%3A1%3Bs%3A52%3A%22%5B3545507%2C%22E_QJqRaNdBrepyeVN7uNXi5Dz9tjGpfX%22%2C2592000%5D%22%3B%7D");
        driver.manage().addCookie(authCookie);
        driver.navigate().refresh();*/

                Thread.sleep(5000);
        driver.quit();
    }
}
