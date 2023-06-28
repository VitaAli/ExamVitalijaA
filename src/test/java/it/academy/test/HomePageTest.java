package it.academy.test;

import it.academy.pom.HomePage;
import it.academy.pom.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HomePageTest extends BaseTest{

    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void numbersCanBeAddedUp() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        int firstNumber = 15;
        int secondNumber = 3;

        loginPage.enterName("VitaAli");
        loginPage.enterPassword("1515");
        loginPage.submitLogin();
        homePage.enterFirstNumber(String.valueOf(firstNumber));
        homePage.enterSecondNumber(String.valueOf(secondNumber));
        homePage.selectSum();
        homePage.getResult();

        String expectedResult = firstNumber + " + " + secondNumber + " = " + (firstNumber + secondNumber);

        assertEquals(expectedResult, homePage.getResultText()
                , "Sum of " + firstNumber + " and " + secondNumber + " must result in a " + (firstNumber + secondNumber));
    }

    @Test
    public void numberCannotBeNegative() {
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
