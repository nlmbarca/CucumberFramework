package API;

import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import utils.APIConstants;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import static org.hamcrest.CoreMatchers.equalTo;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class HardCodedExamplesOfAPI {

    /*
    Given - pre condition - prepare the request
    When - Action - sending the request/hitting the endpoint
    Then - result - verify response
     */

    //rest assured consider baseurl as baseuri
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    String token = "Bearer eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJpYXQiOjE2MzkzMjUyNzIsImlzcyI6ImxvY2FsaG9zdCIsImV4cCI6MTYzOTM2ODQ3MiwidXNlcklkIjoiMzIyNyJ9.GTFFemnS67LjkFUCN7DAouFcsaySSBqx_Rk1-zuzWWs";
    static String employee_id;
    static String token_f;

    @Test
    public void dgetDetailsOfOneEmployee() {
        //given
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", "25517A");

        //when - hitting the endpoint
        Response response = preparedRequest.when().get("/getOneEmployee.php");
        System.out.println(response.asString());

        //then - result/assertion
        response.then().assertThat().statusCode(200);
    }

    @Test
    public void acreateEmployee() {

        //given
        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"emp_firstname\": \"Nicoz\",\n" +
                        "  \"emp_lastname\": \"Ortx\",\n" +
                        "  \"emp_middle_name\": \"seb\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2001-06-13\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"API Tester\"\n" +
                        "}");

        //when
        Response response = preparedRequest.when().post("/createEmployee.php");

        //this pretty print does the same job as syso -> System.out.println(response.asString());
        response.prettyPrint();

        //jsonPath() we use this to get specific information from the json object
        employee_id = response.jsonPath().getString("Employee.employee_id");
        System.out.println(employee_id);

        //then
        response.then().assertThat().statusCode(201);
        response.then().assertThat().body("Employee.emp_firstname", equalTo("Nicoz"));
        response.then().assertThat().body("Message", equalTo("Employee Created"));
        response.then().assertThat().header("Server", "Apache/2.4.39 (Win64) PHP/7.2.18");
    }

    @Test
    public void bgetCreatedEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").queryParam("employee_id", employee_id);

        Response response = preparedRequest.when().get("/getOneEmployee.php");

        String empID = response.jsonPath().getString("employee.employee_id");

        boolean comparingEmpID = empID.contentEquals(employee_id);
        Assert.assertTrue(comparingEmpID);

        String firstName = response.jsonPath().getString("employee.emp_firstname");
        Assert.assertTrue(firstName.contentEquals("Nicoz"));

        String lastName = response.jsonPath().getString("employee.emp_lastname");
        Assert.assertTrue(lastName.contentEquals("Ortx"));
    }

    @Test
    public void cupdatedCreatedEmployee() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json").body("{\n" +
                        "  \"employee_id\": \"" + employee_id + "\",\n" +
                        "  \"emp_firstname\": \"Bruce\",\n" +
                        "  \"emp_lastname\": \"Rob\",\n" +
                        "  \"emp_middle_name\": \"Sev\",\n" +
                        "  \"emp_gender\": \"F\",\n" +
                        "  \"emp_birthday\": \"2001-06-23\",\n" +
                        "  \"emp_status\": \"Emp\",\n" +
                        "  \"emp_job_title\": \"Cloud Consultant\"\n" +
                        "}");

        Response response = preparedRequest.when().put("/updateEmployee.php");
        response.prettyPrint();
    }

    @Test
    public void getAllEmployees() {

        RequestSpecification preparedRequest = given().header("Authorization", token)
                .header("Content-Type", "application/json");

        Response response = preparedRequest.when().get(APIConstants.GET_ALL_EMPLOYEES_URI);

        String allEmployees = response.prettyPrint();

        JsonPath jsonPath = new JsonPath(allEmployees);

        int count = jsonPath.getInt("Employees.size()");
        System.out.println(count);

        for (int i = 0; i < count; i++) {
            String employeeIds = jsonPath.getString("Employees[" + i + "].employee_id");
            System.out.println(employeeIds);

        }
    }

}

