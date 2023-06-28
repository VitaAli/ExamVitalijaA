package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//h3[contains(text(),'Skaičiuotuvas jautrus neigiamiems skaičiams ;)')]")
    private WebElement successMessage;

    @FindBy(xpath = "//input[@id='sk1']")
    private WebElement firstNumber;

    @FindBy(xpath = "//input[@id='sk2']")
    private WebElement secondNumber;

    @FindBy(xpath = "//select[@name='zenklas']")
    private WebElement buttonOperation;

    @FindBy(xpath = "//input[@value='skaičiuoti']")
    private WebElement buttonCalculate;

    @FindBy(xpath = "/html/body/h4")
    private WebElement result;

    @FindBy(xpath = "//*[@id='sk2.errors']")
    private WebElement errorMessage;

    @FindBy(xpath = "//ul/li")
    private WebElement navOperation;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }

    public void enterFirstNumber(String number) {
        firstNumber.clear();
        firstNumber.sendKeys(number);
    }

    public void enterSecondNumber(String number) {
        secondNumber.clear();
        secondNumber.sendKeys(number);
    }

    public void selectSum() {
        Select sum = new Select(buttonOperation);
        sum.selectByValue("+");
    }

    public void selectDivision() {
        Select division = new Select(buttonOperation);
        division.selectByValue("/");
    }

    public void getResult() {
        buttonCalculate.click();
    }

    public String getResultText() {
        return result.getText();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }

    public void navigateToOperations() {
        navOperation.click();
    }

}
