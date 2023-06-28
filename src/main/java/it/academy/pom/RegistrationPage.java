package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends AbstractPage{

    @FindBy(xpath = "//input[@id='username']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@id='password']")
    private WebElement inputPassword;

    @FindBy(xpath = "//input[@id='passwordConfirm']")
    private WebElement inputPasswordConfirm;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//span[@id='passwordConfirm.errors']")
    private WebElement inputError;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void confirmPassword(String password) {
        inputPasswordConfirm.sendKeys(password);
    }

    public void submitRegistrationForm() {
        buttonSubmit.click();
    }

    public String getErrorMessage() {
        return inputError.getText();
    }

}
