package steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.poi.ss.formula.functions.T;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import pages.AddEmployeePage;
import pages.PersonalDetailsPage;
import utils.CommonMethods;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PersonalDetailsModifyEnableSteps extends CommonMethods {

    @Then("user creates a user then modifies his personal fields to his description then verifies")
    public void user_creates_a_user_then_modifies_his_personal_fields_to_his_description_then_verifies(DataTable modifyEmployeeInfo) throws InterruptedException {
        List<Map<String, String>> employeeInfo = modifyEmployeeInfo.asMaps();
        for (Map<String, String> employeeName : employeeInfo) {
            String valueFirstName = employeeName.get("firstname");
            String valueMiddleName = employeeName.get("middlename");
            String valueLastName = employeeName.get("lastname");
            String valueDriversLicenseNumber = employeeName.get("Drivers License Number");
            String valueLicenseExpDate = employeeName.get("License Expiry Date");
            String valueSsnNumber = employeeName.get("SSN Number");
            String valueSinNumber = employeeName.get("SIN Number");
            //String valueGender = employeeName.get("Gender");
            String valueMartialStatus = employeeName.get("Marital Status");
            String valueNationality = employeeName.get("Nationality");
            String valueDOB = employeeName.get("Date of Birth");
            String valueNickName = employeeName.get("Nick Name");
            String valueSmoker = employeeName.get("Smoker");
            String valueMilitaryService = employeeName.get("Military Service");

            AddEmployeePage addEmployeePage = new AddEmployeePage();
            sendText(addEmployeePage.firstName, valueFirstName);
            sendText(addEmployeePage.middleName, valueMiddleName);
            sendText(addEmployeePage.lastName, valueLastName);
            click(addEmployeePage.saveBtn);
            Thread.sleep(2000);
            PersonalDetailsPage page = new PersonalDetailsPage();
            click(page.editPersonalDetailsInfo);
            sendText(page.driversLicenseNumber, valueDriversLicenseNumber);
            sendText(page.licenseExpDate, valueLicenseExpDate);
            sendText(page.SsnNumber, valueSsnNumber);
            Thread.sleep(2000);
            sendText(page.SinNumber, valueSinNumber);
            click(page.maleRadioButton);
            Thread.sleep(2000);
            Select select = new Select(page.martialStatusSelectOption);
            select.selectByVisibleText(valueMartialStatus);
            Thread.sleep(2000);
            Select select1 = new Select(page.nationalitySelectOption);
            select1.selectByVisibleText(valueNationality);
            click(page.smokerField);
            sendText(page.dateOfBirth, valueDOB);
            sendText(page.nickNameField,valueNickName);
            sendText(page.militaryField,valueMilitaryService);
            //click(page.smokerField);
            click(addEmployeePage.saveBtn);
        }

    }
}
