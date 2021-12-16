Feature: User should be able to modify employee personal details

  @HW1030
  Scenario: Personal Details Information Input Available
    When user enters valid admin username and password
    And user clicks on login button
    And user clicks on PIM option and Add Employee option
    Then user creates a user then modifies his personal fields to his description then verifies
      | firstname         | middlename | lastname  | Drivers License Number | License Expiry Date | SSN Number | SIN Number | Gender | Marital Status | Nationality | Date of Birth | Nick Name | Smoker  | Military Service |
      | nizzck1znxzxzb23zz3122 | jackeee    | sohaizl999 | 1234-1231-231          | 2021-10-31          | 111122223  | 333322221  | Male   | Single         | Bolivian    | 2001-06-13    | Nick      | enabled | no               |