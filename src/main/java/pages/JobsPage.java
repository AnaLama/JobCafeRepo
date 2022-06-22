package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class JobsPage extends BasePage{
    public void loginToJobsPage() {
        driver.get(Constants.JOB_URL);
      HomePage  homePage = new HomePage();
      homePage.sendLoginNameText();
      homePage.sendLoginPasswordClick();
    }
    public void waitJobsListLoaded(){
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='entry-meta']")));
    }
    public void getJobsPageLogs(){
        waitJobsListLoaded();
        getLogs();
    }
    public boolean isJobsPageErrorExists(){
        return getLogs().size() > 0;
    }
    public void sendCityName(){
        sendTextToElementByXpath("//input[@name='location']", "Toronto");
    }
    public void clickSearchButton(){
        findElementByXpath("//button[@class='search-butom'][1]").click();
    }
}
