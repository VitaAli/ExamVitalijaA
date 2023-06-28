package it.academy.pom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class OperationsPage extends AbstractPage{

    @FindBy(xpath = "//tbody/tr[last()]/td[5]/a[3]")
    private WebElement lastRecord;

    public OperationsPage(WebDriver driver) {
        super(driver);
    }

    public void displayRecordInformation() {
        lastRecord.click();
    }


}
