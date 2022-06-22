import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.AboutUsPage;
import utils.BaseTest;

import java.io.IOException;

public class AboutUsPageTests extends BaseTest {
    private static AboutUsPage aboutUsPage;

    @BeforeAll

    public static void classSetup() {
        aboutUsPage = new AboutUsPage();
    }
    @BeforeEach

    public void beforeTestSetup() {
        aboutUsPage.navigateToAboutUsPage();
    }

    @Test
    public void testAboutUsLogoVisible () throws IOException {
         aboutUsPage.getLogoScreenshot();
        Assertions.assertTrue(aboutUsPage.isAboutUsLogoVisible());
    }
    @Test
    public void testHomePageErrors(){
        aboutUsPage.getAboutUsPageLogs();

        Assertions.assertFalse(aboutUsPage.isAboutUsPageErrorExists());
    }
}
