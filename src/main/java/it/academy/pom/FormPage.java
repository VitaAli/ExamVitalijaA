package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FormPage extends AbstractPage {

    @FindBy(xpath = "//a[contains(text(),'Sukurti naują paskyrą')]")
    private WebElement createAccount;

    public FormPage(WebDriver driver) {
        super(driver);
    }

    public void openRegistrationPage() {
        createAccount.click();
    }

}
