package API;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class reviewHardCodeExamplesAPI {

    static String token_f;
    String baseURI = RestAssured.baseURI = "http://hrm.syntaxtechs.net/syntaxapi/api";
    @Test
    public void agenerateToken() {

        /*
        REVIEW CLASS 2 12/9/2021
        URI=Baseurl+endpoint
        header:Content-type
        body: payload
         */

        RequestSpecification preparedRequest = given().header("Content-Type", "application/json").body("{\n" +
                "  \"email\": \"barca123@abc.com\",\n" +
                "  \"password\": \"test\"\n" +
                "}");

        Response response = preparedRequest.when().post("/generateToken.php");
        String token = response.jsonPath().getString("token");
        System.out.println(token);

        token_f = "Bearer " + token;

    }

    @Test
    public void breviewCreateEmployee() {

        RequestSpecification prepareRequest = given().header("Authorization", token_f).header("Content-Type", "application/json")
                .body("{\n" +
                        "  \"emp_firstname\": \"Nicolas\",\n" +
                        "  \"emp_lastname\": \"Onyx\",\n" +
                        "  \"emp_middle_name\": \"seb\",\n" +
                        "  \"emp_gender\": \"M\",\n" +
                        "  \"emp_birthday\": \"2001-06-13\",\n" +
                        "  \"emp_status\": \"Employee\",\n" +
                        "  \"emp_job_title\": \"API Tester\"\n" +
                        "}");

        Response response=prepareRequest.when().post("/createEmployee.php");
        response.prettyPrint();

    }
}
