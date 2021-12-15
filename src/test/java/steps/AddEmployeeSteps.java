package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.AddEmployeePage;
import pages.DashBoardPage;
import pages.PersonalDetailsPage;
import utils.CommonMethods;
import utils.Constants;
import utils.ExcelReading;
import utils.GlobalVariables;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class AddEmployeeSteps extends CommonMethods {

    @When("user clicks on PIM option")
    public void user_clicks_on_pim_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
    }

    @When("user clicks on Add Employee button")
    public void user_clicks_on_add_employee_button() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.addEmployeeButton);
    }

    @When("user enters firstname middlename and lastname")
    public void user_enters_firstname_middlename_and_lastname() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, "Nicoz");
        sendText(addEmployeePage.middleName, "13z");
        sendText(addEmployeePage.lastName, "Ortunooz");
    }

    @When("user clicks on save button")
    public void user_clicks_on_save_button() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.saveBtn);
    }

    @Then("employee added successfully")
    public void employee_added_successfully() {
        System.out.println("Employee added successfully");
        PersonalDetailsPage personalDetailPage = new PersonalDetailsPage();
        String personalName = personalDetailPage.profileMadeName.getText();
        Assert.assertTrue(personalDetailPage.profileMadeName.isDisplayed());
    }

    @When("user deletes employee id")
    public void user_deletes_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        addEmployeePage.employeeID.clear();
    }

    @When("user selects checkbox")
    public void user_selects_checkbox() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        click(addEmployeePage.createLoginCheckBox);
    }

    @When("user enters username password and confirmpassword")
    public void user_enters_username_password_and_confirmpassword() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        GlobalVariables.userName="nico1919197182";
        sendText(addEmployeePage.createUsername, GlobalVariables.userName);
        sendText(addEmployeePage.createPassword, "Hum@nhrm123");
        sendText(addEmployeePage.rePassword, "Hum@nhrm123");
    }

    @When("user enters {string} {string} and {string}")
    public void user_enters_and(String firstName, String middleName, String lastName) {
        //initializing global variables using local variables (values coming from feature file)
        GlobalVariables.firstName = firstName;
        GlobalVariables.middleName = middleName;
        GlobalVariables.lastName = lastName;

        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("user enters {string} {string} and {string} for the employee")
    public void user_enters_and_for_the_employee(String firstName, String middleName, String lastName) {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        sendText(addEmployeePage.firstName, firstName);
        sendText(addEmployeePage.middleName, middleName);
        sendText(addEmployeePage.lastName, lastName);
    }

    @When("I add multiple employees and verify them that user has been added successfully")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully(DataTable employees) throws InterruptedException {
        List<Map<String, String>> employeeNames = employees.asMaps();
        for (Map<String, String> employeeName : employeeNames) {
            String valueFirstName = employeeName.get("firstName");
            String valueMiddleName = employeeName.get("middleName");
            String valueLastName = employeeName.get("lastName");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            PersonalDetailsPage pg = new PersonalDetailsPage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);
            click(addEmployeePage.saveBtn);

            /*Assert.assertTrue(pg.profileMadeName.isDisplayed());
            System.out.println("(User Was Created): " + pg.profileMadeName.getText());*/
            String actualProfileInfo = pg.profileMadeName.getText();
            String expectedProfileInfo = valueFirstName + " " + valueMiddleName + " " + valueMiddleName;
            Assert.assertEquals(actualProfileInfo, expectedProfileInfo);
            System.out.println("(User Was Created): " + pg.profileMadeName.getText());

            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(2000);
        }
    }

    //review class 1
    @When("user clicks on PIM option and Add Employee option")
    public void user_clicks_on_pim_option_and_add_employee_option() {
        DashBoardPage dash = new DashBoardPage();
        click(dash.pimOption);
        click(dash.addEmployeeButton);
    }

    //review class 1
    @Then("user is navigated to add employee page")
    public void user_is_navigated_to_add_employee_page() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        //Assert.assertTrue(addEmployeePage.headerValue.isDisplayed());
        String actualText = addEmployeePage.headerValue.getText();
        String expectedText = "Add Employee";
        Assert.assertEquals("Values don't match", actualText, expectedText);

    }

    //review class 1 datatable example
    @When("I add multiple employees and verify them that user has been added successfully in application")
    public void i_add_multiple_employees_and_verify_them_that_user_has_been_added_successfully_in_application(DataTable employeeData) throws InterruptedException {
        List<Map<String, String>> employeeNames = employeeData.asMaps();
        for (Map<String, String> employees : employeeNames) {
            String valueFirstName = employees.get("firstName");
            String valueMiddleName = employees.get("middleName");
            String valueLastName = employees.get("lastName");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);
            click(addEmployeePage.saveBtn);

            //verify

            DashBoardPage dash = new DashBoardPage();
            click(dash.addEmployeeButton);
            Thread.sleep(2000);
        }
    }

    //Class 4 Excel
    @When("user adds multiple employees from excel file using {string} sheet and verify the added employee")
    public void user_adds_multiple_employees_from_excel_file_using_sheet_and_verify_the_added_employee(String sheetName) {
        List<Map<String, String>> newEmployees = ExcelReading.excelIntoListMap(Constants.TESTDATA_FILEPATH, sheetName);
        DashBoardPage dash = new DashBoardPage();
        PersonalDetailsPage personalDetailsPage = new PersonalDetailsPage();
        AddEmployeePage add = new AddEmployeePage();
        Iterator<Map<String, String>> it = newEmployees.iterator();
        while (it.hasNext()) {
            Map<String, String> mapNewEmp = it.next();
            String firstNameInfoFromExcel = mapNewEmp.get("FirstName");
            String middleNameInfoFromExcel = mapNewEmp.get("MiddleName");
            String lastNameInfoFromExcel = mapNewEmp.get("LastName");
            sendText(add.firstName, firstNameInfoFromExcel);
            sendText(add.middleName, middleNameInfoFromExcel);
            sendText(add.lastName, lastNameInfoFromExcel);
            click(add.saveBtn);

            String actual = personalDetailsPage.profileMadeName.getText();
            String expected = firstNameInfoFromExcel + " " + middleNameInfoFromExcel + " " + lastNameInfoFromExcel;
            Assert.assertEquals("Added Employee Not Verified", actual, expected);
            System.out.println("(Test Passed) Verified Added Employee From EmployeeData Sheet: " + personalDetailsPage.profileMadeName.getText());
            click(dash.addEmployeeButton);
        }
    }

    //Database Class 6
    @When("captures employee id")
    public void captures_employee_id() {
        AddEmployeePage addEmployeePage = new AddEmployeePage();
        GlobalVariables.empId = addEmployeePage.employeeID.getAttribute("value");
    }

    @Then("verify employee data is matched in ui and db")
    public void verify_employee_data_is_matched_in_ui_and_db() throws InterruptedException {

        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_firstname") , GlobalVariables.firstName);
        Thread.sleep(2000);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_middle_name") , GlobalVariables.middleName);
        Thread.sleep(2000);
        Assert.assertEquals(GlobalVariables.mapDataFromDb.get("emp_lastname") , GlobalVariables.lastName);
    }
}
