package ru.gb.lesson6;

import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class MainPage extends BaseView {

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(xpath = "//div[@class='standard-header-links-wrapper']//a[.='HOME']")
    private WebElement homeButton;

    @FindBy(xpath = "//div[@class='standard-header-links-wrapper']//a[.='TRACKRR']")
    private WebElement trackRRButton;

    @FindBy(xpath = "//*[@id=\"w-dropdown-toggle-0\"]/div[contains(., 'CASE')]")
    private WebElement caseStudiesButton;

    @FindBy(xpath = "//nav[@id='w-dropdown-list-0']//a[.='Rheumatoid Arthritis']")
    private WebElement rheumatoidArthritisButton;

    @FindBy(xpath = "//nav[@id='w-dropdown-list-0']//a[.='Type 2 Diabetes']")
    private WebElement typeTwoDiabetesButton;

    @FindBy(xpath = "//nav[@id='w-dropdown-list-0']//a[.='Hemophilia']")
    private WebElement hemophiliaButton;

    @FindBy(xpath = "//div[@class='standard-header-links-wrapper']//a[.='ABOUT US']")
    private WebElement aboutButton;

    private static final String contactButtonXpathLocator = "//div[@class='standard-header-links-wrapper']//a[.='CONTACT']";
    @FindBy(xpath = contactButtonXpathLocator)
    private WebElement contactButton;

    @FindBy(xpath = "//a[.='Privacy']")
    private WebElement privacyButton;

    @FindBy(xpath = "//a[.='Terms of Service']")
    private WebElement termsOfServiceButton;

    public void clickContactButton() {
       webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(contactButtonXpathLocator)));
        contactButton.click();
    }

    public TrackRRPage clickTrackRRButton() {
        trackRRButton.click();
        return new TrackRRPage(driver);
    }

    public PrivacyPage moveToPrivacy(){
        actions.moveToElement(privacyButton)
                .click(privacyButton)
                .perform();
        return new PrivacyPage(driver);
    }

    public TermsOfServicePage moveToTermsOfService(){
        actions.moveToElement(termsOfServiceButton)
                .click(termsOfServiceButton)
                .perform();
        return new TermsOfServicePage(driver);
    }
}
