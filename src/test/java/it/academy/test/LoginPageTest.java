package it.academy.test;

import it.academy.pom.HomePage;
import it.academy.pom.LoginPage;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPageTest extends BaseTest {

    private LoginPage loginPage;
    private HomePage homePage;

    @Test
    public void accountLoginSuccessful() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.enterName("VitAli");
        loginPage.enterPassword("1515");
        loginPage.submitLogin();

        String expectedMessage = "Skaičiuotuvas jautrus neigiamiems skaičiams ;)";
        assertEquals(expectedMessage, homePage.getSuccessMessage()
                , "The login name and/or password entered are incorrect");
    }

    @Test
    public void accountLoginFailedWhenPasswordIncorrect() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);

        loginPage.enterName("VitAli");
        loginPage.enterPassword("");
        loginPage.submitLogin();

        String expectedMessage = "Įvestas prisijungimo vardas ir/ arba slaptažodis yra neteisingi";
                assertEquals(expectedMessage, loginPage.getErrorMessageText()
                , "The user must not log in if the login name and/or password entered are incorrect");
    }
}
