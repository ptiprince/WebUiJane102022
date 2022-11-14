package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class TrackRRPageTest {
    WebDriver driver;
    TrackRRPage trackRRPage;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        trackRRPage = new TrackRRPage(driver);
        driver.get("https://www.riproad.com");
    }

    @Test
    void goToTrackRRTest() {
       mainPage.clickTrackRRButton().checkTrackRRPage();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
