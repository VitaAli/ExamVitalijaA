package it.academy.test;

import it.academy.pom.HomePage;
import it.academy.pom.LoginPage;
import it.academy.pom.OperationsPage;
import it.academy.pom.RecordPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperationPageTest extends BaseTest{

    private LoginPage loginPage;
    private HomePage homePage;
    private OperationsPage operationsPage;
    private RecordPage recordPage;

    @Test
    public void recordCanBeFound() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
        operationsPage = new OperationsPage(driver);
        recordPage = new RecordPage(driver);

        int firstNumber = 15;
        int secondNumber = 3;

        loginPage.enterName("VitaAli");
        loginPage.enterPassword("1515");
        loginPage.submitLogin();
        homePage.enterFirstNumber(String.valueOf(firstNumber));
        homePage.enterSecondNumber(String.valueOf(secondNumber));
        homePage.selectSum();
        homePage.getResult();
        homePage.navigateToOperations();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,1000)");

        operationsPage.displayRecordInformation();
        String actualResult = recordPage.getTextOfResult();
        String expectedResult = String.valueOf((firstNumber + secondNumber));

        assertEquals(expectedResult, actualResult
                , "The last record was not found or the result is incorrect");
    }

    @Test
    public void resultCannotBeFoundIfItHasNotBeenEntered() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        int firstNumber = 15;
        int secondNumber = -3;

        loginPage.enterName("VitaAli");
        loginPage.enterPassword("1515");
        loginPage.submitLogin();
        homePage.enterFirstNumber(String.valueOf(firstNumber));
        homePage.enterSecondNumber(String.valueOf(secondNumber));
        homePage.selectDivision();
        homePage.getResult();

        String expectedResult = "Validacijos klaida: skaičius negali būti neigiamas";
        assertEquals(expectedResult, homePage.getErrorMessageText()
                , "The result provided when the number was negative");
    }
}
