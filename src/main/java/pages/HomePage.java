package pages;

import constants.Constants;

import java.io.IOException;

public class HomePage extends BasePage {
    private static final String JOB_CAFE_LOGO = "//a[@href='/']/span";
    private static final String COMING_SOON_IMG = "//img[@src='/img/JC_comingSoon.jpg']";
    private static final String ABOUT_MENU_BUTTON = "//a[@id='2']";
    private static final String JOBS_BUTTON = "//a[@id='3']";
    private static final String CONTACT_US_BUTTON = "//a[@id='4']";

    public void navigateToHomePage() {
        driver.get(Constants.BASE_URL);
    }

    public void getHomePageLogs() {
        getLogs();
    }

    public boolean isHomePageErrorExists() {
        return getLogs().size() > 0;
    }

    public boolean isHomePageLogoVisible() {
        return isElementExists(JOB_CAFE_LOGO);
    }

    public boolean isComingSoonImgExists() {
        return isElementExists(COMING_SOON_IMG);
    }

    public void getIMGScreenshot() throws IOException {
        takeElementScreenshot("ComingSoonImg", COMING_SOON_IMG);
    }

    public void clickAboutMenuButton() {
        findElementByXpath(ABOUT_MENU_BUTTON).click();
    }

    public String getCurrentURL() {
        return driver.getCurrentUrl();
    }

    public void clickJobMenuButton() {
        findElementByXpath(JOBS_BUTTON).click();
    }

    public void clickContactUsButton() {
        findElementByXpath(CONTACT_US_BUTTON).click();
    }

    public void sendLoginNameText() {
        sendTextToElementByXpath("//input[@name='username']", "ana");
    }

    public void sendLoginPasswordClick() {
        sendTextToElementByXpath("//input[@name='password']", "1234");
        findElementByXpath("//button[@type='submit']").click();
    }

}
