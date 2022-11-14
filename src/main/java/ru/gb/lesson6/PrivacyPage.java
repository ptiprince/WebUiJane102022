package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PrivacyPage extends BaseView {
    public PrivacyPage(WebDriver driver) {
        super(driver);
    }

    void checkPrivacyPage() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h2[.='Privacy Policy']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div/h2[.='Privacy Policy']")).isDisplayed());
    }
}
