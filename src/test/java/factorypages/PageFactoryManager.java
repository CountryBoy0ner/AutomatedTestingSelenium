package factorypages;

import org.openqa.selenium.WebDriver;

public class PageFactoryManager {

    private final WebDriver driver;

    public PageFactoryManager(WebDriver driver) {
        this.driver = driver;
    }

    public LoginPage getLoginPage() {
        return new LoginPage(driver);
    }

    public RegistrationPage getRegistrationPage() {
        return new RegistrationPage(driver);
    }
}
