package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.DashBoardPage;
import pages.EmployeeListPage;
import pages.LoginPage;
import utils.CommonMethods;
import utils.ConfigReader;

public class EmployeeSearchSteps extends CommonMethods {

    String desiredId = "20119000";
    String desiredName = "Messi";

    @Given("user is navigated to HRMS")
    public void user_is_navigated_to_hrms() {
        openBrowser();
    }

    @Given("user is logged in with valid admin credentials")
    public void user_is_logged_in_with_valid_admin_credentials() {
        LoginPage login = new LoginPage();
        sendText(login.usernameBox, ConfigReader.getPropertyValue("username"));
        sendText(login.passwordBox, ConfigReader.getPropertyValue("password"));
        click(login.loginBtn);
    }

    @Given("user navigates to employee list page")
    public void user_navigates_to_employee_list_page() {
        DashBoardPage dashBoardPage = new DashBoardPage();
        click(dashBoardPage.pimOption);
        click(dashBoardPage.employeeListOption);
    }

    @When("user enters valid employee id")
    public void user_enters_valid_employee_id() {
        EmployeeListPage emp = new EmployeeListPage();
        sendText(emp.idEmployee, desiredId);
    }

    @When("click on search button")
    public void click_on_search_button() {
        EmployeeListPage emp = new EmployeeListPage();
        click(emp.searchButton);
    }

    @Then("user see employee information is displayed by ID")
    public void user_see_employee_information_is_displayed_by_ID() {
        EmployeeListPage emp = new EmployeeListPage();
        for (int i = 0; i < emp.employeeListTable.size(); i++) {
            String tableRowText = emp.employeeListTable.get(i).getText();
            Assert.assertTrue(tableRowText.contains(desiredId));
            System.out.println("(Test Passed) Employee is found by ID: " + tableRowText);
        }
        tearDown();
    }

    @When("user enters valid employee name")
    public void user_enters_valid_employee_name() throws InterruptedException {
        EmployeeListPage emp = new EmployeeListPage();
        Thread.sleep(2000);
        sendText(emp.employeeNameField, desiredName);
    }

    @Then("user see employee information is displayed by Name")
    public void user_see_employee_information_is_displayed_by_Name() {
        EmployeeListPage emp = new EmployeeListPage();
        for (int i = 0; i < emp.employeeListTable.size(); i++) {
            String tableRowText = emp.employeeListTable.get(i).getText();
            Assert.assertTrue(tableRowText.contains(desiredName));
            System.out.println("(Test Passed) Employee is found by Name: " + tableRowText);

        }
        tearDown();
    }
}
