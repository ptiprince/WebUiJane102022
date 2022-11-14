package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TrackRRPage extends BaseView {
    public TrackRRPage(WebDriver driver) {
        super(driver);
    }

    void checkTrackRRPage() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h1[contains(., 'Our tracking software')]")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div/h1[contains(., 'Our tracking software')]")).isDisplayed());
    }
}
