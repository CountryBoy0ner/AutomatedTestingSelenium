package factorypages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegistrationPage {

    private WebDriver driver;

    // Локаторы элементов страницы
    @FindBy(id = "customer.firstName")
    private WebElement firstNameField;

    @FindBy(id = "customer.lastName")
    private WebElement lastNameField;

    @FindBy(id = "customer.address.street")
    private WebElement addressField;

    @FindBy(id = "customer.address.city")
    private WebElement cityField;

    @FindBy(id = "customer.address.state")
    private WebElement stateField;

    @FindBy(id = "customer.address.zipCode")
    private WebElement zipCodeField;

    @FindBy(id = "customer.phoneNumber")
    private WebElement phoneField;

    @FindBy(id = "customer.ssn")
    private WebElement ssnField;

    @FindBy(id = "customer.username")
    private WebElement usernameField;

    @FindBy(id = "customer.password")
    private WebElement passwordField;

    @FindBy(id = "repeatedPassword")
    private WebElement confirmPasswordField;


    @FindBy(xpath = "//input[@value='Register']")
    private WebElement registerButton;

    public RegistrationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public RegistrationPage enterFirstName(String firstName) {
        firstNameField.sendKeys(firstName);
        return this;
    }

    public RegistrationPage enterLastName(String lastName) {
        lastNameField.sendKeys(lastName);
        return this;
    }

    public RegistrationPage enterAddress(String address) {
        addressField.sendKeys(address);
        return this;
    }

    public RegistrationPage enterCity(String city) {
        cityField.sendKeys(city);
        return this;
    }

    public RegistrationPage enterState(String state) {
        stateField.sendKeys(state);
        return this;
    }

    public RegistrationPage enterZipCode(String zipCode) {
        zipCodeField.sendKeys(zipCode);
        return this;
    }

    public RegistrationPage enterPhone(String phone) {
        phoneField.sendKeys(phone);
        return this;
    }


    public RegistrationPage enterSSN(String ssn) {
        ssnField.sendKeys(ssn);
        return this;
    }

    public RegistrationPage enterUsername(String username) {
        usernameField.sendKeys(username);
        return this;
    }

    public RegistrationPage enterPassword(String password) {
        passwordField.sendKeys(password);
        return this;
    }


    public RegistrationPage enterConfirmPassword(String confirmPassword) {
        confirmPasswordField.sendKeys(confirmPassword);
        return this;
    }


    public void clickRegisterButton() {
        registerButton.click();
    }
}