package ru.gb.lesson3;



import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

//Creating test case to create new expenses request

    public class CrmTestExpenses {
        public static WebDriver driver;

        public static void main(String[] args) throws InterruptedException {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS); - not the best way to wait
            loginToCrm();

            driver.get("https://crm.geekbrains.space/expense-request/");
            driver.findElement(By.xpath("//a[@title='Создать заявку на расход']")).click();

            WebDriverWait webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
            webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.name("crm_expense_request[description]")));
            //Better way to wait until element found

            driver.findElement(By.name("crm_expense_request[description]")).sendKeys("TestExpenses");
            Select businessUnitSelect = new Select(driver.findElement(By.name("crm_expense_request[businessUnit]")));
            businessUnitSelect.selectByVisibleText("Research & Development");

            Select expenditureSelect = new Select(driver.findElement(By.name("crm_expense_request[expenditure]")));
            expenditureSelect.selectByVisibleText("01101 - ОС: вычислительная техника инфраструктуры");

            Select currencySelect = new Select(driver.findElement(By.name("crm_expense_request[currency]")));
            currencySelect.selectByVisibleText("Доллар США");

            driver.findElement(By.name("crm_expense_request[sumPlan]")).sendKeys("100");

            driver.findElement(By.xpath("//input[contains(@id, 'date_selector_crm_expense_request_datePlan')]")).click();
            driver.findElement(By.xpath("//a[text()='20']")).click();
            driver.findElement(By.xpath("//button[contains(text(), 'Сохранить и закрыть')]")).click();


            Thread.sleep(5000);
            driver.quit();
        }

        public static void loginToCrm() {
            driver.get("https://crm.geekbrains.space/user/login");
            driver.findElement(By.id("prependedInput")).sendKeys("Applanatest1");
            driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
            driver.findElement(By.xpath("//button")).click();
//xpath=//input[@id='prependedInput']
        }
}
