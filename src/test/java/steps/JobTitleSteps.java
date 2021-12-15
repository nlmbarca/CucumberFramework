package steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AdminPage;
import pages.DashBoardPage;
import pages.JobTitlesPage;
import utils.CommonMethods;
import utils.DataBaseUtils;
import utils.GlobalVariables;

public class JobTitleSteps extends CommonMethods {
    @When("user navigates to Job Titles Page")
    public void user_navigates_to_job_titles_page() throws InterruptedException {
        DashBoardPage dash = new DashBoardPage();
        click(dash.adminTabButton);
    }


    @When("selects Job dropdown and selects Job Titles")
    public void selects_job_dropdown_and_selects_job_titles() throws InterruptedException {
        AdminPage admin = new AdminPage();
        click(admin.jobDD);
        Thread.sleep(2000);
        click(admin.jobTitles);
    }

    @When("query HRMS database for Job Title")
    public void query_hrms_database_for_job_title() {
        GlobalVariables.empListData = DataBaseUtils.listOfMapsFromDb("select distinct * from ohrm_job_title where is_deleted=0 order by 2 asc");
    }

    @Then("Verify that all job titles are displayed in Ascending order in HRMS Application also \\(Must be verified against DB)")
    public void verifyThatAllJobTitlesAreDisplayedInAscendingOrderInHRMSApplicationAlsoMustBeVerifiedAgainstDB() {
        JobTitlesPage jb = new JobTitlesPage();
        for (int i = 1; i <jb.jobTitleTable.size(); i++) {
            String optionText = jb.jobTitleTable.get(i).getText();
            Assert.assertEquals(GlobalVariables.empListData, optionText);
            System.out.println("(TEST PASSED) Verified job titles are displayed in Ascending Order in HRMS Application");
            System.out.println(optionText);
        }
    }
}

