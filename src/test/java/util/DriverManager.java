package util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class DriverManager {

    private WebDriver driver;

    public void initializeDriver() {
        if (driver == null) {
            System.setProperty("webdriver.chrome.driver", DriverLinks.CHROME_DRIVER_PATH);
            ChromeOptions options = new ChromeOptions();
            driver = new ChromeDriver(options);
        }
    }

    public void initializeSetUpTest(String url) {
        initializeDriver();
        navigateToPage(url);
    }

    public WebDriver getDriver() {
        if (driver == null) {
            initializeDriver();
        }
        return driver;
    }

    public void navigateToPage(String url) {
        getDriver().get(url);
    }

    public void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
