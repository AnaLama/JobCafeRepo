package utils;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;
import pages.BasePage;

public class BaseTest {
    private static WebDriver driver;
    private static BasePage page;

    @BeforeAll
    public static void setupMain() {
        page = new BasePage();
        driver = SharedDriver.getDriver(SharedDriver.Browser.CHROME);
        page.setDriver(driver);
    }

    @AfterAll
    public static void tearDownMain() {
        SharedDriver.closeDriver();
        driver = null;
    }
}
