Feature: Verifying Job Titles are Displayed

  @databasehw1
  Scenario: Verify that all job titles are displayed in Ascending order in HRMS Application (Must be verified against DB)
    When user is logged in with valid admin credentials
    And user navigates to Job Titles Page
    And selects Job dropdown and selects Job Titles
    And query HRMS database for Job Title
    Then Verify that all job titles are displayed in Ascending order in HRMS Application also (Must be verified against DB)
