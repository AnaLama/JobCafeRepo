import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.JobsPage;
import utils.BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
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
    public void testJobsPageErrors(){
        jobsPage.getJobsPageLogs();

        Assertions.assertFalse(jobsPage.isJobsPageErrorExists());
    }
    @Test
    public void testTorontoInput() throws InterruptedException {
        jobsPage.waitJobsListLoaded();
        jobsPage.sendCityName();
        Thread.sleep(5000);
        jobsPage.clickSearchButton();
        Thread.sleep(5000);
        jobsPage.waitJobsListLoaded();
       List<String> actjobs = jobsPage.listCreate();
       int act1 = jobsPage.countCityNames(actjobs, "Toronto");
       Assertions.assertEquals(1, act1);
     //  Assertions.assertTrue(jobsPage.countCityNames(act, "Toronto"));
     //   List<String> expectedResult = new ArrayList<>(Arrays.asList("Language", "Author", "Date", "Comments", "Rate"));
       // Assertions.assertEquals(expectedResult.toString(), act.toString());

    }
}

