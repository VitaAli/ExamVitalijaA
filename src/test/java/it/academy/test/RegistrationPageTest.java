package it.academy.test;

import it.academy.pom.FormPage;
import it.academy.pom.RegistrationPage;
import it.academy.pom.RegisteredUserPage;
import org.junit.jupiter.api.Test;

import static it.academy.utils.GenerateDataUtils.generateRandomNumber;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RegistrationPageTest extends BaseTest {

    private FormPage homePage;
    private RegistrationPage registrationPage;
    private RegisteredUserPage userPage;

    @Test
    public void accountRegistrationSuccessful() {
        homePage = new FormPage(driver);
        registrationPage = new RegistrationPage(driver);
        userPage = new RegisteredUserPage(driver);

        homePage.openRegistrationPage();
        registrationPage.enterName("Name" + generateRandomNumber());
        String password = "Password" + generateRandomNumber();
        registrationPage.enterPassword(password);
        registrationPage.confirmPassword(password);
        registrationPage.submitRegistrationForm();

        String expectedMessage = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        assertEquals(expectedMessage, userPage.getSuccessMessage(), "User is not on home page, registration failed");
    }

    @Test
    public void accountRegistrationFailedWhenPasswordDoesNotMatch() {
        homePage = new FormPage(driver);
        registrationPage = new RegistrationPage(driver);

        homePage.openRegistrationPage();
        registrationPage.enterName("Name" + generateRandomNumber());
        registrationPage.enterPassword("Password" + generateRandomNumber());
        registrationPage.confirmPassword("Password" + generateRandomNumber());
        registrationPage.submitRegistrationForm();

        String expectedMessage = "Įvesti slaptažodžiai nesutampa";
        assertEquals(expectedMessage, registrationPage.getErrorMessage(), "User must get error message when password does not match");
    }
}
