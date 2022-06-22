import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pages.JobsPage;
import utils.BaseTest;

public class JobsPageTests extends BaseTest {

    private static JobsPage jobsPage;

    @BeforeAll
    public static void classSetup() {
        jobsPage = new JobsPage();
    }
    @BeforeEach
    public void beforeTestSetup() {
        jobsPage.loginToJobsPage();
    }
    @Test  //often fails because it does not wait until the job list is loaded (don't know why)
    public void testJobsPageErrors(){
        jobsPage.getJobsPageLogs();

        Assertions.assertFalse(jobsPage.isJobsPageErrorExists());
    }
    @Test
    public void testTorontoInput(){
        jobsPage.sendCityName();
        jobsPage.clickSearchButton();
        jobsPage.waitJobsListLoaded();

    }
}
