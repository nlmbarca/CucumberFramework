Feature: Syntax HRM API workflow

  Background:
    Given a JWT is generated

  @APIWorkFlow
  Scenario: Creating an employee
    Given a request is prepared for creating an employee
    When a POST call is made to create an employee
    Then the status code for creating an employee is 201
    And the employee created contains key "Message" and Value "Employee Created"
    And the employee id "Employee.employee_id" is stored as a global variable to be used for other calls

  @APIWorkFlow
  Scenario: Retrieving created employee
    Given a request is prepared to retrieve the created employee
    When a GET call is made to retrieve the created employee
    Then the status code for this employee is 200
    And the retrieved employee ID "employee.employee_id" should match the globally stored employee id
    And the retrieved data at "employee" object matches the data used to create an employee with employee id "employee.employee_id"
      | emp_firstname | emp_middle_name | emp_lastname | emp_birthday | emp_gender | emp_job_title | emp_status |
      | Nicolas       | seb             | Onyx         | 2001-06-13   | Male       | API Tester    | Employee   |

  @DynamicCreatingEmployee
  Scenario: Create dynamic scenario
    Given a request is prepared fr creating an employee with dynamic data "Nicc", "Arrr","Blakk","F","2020-09-12","Employee","API Tester"


