package it.academy.test;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseTest {

    public static WebDriver driver;

    @BeforeEach
    public void setUp() {
//        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://op.akademijait.vtmc.lt/");
    }

    @AfterEach
    public void closeDriver() {
        driver.quit();
    }
}
