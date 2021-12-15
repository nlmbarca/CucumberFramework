package utils;

import org.json.JSONObject;

public class APIPayloadConstants {

    public static String createEmployeePayload() {
        String createEmployeePayload = "{\n" +
                "  \"emp_firstname\": \"Nicolas\",\n" +
                "  \"emp_lastname\": \"Onyx\",\n" +
                "  \"emp_middle_name\": \"seb\",\n" +
                "  \"emp_gender\": \"M\",\n" +
                "  \"emp_birthday\": \"2001-06-13\",\n" +
                "  \"emp_status\": \"Employee\",\n" +
                "  \"emp_job_title\": \"API Tester\"\n" +
                "}";
        return createEmployeePayload;
    }

    public static String createEmployeeBody() {

        JSONObject object = new JSONObject();
        object.put("emp_firstname", "Nicolas");
        object.put("emp_lastname", "Onyx");
        object.put("emp_middle_name", "seb");
        object.put("emp_gender", "M");
        object.put("emp_birthday", "2001-06-13");
        object.put("emp_status", "Employee");
        object.put("emp_job_title", "API Tester");
        return object.toString();
    }

    public static String payloadMoreDynamic(String emp_firstname,String emp_lastname,String emp_middle_name,String emp_gender,String emp_birthday,String emp_status,String emp_job_title){

        JSONObject object = new JSONObject();
        object.put("emp_firstname", emp_firstname);
        object.put("emp_lastname", emp_lastname);
        object.put("emp_middle_name", emp_middle_name);
        object.put("emp_gender", emp_gender);
        object.put("emp_birthday", emp_birthday);
        object.put("emp_status", emp_status);
        object.put("emp_job_title", emp_job_title);

        return object.toString();

    }
}
