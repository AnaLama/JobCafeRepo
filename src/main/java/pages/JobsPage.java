package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.List;

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
    public List<String> listCreate(){
    List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='entry-content']"));
           //li[@class='entry-content/span/svg/text()']
    List<String> actjobs = new ArrayList<>();
    for (WebElement listElement: listElements){
        actjobs.add(listElement.getText());
    }
    return actjobs;
         }
    public int countCityNames(List<String> actjobs, String name){
        int count = 0;
                for(String actjob: actjobs) {
                    String a[] = actjob.split(" ");
                    for (int j = 0; j < a.length; j++) {
                        if (name.equals(a[j])) {
                            count++;
                        }
                    }
                }
        return  count; //count > actjobs.size()-1;
    }

}
