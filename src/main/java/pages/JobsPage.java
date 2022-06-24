package pages;

import constants.Constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JobsPage extends BasePage {
    private static final String JOBS_ERROR_MESSAGE = "//div[@class='error-indicator']";

    public void loginToJobsPage() {
        driver.get(Constants.JOB_URL);
        HomePage homePage = new HomePage();
        homePage.sendLoginNameText();
        homePage.sendLoginPasswordClick();
    }

    public void waitJobsListLoaded() {
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//ul[@class='entry-meta']")));
    }

    public void getJobsPageLogs() {
        waitJobsListLoaded();
        getLogs();
    }

    public boolean isJobsPageErrorExists() {
        return getLogs().size() > 0;
    }

    public void sendCityName(String name) {
        sendTextToElementByXpath("//input[@name='location']", name);
    }

    public void clickSearchButton() {
        findElementByXpath("//button[@class='search-butom'][1]").click();
    }

    public void clickResetButton() {
        findElementByXpath("//button[@class='search-butom'][2]").click();
    }

    public List<String> jobsListCreate() {
        List<WebElement> listElements = driver.findElements(By.xpath("//li[@class='entry-content']"));
        List<String> actJobs = new ArrayList<>();
        for (WebElement listElement : listElements) {
            actJobs.add(listElement.getText());
        }
        return actJobs;
    }

    public boolean countCityNames(List<String> actJobs, String name) {
        int count = 0;
        for (String actJob : actJobs) {
            String[] a = actJob.replaceAll(",", "").replaceAll("\n", " ").split(" ");
            for (String s : a) {
                if (name.equals(s)) {
                    count++;
                }
            }
        }
        return count >= actJobs.size();
    }

    public void closeDriver() {
        driver.close();
    }

    public void sendCompanyName(String name) {
        sendTextToElementByXpath("//input[@placeholder='company']", name);
    }

    public void sendPositionName(String name) {
        sendTextToElementByXpath("//input[@placeholder='position']", name);
    }

    public String getMessageText() throws IOException {
        takeElementScreenshot("No result found", JOBS_ERROR_MESSAGE);
        return findElementByXpath("//div[@class='error-indicator']").getText().replaceAll("\n", " ");
    }

    public List<String> getText(String xpath) {
        List<WebElement> listElements = driver.findElements(By.xpath(xpath));
        List<String> act = new ArrayList<>();
        for (WebElement listElement : listElements) {
            act.add(listElement.getAttribute("value"));
        }
        return act;
    }
}
