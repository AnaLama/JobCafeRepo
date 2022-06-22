package pages;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.io.File;
import java.io.IOException;
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
    public void printLogs(List<LogEntry> logs){
        for (LogEntry e: logs){
            System.out.println("Message" + e.getMessage());
            System.out.println("Level" + e.getLevel());
        }
    }
    public boolean isElementExists (String xpath){
      try {
          driver.findElement(By.xpath(xpath));

          return true;
      } catch (Exception error){

          return false;
      }
    }
    public WebElement findElementByXpath (String xpath){
      return  driver.findElement(By.xpath(xpath));
    }
    public void takeElementScreenshot(String name, String xpath) throws IOException {
        WebElement logo = findElementByXpath(xpath);
        File file = logo.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(file, new File("Screenshots/" +name + ".png"));
    }

    protected void sendTextToElementByXpath(String xpath, String text) {
        findElementByXpath(xpath).sendKeys(text);
    }
//    public String getCurrentUrl(){
//       return driver.getCurrentUrl();
//    }
}
