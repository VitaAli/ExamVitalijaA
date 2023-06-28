package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage{

    @FindBy(xpath = "//input[@placeholder='Prisijungimo vardas']")
    private WebElement inputName;

    @FindBy(xpath = "//input[@placeholder='Slaptažodis']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement buttonSubmit;

    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement createAccount;

    @FindBy(xpath = "//span[contains(text(),'Įvestas prisijungimo vardas ir/ arba slaptažodis y')]")
    private WebElement errorMessage;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void enterName(String name) {
        inputName.sendKeys(name);
    }

    public void enterPassword(String password) {
        inputPassword.sendKeys(password);
    }

    public void submitLogin() {
        buttonSubmit.click();
    }

    public void openRegistrationPage() {
        createAccount.click();
    }

    public String getErrorMessageText() {
        return errorMessage.getText();
    }
}
