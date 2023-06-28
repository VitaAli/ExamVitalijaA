package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RecordPage extends AbstractPage {

    @FindBy(xpath = "//tr[5]/td[2]")
    private WebElement resultOfRecord;

    public RecordPage(WebDriver driver) {
        super(driver);
    }

    public String getTextOfResult() {
        return resultOfRecord.getText();
    }
}
