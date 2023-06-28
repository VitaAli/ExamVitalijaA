package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegisteredUserPage extends AbstractPage {

    @FindBy(xpath = "//h3[contains(text(),'Skaičiuotuvas jautrus neigiamiems skaičiams ;)')]")
    private WebElement successMessage;

    public RegisteredUserPage(WebDriver driver) {
        super(driver);
    }

    public String getSuccessMessage() {
        return successMessage.getText();
    }
}
