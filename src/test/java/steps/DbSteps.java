package steps;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import utils.DataBaseUtils;
import utils.GlobalVariables;

import java.util.List;
import java.util.Map;

public class DbSteps {

    @Then("query HRMS database and get data")
    public void query_hrms_database_and_get_data() {

        GlobalVariables.mapDataFromDb = DataBaseUtils.mapFromDataBase("SELECT emp_firstname, emp_middle_name, emp_lastname "
                + "FROM hs_hr_employees "
                + "WHERE employee_id=" + GlobalVariables.empId);
    }

    @Then("verify username from db")
    public void verifyUsernameFromDb() {
        String actual = DataBaseUtils.mapFromDataBase("select * from ohrm_user where user_name='" + GlobalVariables.userName + "';").get("user_name");
        String expected=GlobalVariables.userName;
        System.out.println("Actual "+actual);
        System.out.println("Expected "+expected);
        Assert.assertEquals(actual, expected);
    }
}