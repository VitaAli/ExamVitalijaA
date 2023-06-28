package it.academy.test;

import it.academy.pom.LoginPage;
import it.academy.pom.RegistrationPage;
import it.academy.pom.HomePage;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BaseTest {

    private LoginPage loginPage;
    private RegistrationPage registrationPage;
    private HomePage homePage;

    @Test
    public void accountRegistrationSuccessful() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);
        homePage = new HomePage(driver);

        loginPage.openRegistrationPage();
        registrationPage.enterName("Name" + generateRandomNumber());
        String password = "Password" + generateRandomNumber();
        registrationPage.enterPassword(password);
        registrationPage.confirmPassword(password);
        registrationPage.submitRegistrationForm();

        String expectedMessage = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        assertEquals(expectedMessage, homePage.getSuccessMessage(), "User could not be registered");
    }

    @Test
    public void accountRegistrationFailedWhenPasswordDoesNotMatch() {
        loginPage = new LoginPage(driver);
        registrationPage = new RegistrationPage(driver);

        loginPage.openRegistrationPage();
        registrationPage.enterName("Name" + generateRandomNumber());
        registrationPage.enterPassword("Password" + generateRandomNumber());
        registrationPage.confirmPassword("Password" + generateRandomNumber());
        registrationPage.submitRegistrationForm();

        String expectedMessage = "Įvesti slaptažodžiai nesutampa";
        assertEquals(expectedMessage, registrationPage.getErrorMessage()
                , "User must get error message when password does not match");
    }
}
