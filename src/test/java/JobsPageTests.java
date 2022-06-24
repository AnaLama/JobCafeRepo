
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.JobsPage;
import utils.BaseTest;
import java.io.IOException;
import java.util.List;

public class JobsPageTests extends BaseTest {

    private static JobsPage jobsPage;

    @BeforeAll
    public static void classSetup() {
        jobsPage = new JobsPage();
        jobsPage.loginToJobsPage();
        jobsPage.waitJobsListLoaded();
    }

    @Test
    public void testJobsPageErrors() {
        jobsPage.getJobsPageLogs();

        Assertions.assertFalse(jobsPage.isJobsPageErrorExists());
    }

    @Test
    public void testTorontoInput() throws InterruptedException {

        jobsPage.sendCityName("Toronto");
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        jobsPage.waitJobsListLoaded();
        List<String> actJobs = jobsPage.jobsListCreate();

        Assertions.assertTrue(jobsPage.countCityNames(actJobs, "Toronto"));
    }

    //       @Test
//    public void testTelAvivInput() throws InterruptedException {
//
//        jobsPage.sendCityName("Tel Aviv-Yafo");
//        jobsPage.clickSearchButton();
//        Thread.sleep(5000);
//        jobsPage.waitJobsListLoaded();
//        List<String> actJobs = jobsPage.listCreate();
//
//        Assertions.assertTrue(jobsPage.countCityNames(actJobs, "Tel Aviv-Yafo"));
//    }
    @Test
    public void testChicagoInput() throws InterruptedException {

        jobsPage.sendCityName("Chicago");
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        jobsPage.waitJobsListLoaded();
        List<String> actJobs = jobsPage.jobsListCreate();

        Assertions.assertTrue(jobsPage.countCityNames(actJobs, "Chicago"));
    }

    @Test
    public void testAppleInput() throws InterruptedException {

        jobsPage.sendCompanyName("Apple");
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        jobsPage.waitJobsListLoaded();
        List<String> actJobs = jobsPage.jobsListCreate();

        Assertions.assertTrue(jobsPage.countCityNames(actJobs, "Apple"));
    }

    @Test
    public void testGoogleInput() throws InterruptedException {

        jobsPage.sendCompanyName("Google");
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        jobsPage.waitJobsListLoaded();
        List<String> actJobs = jobsPage.jobsListCreate();

        Assertions.assertTrue(jobsPage.countCityNames(actJobs, "Google"));
    }

    @Test
    public void testQAInput() throws InterruptedException {

        jobsPage.sendPositionName("QA");
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        jobsPage.waitJobsListLoaded();
        List<String> actJobs = jobsPage.jobsListCreate();

        Assertions.assertTrue(jobsPage.countCityNames(actJobs, "QA"));
    }

    @Test
    public void testNoResultFoundMessage() throws InterruptedException, IOException {
        jobsPage.sendPositionName("hfugfud");
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        String actualResult = jobsPage.getMessageText();

        Assertions.assertEquals("No results found! Please try different search criteria", actualResult);
    }

    @Test
    public void testResetButton() {
        jobsPage.sendCityName("Chicago");
        jobsPage.sendPositionName("QA");
        jobsPage.sendCompanyName("Google");

        String searchFields = "//form[@class='search-form']/input";

        Assertions.assertEquals("[QA, Chicago, Google, ]", jobsPage.getText(searchFields).toString());

        jobsPage.clickResetButton();

        Assertions.assertEquals("[, , , ]", jobsPage.getText(searchFields).toString());
    }
}

