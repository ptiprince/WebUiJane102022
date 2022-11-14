package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class TermsOfServicePage extends BaseView {
    public TermsOfServicePage(WebDriver driver) {
        super(driver);
    }

    void checkTermsOfServicePage() {
        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div/h2[.='Terms of Use']")));
        Assertions.assertTrue(driver.findElement(By.xpath("//div/h2[.='Terms of Use']")).isDisplayed());
    }
}
