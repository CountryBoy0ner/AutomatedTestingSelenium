package factoryTests;

import ehu.Verkhavodko.factorypages.RegistrationPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.testng.Assert.assertTrue;

public class RegistrationTest {

    private WebDriver driver;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
    }

    @Test
    public void testRegistrationFunctionality() {
        String username = "testuser123";
        String password = "password123";
        String firstName = "Test";
        String lastName = "User";
        String address = "123 Street";
        String city = "City";
        String state = "State";
        String zipCode = "12345";
        String phone = "1234567890";
        String ssn = "123-45-6789";

        RegistrationPage registrationPage = new RegistrationPage(driver);

        registrationPage.enterFirstName(firstName)
                .enterLastName(lastName)
                .enterAddress(address)
                .enterCity(city)
                .enterState(state)
                .enterZipCode(zipCode)
                .enterPhone(phone)
                .enterSSN(ssn)
                .enterUsername(username)
                .enterPassword(password)
                .enterConfirmPassword(password)
                .clickRegisterButton();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));

        try {

            WebElement welcomeMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[contains(text(),'Welcome " + username + "')]")));
            assertTrue(welcomeMessage.isDisplayed(), "Welcome message not displayed.");

            WebElement successMessage = driver.findElement(By.xpath("//p[contains(text(),'Your account was created successfully.')]"));
            assertTrue(successMessage.isDisplayed(), "Success message not displayed.");

        } catch (Exception e) {
            WebElement errorMessage = driver.findElement(By.xpath("//span[@class='error'][contains(text(),'This username already exists.')]"));
            assertTrue(errorMessage.isDisplayed(), "Error message for existing username not displayed.");
        }
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
