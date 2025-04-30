Feature: Create an account

  Scenario: basic
    Given I am on the right page
    When I put all the login info "14/04/2002", "Nahom", "Tesfay", "Nahomt59@mailnesia.com", "1234.Tesfay", "1234.Tesfay"
    And Click the right boxes
    Then I will get to the confirmation page

  Scenario Outline: dataDrivenFelscenario
    Given I am on the right page
    When I put all the login info "<DateOfBirth>", "<Forename>", "<Surname>", "<Email>", "<password>", "<confirmpassword>"
    And Click the right boxes
    Then I will get error message


    Examples:
      | DateOfBirth | Forename | Surname | Email                | password     | confirmpassword |
      | 14/13/2002  | Nahom    | Tesfay  | OfficeNT.3@gmail.com | 12345.Tesfay | 1234.Tesfay     |
      | 14/04/2002  |          | Tesfay  | OfficeNT.3@gmail.com | 1234.Tesfay  | 1234.Tesfay     |
      | 14/04/2002  | Nahom    |         | OfficeNT.3@gmail.com | 1234.Tesfay  | 1234.Tesfay     |