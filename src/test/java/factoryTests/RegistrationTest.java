package factoryTests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.time.Duration;

import static org.testng.Assert.assertTrue;
import static util.DriverLinks.REGISTER_PAGE;
import static util.TestData.*;

public class RegistrationTest extends BaseTest {

    @BeforeClass
    @Override
    public void setUp() {
        super.setUp();
        driverManager.initializeSetUpTest(REGISTER_PAGE.getUrl());
    }

    @Test
    public void testRegistrationFunctionality() {
        var registrationPage = pageFactoryManager.getRegistrationPage();

        registrationPage.enterFirstName(FIRST_NAME)
                .enterLastName(LAST_NAME)
                .enterAddress(ADDRESS)
                .enterCity(CITY)
                .enterState(STATE)
                .enterZipCode(ZIP_CODE)
                .enterPhone(PHONE)
                .enterSSN(SSN)
                .enterUsername(USERNAME)
                .enterPassword(PASSWORD)
                .enterConfirmPassword(PASSWORD)
                .clickRegisterButton();

        WebDriverWait wait = new WebDriverWait(driverManager.getDriver(), Duration.ofSeconds(10));
        WebElement successMessage = wait.until(driver ->
                driver.findElement(By.xpath("//p[contains(text(), 'Your account was created successfully')]"))
        );
        assertTrue(successMessage.isDisplayed(), "Сообщение об успешной регистрации отсутствует на странице!");
    }
}
