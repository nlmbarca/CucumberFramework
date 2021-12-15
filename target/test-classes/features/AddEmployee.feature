Feature: Add employee

  Background:
    And user is logged in with valid admin credentials
    When user clicks on PIM option
    And user clicks on Add Employee button

  @1027
  Scenario: first scenario of adding the employee
    And user enters firstname middlename and lastname
    And user clicks on save button
    Then employee added successfully

  @1027
  Scenario: second scenario of adding the employee
    And user enters firstname middlename and lastname
    When user deletes employee id
    And user clicks on save button
    Then employee added successfully

  @1027
  Scenario: third scenario of adding the employee
    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then employee added successfully

  @1028
  Scenario: adding the employee from feature file
    And user enters "Nick21" "Sebas" and "Ortunno"
    And user clicks on save button
    Then employee added successfully

  @examples
  Scenario Outline: adding the employee from feature file
    And user enters "<firstName>" "<middleName>" and "<lastName>" for the employee
    And user clicks on save button
    Then employee added successfully
    Examples:
      | firstName | middleName | lastName |
      | nico1235  | seb        | carl     |
      | jamol     | nico       | sohail   |
      | sule      | asghar     | syntax   |

  @datatable
  Scenario: adding an employee using data table
    When I add multiple employees and verify them that user has been added successfully
      | firstName  | middleName | lastName  |
      | nico1235sd | sebs2      | carls2    |
      | jamols2    | nicos2     | sohails2  |
      | sules2     | asghars2   | syntaxs   |
      | jamosl2    | nicoos1    | lopezs1   |
      | sule12s2   | asghar12s2 | syntaxxs2 |

  @datatable2
  Scenario: adding an employee using data table
    When I add multiple employees and verify them that user has been added successfully in application
      | firstName  | middleName | lastName  |
      | nico1235sz | sebsz      | carlsz    |
      | jamolszz   | nicoszz    | sohailzzs |

  @excel
  Scenario: Adding an employee from excel file
      When user adds multiple employees from excel file using "EmployeeData" sheet and verify the added employee

  @database @regression
  Scenario: Adding employee and validating in DataBase
    When user enters "ken" "car" and "sonny"
    And captures employee id
    And user clicks on save button
    And employee added successfully
    Then query HRMS database and get data
    And verify employee data is matched in ui and db

  @ReviewClassSQL3
  Scenario: third scenario of adding the employee
    And user enters firstname middlename and lastname
    And user selects checkbox
    When user enters username password and confirmpassword
    And user clicks on save button
    Then verify username from db

