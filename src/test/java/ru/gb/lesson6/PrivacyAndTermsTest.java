package ru.gb.lesson6;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class PrivacyAndTermsTest {
    WebDriver driver;
    PrivacyPage privacyPage;
    TermsOfServicePage termsOfServicePage;
    MainPage mainPage;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }

    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
        mainPage = new MainPage(driver);
        privacyPage = new PrivacyPage(driver);
        termsOfServicePage = new TermsOfServicePage(driver);
        driver.get("https://www.riproad.com");
    }

    @Test
    void goToTermsOfServiceTest() {
        mainPage.moveToTermsOfService().checkTermsOfServicePage();
    }

    @Test
    void goToPrivacyTest() {
        mainPage.moveToPrivacy().checkPrivacyPage();
    }

        @AfterEach
        void tearDown() {
            driver.quit();
        }

    }