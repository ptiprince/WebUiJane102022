package ru.gb.lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends BaseView {

    public ContactPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@data-name='firstName']")
    private WebElement firstNameField;

    @FindBy(xpath = "//input[@data-name='lastName']")
    private WebElement lastNameField;

    @FindBy(xpath = "//input[@data-name='email']")
    private WebElement emailField;

    @FindBy(xpath = "//textarea[@data-name='notes']")
    private WebElement notesField;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement submitButton;

    public void contactUs(String firstName, String lastName, String email, String note){
        firstNameField.sendKeys(firstName);
        lastNameField.sendKeys(lastName);
        emailField.sendKeys(email);
        notesField.sendKeys(note);
        submitButton.click();
    }
}
