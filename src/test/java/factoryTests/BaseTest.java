package factoryTests;

import factorypages.PageFactoryManager;
import util.DriverManager;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

    protected DriverManager driverManager;
    protected PageFactoryManager pageFactoryManager;

    @BeforeClass
    public void setUp() {
        driverManager = new DriverManager();
        pageFactoryManager = new PageFactoryManager(driverManager.getDriver());
    }

    @AfterClass
    public void tearDown() {
        if (driverManager != null) {
            driverManager.quitDriver();
        }
    }
}
