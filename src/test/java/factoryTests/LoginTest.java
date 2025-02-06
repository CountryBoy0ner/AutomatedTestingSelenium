package factoryTests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertTrue;
import static util.DriverLinks.LOGIN_PAGE;
import static util.TestData.PASSWORD;
import static util.TestData.USERNAME;

public class LoginTest extends BaseTest {

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        driverManager.initializeSetUpTest(LOGIN_PAGE.getUrl());
    }

    @Test
    public void testLogin() {
        var loginPage = pageFactoryManager.getLoginPage();
        loginPage.enterUsername(USERNAME);
        loginPage.enterPassword(PASSWORD);
        loginPage.clickLoginButton();

        assertTrue(loginPage.getCurrentUrl().contains("overview.htm"), "Login failed.");
    }
}
