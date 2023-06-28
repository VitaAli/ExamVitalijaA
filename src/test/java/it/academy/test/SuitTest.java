package it.academy.test;

import org.junit.platform.suite.api.SelectClasses;
import org.junit.platform.suite.api.Suite;

@Suite
@SelectClasses({RegistrationPageTest.class, LoginPageTest.class, HomePageTest.class, OperationPageTest.class})
public class SuitTest {
}
