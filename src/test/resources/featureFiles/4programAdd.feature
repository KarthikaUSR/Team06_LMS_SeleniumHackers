#Author: Anusuya S

@ProgramAdd
Feature:  Program - Add New Program
          Admin successfully Logged on to the  page

  @AddNewProgram


 Scenario: Verify add New Program
  
    Given Admin is on Program module
    When  Admin clicks on "Add New Program" under the "Program" menu bar
    Then  Admin should see pop up window for program details

  Scenario: Verify title of the pop up window
    Given Admin is on Program module
    When  Admin clicks on "Add New Program" under the "Program" menu bar 
    Then  Admin should see window title as "Program Details"
  
  Scenario: Verify mandatory fields with red "*" mark 
    Given Admin is on Program module
    When  Admin clicks on "Add New Program" under the "Program" menu bar 
    Then  Admin should see red '*' mark beside mandatory field "programName"