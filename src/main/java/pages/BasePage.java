package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BasePage {
    protected static WebDriver driver;
    protected static WebDriverWait wait;



    public void setDriver(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 3);
    }
    public List<LogEntry> getLogs(){
        LogEntries entries = driver.manage().logs().get(LogType.BROWSER);
        List<LogEntry> logs = entries.getAll();
        return logs;
    }

}
