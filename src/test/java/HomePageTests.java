import constants.Constants;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import utils.BaseTest;
import java.io.IOException;

public class HomePageTests extends BaseTest {
    private static HomePage homePage;

    @BeforeAll

    public static void classSetup() {
        homePage = new HomePage();
    }
    @BeforeEach

    public void beforeTestSetup() {
        homePage.navigateToHomePage();
    }
    @Test
    public void testHomePageErrors(){
        homePage.getHomePageLogs();

        Assertions.assertFalse(homePage.isHomePageErrorExists());
    }

    @Test
    public void testJobCafeLogoVisible (){

      Assertions.assertTrue(homePage.isHomePageLogoVisible());
    }

    @Test
    public void testComingSoonImg() throws IOException {

        Assertions.assertTrue(homePage.isComingSoonImgExists());
        homePage.getIMGScreenshot();
    }
    @Test
    public void testAboutMenuButton(){
        homePage.clickAboutMenuButton();

        Assertions.assertEquals(Constants.ABOUT_US_URL, homePage.getCurrentURL());
    }
    @Test
    public void testJobMenuButton() throws InterruptedException {
        homePage.clickJobMenuButton();

        Assertions.assertEquals(Constants.LOGIN_URL, homePage.getCurrentURL());
        homePage.sendLoginNameText();
        homePage.sendLoginPasswordClick();
        Thread.sleep(1000);

        Assertions.assertEquals(Constants.JOB_URL, homePage.getCurrentURL());
    }
    @Test
    public void testContactUsMenuButton(){
        homePage.clickContactUsButton();

        Assertions.assertEquals(Constants.CONTACT_US_URL, homePage.getCurrentURL());
    }
}

