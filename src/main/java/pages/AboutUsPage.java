package pages;

import constants.Constants;

import java.io.IOException;

public class AboutUsPage extends BasePage{

    private static final String ABOUT_US_LOGO = "//div[@class='d-flex justify-content-between align-items-center']/h2";

    public void navigateToAboutUsPage(){
        driver.get(Constants.ABOUT_US_URL);
    }
    public boolean isAboutUsLogoVisible(){
        return isElementExists(ABOUT_US_LOGO);
    }

    public void getLogoScreenshot() throws IOException {
        takeElementScreenshot("AboutUsLogoImg", ABOUT_US_LOGO);
    }

    public void getAboutUsPageLogs(){
        getLogs();
    }
    public boolean isAboutUsPageErrorExists(){
        return getLogs().size() > 0;
    }
}
